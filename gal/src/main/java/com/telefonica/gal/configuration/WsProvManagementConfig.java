package com.telefonica.gal.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;



@EnableWs
@Configuration
public class WsProvManagementConfig extends WsConfigurerAdapter {
    @Value("${webservice.northbound.provManagement.targetNamespace}")
    private String targetNamespace;

    @Value("${webservice.northbound.provManagement.xsd}")
    private String pathXsd;

    @Value("${webservice.northbound.provManagement.uri}")
    private String uri;


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletUserManagement(ApplicationContext applicationContext) {
    	
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "userManagement")
    public DefaultWsdl11Definition userManagement() throws Exception {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("userManagementPort");
        wsdl11Definition.setLocationUri(uri);
        wsdl11Definition.setTargetNamespace(targetNamespace);
        wsdl11Definition.setSchemaCollection(userManagementSchema());

        return wsdl11Definition;
    }

    @Bean
    public XsdSchemaCollection userManagementSchema() throws Exception {
    	
        CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource(pathXsd));
        xsds.setInline(true);
        return xsds;
    }
    
    
    //WSS interceptors
    @Bean
    SimplePasswordValidationCallbackHandler callbackHandler() {
       SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
       
       callbackHandler.setUsersMap(userPasswordMap());

       return callbackHandler;
    }
    
    private Map<String, String> userPasswordMap() {
    	Map<String, String> map = new HashMap<String,String>();
    	map.put("gvp_app", "gvp_123456");
    	map.put("gvp_app1","gvp_123456");
		return map;
	}
    
    
    @Bean
    public Wss4jSecurityInterceptor wss4jSecurityInterceptor() {
        Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();
        interceptor.setValidationActions(WSConstants.USERNAME_TOKEN_LN);
        interceptor.setValidationCallbackHandler(callbackHandler());
        return interceptor;
    }

    
    //Validator
    private PayloadValidatingInterceptor validatingOProvManagementInterceptor() {
    	PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        try {
			validatingInterceptor.setXsdSchemaCollection(userManagementSchema());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return validatingInterceptor;
    }
    

    
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(wss4jSecurityInterceptor());
        interceptors.add(validatingOProvManagementInterceptor());

    }

}
