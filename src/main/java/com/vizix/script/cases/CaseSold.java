package com.vizix.script.cases;

import java.io.*;
import java.util.Random;

/**
 * Created by alvaro on 29-06-16.
 */
public class CaseSold {
    int counter = 1;
    public void Build(int count,double time) {
        fileStructure fls = new fileStructure();
        System.out.println("\n--Start Group "+counter+"--");
        String[] zones = {"0.0,1.0","0.1,0.5","1.5,0.8"};//CHANGE VALUES
        for(int j = 0; ;j++) {
            for(int i = 0; i < 3; i++) {
                System.out.println("\nBuilding aledata...");
                System.out.println("Zone: "+zones[i]);
                //System.out.println(fls.aledata("mnsSold",count,counter,zones[i]));
                PrintWriter w = null;
                try {
                    w = new PrintWriter("resource/aledata.txt", "UTF-8");
                    w.println(fls.aledata("mnsSold",count,counter,zones[i]));
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int sec = (int) time;
                random(sec*60);
            }
            System.out.println("\n--End Group--");
            counter++;
        }

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