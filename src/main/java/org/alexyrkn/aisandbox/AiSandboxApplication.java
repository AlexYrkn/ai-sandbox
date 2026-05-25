package org.alexyrkn.aisandbox;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AiSandboxApplication {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AiSandboxApplication.class, args);
        ChatClient chatClient = context.getBean(ChatClient.class);
        System.out.println(chatClient.prompt().user("Коротко что такое RAG?").call().content());
    }

}
