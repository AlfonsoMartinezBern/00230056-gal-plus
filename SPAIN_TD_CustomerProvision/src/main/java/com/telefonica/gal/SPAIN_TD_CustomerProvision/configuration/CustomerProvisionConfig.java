package com.telefonica.gal.SPAIN_TD_CustomerProvision.configuration;

import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

//@Component
@Configuration
public class CustomerProvisionConfig {

    @Value("${customerProvision.xsd}")
    private String xsdPath;

    @Bean
    public MarshallingHttpMessageConverter marshallingMessageConverter() throws Exception {
        return new MarshallingHttpMessageConverter(
                jaxb2Marshaller(),
                jaxb2Marshaller()
        );
    }

    @Bean(name = "ValidateXML")
    public Jaxb2Marshaller jaxb2Marshaller() throws Exception {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setSchemas(new ClassPathResource(xsdPath));
        jaxb2Marshaller.setClassesToBeBound(CUSTOMERPROVISIONREQUEST.class);
        jaxb2Marshaller.afterPropertiesSet();
        jaxb2Marshaller.setValidationEventHandler(new CustomerValidationHandler());
        System.out.println("Validando el XML ============> ");
        return jaxb2Marshaller;

    }

    //TODO VALIDAR OTRA FORMA se debe terminar de probar porque no funciona del todo bien.

    /*public void validateCustomerProvision() throws SAXException {
        try {


            Source schemaFile = new StreamSource(getClass().getClassLoader()
                    .getResourceAsStream(xsdPath));
            //Schema schema = factory.newSchema(schemaFile);


            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            validator.setErrorHandler(new CustomerNotfoundException());
            validator.validate(schemaFile);

        } catch (SAXException | IOException ex) {

            System.err.println(ex.getMessage());

        }

    }*/

}
