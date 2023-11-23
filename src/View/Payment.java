/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Payment {

    public Payment(int id, String name, String departureCity, String arrivalCity, Date dateFlight, String airlines, String classSeat, String seatNum, String preference, String fnb, int ticketPrice, int promo) {
        Payment(id, name, departureCity, arrivalCity, dateFlight, airlines, classSeat, seatNum, preference, fnb, ticketPrice, promo);
    }

    private void Payment(int id, String name, String departureCity, String arrivalCity, Date dateFlight, String airlines, String classSeat, String seatNum, String preference, String fnb, int ticketPrice, int promo) {

        Controller con = new Controller();

        //=============BAGIAN CONTAINER================
        JFrame form = new JFrame("Payment Menu");
        form.setSize(650, 400);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Order Confirmation");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 300, 30);
        form.add(labelTitle);

        JLabel labelName = new JLabel("Customer : " + name);
        labelName.setBounds(20, 40, 200, 30);
        form.add(labelName);

        Object[][] dataTicket = {
            {departureCity, arrivalCity, dateFlight, airlines, preference, fnb, classSeat, seatNum, ticketPrice}
        };

        String[] columnNames = {"Departure", "Arrival", "Date", "Arilines", "Preference", "Food", "Class", "Seat", "Price"};

        DefaultTableModel model = new DefaultTableModel(dataTicket, columnNames);

        JTable tablePurchase = new JTable(model);
        JScrollPane scrollPanel = new JScrollPane(tablePurchase);
        scrollPanel.setBounds(20, 75, 600, 95);
        form.getContentPane().add(scrollPanel);

        //Payment Method
        JLabel labelpaymentMethod = new JLabel("Choose your Payment Method :");
        labelpaymentMethod.setBounds(20, 175, 250, 30);
        form.add(labelpaymentMethod);
        //ComboBox payment Method
        String paymentMethod[] = {"Debit Mastercard", "Virtual Account"};
        JComboBox dbPaymentMethod = new JComboBox(paymentMethod);
        dbPaymentMethod.setBounds(210, 175, 150, 30);
        form.add(dbPaymentMethod);

        //Promo Code
        JLabel labelPromoCode = new JLabel("Promo Code :");
        labelPromoCode.setBounds(20, 210, 100, 30);
        form.add(labelPromoCode);
        JTextField textPromo = new JTextField();
        textPromo.setBounds(115, 210, 150, 30);
        form.add(textPromo);
        //Button Promo Code
        JButton buttonPromo = new JButton("Redeem Code");
        buttonPromo.setBounds(270, 215, 130, 20);
        form.add(buttonPromo);

        buttonPromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String promoCode = textPromo.getText();
                boolean found = con.getPromo(promoCode);

                if (found) {
                    int potongan = getPromoPercent(String promoCode);
                    form.dispose();
                    new Payment(id, name, departureCity, arrivalCity, dateFlight, airlines, classSeat, seatNum, preference, fnb, ticketPrice, promo);
                } else {
                    JOptionPane.showMessageDialog(form, "Promo Not Found!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JLabel line = new JLabel("___________________________"
                + "__________________________");
        Font fontLine = new Font("Arial", Font.BOLD, 20);
        line.setFont(fontLine);
        line.setBounds(20, 220, 650, 30);
        form.add(line);

        JLabel harga = new JLabel("Ticket Price : " + ticketPrice);
        harga.setBounds(450, 245, 200, 20);
        form.add(harga);

        JLabel hargaPromo = new JLabel("Promo : " + promo);
        hargaPromo.setBounds(450, 265, 100, 20);
        form.add(hargaPromo);

        JLabel hargaAfter = new JLabel("Total Payment : " + (ticketPrice - promo));
        hargaAfter.setBounds(450, 285, 200, 20);
        form.add(hargaAfter);

        JButton buttonConfirmPayment = new JButton("Confirmation Payment");
        buttonConfirmPayment.setBounds(110, 315, 400, 25);
        form.add(buttonConfirmPayment);
        
        //Controller Inser Data
        
        form.setVisible(true);
    }
}
