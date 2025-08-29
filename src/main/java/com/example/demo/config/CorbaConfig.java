package com.example.demo.config;

import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class CorbaConfig {

    @Value("${corba.service.url}")
    private String corbaServiceUrl;

    @Bean
    public ORB orb() {
        Properties props = new Properties();
        props.setProperty("ORBInitRef.NameService", corbaServiceUrl);

        return org.jacorb.orb.ORB.init(new String[0], props);
    }
}
