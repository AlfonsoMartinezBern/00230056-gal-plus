/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.axis;

import org.apache.axis.EngineConfigurationFactory;
import org.apache.axis.transport.http.AdminServlet;
import org.apache.axis.transport.http.AxisServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxisConfig {
    
    @Bean
    public ServletRegistrationBean axisServletRegistrationBean() {
        System.setProperty(EngineConfigurationFactory.SYSTEM_PROPERTY_NAME, com.telefonica.gal.SRV_SPAIN_TD_Helpdesk.axis.EngineConfigurationFactory.class.getName());
        AxisServlet servlet = new AxisServlet();
        ServletRegistrationBean servletBean = new ServletRegistrationBean(servlet, "/*", "/axis/*", "/axis-secured/*");
        return servletBean;
    }
    
    @Bean
    public ServletRegistrationBean axisAdminServletRegistrationBean() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new AdminServlet(), "/axis-admin");
        servletBean.setLoadOnStartup(100);
        return servletBean;
    }
}
