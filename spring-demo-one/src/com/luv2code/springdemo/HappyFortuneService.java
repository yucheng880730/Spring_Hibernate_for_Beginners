package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Random;

public class HappyFortuneService implements FortuneService{

    private ArrayList<String> list;
    private Random random;

    public HappyFortuneService() {
        list = new ArrayList<>();
        list.add("Today is your lucky day");
        list.add("You will meet someone great today");
        list.add("You will win lottery");
        random = new Random();
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
