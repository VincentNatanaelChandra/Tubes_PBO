package View;
import javax.swing.*;
import java.awt.*;

public class ViewHistory {
    private JTable table;
    private JPanel panel;
    private JFrame frame;

    public ViewHistory() {
        frame = new JFrame();
        frame.setTitle("Ticket Information");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = {
                "Nama",
                "Member ID",
                "Tiket ID",
                "Tiket Code",
                "Tiket Date",
                "Tiket Preference",
                "Transaction ID",
                "Transaction PayMethod",
                "Transaction Seat Price",
                "Transaction Meal Price",
                "Transaction Promo Discount",
                "Transaction Total Price",
                "Promo ID",
                "Promo Code"
        };

        // Data contoh (dapat diganti dengan data yang sesuai)
        String[][] data = {
                {"John Doe", "12345", "T001", "T123", "2023-01-15", "Window", "TRX001", "Credit Card", "$100", "$20", "$10", "$110", "P001", "SUMMER10"},
                {"Jane Smith", "67890", "T002", "T456", "2023-02-20", "Aisle", "TRX002", "Debit Card", "$120", "$25", "$15", "$130", "P002", "HOLIDAY20"}
        };

        // Membuat JTable
        table = new JTable(data, columns);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Mengatur tampilan JScrollPane agar tabel dapat di-scroll jika data melebihi ruang tampilan
        JScrollPane scrollPane = new JScrollPane(table);

        // Membuat panel baru dan menambahkan komponen-komponen di dalamnya
        panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela ViewHistory
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(11, "tono"); // Menampilkan kembali Main Menu Admin
        });
        panel.add(backButton, BorderLayout.SOUTH);

        frame.add(panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void showViewHistoryWindow(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        ViewHistory viewHistory = new ViewHistory();
        viewHistory.showViewHistoryWindow(true); // Menampilkan ViewHistory
    }
}
