package com.ai.flightbooking.common.model;

import java.time.LocalDate;

public record BookingRequest(
    String userId, String flightId, String passengerName, String email, LocalDate travelDate) {}
