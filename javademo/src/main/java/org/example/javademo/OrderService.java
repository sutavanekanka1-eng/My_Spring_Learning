package org.example.javademo;

import org.example.javademo.payment.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    EmailService notification=new EmailService();
    private paymentService paymentservice;
    @Autowired
    public OrderService(@Qualifier("cardPayment") paymentService paymentservice){
        this.paymentservice=paymentservice;
    }
    public void placeOrder(){
        System.out.println("order placed!");
        paymentservice.pay();
        notification.SendNotification();
    }
}
