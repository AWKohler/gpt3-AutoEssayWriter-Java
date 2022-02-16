package me.aronne.app.frame;

import javax.swing.*;

public class TrainingFrame extends JFrame {

    public TrainingFrame() {
        setTitle("Training");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        initComponents();
    }

    public void initComponents(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Training");
        JButton button = new JButton("Start");
        panel.add(label);
        panel.add(button);
        add(panel);
    }

}
