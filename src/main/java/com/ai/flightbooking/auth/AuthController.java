package com.ai.flightbooking.auth;

import jakarta.servlet.http.HttpSession;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
    if ("demo".equals(request.username()) && "demo123".equals(request.password())) {
      session.setAttribute("user", request.username());
      return ResponseEntity.ok(Map.of("message", "Login successful", "user", request.username()));
    }
    return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(HttpSession session) {
    session.invalidate();
    return ResponseEntity.ok(Map.of("message", "Logged out"));
  }
}
