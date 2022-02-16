package me.aronne.app;

import javax.swing.*;
import java.awt.*;

public class loginEntry {
    private String username = "";
    private String password = "";
    private JButton loginButton;
    public Panel unPanel = new Panel();
    public Panel pwPanel = new Panel();

    public loginEntry() {
        loginButton = new JButton("Login");
        unPanel();
        pwPanel();
    }

    public void unPanel(){
        unPanel.add(new Label("Username:"));
        TextField unTextField = new TextField(20);
        unPanel.add(unTextField);
        loginButton.addActionListener(e -> {
            this.username = unTextField.getText();
        });
    }

    public void pwPanel(){
        pwPanel = new Panel();
        pwPanel.add(new Label("Password:"));
        TextField pwTextField = new TextField(20);
        pwPanel.add(pwTextField);
        loginButton.addActionListener(e -> {
            this.password = pwTextField.getText();
        });
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //getter for un and pw panels
    public Panel getUnPanel() {
        return unPanel;
    }

    public Panel getPwPanel() {
        return pwPanel;
    }

    //getter for login button
    public JButton getLoginButton() {
        return loginButton;
    }
}
