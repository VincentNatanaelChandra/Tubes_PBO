/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class FlightRefund {
    private static JTextField tiketText;
    private static JLabel resultLabel;
    private static JButton refundButton;
    private static JCheckBox checkBox1;
    private static JCheckBox checkBox2;
    private static JCheckBox checkBox3;
    private static JCheckBox checkBox4;
    private static JCheckBox checkBox5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Refund Tiket Pesawat");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

   
       private static void placeComponents(JPanel panel) {
        JLabel titleLabel = new JLabel("REFUND TIKET");
     titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
     titleLabel.setBounds(50, 10, 300, 30); 

     JLabel nomorTiketLabel = new JLabel("Nomor Tiket:");
     JTextField nomorTiketField = new JTextField(20);
     nomorTiketLabel.setBounds(50, 50, 150, 25); 
     nomorTiketField.setBounds(200, 50, 150, 25); 

     JLabel boardPassNameLabel = new JLabel("Boarding name:");
     JTextField boardPassNameField = new JTextField(20);
     boardPassNameLabel.setBounds(50, 90, 150, 25); 
     boardPassNameField.setBounds(200, 90, 150, 25);

     JCheckBox checkBox1 = new JCheckBox("Tanggal refund tidak kurang dari 1 hari ");
     JCheckBox checkBox2 = new JCheckBox("Jumlah pengembalian biaya hanya 80%");
     JCheckBox checkBox3 = new JCheckBox("Tiket yang sudah direfund tidak dapat dipakai kembali");
     JCheckBox checkBox4 = new JCheckBox("Pengembalian biaya dilakukan selama jam kerja");
     checkBox1.setBounds(50, 130, 250, 25); 
     checkBox2.setBounds(50, 170, 250, 25); 
     checkBox3.setBounds(50, 210, 345, 25); 
     checkBox4.setBounds(50, 250, 290, 25); 

     JButton refundButton = new JButton("REFUND");
     refundButton.setBounds(150, 290, 100, 30); 

     panel.setLayout(null); 

     panel.add(titleLabel);
     panel.add(nomorTiketLabel);
     panel.add(nomorTiketField);
     panel.add(boardPassNameLabel);
     panel.add(boardPassNameField);
     panel.add(checkBox1);
     panel.add(checkBox2);
     panel.add(checkBox3);
     panel.add(checkBox4);
     panel.add(refundButton);


    refundButton.addActionListener(e -> {
        if (checkBox1.isSelected() && checkBox2.isSelected() && checkBox3.isSelected() && checkBox4.isSelected()) {
            JOptionPane.showMessageDialog(panel, "Refund berhasil");
        } else {
            JOptionPane.showMessageDialog(panel, "Mohon centang semua syarat untuk refund");
        }
    });
}

private static JPanel createPanel(Component... components) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    for (Component component : components) {
        panel.add(component);
    }
    return panel;
}

private static boolean checkSyarat1() {
    
    return true; 
}

private static boolean checkSyarat2() {
   
    return true; 
}
private static boolean checkSyarat3() {
    
    return true; 
}
private static boolean checkSyarat4() {
    
    return true; 
}

// Method untuk melakukan proses refund
private static boolean processRefund(String nomorTiket) {
    boolean isTiketValid = checkDatabase(nomorTiket);
    if (isTiketValid) {
        boolean userAgrees = showConfirmationDialog();
        if (userAgrees) {
            boolean meetsConditions = checkConditions();
            if (meetsConditions) {
                return performRefund();
            } else {
                return false; 
            }
        } else {
            return false; 
        }
    } else {
        return false; 
    }
}

// Metode untuk memeriksa nomor tiket di database
private static boolean checkDatabase(String nomorTiket) {
   
    return true; 
}


private static boolean showConfirmationDialog() {
   
    return true; 
}


private static boolean checkConditions() {
   
    return true; 
}

// Method untuk melaksanakan refund
private static boolean performRefund() {
   
    return true; 
}
}



