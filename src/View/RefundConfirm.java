package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RefundConfirm {
    // Map untuk melacak status yang sudah diubah oleh setiap user ID
    private static Map<String, Boolean> userStatusMap = new HashMap<>();

    private JFrame frame;

    public RefundConfirm() {
        createRefundConfirmWindow();
        showRefundConfirmWindow(false);
    }

    private void createRefundConfirmWindow() {
        frame = new JFrame("Request Refund List");
        frame.setSize(600, 400);

        // Data untuk tabel (Simulasi data)
        String[][] data = {
                {"John Doe", "12345","Ditinggal Nikah", "Pending"},
                {"Jane Smith", "54321", "Telat Bangun","Pending"},
                // Data lainnya...
        };

        // Nama kolom untuk tabel
        String[] columns = {"User", "Ticket ID","Alasan ", "Status,"};

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


    public void showRefundConfirmWindow(boolean visible) {
        frame.setVisible(visible);
    }


    }

