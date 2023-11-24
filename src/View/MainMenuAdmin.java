/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class MainMenuAdmin {
   private JFrame frame;

    
    
    public MainMenuAdmin(int id,String nama){
        MenuAdmin(id, nama);
    }
    
    private void MenuAdmin(int id, String nama){
        //=============BAGIAN CONTAINER================
        JFrame formMenuAdmin = new JFrame("Menu Admin");
        formMenuAdmin.setSize(320, 330);
        formMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuAdmin.setLocationRelativeTo(null);
        formMenuAdmin.setLayout(null);
        //================END CONTAINER=================
        
        JLabel labelTitle = new JLabel("Welcome Back, Admin " + nama);
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(10, 5, 400, 30);
        formMenuAdmin.add(labelTitle);
        
        JButton buttonUpdateDestination = new JButton("Update Destination");
        buttonUpdateDestination.setBounds(30, 40, 250, 30);
        formMenuAdmin.add(buttonUpdateDestination);
    
         UpdateDestinasi updateDestinasi = new UpdateDestinasi();

          buttonUpdateDestination.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  // Menutup tampilan saat ini (MainMenuAdmin)
                  formMenuAdmin.setVisible(false);

                  // Menampilkan tampilan baru dari UpdateDestination
                  updateDestinasi.showUpdateDestinasiWindow(true);
              }
          });   
        
        JButton buttonUpdateFlight = new JButton("Update Flight");
        buttonUpdateFlight.setBounds(30, 75, 250, 30);
        formMenuAdmin.add(buttonUpdateFlight);
        
        UpdatePenerbangan updateFlight = new UpdatePenerbangan();

          buttonUpdateFlight.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  // Menutup tampilan saat ini (MainMenuAdmin)
                  formMenuAdmin.setVisible(false);

                  // Menampilkan tampilan baru dari UpdateFlight
                  updateFlight.showUpdatePenerbanganWindow(true);
              }
          });
          
        JButton buttonUpdatePromo = new JButton("Update Promo");
        buttonUpdatePromo.setBounds(30, 110, 250, 30);
        formMenuAdmin.add(buttonUpdatePromo);

         
          UpdatePromo updatePromo = new UpdatePromo();

          buttonUpdatePromo.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  // Menutup tampilan saat ini (MainMenuAdmin)
                  formMenuAdmin.setVisible(false);

                  // Menampilkan tampilan baru dari UpdatePromo
                  updatePromo.showUpdatePromoWindow(true);
              }
          });

        JButton buttonConfirmationReschedule = new JButton("Reschedule Confirmation");
        buttonConfirmationReschedule.setBounds(30, 145, 250, 30);
        formMenuAdmin.add(buttonConfirmationReschedule);
        
            RescheduleConfirm rescheduleConfirm = new RescheduleConfirm(); // Menginisialisasi objek RescheduleConfirm

    buttonConfirmationReschedule.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            rescheduleConfirm.showRescheduleConfirmWindow(true);
            formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
        }
    });
        
        JButton buttonConfirmationRefund = new JButton("Refund Confirmation");
        buttonConfirmationRefund.setBounds(30, 180, 250, 30);
        formMenuAdmin.add(buttonConfirmationRefund);
      
        RefundConfirm refundConfirm = new RefundConfirm(); // Menginisialisasi objek RefundConfirm

        buttonConfirmationRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refundConfirm.showRefundConfirmWindow(true);
                formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
            }
        });
        
        JButton buttonHistory = new JButton("View History");
        buttonHistory.setBounds(30, 215, 250, 30);
        formMenuAdmin.add(buttonHistory);
        
        JButton buttonBacktoLogin = new JButton("Back");
        buttonBacktoLogin.setBounds(30, 250, 250, 30);
        formMenuAdmin.add(buttonBacktoLogin);
        
            buttonBacktoLogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            formMenuAdmin.setVisible(false); // Sembunyikan formMenuAdmin
            Login formLogin = new Login(); // Buat objek baru dari FormLogin
        }
    });

        formMenuAdmin.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new MainMenuAdmin(11,"tono");
}
}

