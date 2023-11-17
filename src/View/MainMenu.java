/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Vincent
 */
public class MainMenu {
    public MainMenu(){
        pilihOpsi();
    }

    private void pilihOpsi() {
        JFrame mainMenu = new JFrame("PILIHLAH MUAHAHAHAHA");
        
        JButton buttonLogin = new JButton("LOGIN PENGGUNA");
        buttonLogin.setBounds(140, 100, 200, 30);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                mainMenu.dispose();
            }
        });
        
        JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(140, 250, 100, 30); 
        buttonExit.addActionListener((event) -> System.exit(0));

        mainMenu.add(buttonLogin);
        mainMenu.add(buttonExit);
        
        mainMenu.setSize(400, 600);
        mainMenu.setLayout(null);
        mainMenu.setVisible(true);
    }
}
