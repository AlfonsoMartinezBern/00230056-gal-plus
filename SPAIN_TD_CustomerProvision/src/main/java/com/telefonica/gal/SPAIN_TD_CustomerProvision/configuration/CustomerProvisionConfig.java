package com.telefonica.gal.SPAIN_TD_CustomerProvision.configuration;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CustomerProvisionConfig {

    @Value("${customerProvision.xsd}")
    private String xsdPath;

    @Bean
    public MarshallingHttpMessageConverter marshallingHttpMessageConverter() throws Exception {
        MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

        marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
        marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

        return marshallingHttpMessageConverter;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() throws Exception {
        try {
            Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setSchemas(new ClassPathResource(xsdPath));
            //jaxb2Marshaller.setValidationEventHandler();
            jaxb2Marshaller.setClassesToBeBound(CUSTOMERPROVISIONREQUEST.class);
            //jaxb2Marshaller.setPackagesToScan();
            jaxb2Marshaller.afterPropertiesSet();
            return jaxb2Marshaller;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
