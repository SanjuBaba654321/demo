package com.ai.flightbooking.common.event;

public record PaymentCompletedEvent(
    String bookingId, String paymentId, String status, String message) {}
