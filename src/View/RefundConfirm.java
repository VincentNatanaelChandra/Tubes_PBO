package View;

import Controller.Controller;
import Model.Refund;
import Model.RefundEnum;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RefundConfirm {

    public JFrame frame;
    Controller controller = new Controller();

    public RefundConfirm(int admin_id, String name) {
        this.controller = Controller.getInstance();
        ArrayList<Refund> listRefund = controller.getViewRefund();
        createRefundConfirmWindow(admin_id, name, listRefund);
        showRefundConfirmWindow(false);
    }

    private void createRefundConfirmWindow(int admin_id, String name, ArrayList<Refund> listRefund) {
        frame = new JFrame("Request Refund List");
        frame.setSize(600, 400);

        // Data untuk tabel (Simulasi data)
        Object[][] data = new Object[listRefund.size()][4];

        for (int i = 0; i < listRefund.size(); i++) {
            Refund refunds = listRefund.get(i);
            data[i][0] = refunds.getRefund_id();
            data[i][1] = refunds.getTicket_id();
            data[i][2] = refunds.getRefund_status().toString();
            data[i][3] = refunds.getRefund_total();
            data[i][4] = refunds.getRefund_reason();
        }

        // Nama kolom untuk tabel
        String[] columns = {"Refund ID", "Ticket ID", " Refund_status ", "Refund_total", "Refund_total"};

        // Model tabel
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);
        frame.add(scrollPane);

        // ... (kode lainnya)
        JButton acceptButton = new JButton("Terima");
        acceptButton.setBounds(50, 330, 100, 30);
        frame.add(acceptButton);

        JButton rejectButton = new JButton("Tolak");
        rejectButton.setBounds(200, 330, 100, 30);
        frame.add(rejectButton);

        // Event listener untuk tombol "Terima"
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Refund refund = listRefund.get(selectedRow);
                    if (refund.getRefund_status() == RefundEnum.REFUNDDENIED) {
                        model.setValueAt(RefundEnum.REFUNDSUCCESS.toString(), selectedRow, 2);
                        refund.setRefund_status(RefundEnum.REFUNDSUCCESS);
                        if (!Controller.getInstance().updateRefund(refund.getTicket_id(), "accept")) {
                            JOptionPane.showMessageDialog(frame, "Gagal memperbarui status refund.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Status tidak dapat diubah lagi.");
                    }
                }
            }
        });

// Event listener untuk tombol "Tolak"
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Refund refund = listRefund.get(selectedRow);
                    if (refund.getRefund_status() == RefundEnum.REFUNDSUCCESS) {
                        model.setValueAt(RefundEnum.REFUNDDENIED.toString(), selectedRow, 2);
                        refund.setRefund_status(RefundEnum.REFUNDDENIED);
                        if (!Controller.getInstance().updateRefund(refund.getTicket_id(), "reject")) {
                            JOptionPane.showMessageDialog(frame, "Gagal memperbarui status refund.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Status tidak dapat diubah lagi.");
                    }
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 330, 100, 30);
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela RefundConfirm
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(admin_id, name); // Kembali ke Main Menu Admin
        });
        frame.add(backButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void showRefundConfirmWindow(boolean visible) {
        frame.setVisible(visible);
    }

}
