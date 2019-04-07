package com.kimmarcel.realtimeordering.api.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/realtime-ordering-websocket").setAllowedOrigins("http://localhost:4200").withSockJS();
        registry.addEndpoint("/realtime-ordering-websocket2").setAllowedOrigins("http://localhost:4200").withSockJS();
    }
}
