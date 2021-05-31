package com.telefonica.gal.configuration;

import com.telefonica.gal.exception.HttpErrors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class RestClientConfiguration {

    @Bean(name="ServicesConsolidationRestTemplate")
    public RestTemplate graphModRestTemplate() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate();

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        restTemplate.setErrorHandler(new HttpErrors());

        return restTemplate;
    }
}
