package com.hero.pojo;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("asfasdfasd");
            }
        };


        runnable.run();

    }
}
