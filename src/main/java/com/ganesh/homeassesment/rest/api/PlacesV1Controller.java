package com.ganesh.homeassesment.rest.api;

import com.ganesh.homeassesment.dao.PlacesDao;
import com.ganesh.homeassesment.rest.model.DailySchedule;
import com.ganesh.homeassesment.rest.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlacesV1Controller {

    final static String BASE_PATH = "/api/v1/places";

    private final PlacesDao placesDao;

    @GetMapping(path = BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> list(@RequestParam(value = "limit", defaultValue = "10") int limit) {
        return placesDao.listAll(limit);
    }

}
