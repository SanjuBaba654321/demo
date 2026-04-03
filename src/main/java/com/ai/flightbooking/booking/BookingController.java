package com.ai.flightbooking.booking;

import com.ai.flightbooking.common.model.BookingRequest;
import com.ai.flightbooking.common.model.BookingResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public BookingResponse create(@RequestBody BookingRequest request) {

    return bookingService.createBooking(request);
  }
}
