package com.ai.flightbooking.agent;

import com.ai.flightbooking.common.model.FlightOption;
import com.ai.flightbooking.planner.PlannerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

  private final PlannerService plannerService;

  public AgentService(PlannerService plannerService) {
    this.plannerService = plannerService;
  }

  public String handleRequest(String userPrompt) {
    List<FlightOption> options = plannerService.searchFlights("BOM", "LHR", "2026-04-01");
    return "I found " + options.size() + " flight options for your trip request.";
  }
}
