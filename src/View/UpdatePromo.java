/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class UpdatePromo {
    private JFrame frame;

    public UpdatePromo() {
        createUpdatePromoWindow();
    }

    private void createUpdatePromoWindow() {
        frame = new JFrame("Update Promo Menu");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
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

        panel.add(Box.createVerticalGlue());

        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.addActionListener(e -> {
            String promoCode = field1.getText();
            String promoType = field2.getText();
            Date destinationDepartureDate = (Date) dateSpinner.getValue();

            JOptionPane.showMessageDialog(frame, "Data has been updated", "Notification", JOptionPane.INFORMATION_MESSAGE);
        });
     panel.add(updateButton);
    frame.add(panel);
    
    JButton backButton = new JButton("Back");
    backButton.addActionListener(e -> {
    frame.dispose(); // Menutup jendela UpdateDestinasi
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
        frame.setVisible(visible);
    }

    // Metode lain di sini...
}
