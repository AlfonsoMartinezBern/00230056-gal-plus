package com.telefonica.gal.configuration;

//@Configuration
public class RestClientConfiguration {

    /*@Bean(name="ServicesConsolidationRestTemplate")
    public RestTemplate graphModRestTemplate() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        RestTemplate restTemplate = new RestTemplate();

        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        restTemplate.setErrorHandler(new HttpErrors());

        return restTemplate;
    }*/
}
