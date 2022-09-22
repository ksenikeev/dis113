package ru.itis.dis.lab04;

import javax.swing.*;

public class SimpleWindow extends JFrame {

    public SimpleWindow() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Simple Window");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleWindow();
    }
}
