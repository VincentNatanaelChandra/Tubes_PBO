/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Controller.DateLabelFormatter;
import Model.RefundEnum;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class FlightRefund {

    private  JTextField tiketText;
    private  JLabel resultLabel;
    private  JButton refundButton;

    private static void placeComponents(JPanel panel) {
        JFrame frame = new JFrame("Airplane Ticket Refund Menu");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
        JLabel titleLabel = new JLabel("REFUND TIKET");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(120, 10, 200, 30);

        JLabel nomorTiketLabel = new JLabel("Tiket Number:");
        JTextField nomorTiketField = new JTextField(20);
        nomorTiketLabel.setBounds(50, 50, 150, 25);
        nomorTiketField.setBounds(200, 50, 150, 25);

        JLabel reasonNameLabel = new JLabel("Refund Reason:");
        JTextField reasonNameField = new JTextField(20);
        reasonNameLabel.setBounds(50, 90, 150, 25);
        reasonNameField.setBounds(200, 90, 150, 25);

        JLabel tanggalRefundLabel = new JLabel("Refund Date:");
        tanggalRefundLabel.setBounds(50, 130, 150, 25);

        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(200, 130, 150, 25);
        panel.add(datePicker);

        JLabel syaratLabel = new JLabel("<html><u>Terms Refund </u></html>");
        syaratLabel.setForeground(Color.BLUE);
        syaratLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        syaratLabel.setBounds(50, 170, 250, 30);

        JCheckBox agreeCheckBox = new JCheckBox(" I agree about terms and conditions");
        agreeCheckBox.setBounds(50, 210, 300, 25);

        JButton refundButton = new JButton("REFUND");
        refundButton.setBounds(150, 250, 100, 30);
        refundButton.addActionListener(e -> {
            if (agreeCheckBox.isSelected()) {
                // Lakukan refund
            } else {
                JOptionPane.showMessageDialog(null, "Please agree to all the necessary prerequisites.\"");
            }
        });

        panel.setLayout(null);
        panel.add(titleLabel);
        panel.add(nomorTiketLabel);
        panel.add(nomorTiketField);
        panel.add(reasonNameLabel);
        panel.add(reasonNameField);
        panel.add(tanggalRefundLabel);
        panel.add(syaratLabel);
        panel.add(agreeCheckBox);
        panel.add(datePicker);
        panel.add(refundButton);

        syaratLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel syaratPanel = new JPanel();
                syaratPanel.setLayout(new BoxLayout(syaratPanel, BoxLayout.Y_AXIS));

                JLabel tanggalRefundLabel = new JLabel("&#8226; Refund date must not be less than 1 day");
                tanggalRefundLabel.setText("<html>&#8226; Refund date must not be less than 1 day</html>");
                panel.add(tanggalRefundLabel);

                JLabel biayaLabel = new JLabel();
                biayaLabel.setText("<html>&#8226; Refund amount is only 80%</html>");
                panel.add(biayaLabel);

                JLabel tiketLabel = new JLabel();
                tiketLabel.setText("<html>&#8226; Refunded tickets cannot be reused</html>");
                panel.add(tiketLabel);

                JLabel jamKerjaLabel = new JLabel();
                jamKerjaLabel.setText("<html>&#8226; Refund transactions are carried out during working hours</html>");
                panel.add(jamKerjaLabel);

                syaratPanel.add(tanggalRefundLabel);
                syaratPanel.add(biayaLabel);
                syaratPanel.add(tiketLabel);
                syaratPanel.add(jamKerjaLabel);

                int option = JOptionPane.showConfirmDialog(null, syaratPanel, "Refund Terms",
                        JOptionPane.OK_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "You agree to the terms!");
                }

            }
        });
        refundButton.addActionListener(e -> {
            String ticket = nomorTiketField.getText();
            String reason = reasonNameField.getText();
            boolean found = Controller.getInstance().getTicket(ticket);
            if (found) {
                frame.dispose();
                int id = Controller.getInstance().getTicketIdInt(ticket);
                double price = Controller.getInstance().getTotalPrice(ticket) * 0.8;
                Controller.getInstance().requestRefund(id, RefundEnum.REFUNDDENIED, price, reason);
            } else {
                JOptionPane.showMessageDialog(frame, "Ticket Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
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

}
