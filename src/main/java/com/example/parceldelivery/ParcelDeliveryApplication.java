package com.example.parceldelivery;

import com.example.parceldelivery.entity.UserEntity;
import com.example.parceldelivery.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@SpringBootApplication
@RequestMapping("/api")
public class ParcelDeliveryApplication {

    @Autowired
    RoleRepository roleRepository;


    public static void main(String[] args) {
        SpringApplication.run(ParcelDeliveryApplication.class, args);
    }

}
