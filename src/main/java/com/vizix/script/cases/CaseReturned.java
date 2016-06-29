package com.vizix.script.cases;

import java.util.Random;

/**
 * Created by alvaro on 29-06-16.
 */
public class CaseReturned {
    public void Build() {
        System.out.println(".");
    }

    void random(int sec){
        Random rand = new Random();
        int s = rand.nextInt(sec) + 1;
        System.out.println("Waiting "+s+" seconds.");
        for(int i = s;i > 0; i--){
            try {
                Thread.sleep(1000);
                if(i <= 10) System.out.println(i+" s...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
