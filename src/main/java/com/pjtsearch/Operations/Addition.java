package com.pjtsearch.Operations;

import java.util.ArrayList;

public class Addition {
    public Float value = null;
    public Addition(ArrayList<Float> args) {
        value = args.get(0)+args.get(1);
    }
}