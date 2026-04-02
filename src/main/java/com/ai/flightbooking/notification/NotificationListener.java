package com.ai.flightbooking.notification;

import com.ai.flightbooking.common.event.NotificationEvent;
import com.ai.flightbooking.common.event.PaymentCompletedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

  @KafkaListener(topics = "payment-completed", groupId = "notification-service")
  public void onPaymentCompleted(PaymentCompletedEvent event) {
    NotificationEvent notification =
        new NotificationEvent(
            "user-unknown",
            "customer@example.com",
            "Booking Confirmed",
            "Your flight booking " + event.bookingId() + " is confirmed.");

    System.out.println(
        "Sending notification: " + notification.subject() + " -> " + notification.email());
  }
}
