package com.ai.agent.controller;

import com.ai.agent.service.AiAgentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiAgentController {

  private final AiAgentService aiAgentService;

  public AiAgentController(AiAgentService aiAgentService) {
    this.aiAgentService = aiAgentService;
  }

  @GetMapping("/ask")
  public String askAI(@RequestParam String question) {
    return aiAgentService.askAI(question);
  }
}
