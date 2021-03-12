package com.telefonica.gal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Value("${webservice.identitymanagement.targetNamespace}")
    private String targetNamespace;

    @Value("${webservice.identitymanagement.xsd}")
    private String pathXsd;

    @Value("${webservice.identitymanagement.uri}")
    private String uri;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "identityManagement")
    public DefaultWsdl11Definition defaultWsdl11Definition() throws Exception {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("IdentityManagementPort");
        wsdl11Definition.setLocationUri(uri);
        wsdl11Definition.setTargetNamespace(targetNamespace);
        wsdl11Definition.setSchemaCollection(identityManagementSchema());

        return wsdl11Definition;
    }

    @Bean
    public XsdSchemaCollection identityManagementSchema() throws Exception {
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource(pathXsd));
        xsds.setInline(true);
        return xsds;
    }

}
