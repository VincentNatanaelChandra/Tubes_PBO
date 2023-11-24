/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Reschedule {
    public Reschedule(){
        reschedule();
    }
    
    private void reschedule(){
        
        Controller con = new Controller();
        
        //=============BAGIAN CONTAINER================
        JFrame formReschedule = new JFrame("Reschedule Menu");
        formReschedule.setSize(300, 300);
        formReschedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formReschedule.setLocationRelativeTo(null);
        formReschedule.setLayout(null);
        //================END CONTAINER=================
        
        //Judul Form
        JLabel labelTitle = new JLabel("Form Reschedule");
        Font fontTitle = new Font("Mont", Font.BOLD, 20);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 250, 30);
        formReschedule.add(labelTitle);
        
        //Kode Ticket
        JLabel labelTicketCode = new JLabel("Kode Ticket :");
        labelTicketCode.setBounds(20, 40, 100, 30);
        formReschedule.add(labelTicketCode);
        JTextField textTicketCode = new JTextField();
        textTicketCode.setBounds(105, 40, 165, 30);
        formReschedule.add(textTicketCode);
        
        //Alasan Reschedule
        JLabel labelReason = new JLabel("Alasan Reschedule :");
        labelReason.setBounds(20, 75, 200, 30);
        formReschedule.add(labelReason);
        JTextField textReason = new JTextField();
        textReason.setBounds(20, 110, 250, 70);
        formReschedule.add(textReason);
        
        Font fontLabelCheck = new Font("Mont", Font.PLAIN, 10);
        JLabel labelCheck = new JLabel("Apakah anda yakin ingin melakukan Reschedule? ");
        labelCheck.setFont(fontLabelCheck);
        labelCheck.setBounds(20, 185, 250, 20);
        JCheckBox checkAcc = new JCheckBox();
        checkAcc.setBounds(235, 185, 50, 20);
        formReschedule.add(labelCheck);
        formReschedule.add(checkAcc);
        
        JButton buttonSubmit = new JButton("Next Page");
        buttonSubmit.setBounds(160, 215, 100, 30);
        formReschedule.add(buttonSubmit);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticket = textTicketCode.getText();
                String reason = textReason.getText();
                boolean found = con.getTicket(ticket);
                if (found) {
                    formReschedule.dispose();
                    new nextReschedule(ticket, reason);
                } else {
                    JOptionPane.showMessageDialog(formReschedule, "Ticket Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        formReschedule.setVisible(true);
    }
    public static void main(String[] args) {
        new Reschedule();
    }
}
