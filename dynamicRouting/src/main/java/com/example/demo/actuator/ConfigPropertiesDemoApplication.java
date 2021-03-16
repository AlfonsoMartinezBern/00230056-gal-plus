package com.example.demo.actuator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { JsonProperties.class,
  CustomJsonProperties.class })
public class ConfigPropertiesDemoApplication {
	//Punto de entrada principal de la aplicación
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigPropertiesDemoApplication.class)
            .initializers(new JsonPropertyContextInitializer())
            .run();
    }
}