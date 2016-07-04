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
        String[] zones = {"6.1,125.9","32.2,125.2","21.4,126.1"};//CHANGE VALUES
        for(int j = 0; ;j++) {
            System.out.println("\n--Start Group "+counter+"--");
            for(int i = 0; i < 3; i++) {
                System.out.println("\nBuilding aledata...");
                System.out.println("Zone: "+zones[i]);
                //System.out.println(fls.aledata("mnsSold",count,counter,zones[i]));

                PrintWriter w = null;
                try {
                    w = new PrintWriter("aledataMnS_Sold.txt", "UTF-8");
                    w.println(fls.aledata("mnsSold",count,counter,zones[i]));
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
            p = Runtime.getRuntime().exec("sh aledataSold.sh");
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
