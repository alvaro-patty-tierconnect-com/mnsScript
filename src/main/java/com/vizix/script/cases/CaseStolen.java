package com.vizix.script.cases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by alvaro on 29-06-16.
 */
public class CaseStolen {
    int counter = 1;
    public void Build(int count,double time) {
        fileStructure fls = new fileStructure();
        System.out.println("\n--Start Group "+counter+"--");
        String[] zones = {"9.8,126.2","21.8,125.9"};//CHANGE VALUES
        for(int j = 0; ;j++) {
            for(int i = 0; i < 2; i++) {
                System.out.println("\nBuilding aledata...");
                System.out.println("Zone: "+zones[i]);
                //System.out.println(fls.aledata("mnsSold",count,counter,zones[i]));

                PrintWriter w = null;
                try {
                    w = new PrintWriter("aledataMnS_Stolen.txt", "UTF-8");
                    w.println(fls.aledata("mnsStolen",count,counter,zones[i]));
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                executeComand();

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

    void executeComand(){
        System.out.println("Executing aledata.sh----");

        Process p;
        try {
            p = Runtime.getRuntime().exec("sh aledataStolen.sh");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader readerError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line = null;
            while((line = reader.readLine())!=null) {
                System.out.println(line);
            }
            line = null;
            while((line = readerError.readLine())!=null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Execute aledata.sh----");
    }
}
