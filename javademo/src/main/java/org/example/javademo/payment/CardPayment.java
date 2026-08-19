package org.example.javademo.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class CardPayment implements paymentService {
    @Override
    public void pay(){
        System.out.println("Card payment Successful!!");
    }
}
