package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FunnyFortuneService implements FortuneService{

    private Random myRandom = new Random();

    @Value("${foo.fortunes}")
    private String[] Fortunes;

    @Override
    public String getFortune() {
        return Fortunes[Math.abs(myRandom.nextInt()%Fortunes.length)];
    }
}
