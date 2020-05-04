package com.jsonexample.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")//!dev is sued to make sure this class is used in all other class except for dev profile
public class ConfigClass {

    @PostConstruct
    public void test() {
        System.out.println("Loaded Dev Environment");
    }
}
