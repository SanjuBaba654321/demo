package com.ai.flightbooking.payment;

import com.ai.flightbooking.common.event.BookingCreatedEvent;
import com.ai.flightbooking.common.event.PaymentCompletedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public PaymentListener(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @KafkaListener(topics = "booking-created", groupId = "payment-service")
  public void onBookingCreated(BookingCreatedEvent event) {
    PaymentCompletedEvent paymentEvent =
        new PaymentCompletedEvent(
            event.bookingId(),
            "PAY-" + event.bookingId().substring(0, 8),
            "SUCCESS",
            "Payment processed successfully");

    kafkaTemplate.send("payment-completed", event.bookingId(), paymentEvent);
  }
}
