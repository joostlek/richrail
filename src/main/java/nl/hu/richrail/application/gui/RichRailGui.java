package nl.hu.richrail.application.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RichRailGui {

    public static void start() {
        // Create frame.
        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create button.
        JButton button = new JButton();

        button.setBounds(130, 100, 100, 40);
        button.setText("Hoi");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JButton) e.getSource()).setText("Doei");
            }
        });

        // Show frame.
        frame.add(button);
        frame.setVisible(true);
    }

}
