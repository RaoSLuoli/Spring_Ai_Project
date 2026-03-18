package com.demo.langchain4j.config;

import com.demo.langchain4j.service.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel model;
    @Bean
    public ConsultantService consultantService() {
        ConsultantService cs = AiServices.builder(ConsultantService.class)
                .chatModel(model)
                .build();
        return cs;
    }
}
