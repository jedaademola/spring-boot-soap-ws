package com.soapws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebServicesApplication.class, args);
    }
    //TODO: RUN this cmd to generate WSDL: mvn jaxb2:xjc or mvn generate-sources or mvn compile
    //TODO TEST with : Install the chrome plugin Wizdler.
    //TODO: required jars
    /*
    compile('javax.xml.bind:jaxb-api:2.3.0')
    compile('javax.activation:activation:1.1')
    compile('org.glassfish.jaxb:jaxb-runtime:2.3.0')
     */
}
