package View;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class UpdateDestinasi {
    private JFrame frame;
    private JComboBox<String> comboBoxFlightID;
    private String selectedFlightID;

    public UpdateDestinasi(String selectedFlightID) {
        this.selectedFlightID = selectedFlightID;
    }

    private void createUpdateDestinasiWindow() {
        frame = new JFrame("Update Destination Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // Ubah tata letak menjadi 6 baris, 2 kolom

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JSpinner dateSpinner = createDescendingDateSpinner();

        panel.add(new JLabel("Destination Departure:"));
        panel.add(field1);
        panel.add(new JLabel("Destination Arrival:"));
        panel.add(field2);
        panel.add(new JLabel("Destination Date:"));
        panel.add(dateSpinner);

        // Tambahkan label dan combo box untuk Flight ID
        panel.add(new JLabel("Flight ID:"));
        comboBoxFlightID = new JComboBox<>();
        comboBoxFlightID.addItem(selectedFlightID); // Set nilai awal Flight ID
        comboBoxFlightID.setEnabled(false); // Agar tidak bisa diubah
        panel.add(comboBoxFlightID);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Menutup jendela UpdateDestinasi
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(11, "tono");
        });
        panel.add(backButton);

        frame.add(panel);
    }

    // Method untuk membuat Spinner tanggal
    private JSpinner createDescendingDateSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd")); // Ubah format tanggal disini

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.YEAR, -10);
        Date tenYearsAgo = calendar.getTime();
        model.setValue(today);

        spinner.setModel(new SpinnerDateModel(today, tenYearsAgo, today, Calendar.DAY_OF_MONTH));
        return spinner;
    }

    // Method untuk menampilkan atau menyembunyikan frame
    public void showUpdateDestinasiWindow(boolean visible) {
        if (visible) {
            createUpdateDestinasiWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
