package com.ganesh.homeassesment.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record OpeningHours(@JsonProperty("days") Map<String, List<DailySchedule>> days) {
}
