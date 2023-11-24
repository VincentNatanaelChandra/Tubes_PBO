package View;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.text.NumberFormat;

public class UpdatePromo {
    private JFrame frame;

    public UpdatePromo() {}

    private void createUpdatePromoWindow() {
        frame = new JFrame("Update Promo Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JSpinner dateSpinner = createDescendingDateSpinner();

        panel.add(new JLabel("Promo Code :"));
        panel.add(field1);
        panel.add(new JLabel("Promo Type :"));
        panel.add(field2);
        panel.add(new JLabel("Expired Date:"));
        panel.add(dateSpinner);

        JTextField field5 = new JFormattedTextField(NumberFormat.getNumberInstance()); // Menggunakan JFormattedTextField
        panel.add(new JLabel("Persen Promo"));
        panel.add(field5);

        panel.add(Box.createVerticalGlue());

        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.addActionListener(e -> {
            String promoCode = field1.getText();
            String promoType = field2.getText();
            Date expiredDate = (Date) dateSpinner.getValue();

            double percentPromo = 0.0; // Inisialisasi variabel untuk persen promo
            try {
                percentPromo = Double.parseDouble(field5.getText()); // Mengambil nilai dari field "Persen Promo"
            } catch (NumberFormatException ex) {
                // Penanganan jika input tidak valid (bukan angka)
                JOptionPane.showMessageDialog(frame, "Invalid input for percent promo", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Keluar dari actionPerformed jika input tidak valid
            }

            // Lakukan sesuatu dengan nilai percentPromo

            JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela UpdatePromo
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(11, "tono"); // Menampilkan kembali Main Menu Admin
        });
        panel.add(backButton);

        frame.add(panel);
    }

    private JSpinner createDescendingDateSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.YEAR, -10);
        Date tenYearsAgo = calendar.getTime();
        model.setValue(today);

        spinner.setModel(new SpinnerDateModel(today, tenYearsAgo, today, Calendar.DAY_OF_MONTH));
        return spinner;
    }

    public void showUpdatePromoWindow(boolean visible) {
        if (visible) {
            createUpdatePromoWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
