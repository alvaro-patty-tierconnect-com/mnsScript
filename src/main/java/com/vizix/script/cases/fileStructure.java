package com.vizix.script.cases;

/**
 * Created by alvaro on 29-06-16.
 */
public class fileStructure {
    public String aledata(String name,int count,int counter,String zone) {
        String ini = "EPOCH,NOW\nDELT,REL\n";
        String map = "CS,-1.472006,52.918259,0.0,0.0,meters\n";//CHANGE VALUES
        String blink = "\n";

        String loc = "LOC,00:00:00,";
        String pos =","+zone;
        String complement = ",0,LR5,x3ed9371";
        String end = "\n";

        int endd = count*counter;
        int beg = ((counter-1)*count)+1;

        for(int i = beg; i <= endd;i++){
            blink += loc+name+i+pos+complement+end;
        }
        return ini+map+blink;
    }
}
