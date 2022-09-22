package ru.itis.dis.lab04;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstEvents extends JFrame {
    public FirstEvents() {
        super("FirstEvents");
        // при закрытии окна - выход
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // регистрируем нашего слушателя
        addKeyListener(new KeyL());
        // выводим окно на экран
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new FirstEvents(); } });
    }
}

// этот класс будет получать извещения о событиях
class KeyL implements KeyListener {
    // печать символа
    public void keyTyped(KeyEvent k) {
        System.out.println("keyTyped: " + k);
    }
    // нажатие клавиши
    public void keyPressed(KeyEvent k) {
        System.out.println("keyPressed: " + k);
    }
    // отпускание нажатой клавиши
    public void keyReleased(KeyEvent k) {
        System.out.println("keyReleased: " + k);
    }
}