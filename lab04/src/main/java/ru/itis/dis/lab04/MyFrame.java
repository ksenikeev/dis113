package ru.itis.dis.lab04;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Inner Frame");

        init();

        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("Button 1");

        this.add(button);
    }
}
