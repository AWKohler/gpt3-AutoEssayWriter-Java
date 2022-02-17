package me.aronne.app.frame;

import javax.swing.*;
import java.awt.*;

public class OptionFrame extends javax.swing.JFrame {

    public OptionFrame() {
        init();
    }

    public void init() {
        setTitle("Options");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        display();
    }

    public void display() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));
        panel.add(new JLabel("Options"));

        panel.add(new JLabel("<html><tag>Choose Research Paper to optimise the AI for research papers<br><html>"){
            @Override
            public Font getFont() {
                return new Font("Arial", Font.BOLD, 16);
            }
        });
        JButton button3 = new JButton("Reserch Paper");
        panel.add(button3);

        panel.add(new JLabel("<html><tag>Choose Book Report to optimise the AI for book reports<br><html>"){
            @Override
            public Font getFont() {
                return new Font("Arial", Font.BOLD, 16);
            }
        });
        JButton button2 = new JButton("Book Report");
        panel.add(button2);

        panel.add(new JLabel("<html><tag>Choose Fictional Story to optimise the AI for fictional stories<br><html>"){
            @Override
            public Font getFont() {
                return new Font("Arial", Font.BOLD, 16);
            }
        });
        JButton button4 = new JButton("Fictional Story");
        panel.add(button4);

        panel.add(new JLabel("<html><tag>Choosing Freestyle will let you have more control over your essay. The AI will complete paragraphs that you start<br><html>"){
            @Override
            public Font getFont() {
                return new Font("Arial", Font.BOLD, 16);
            }
        });
        JButton button5 = new JButton("Freestyle");
        panel.add(button5);

        JButton button = new JButton("Back");

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new ApplicationFrame();
                dispose();

            }

        }
        );
        panel.add(button);

        add(panel);


    }

}
