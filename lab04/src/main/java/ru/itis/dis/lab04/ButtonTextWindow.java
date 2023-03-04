package ru.itis.dis.lab04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTextWindow extends JFrame {

    // Элементы управления
    private JButton button;
    private JTextField textField;
    private JLabel label1;
    private JLabel label2;

    public ButtonTextWindow() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Simple Window");
        this.setVisible(true);

        // Отключаем автоматическое расположение
        this.setLayout(null);

        button = new JButton("Нажми меня");
        button.setBounds(10,10, 100, 20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xStr = textField.getText();
                Double x = Double.parseDouble(xStr);
                Double y = exp(x);
                label2.setText(y.toString());
            }
        });

        this.add(button);

        label1 = new JLabel("Введите");
        label1.setBounds(10, 40, 70,20);
        this.add(label1);

        textField = new JTextField();
        textField.setBounds(80, 40, 200, 20);
        this.add(textField);

        label2 = new JLabel();
        label2.setBounds(10, 70, 200,20);
        label2.setText("Информация");
        this.add(label2);
    }

    public double exp(double x) {
        return Math.exp(x);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new ButtonTextWindow(); } });
    }
}
