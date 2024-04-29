package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer extends JobField{


    private static int nextId = 1;


    public Employer() {
        super(nextId);
        nextId++;
    }

    public Employer(String value) {
        super(nextId,value);
        nextId++;
    }

}
