package org.example.usermanagement.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class Modelmapperconfig {
    @Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();
    }
}
