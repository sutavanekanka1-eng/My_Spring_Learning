package org.example.javademo.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class UPI implements paymentService {
    @Override
    public void pay(){
        System.out.println("pay via UPI");
    }
}
