package com.example.rest.api;

import com.example.dao.PlacesDao;
import com.example.rest.model.Place;
import com.example.service.PlaceService;
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

    private final PlaceService placeService;

    @GetMapping(path = BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> list(@RequestParam(value = "limit", defaultValue = "10") int limit) {
        return placeService.listAll(limit);
    }

}
