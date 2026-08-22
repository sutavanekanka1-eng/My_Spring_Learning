package org.example.first_springboot_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class FirstSpringbootWebappApplication {

    public static void main(String[] args) {

        SpringApplication.run(FirstSpringbootWebappApplication.class, args);

    }

}
