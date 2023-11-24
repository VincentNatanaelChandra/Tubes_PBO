package View;

import Model.Reschedule;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RescheduleConfirm {
    // Map untuk melacak status yang sudah diubah oleh setiap user ID
    private static Map<String, Boolean> userStatusMap = new HashMap<>();

    private JFrame frame;

    public RescheduleConfirm(ArrayList<Reschedule> listReschedule) {
        createRescheduleConfirmWindow(listReschedule);
        showRescheduleConfirmWindow(false);
    }

    private void createRescheduleConfirmWindow(ArrayList<Reschedule> listReschedule) {
        frame = new JFrame("Request Reschedule List");
        frame.setSize(600, 400);

        Object[][] data = new Object[listReschedule.size()][4];
        
        for (int i = 0; i < listReschedule.size(); i++) {
            Reschedule refunds = listReschedule.get(i);
            data[i][0] = refunds.getReschedule_id();
            data[i][1] = refunds.getTicket_id();
            data[i][2] = refunds.getReschedule_status();
            data[i][3] = refunds.getReschedule_reason();
            data[i][4] = refunds.getReschedule_date();
            data[i][5] = refunds.getReschedule_seat();
        }
        // Nama kolom untuk tabel
        String[] columns = {"Reschedule_id", "Ticket_id", "Reschedule_status", "Reschedule_reason", "Reschedule_date", "Reschedule_seat"};
        // Model tabel
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 300);
        frame.add(scrollPane);

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
                    String userID = (String) model.getValueAt(selectedRow, 1); // Ambil nilai ID user dari tabel
                    if (!userStatusMap.containsKey(userID) || !userStatusMap.get(userID)) {
                        model.setValueAt("Approved", selectedRow, 3);
                        userStatusMap.put(userID, true); // Menandai bahwa user ID ini sudah diubah statusnya
                    } else {
                        // Jika sudah diubah, tampilkan pesan bahwa user ID ini sudah memiliki status yang diubah
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
                    String userID = (String) model.getValueAt(selectedRow, 1); // Ambil nilai ID user dari tabel
                    if (!userStatusMap.containsKey(userID) || !userStatusMap.get(userID)) {
                        model.setValueAt("Rejected", selectedRow, 3);
                        userStatusMap.put(userID, true); // Menandai bahwa user ID ini sudah diubah statusnya
                    } else {
                        // Jika sudah diubah, tampilkan pesan bahwa user ID ini sudah memiliki status yang diubah
                        JOptionPane.showMessageDialog(frame, "Status tidak dapat diubah lagi.");
                    }
                }
            }
        });
 JButton backButton = new JButton("Back");
        backButton.setBounds(350, 330, 100, 30);
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela RefundConfirm
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(11, "tono"); // Kembali ke Main Menu Admin
        });
        frame.add(backButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }


    public void showRescheduleConfirmWindow(boolean visible) {
        frame.setVisible(visible);
    }
}
