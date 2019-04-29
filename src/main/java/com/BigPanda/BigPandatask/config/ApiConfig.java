package com.BigPanda.BigPandatask.config;

import com.BigPanda.BigPandatask.model.EventTracker;
import com.BigPanda.BigPandatask.service.EventGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@Configuration
public class ApiConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false).configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public EventTracker eventTrackerSingleton() {
        return new EventTracker();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public EventGenerator eventGeneratorSingleton() throws IOException {
        return new EventGenerator();
    }
}
