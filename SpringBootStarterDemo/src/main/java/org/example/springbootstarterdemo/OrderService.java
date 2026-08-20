package org.example.springbootstarterdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class OrderService {
    private PaymentService paymentservice;
    public OrderService(PaymentService paymentservice){
        this.paymentservice=paymentservice;
    }
    public void placeOrder(){
        paymentservice.pay();
        System.out.println("Order Placed!!");
    }

}
