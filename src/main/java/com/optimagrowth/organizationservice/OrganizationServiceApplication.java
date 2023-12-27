package com.optimagrowth.organizationservice;

import com.optimagrowth.organizationservice.events.source.CustomChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(CustomChannels.class)
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }

}
