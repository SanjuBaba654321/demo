package com.ai.flightbooking.confirmation;

import com.ai.flightbooking.common.event.PaymentCompletedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationListener {

  private final ConfirmationService confirmationService;

  public ConfirmationListener(ConfirmationService confirmationService) {
    this.confirmationService = confirmationService;
  }

  @KafkaListener(topics = "payment-completed", groupId = "confirmation-service")
  public void onPaymentCompleted(PaymentCompletedEvent event) {
    String confirmationNumber = confirmationService.confirm(event);
    System.out.println("Booking confirmed: " + confirmationNumber + " for " + event.bookingId());
  }
}
