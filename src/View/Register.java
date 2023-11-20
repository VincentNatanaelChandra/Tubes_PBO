/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Register {

    public Register() {
        newRegister();
    }

    private void newRegister() {
        //=============BAGIAN CONTAINER================
        JFrame formRegister = new JFrame("Register Menu");
        formRegister.setSize(320, 350);
        formRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formRegister.setLocationRelativeTo(null);
        formRegister.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Welcome New User!!!");
        labelTitle.setBounds(80, 5, 250, 30);
        formRegister.add(labelTitle);
        
        //Login: Username
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(100, 40, 100, 30);
        formRegister.add(labelUsername);
        JTextField textUsername = new JTextField();
        textUsername.setBounds(170, 40, 150, 30);
        formRegister.add(textUsername);

        //Login: Username
        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setBounds(100, 75, 100, 30);
        formRegister.add(labelEmail);
        JTextField textEmail = new JTextField();
        textEmail.setBounds(170, 75, 150, 30);
        formRegister.add(textEmail);

        //Login: Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(100, 110, 100, 30);
        formRegister.add(labelPassword);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 110, 150, 30);
        formRegister.add(passwordField);

        //Login: Button
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(170, 145, 80, 30);
        formRegister.add(buttonLogin);

        formRegister.setVisible(true);
    }
}
