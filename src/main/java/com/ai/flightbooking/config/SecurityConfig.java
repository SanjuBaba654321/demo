package com.ai.flightbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers(
                        "/",
                        "/login",
                        "/api/auth/login",
                        "/api/confirmation/**",
                        "/api/flights/**",
                        "/api/bookings/**",
                        "/api/users/**",
                        "/api/airports/**",
                        "/api/airlines/**",
                        "/api/airports/search",
                        "/api/airlines/search",
                        "api/planner/**",
                        "/css/**",
                        "/js/**",
                        "/images/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(form -> form.loginPage("/login").permitAll());

    return http.build();
  }
}
