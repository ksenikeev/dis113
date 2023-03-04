package ru.itis.dis.lab04;

import javax.swing.*;

public class InnerWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MyFrame(); } });
    }
}
