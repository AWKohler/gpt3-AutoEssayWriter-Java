package me.aronne.app.frame;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ErrorFrame extends JFrame {

    public ErrorFrame(String message){
        setTitle("Error");
        setSize(200, 50);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        JLabel text = new JLabel(message);

        JButton button = new JButton("ok");

        add(text, "wrap");
        add(button);

        setVisible(true);
    }
}
