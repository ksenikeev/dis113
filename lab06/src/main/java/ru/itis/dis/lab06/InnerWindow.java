package ru.itis.dis.lab06;

import javax.swing.*;

public class InnerWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        //new SimpleDBTable();
                        //new DefaultModelTableFrame();
                        //new SimpleTableFrame();
                        new ExModelTableFrame();
                    } });
    }
}
