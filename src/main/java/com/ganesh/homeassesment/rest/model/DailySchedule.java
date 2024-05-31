package com.ganesh.homeassesment.rest.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalTime;

@JsonPropertyOrder({"start", "end", "type"})
public record DailySchedule(PlaceStatus type, LocalTime start, LocalTime end) {
}
