/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.Controller;


public class Login {
    public Login() {
        LoginScreen();
    }

    private void LoginScreen() {
        JFrame frameCari = new JFrame("LOGIN");

        Controller con = new Controller();
        
        JLabel email = new JLabel("Email: ");
        email.setBounds(10, 10, 100, 30);
        JTextField inputEmail = new JTextField();
        inputEmail.setBounds(120, 10, 200, 30);
        
        JLabel password = new JLabel("Pasword: ");
        password.setBounds(10, 40, 100, 30);
        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(120, 40, 200, 30);
        
        
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(150, 100, 100, 30);
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(inputPassword.getPassword());
                boolean found = con.getUser(inputEmail.getText(), password);
                if (found) {
                    frameCari.dispose();
                    int getId = con.getIdUser(inputEmail.getText());
                    new Gamelist(getId);
                } else {
                    JOptionPane.showMessageDialog(frameCari, "Yah ga ada", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(150, 130, 150, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameCari.dispose();
                new MainMenu();
            }
        });

        JPanel panel = new JPanel(null);
        panel.add(email);
        panel.add(inputEmail);
        panel.add(password);
        panel.add(inputPassword);
        panel.add(backButton);
        panel.add(buttonLogin);

        frameCari.setSize(400, 200);
        frameCari.add(panel);
        frameCari.setVisible(true);
    }
}
