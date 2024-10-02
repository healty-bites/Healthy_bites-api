package com.healthybites.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ModelMapperConfig {
    @Bean
    public ModelMapperConfig modelMapper(){
        return new ModelMapperConfig();
    }
}
