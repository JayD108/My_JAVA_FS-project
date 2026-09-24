package com.example.myapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class App implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField t1, t2, tresult;
    JButton addBtn, subBtn, mulBtn, divBtn, exitBtn, clearBtn;

    public App() {
        frame = new JFrame("✨ Fancy Calculator ✨");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Input fields
        JLabel l1 = new JLabel("First Number:");
        l1.setForeground(Color.WHITE);
        l1.setFont(labelFont);
        t1 = new JTextField(10);

        JLabel l2 = new JLabel("Second Number:");
        l2.setForeground(Color.WHITE);
        l2.setFont(labelFont);
        t2 = new JTextField(10);

        JLabel l3 = new JLabel("Result:");
        l3.setForeground(Color.WHITE);
        l3.setFont(labelFont);
        tresult = new JTextField(10);
        tresult.setEditable(false);

        // Buttons
        addBtn = new JButton("ADD");
        subBtn = new JButton("SUBTRACT");
        mulBtn = new JButton("MULTIPLY");
        divBtn = new JButton("DIV");
        exitBtn = new JButton("EXIT");
        clearBtn = new JButton("CLEAR");

        addBtn.setBackground(new Color(144, 238, 144)); // Light Green
        exitBtn.setBackground(new Color(255, 99, 71)); // Tomato Red
        clearBtn.setBackground(Color.ORANGE);

        panel.setLayout(null); // <--- IMPORTANT

        // setBounds for Layouts
        l1.setBounds(50, 50, 100, 25); // <--- positioning
        t1.setBounds(160, 50, 150, 25);
        l2.setBounds(50, 100, 120, 25);
        t2.setBounds(160, 100, 150, 25);
        l3.setBounds(50, 150, 100, 25);
        tresult.setBounds(160, 150, 150, 25);
        addBtn.setBounds(50, 200, 100, 25);
        subBtn.setBounds(160, 200, 120, 25);
        mulBtn.setBounds(290, 200, 120, 25);
        divBtn.setBounds(50, 250, 100, 25);
        exitBtn.setBounds(160, 250, 100, 25);
        clearBtn.setBounds(290, 250, 120, 25);

        // Add listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        // Add components to panel
        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(tresult);
        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(exitBtn);
        panel.add(clearBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
        if (e.getSource() == clearBtn) {
            t1.setText("");
            t2.setText("");
            tresult.setText("");
            return;
        }
        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result;

            if (e.getSource() == addBtn) {
                result = num1 + num2;
                tresult.setText(String.valueOf(result));
            }
            if (e.getSource() == subBtn) {
                result = num1 - num2;
                tresult.setText(String.valueOf(result));
            }
            if (e.getSource() == mulBtn) {
                result = num1 * num2;
                tresult.setText(String.valueOf(result));
            }
            if (e.getSource() == divBtn) {
                if (num2 != 0) {
                    result = num1 / num2;
                    tresult.setText(String.valueOf(result));
                } else {
                    tresult.setText("Error: Divide by 0");
                    // return;
                }
            }
        } catch (NumberFormatException ex) {
            tresult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
