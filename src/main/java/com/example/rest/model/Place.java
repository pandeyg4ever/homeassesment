package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Place(String label, String location, @JsonProperty("opening_hours") OpeningHours openingHours) {
}
