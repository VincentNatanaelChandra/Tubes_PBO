/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class nextReschedule {
    public nextReschedule(String ticket, String reasonReschedule){
        nextReschedule(ticket, reasonReschedule);
    }
    
    private void nextReschedule(String ticketKode, String reason){
        //=============BAGIAN CONTAINER================
        JFrame formReschedule = new JFrame("Form Reschedule");
        formReschedule.setSize(420, 280);
        formReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formReschedule.setLocationRelativeTo(null);
        formReschedule.setLayout(null);
        //================END CONTAINER=================
        
        //==================COMPONENT===================
        //Judul Form
        JLabel labelTitle = new JLabel("Fill your new Schedule!!");
        Font fontTitle = new Font("Mont", Font.BOLD, 18);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 400, 30);
        formReschedule.add(labelTitle);
        
        
        formReschedule.setVisible(true);
    }
}

