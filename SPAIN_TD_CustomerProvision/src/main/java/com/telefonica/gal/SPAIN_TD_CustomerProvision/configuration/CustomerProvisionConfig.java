package com.telefonica.gal.SPAIN_TD_CustomerProvision.configuration;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.UnmarshalException;

@Configuration
public class CustomerProvisionConfig {

    @Value("${customerProvision.xsd}")
    private String xsdPath;

    @Bean
    public MarshallingHttpMessageConverter marshallingHttpMessageConverter() throws UnmarshalException {
        MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

        try{
            marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
            marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

        } catch (UnmarshalException unmarshalException) {
            System.out.println("UnmarshalException ------>" + unmarshalException.getMessage());
            throw new UnmarshalException(unmarshalException);

        }

        return marshallingHttpMessageConverter;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() throws UnmarshalException {
        try {
            Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setSchemas(new ClassPathResource(xsdPath));
            //jaxb2Marshaller.setValidationEventHandler();
            jaxb2Marshaller.setClassesToBeBound(CUSTOMERPROVISIONREQUEST.class);
            //jaxb2Marshaller.setPackagesToScan();
            jaxb2Marshaller.afterPropertiesSet();
            return jaxb2Marshaller;
        } catch (UnmarshalException e) {
            System.out.println("UnmarshalException ---->" + e.getMessage());
            throw new UnmarshalException(e);
        } catch (Exception e) {
            System.out.println("Exception ---->" + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
