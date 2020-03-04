package com.example.accessingmongodbdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.accessingmongodbdatarest"})
// same as @Configuration @EnableAutoConfiguration @ComponentScan
//@ComponentScan(basePackageClasses = PersonController.class)
//@ComponentScan({"com.example.accessingmongodbdatarest"})
public class PersonApp {
    public static void main( String[] args ) {
        SpringApplication.run( PersonApp.class, args );
    }
}
