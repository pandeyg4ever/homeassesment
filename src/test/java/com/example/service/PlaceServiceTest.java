package com.example.service;

import com.example.rest.model.DailySchedule;
import com.example.rest.model.PlaceStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlaceServiceTest {
    @Test
    void grouped() {
        assertEquals(
                Map.of(
                        "monday-friday",
                        List.of(new DailySchedule(
                                PlaceStatus.OPEN,
                                LocalTime.of(8, 00, 00, 00 ),
                                LocalTime.of(16, 00, 00, 00 )
                        ))
                ),
                PlaceService.grouped(
                        Map.of(
                                "monday",
                                List.of(new DailySchedule(
                                        PlaceStatus.OPEN,
                                        LocalTime.of(8, 00, 00, 00 ),
                                        LocalTime.of(16, 00, 00, 00 )
                                )),
                                "tuesday",
                                List.of(new DailySchedule(
                                        PlaceStatus.OPEN,
                                        LocalTime.of(8, 00, 00, 00 ),
                                        LocalTime.of(16, 00, 00, 00 )
                                )),
                                "wednesday",
                                List.of(new DailySchedule(
                                        PlaceStatus.OPEN,
                                        LocalTime.of(8, 00, 00, 00 ),
                                        LocalTime.of(16, 00, 00, 00 )
                                )),
                                "thursday",
                                List.of(new DailySchedule(
                                        PlaceStatus.OPEN,
                                        LocalTime.of(8, 00, 00, 00 ),
                                        LocalTime.of(16, 00, 00, 00 )
                                )),
                                "friday",
                                List.of(new DailySchedule(
                                        PlaceStatus.OPEN,
                                        LocalTime.of(8, 00, 00, 00 ),
                                        LocalTime.of(16, 00, 00, 00 )
                                ))
                        )
                )
        );
    }
}