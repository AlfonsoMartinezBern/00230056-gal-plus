package com.example.demo.actuator;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
  value = "classpath:C:/Develop/STSWorkspace/demo/directory/configprops.json", 
  factory = JsonPropertySourceFactory.class)
@ConfigurationProperties
public class JsonProperties {
	//Clase de configuración

    private int port;
    private boolean resend;
    private String host;
    private List<String> topics;
    private LinkedHashMap<String, ?> sender;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isResend() {
		return resend;
	}

	public void setResend(boolean resend) {
		this.resend = resend;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public LinkedHashMap<String, ?> getSender() {
		return sender;
	}

	public void setSender(LinkedHashMap<String, ?> sender) {
		this.sender = sender;
	}

}