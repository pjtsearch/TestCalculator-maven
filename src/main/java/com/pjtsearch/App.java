package com.pjtsearch;

import com.pjtsearch.Operations.OperationType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {
    JFrame window;
    JLabel bufferText;
    JPanel btns;
    Calculator calculator;

    public static void main(String[] args) throws Exception {
        javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        App app = new App();
        app.openFrame(500, 600);
    }

    public App() {
        calculator = new Calculator();
        createBufferText();
        createBtns();
        createFrame();
    }

    public void createFrame() {
        window = new JFrame();
        window.setLayout(new GridLayout(2, 0));
        window.add(bufferText);
        window.add(btns);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void openFrame(int x, int y) {
        window.setSize(x, y);
        window.setVisible(true);
    }

    public void createBufferText() {
        bufferText = new JLabel("");
    }

    public void addToBufferText(String value) {
        bufferText.setText(bufferText.getText() + value);
    }

    public void createBtns() {
        btns = new JPanel();
        String[] btnsArray = { "", "", "<-", "CLR", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "x", ".",
                "0", "=", "/", };

        for (int i = 0; i < btnsArray.length; i++) {
            final String txt = btnsArray[i];
            JButton btn = new JButton(txt);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (Integer.parseInt(txt) >= 0 && Integer.parseInt(txt) <= 10) {
                            addToBufferText(txt);
                        }
                    } catch (NumberFormatException nfe) {
                    }
                    if (txt == "."){
                        addToBufferText(txt);
                    }
                    if (txt == "+" || txt == "-" || txt == "x" || txt == "/") {
                        if (bufferText.getText() != ""){
                            try {
                                calculator.buffer.clear();
                                calculator.buffer.push(Float.parseFloat(bufferText.getText()));
                            } catch (Exception e1) {
                            }
                            bufferText.setText("");
                            System.out.println(calculator.buffer.items);
                            switch (txt) {
                                case "+":
                                    calculator.setOperation(OperationType.ADD);
                                    break;
                                case "-":
                                    calculator.setOperation(OperationType.SUBTRACT);
                                    break;
                                case "x":
                                    calculator.setOperation(OperationType.MULTIPLY);
                                    break;
                                case "/":
                                    calculator.setOperation(OperationType.DIVIDE);
                                    break;
                            }

                        }
                    }
                    if (txt == "=") {
                        try {
                            try {
                                if (calculator.operation != null) calculator.buffer.push(Float.parseFloat(bufferText.getText()));
                            } catch (Exception e1) {
                            }
                            System.out.println(calculator.buffer.items);
                            calculator.eval();
                            calculator.setOperation(null);
                            System.out.println(String.valueOf(calculator.buffer.items.get(0)));
                            bufferText.setText(String.valueOf(calculator.buffer.items.get(0)));
                        } catch (Exception e1) {}
                    }
                    if (txt == "CLR") {
                        bufferText.setText("");
                        calculator.buffer.clear();
                        calculator.setOperation(null);
                    }
                    if (txt == "<-"){
                        bufferText.setText(bufferText.getText().replaceAll(".$", ""));
                    }
                }  
            });  
            btns.add(btn);
        }

        btns.setLayout(new GridLayout(5,4)); 
    }
}