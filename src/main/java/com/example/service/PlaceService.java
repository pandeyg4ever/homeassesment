package com.example.service;

import com.example.dao.PlacesDao;
import com.example.rest.model.DailySchedule;
import com.example.rest.model.OpeningHours;
import com.example.rest.model.Place;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlacesDao placesDao;

    public Place getById(UUID id) {
        return daysGrouped(placesDao.getById(id));
    }

    public List<Place> listAll(int limit) {
        return placesDao.listAll(limit).stream()
                .map(PlaceService::daysGrouped)
                .toList();
    }

    static Place daysGrouped(Place place) {
        return new Place(place.label(), place.location(), grouped(place.openingHours()));
    }

    static OpeningHours grouped(OpeningHours openingHours) {
        return new OpeningHours(grouped(openingHours.days()));
    }

    static final List<String> daysOfWeek =
            List.of("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday");

    static Map<String, List<DailySchedule>> grouped(Map<String, List<DailySchedule>> days) {
        Map<List<DailySchedule>, List<String>> inverse
                = days.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        var result = new HashMap<>(days);
        inverse.forEach((key, value) -> {
            if (value.size() > 1 && continuous(value)) {
                value.forEach(result::remove);
                result.put(
                        daysOfWeek.stream().filter(value::contains).findFirst().orElse("")
                                + "-" +
                                Lists.reverse(daysOfWeek).stream().filter(value::contains).findFirst().orElse("")
                        , key);
            }
        });

        return result;
    }

    static boolean continuous(List<String> days) {
        var min = days.stream().min(Comparator.comparingInt(daysOfWeek::indexOf)).orElse("");
        var max = days.stream().max(Comparator.comparingInt(daysOfWeek::indexOf)).orElse("");
        return new HashSet<>(days).containsAll(daysOfWeek.subList(daysOfWeek.indexOf(min), daysOfWeek.indexOf(max) + 1));
    }
}
