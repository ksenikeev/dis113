package ru.itis.dis.lab06;

import java.awt.*;
import javax.swing.*;

public class DrawArc extends JPanel {

    public void paintComponent(Graphics g) {

        g.drawArc(1, 1, 200, 200, 0, 270);

    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Draw Arc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(300, 200);

        DrawArc panel = new DrawArc();

        frame.add(panel);

        frame.setVisible(true);
    }
}