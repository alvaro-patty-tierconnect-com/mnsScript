package com.vizix.script;

import com.vizix.script.cases.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by alvaro on 29-06-16.
 */
public class Blink {
    CaseSold cSold = new CaseSold();
    CaseStolen cStolen = new CaseStolen();
    CaseReturned cReturned = new CaseReturned();
    void Start(String step, int thing, double time) {
        System.out.println("Starting Script...");

        if (step.equals("sold"))cSold.Build(thing, time);
        if (step.equals("stolen")) cStolen.Build(thing, time);
        if (step.equals("returned"))cReturned.Build();

        System.out.println("DONE");
    }
}
