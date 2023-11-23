/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Payment {
    public Payment(){
        payment();
    }
    
    private void payment(){
        //=============BAGIAN CONTAINER================
        JFrame form = new JFrame("Payment Menu");
        form.setSize(650, 360);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Order Confirmation");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 300, 30);
        form.add(labelTitle);
        
        JLabel detailPurchase = new JLabel(); //Detail Pesanan
        JLabel detailHarga = new JLabel(); //Detail Total Harga
        
        Object[][] dataTicket = {
            {"Jakarta", "Semarang", "2023-11-27", "Dunia Air", "Over Night", "Indonesian Food", "Economy", "E1", "120000"}
        };
        
        String[] columnNames = {"Departure", "Arrival", "Date", "Arilines", "Preference", "Food", "Class", "Seat", "Price"};
        
        DefaultTableModel model = new DefaultTableModel(dataTicket, columnNames);
        
        JTable tablePurchase = new JTable(model);
        JScrollPane scrollPanel = new JScrollPane(tablePurchase);
        scrollPanel.setBounds(20, 40, 600, 95);
        form.getContentPane().add(scrollPanel);        

        //Payment Method
        JLabel labelpaymentMethod = new JLabel("Choose your Payment Method :");
        labelpaymentMethod.setBounds(20, 140, 250, 30);
        form.add(labelpaymentMethod);
        //ComboBox payment Method
        String paymentMethod[] = {"Debit Mastercard", "Virtual Account"};
        JComboBox dbPaymentMethod =new JComboBox(paymentMethod);
        dbPaymentMethod.setBounds(210, 140, 150, 30);
        form.add(dbPaymentMethod);
        
        //Promo Code
        JLabel labelPromoCode = new JLabel("Promo Code :");
        labelPromoCode.setBounds(20, 175, 100, 30);
        form.add(labelPromoCode);
        JTextField textPromo = new JTextField();
        textPromo.setBounds(115, 175, 150, 30);
        form.add(textPromo);
        
//        Jlabel harga = new JLabel("Ticket Price : " + con.getPrice());
        JLabel harga =new JLabel("Ticket Price : 120000");
        harga.setBounds(350, 210, 200, 20);
        form.add(harga);
//        Jlabel hargaPromo = new JLabel("Promo : " + con.getPricePromo(ticketPrice));
        JLabel hargaPromo = new JLabel("Promo : 12000");
        hargaPromo.setBounds(350, 230, 100, 20);
        form.add(hargaPromo);
//        JLabel hargaAfter = new JLabel("Total Payment : " + con.getAfterPrice(con.getPrice() - con.getPricePromo(ticketPrice));        
        JLabel hargaAfter = new JLabel("Total Payment : 108000");
        hargaAfter.setBounds(350, 250, 200, 20);
        form.add(hargaAfter);
        
        form.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Payment();
    }
}
