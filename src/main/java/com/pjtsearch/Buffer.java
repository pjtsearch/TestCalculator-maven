package com.pjtsearch;

import java.util.ArrayList;

public class Buffer {
    ArrayList<Float> items = new ArrayList<Float>();
    int maxSize = 2;
    public Buffer(int maxSize){
        this.maxSize = maxSize;
    }
    public void push(Float item) throws Exception{
        if (items.size() < maxSize){
            items.add(item);
        }else{
            throw new Exception("Buffer max size exceeded.");
        }
    }
    public void delete(int index){
        items.remove(index);
    }
    public void pop(){
        delete(items.size()-1);
    }
    public void clear(){
        items.clear();
    }
    public void set(ArrayList<Float> value){
        items = value;
    }
}