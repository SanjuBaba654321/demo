package com.ai.flightbooking.common.event;

import java.math.BigDecimal;

public record BookingCreatedEvent(
    String bookingId,
    String userId,
    String flightId,
    String passengerName,
    String email,
    BigDecimal amount) {}
