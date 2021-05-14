package com.telefonica.gal.SPAIN_TD_CustomerProvision.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CustomerProvisionConfig {

    @Bean
    public MarshallingHttpMessageConverter marshallingHttpMessageConverter()
    {
        MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

        marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
        marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

        return marshallingHttpMessageConverter;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller()
    {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setSchemas(new ClassPathResource("CustomerProvision_request.xsd"));
        //jaxb2Marshaller.setValidationEventHandler();
        //jaxb2Marshaller.setClassesToBeBound(Import.class);
        return jaxb2Marshaller;
    }

}
