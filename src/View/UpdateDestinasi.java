package View;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class UpdateDestinasi {
    private JFrame frame;

    public UpdateDestinasi() {
        createUpdateDestinasiWindow();
    }

    private void createUpdateDestinasiWindow() {
        frame = new JFrame("Update Destination Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JSpinner dateSpinner = createDescendingDateSpinner(); // Spinner untuk pemilihan tanggal secara descending

        panel.add(new JLabel("Destination Departure:"));
        panel.add(field1);
        panel.add(new JLabel("Destination Arrival:"));
        panel.add(field2);
        panel.add(new JLabel("Destination Date:"));
        panel.add(dateSpinner);

        panel.add(Box.createVerticalGlue()); // Untuk membuat jarak di tengah

        JButton updateButton = new JButton("Update");
          updateButton.addActionListener(e -> {
         JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);

    });
    panel.add(updateButton);
    frame.add(panel);
    
    JButton backButton = new JButton("Back");
    backButton.addActionListener(e -> {
    });
    panel.add(backButton);
    frame.add(panel);
}
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

    public void showUpdateDestinasiWindow(boolean visible) {
        frame.setVisible(visible);
    }

}
