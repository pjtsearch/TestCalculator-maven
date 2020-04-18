package com.pjtsearch.Operations;

import java.util.ArrayList;

public class Subtraction {
    public Float value = null;
    public Subtraction(ArrayList<Float> args) {
        value = args.get(0)-args.get(1);
    }
}