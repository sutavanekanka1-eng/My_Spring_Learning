package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService /*implements InitializingBean*/implements DisposableBean {
    Map<Integer,String> mp;
    public CartService(){
        mp=new HashMap<>();
        System.out.println("CartService Constructor");
    }
    /*@Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("map is all set");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");
    }*/
    //if we add aware interfaces they will be executed before PostConstruct
    @PostConstruct
    public void start2(){
        System.out.println("map is all set with postConstruct");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");
    }

    public void addToCart(){
        Map<Integer,String> mp;

        System.out.println("Added to cart!!");
    }
    public String getValue(int key){
        return mp.get(key);
    }


    @Override
    public void destroy() throws Exception {
        mp.clear();
        System.out.println("Bean is getting Destroyed");
    }
}
