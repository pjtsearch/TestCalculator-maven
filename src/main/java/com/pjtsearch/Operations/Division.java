package com.pjtsearch.Operations;

import java.util.ArrayList;

public class Division {
    public Float value = null;
    public Division(ArrayList<Float> args) {
        value = args.get(0)/args.get(1);
    }
}