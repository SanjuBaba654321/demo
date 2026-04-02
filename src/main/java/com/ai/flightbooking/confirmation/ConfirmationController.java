package com.ai.flightbooking.confirmation;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/confirmation")
public class ConfirmationController {

  private final ConfirmationService confirmationService;

  public ConfirmationController(ConfirmationService confirmationService) {
    this.confirmationService = confirmationService;
  }

  @GetMapping("/{bookingId}")
  public Map<String, String> getConfirmation(@PathVariable String bookingId) {
    return Map.of(
        "bookingId", bookingId, "confirmation", confirmationService.getConfirmation(bookingId));
  }
}
