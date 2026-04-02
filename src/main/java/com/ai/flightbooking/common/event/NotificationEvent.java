package com.ai.flightbooking.common.event;

public record NotificationEvent(String userId, String email, String subject, String body) {}
