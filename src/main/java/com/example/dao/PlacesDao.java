package com.example.dao;

import com.example.rest.model.Place;

import java.util.List;
import java.util.UUID;

public interface PlacesDao {
    Place getById(UUID id);
    List<Place> listAll(int limit);

}
