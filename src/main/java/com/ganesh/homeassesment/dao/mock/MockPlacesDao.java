package com.ganesh.homeassesment.dao.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ganesh.homeassesment.dao.PlacesDao;
import com.ganesh.homeassesment.rest.model.Place;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
public class MockPlacesDao implements PlacesDao {

    private List<Place> places;

    public MockPlacesDao(ObjectMapper objectMapper) throws IOException {
        places = readResouorce("places_example.json", objectMapper);
    }

    private List<Place> readResouorce(String path, ObjectMapper objectMapper) throws IOException {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            return objectMapper.readValue(input, objectMapper.getTypeFactory().constructCollectionType(List.class, Place.class));
        }
    }

    @Override
    public List<Place> listAll(int limit) {
        return places;
    }

    @Override
    public Place getById(UUID id) {
        return null;
    }
}
