package com.ai.flightbooking.agent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

  private final AgentService agentService;

  public AgentController(AgentService agentService) {
    this.agentService = agentService;
  }

  @GetMapping("/api/agent/ask")
  public String ask(@RequestParam String prompt) {
    return agentService.handleRequest(prompt);
  }
}
