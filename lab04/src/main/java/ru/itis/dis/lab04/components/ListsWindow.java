package ru.itis.dis.lab04.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListsWindow extends JFrame {

    public JList list1;
    public JList list2;
    public JList list3;

    public ListsWindow() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Simple Window");

        //GridLayout gridLayout = new GridLayout(1, 0, 5, 12);
        //this.setLayout(gridLayout);
        this.setLayout(new BorderLayout());
        JPanel panelList = new JPanel();
        this.add(panelList, BorderLayout.NORTH);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(panelButton, BorderLayout.SOUTH);


        BoxLayout boxy = new BoxLayout(panelList, BoxLayout.X_AXIS);
        panelList.setLayout(boxy);

        String[] data1 = { "Один", "Два", "Три", "Четыре", "Пять"};
        list1 = new JList(data1);
        panelList.add(list1);

        Vector<String> data2 = new Vector<>();
        data2.add("Первый");
        data2.add("Второй");
        list2 = new JList(data2);
        panelList.add(list2);

        Vector<String> data3 = new Vector<>();
        for(int i = 0; i < 100; i++) {
            data3.add("Длинный список " + i);
        }
        list3 = new JList(data3);
        panelList.add(new JScrollPane(list3));


        JButton button = new JButton("Показать выбор");
        button.addActionListener(new ButtonListener());

        panelButton.add(button);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ListsWindow();
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
                    ListsWindow.this,
                        list1.getSelectedValue() + "/" +
                                list2.getSelectedValue() + "/" +
                                list3.getSelectedValue()
                    );
        }
    }
}
