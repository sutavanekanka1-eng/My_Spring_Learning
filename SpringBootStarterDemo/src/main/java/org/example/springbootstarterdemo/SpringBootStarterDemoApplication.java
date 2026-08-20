package org.example.springbootstarterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //contains annotations that provide inbuild settings equivalent to appConfig file.
//EnableAutoConfiguration--Beans creation-->1 @Component 2.@Bean 3.@AutoConfiguration(Internally used)
public class SpringBootStarterDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(SpringBootStarterDemoApplication.class, args);
        OrderService order=context.getBean(OrderService.class);
        order.placeOrder();
    }

}
