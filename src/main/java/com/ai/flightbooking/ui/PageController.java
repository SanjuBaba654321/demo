package com.ai.flightbooking.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  @GetMapping("/")
  public String home() {
    return "login";
  }

  @GetMapping("/planner")
  public String planner() {
    return "planner";
  }

  @GetMapping("/booking")
  public String booking() {
    return "booking";
  }

  @GetMapping("/confirmation")
  public String confirmation() {
    return "confirmation";
  }
}
