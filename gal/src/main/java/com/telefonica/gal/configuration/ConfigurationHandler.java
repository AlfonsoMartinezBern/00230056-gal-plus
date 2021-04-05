package com.telefonica.gal.configuration;

import com.telefonica.gal.handler.WsAddressInjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationHandler {
    @Bean
    public WsAddressInjectHandler wsAddressInjectHandler(){
        return new WsAddressInjectHandler();
    }
}
