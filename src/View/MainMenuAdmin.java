/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class MainMenuAdmin {
    public MainMenuAdmin(int id,String nama){
        MenuAdmin(id, nama);
    }
    
    private void MenuAdmin(int id, String nama){
        //=============BAGIAN CONTAINER================
        JFrame formMenuAdmin = new JFrame("Register Menu");
        formMenuAdmin.setSize(320, 300);
        formMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuAdmin.setLocationRelativeTo(null);
        formMenuAdmin.setLayout(null);
        //================END CONTAINER=================
        
        JLabel labelTitle = new JLabel("Welcome Back, Admin " + nama);
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(10, 5, 400, 30);
        formMenuAdmin.add(labelTitle);
        
        JButton buttonUpdateSchedule = new JButton("Update Schedule");
        buttonUpdateSchedule.setBounds(30, 40, 250, 30);
        formMenuAdmin.add(buttonUpdateSchedule);
        
        JButton buttonUpdatePromo = new JButton("Update Promo");
        buttonUpdatePromo.setBounds(30, 75, 250, 30);
        formMenuAdmin.add(buttonUpdatePromo);
        
        JButton buttonConfirmationReschedule = new JButton("Reschedule Confirmation");
        buttonConfirmationReschedule.setBounds(30, 110, 250, 30);
        formMenuAdmin.add(buttonConfirmationReschedule);
        
        JButton buttonConfirmationRefund = new JButton("Refund Confirmation");
        buttonConfirmationRefund.setBounds(30, 145, 250, 30);
        formMenuAdmin.add(buttonConfirmationRefund);
        
        JButton buttonHistory = new JButton("View History");
        buttonHistory.setBounds(30, 180, 250, 30);
        formMenuAdmin.add(buttonHistory);
        
        JButton buttonBacktoLogin = new JButton("Back");
        buttonBacktoLogin.setBounds(30, 215, 250, 30);
        formMenuAdmin.add(buttonBacktoLogin);
        
        formMenuAdmin.setVisible(true);
    }
}

