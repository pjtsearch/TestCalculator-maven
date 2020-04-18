package com.pjtsearch.Operations;

import java.util.ArrayList;

public class Multiplication {
    public Float value = null;
    public Multiplication(ArrayList<Float> args) {
        value = args.get(0)*args.get(1);
    }
}