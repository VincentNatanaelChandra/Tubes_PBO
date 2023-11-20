/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Login {
    
    private static JFrame frame;
    private static String loggedInUser;
    
    private void performLogin(String username, String password) {
        // Implement your logic for user authentication here
        // For demonstration purposes, just print the credentials
        System.out.println("Logged in as: " + username);
    }
    
    public Login() {
        newLogin();
    }
    
    private void newLogin() {
        
        //=============BAGIAN CONTAINER================
        JFrame form = new JFrame("Flight Apps Harapan Bangsa");
        form.setSize(420, 280);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);
        ImageIcon backgroundImage = new ImageIcon("D:\\ITHB\\Semester 3\\Prak. PBO\\tubesPBO_view\\src\\View\\pswt.png"); // Ganti dengan path gambar Anda
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 420, 280);
        //================END CONTAINER=================
        
        //==================COMPONENT===================
        //Judul Form
        JLabel labelTitle = new JLabel("Welcome to, Flight Apps Harapan Bangsa!!!");
        labelTitle.setBounds(80, 5, 250, 30);
        form.add(labelTitle);
        
        //Login
        JLabel labelLogin = new JLabel("Login to your Account");
        labelLogin.setBounds(140, 40, 350, 30);
        form.add(labelLogin);
        
        //Login: Username
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(100, 85, 100, 30);
        form.add(labelUsername);
        JTextField textUsername = new JTextField();
        textUsername.setBounds(170, 85, 150, 30);
        form.add(textUsername);
        
        //Login: Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(100, 115, 100, 30);
        form.add(labelPassword);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 115, 150, 30);
        form.add(passwordField);
        //Login: Button
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(170, 150, 80, 30);
        form.add(buttonLogin);
        
        //Register
        JLabel labelRegister = new JLabel("Doesn't have any account?");
        labelRegister.setBounds(100, 185,160, 30);
        form.add(labelRegister);
        
        JLabel linkLabel = new JLabel("<html><u>Register</u></html>");
        linkLabel.setForeground(Color.BLUE); // Mengubah warna teks menjadi biru
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mengubah kursor saat mengarah ke hyperlink
        linkLabel.setBounds(260, 185, 250, 30);
        form.add(linkLabel);
        
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Register();
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = textUsername.getText();
            char[] password = passwordField.getPassword();
            loggedInUser = username;
            performLogin(username, new String(password));
            
        }
    });
        
        form.add(backgroundLabel);
        form.setVisible(true);
    }
}
