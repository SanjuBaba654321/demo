package com.ai.flightbooking.planner;

import com.ai.flightbooking.common.model.FlightOption;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {

  public List<FlightOption> searchFlights(String origin, String destination, String date) {
    return List.of(
        new FlightOption(
            "FL-101",
            "SkyJet",
            origin,
            destination,
            LocalDateTime.now().plusDays(1).withHour(9).withMinute(30),
            LocalDateTime.now().plusDays(1).withHour(12).withMinute(15),
            BigDecimal.valueOf(189.99)),
        new FlightOption(
            "FL-202",
            "AirNova",
            origin,
            destination,
            LocalDateTime.now().plusDays(1).withHour(14).withMinute(5),
            LocalDateTime.now().plusDays(1).withHour(17).withMinute(0),
            BigDecimal.valueOf(229.99)));
  }
}
