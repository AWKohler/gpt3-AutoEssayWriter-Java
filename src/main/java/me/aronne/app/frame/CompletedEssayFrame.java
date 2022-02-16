package me.aronne.app.frame;

import javax.swing.*;
import java.awt.*;

public class CompletedEssayFrame extends JFrame {

    String essay = "";

    public CompletedEssayFrame() {

    }

    public void init(){
        setTitle("Completed Essay");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.essay = essay;
        display();
    }


    public void display() {
        JTextArea textArea = new JTextArea();
        textArea.setText(essay);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);

//        JScrollPane scrollPane5 = new JScrollPane();
//        //======== scrollPane5 ========
//        {
//            scrollPane5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//            scrollPane5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//
//            //---- editorPane1 ----
//            textArea.setText("Enter prompt here\n\nYour prompt should be a sentence, or paragraph you want to send to the AI for it to complete into a essay");
//            scrollPane5.setViewportView(textArea);
//
//            textArea.setCaretPosition(0);
//        }
//        add(scrollPane5, "cell 1 10,growy");
    }

    public void setEssay(String essay){
        this.essay = essay;
    }

}
