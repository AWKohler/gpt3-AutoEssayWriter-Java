package me.aronne.app.frame;

import me.aronne.app.api.Gpt3interface;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationFrame extends javax.swing.JFrame {

    public JTextArea editorPane;

    public ApplicationFrame() {
        initComponents();
    }

    private void initComponents() {
        setSize(800, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel textPanelHolder = new JPanel();
        textPanelHolder.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));

        JLabel textLabel = new JLabel("<html><tag>Enter prompt here<br><small>Your prompt should be a sentence, or paragraph you want to send to the AI for it to complete into a essay</tag></html>");
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));


        // The Instructional area
        JTextArea instructPane = new JTextArea();
        instructPane.setText("\nYour prompt should be a sentence, or paragraph you want to send to the AI for it to complete into a essay");
        instructPane.setEditable(false);
        instructPane.setFont(new Font("Arial", Font.BOLD, 16));
        instructPane.setLineWrap(true);
        instructPane.setWrapStyleWord(true);


        editorPane = new JTextArea();
        TitledBorder titledBorder = new TitledBorder("Enter prompt here");
        editorPane.setFont(new Font("Monospaced", Font.PLAIN, 14));
        editorPane.setLineWrap(true);
        editorPane.setWrapStyleWord(true);
        editorPane.setBorder(titledBorder);
        editorPane.setLocation(0, 0);


        // scrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        editorPane.setText("Enter prompt here\n\nYour prompt should be a sentence, or paragraph you want to send to the AI for it to complete into a essay");
        scrollPane.setViewportView(editorPane);
        editorPane.setCaretPosition(0);

        jPanel.add(scrollPane, "cell 1 10,growy");


        JPanel outerButtonPanel = new JPanel();

        JButton completeButton = new JButton("Complete");
        JButton apiButton = new JButton("Train AI");
        JButton copyButton = new JButton("Copy Result");

        outerButtonPanel.setLayout(new MigLayout());
        outerButtonPanel.add(completeButton, "wrap");
        outerButtonPanel.add(apiButton, "wrap");
        outerButtonPanel.add(copyButton, "wrap");

        apiButton.addActionListener(e -> {
            TrainingFrame trainingFrame = new TrainingFrame();
        });

        completeButton.addActionListener(e -> {
            complete();
        });

        // Set the default button (makes it highlighted)
        getRootPane().setDefaultButton(completeButton);

        // Add all the panels
        sidePanel.add(instructPane);
        sidePanel.add(outerButtonPanel);

        jPanel.add(sidePanel);
        add(jPanel);
    }

    public void setTextCleanly(String text) {

        String[] words = text.split(" ");

        Timer t = new Timer(100, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= words.length) return;
                editorPane.append(words[i] + " ");
                i++;
            }
        });
        t.start();
    }

    public void complete(){
        Gpt3interface.sendRequest(getPreparedText(), this);
    }

    public String getPreparedText(){
        return editorPane.getText();
    }
}
