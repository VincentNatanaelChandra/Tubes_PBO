/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Refund;
import Model.Reschedule;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class MainMenuAdmin {

    private JFrame frame;

    public MainMenuAdmin(int admin_id, String name) {
        MenuAdmin(admin_id, name);
    }

    private void MenuAdmin(int admin_id, String name) {
        //=============BAGIAN CONTAINER================
        JFrame formMenuAdmin = new JFrame("Menu Admin");
        formMenuAdmin.setSize(320, 330);
        formMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuAdmin.setLocationRelativeTo(null);
        formMenuAdmin.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Welcome Back, Admin " + name);
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(10, 5, 400, 30);
        formMenuAdmin.add(labelTitle);

        JButton buttonUpdateDestination = new JButton("Update Destination");
        buttonUpdateDestination.setBounds(30, 40, 250, 30);
        formMenuAdmin.add(buttonUpdateDestination);

        buttonUpdateDestination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                Integer destination[] = Controller.getInstance().getDestinationId().toArray(new Integer[Controller.getInstance().getDestinationId().size()]);

                if (destination.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Flight ID
                    int selectedDestinationID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a Destination ID:",
                            "Select Destination ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            destination,
                            destination[0]); // Pilihan default (opsional)

                    if (selectedDestinationID != 0) { // Jika pengguna memilih Flight ID
                        UpdateDestinasi updateDestinasi = new UpdateDestinasi(selectedDestinationID);
                        updateDestinasi.showUpdateDestinasiWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdateDestinasi
                    } else {
                        formMenuAdmin.setVisible(true);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Flight ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Destination IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonUpdateFlight = new JButton("Update Flight");
        buttonUpdateFlight.setBounds(30, 75, 250, 30);
        formMenuAdmin.add(buttonUpdateFlight);

        buttonUpdateFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                String flight[] = Controller.getInstance().getAllFlightCode().toArray(new String[Controller.getInstance().getAllFlightCode().size()]);

                if (flight.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Flight ID
                    String selectedFlightID = (String) JOptionPane.showInputDialog(
                            null,
                            "Choose a Flight ID:",
                            "Select Flight ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            flight,
                            flight[0]); // Pilihan default (opsional)

                    if (selectedFlightID != null) { // Jika pengguna memilih Flight ID
                        UpdatePenerbangan updatePenerbangan = new UpdatePenerbangan(selectedFlightID);
                        updatePenerbangan.showUpdatePenerbanganWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdatePenerbangan
                    } else {
                        formMenuAdmin.setVisible(true);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Flight ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Flight IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonUpdatePromo = new JButton("Update Promo");
        buttonUpdatePromo.setBounds(30, 110, 250, 30);
        formMenuAdmin.add(buttonUpdatePromo);

        buttonUpdatePromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup tampilan saat ini (MainMenuAdmin)
                formMenuAdmin.setVisible(false);

                Integer promo[] = Controller.getInstance().getPromoId().toArray(new Integer[Controller.getInstance().getPromoId().size()]);

                if (promo.length > 0) {
                    // Tampilkan JOptionPane untuk memilih Flight ID
                    int selectedPromoID = (int) JOptionPane.showInputDialog(
                            null,
                            "Choose a Promo ID:",
                            "Select Promo ID",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            promo,
                            promo[0]); // Pilihan default (opsional)

                    if (selectedPromoID != 0) { // Jika pengguna memilih Flight ID
                        UpdatePromo updatePromo = new UpdatePromo(selectedPromoID);
                        updatePromo.showUpdatePromoWindow(true);
                        formMenuAdmin.setVisible(false); // Menutup formMenuAdmin saat menampilkan UpdateDestinasi
                    } else {
                        new MainMenuAdmin(admin_id, name);
                    }
                } else {
                    // Tampilkan pesan jika tidak ada Flight ID yang tersedia
                    JOptionPane.showMessageDialog(null, "No Promo IDs available", "No Data", JOptionPane.WARNING_MESSAGE);
                    formMenuAdmin.setVisible(true);
                }
            }
        });

        JButton buttonConfirmationReschedule = new JButton("Reschedule Confirmation");
        buttonConfirmationReschedule.setBounds(30, 145, 250, 30);
        formMenuAdmin.add(buttonConfirmationReschedule);

        ArrayList<Reschedule> reschedule = Controller.getInstance().getViewReschedule();

        RescheduleConfirm rescheduleConfirm = new RescheduleConfirm(admin_id, name, reschedule); // Menginisialisasi objek RescheduleConfirm

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

        ArrayList<Refund> refunds = Controller.getInstance().getViewRefund();

        RefundConfirm refundConfirm = new RefundConfirm(admin_id, name, refunds); // Menginisialisasi objek RefundConfirm

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

//        ViewHistory viewhistory = new ViewHistory();
//        buttonHistory.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                viewhistory.showViewHistoryWindow(true);
//                formMenuAdmin.setVisible(false); // Menutup tampilan saat ini (MainMenuAdmin)
//            }
//        });

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

}
