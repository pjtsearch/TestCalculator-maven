package com.pjtsearch;

import java.util.ArrayList;
import java.util.Arrays;

import com.pjtsearch.Operations.Addition;
import com.pjtsearch.Operations.Division;
import com.pjtsearch.Operations.Multiplication;
import com.pjtsearch.Operations.OperationType;
import com.pjtsearch.Operations.Subtraction;

public class Calculator {
    OperationType operation = null;
    Buffer buffer = new Buffer(2);
    public Calculator(){

    }
    public void setOperation(OperationType newOperation){
        operation = newOperation;
    }
    public void eval() throws Exception{
        Float newValue = null;
        switch (operation){
            case ADD:
                newValue = new Addition(buffer.items).value;
                break;
            case SUBTRACT:
                newValue = new Subtraction(buffer.items).value;
                break;
            case MULTIPLY:
                newValue = new Multiplication(buffer.items).value;
                break;
            case DIVIDE:
                newValue = new Division(buffer.items).value;
                break;
            default:
                throw new Exception("Operation: '"+operation+"' is not recognized");
        }
        buffer.set(new ArrayList<Float>(Arrays.asList(newValue)));
        operation = null;
    }
}