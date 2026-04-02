package com.ai.agent.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiAgentService {

  private final ChatClient chatClient;

  public AiAgentService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  public String askAI(String question) {

    return chatClient.prompt().user(question).call().content();
  }
}
