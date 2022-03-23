package com.nisum.pruebatecnica.config;

import com.nisum.pruebatecnica.converts.PhoneConvert;
import com.nisum.pruebatecnica.converts.UserConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertConfig {

    @Bean
    public PhoneConvert getPhoneConvert(){
        return new PhoneConvert();
    }

    @Bean
    public UserConvert getUserConvert(){
        return new UserConvert();
    }
}
