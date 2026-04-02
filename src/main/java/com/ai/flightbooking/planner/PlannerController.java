package com.ai.flightbooking.planner;

import com.ai.flightbooking.common.model.FlightOption;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlannerController {

  private final PlannerService plannerService;

  public PlannerController(PlannerService plannerService) {
    this.plannerService = plannerService;
  }

  @GetMapping("/api/planner/search")
  public List<FlightOption> search(
      @RequestParam String origin, @RequestParam String destination, @RequestParam String date) {
    return plannerService.searchFlights(origin, destination, date);
  }
}
