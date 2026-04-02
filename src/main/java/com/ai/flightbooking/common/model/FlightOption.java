package com.ai.flightbooking.common.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightOption(
    String flightId,
    String airline,
    String origin,
    String destination,
    LocalDateTime departureTime,
    LocalDateTime arrivalTime,
    BigDecimal price) {}
