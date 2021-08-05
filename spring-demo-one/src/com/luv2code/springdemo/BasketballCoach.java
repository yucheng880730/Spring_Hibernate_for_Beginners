package com.luv2code.springdemo;

public class BasketballCoach implements Coach{

    private FortuneService fortuneService;

    public BasketballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "play three 3 vs 3 game.";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
