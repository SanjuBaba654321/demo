package com.ai.flightbooking.confirmation;

import com.ai.flightbooking.common.event.PaymentCompletedEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {

  private final Map<String, String> confirmations = new ConcurrentHashMap<>();

  public String confirm(PaymentCompletedEvent event) {
    String confirmationNumber = "CNF-" + event.bookingId().substring(0, 8);
    confirmations.put(event.bookingId(), confirmationNumber);
    return confirmationNumber;
  }

  public String getConfirmation(String bookingId) {
    return confirmations.getOrDefault(bookingId, "PENDING");
  }
}
