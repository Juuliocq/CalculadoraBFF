package com.example.demo.config;

import org.omg.CORBA.ORB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class CorbaConfig {

    @Bean
    public ORB orb() {
        Properties props = new Properties();
        props.setProperty("ORBInitRef.NameService", "corbaloc::localhost:1050/NameService");

        return org.jacorb.orb.ORB.init(new String[0], props);
    }
}
