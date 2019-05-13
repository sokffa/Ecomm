package com.energiedin.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.energiedin.restservice.entity.*;
import com.energiedin.restservice.repository.*;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    protected CommandLineRunner init(final ProprietaireRepository userRepository) {

        return args -> {
         	//Creation du compte du RH
        	Proprietaire user = new Proprietaire();
            user.setEmail("admin@gmail.com");
            user.setPassword("admin");
            user.setNom("Administrator");
            user.setPrenom("Imoge");
            if(userRepository.findOne(user.getEmail())==null)
            userRepository.save(user);
        };
    }
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}