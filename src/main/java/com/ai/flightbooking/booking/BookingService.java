package com.ai.flightbooking.booking;

import com.ai.flightbooking.common.event.BookingCreatedEvent;
import com.ai.flightbooking.common.model.BookingRequest;
import com.ai.flightbooking.common.model.BookingResponse;
import java.util.UUID;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public BookingService(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public BookingResponse createBooking(BookingRequest request) {
    String bookingId = UUID.randomUUID().toString();
    BookingCreatedEvent event =
        new BookingCreatedEvent(
            bookingId,
            request.userId(),
            request.flightId(),
            request.passengerName(),
            request.email(),
            java.math.BigDecimal.valueOf(199.99));

    kafkaTemplate.send("booking-created", bookingId, event);

    return new BookingResponse(bookingId, "PENDING_PAYMENT", "Booking created successfully");
  }
}
