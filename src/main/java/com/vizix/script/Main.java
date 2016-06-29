package com.vizix.script;

/**
 * Created by alvaro on 29-06-16.
 */
public class Main {
    public static String Step;//sold,stole, returned
    public static int things;
    public static double time;
    public static void main(String[] args){
        //CHANGE VALUES
        Step = "sold";
        things = 11;
        time = 1;

        Blink b = new Blink();
        b.Start(Step,things,time);

    }
}
