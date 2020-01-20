package com.soapws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "soapService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection schemaCollection) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("soapServicePort");
        //definition.setTargetNamespace("http://soapws.com/students");
        definition.setLocationUri("/ws");
        //definition.setSchema(studentsSchema);
        definition.setSchemaCollection(schemaCollection());
        return definition;
    }

   /* @Bean(name = "studentswsl")
    public XsdSchema studentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("student-details.xsd"));
    }*/

    @Bean
    public XsdSchemaCollection schemaCollection() {
        CommonsXsdSchemaCollection commonsXsdSchemaCollection = new CommonsXsdSchemaCollection(
                new ClassPathResource("student-details.xsd"),
                new ClassPathResource("countries.xsd"));
        commonsXsdSchemaCollection.setInline(true);
        return commonsXsdSchemaCollection;
    }
}