package com.yyq.project.websocket.config;


import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;

/**
 * Created by yangyunqi on 2017/7/27.
 */
@org.springframework.context.annotation.Configuration
public class CustomNettySocketConfig {

    private static final String HOST = "localhost";
    private static final Integer PORT = 10110;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration configuration = new Configuration();
        configuration.setHostname(HOST);
        configuration.setPort(PORT);
        return new SocketIOServer(configuration);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
