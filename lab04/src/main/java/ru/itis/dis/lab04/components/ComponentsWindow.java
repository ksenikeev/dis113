package ru.itis.dis.lab04.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponentsWindow extends JFrame {

    public ComponentsWindow() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Simple Window");

        this.setLayout(null);

        // Метка
        JLabel label1 = new JLabel("Пример метки 1");
        label1.setBounds(10, 10, 300, 30);
        this.add(label1);

        JLabel label2 = new JLabel("<html><span style=\"color:'green'\">Пример метки 2</span></html>");
        this.add(label2);
        label2.setBounds(10, 50, 300, 30);

        ImageIcon image = new ImageIcon("smile.png");
        JLabel label3 = new JLabel();
        label3.setIcon(image);
        this.add(label3);
        label3.setBounds(10, 100, 64, 64);

        // Текстовое поле
        JTextField textField = new JTextField();
        textField.setBounds(10, 300, 200, 30);
        this.add(textField);

        // Кнопка
        JButton button = new JButton("Кнопка");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        ComponentsWindow.this,
                        textField.getText());
            }
        });
        button.setBounds(10, 170, 100, 30);
        this.add(button);

        JButton button2 = new JButton();
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setEnabled(false);
            }
        });
        button2.setIcon(new ImageIcon("1.png"));
        button2.setRolloverIcon(new ImageIcon("2.png"));
        button2.setPressedIcon(new ImageIcon("3.png"));
        button2.setDisabledIcon(new ImageIcon("4.png"));
        button2.setBounds(10, 230, 64   , 64);
        this.add(button2);

        JCheckBox checkBox = new JCheckBox("Press my", false);
        checkBox.setBounds(10, 340, 150, 30);

        System.out.println(checkBox.isSelected());
        this.add(checkBox);

        JRadioButton radio1 = new JRadioButton("Java");
        radio1.setBounds(10, 400, 100, 60);
        add(radio1);
        radio1.setSelected(true);
        JRadioButton radio2 = new JRadioButton("Python");
        radio2.setBounds(110, 400, 100, 60);
        add(radio2);
        ButtonGroup gr = new ButtonGroup();
        gr.add(radio1);
        gr.add(radio2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentsWindow();
    }
}
