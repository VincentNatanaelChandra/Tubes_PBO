package View;

import javax.swing.*;
import java.awt.*;

public class UpdatePenerbangan {
    private JFrame frame;
     private JComboBox<String> comboBoxFlightID;
    private String selectedFlightID;
   
    public UpdatePenerbangan(String selectedFlightID) {
        this.selectedFlightID = selectedFlightID;
    }
    
    private void createUpdatePenerbanganWindow() {
        frame = new JFrame("Update Flight Menu");
        frame.setSize(400, 290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1, 10, 10)); // Ubah jumlah baris

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JTextField field3 = new JTextField(10);
        JTextField field4 = new JTextField(10);
        JTextField field5 = new JTextField(10);

        panel.add(new JLabel("Plane Code:"));
        panel.add(field1);
        panel.add(new JLabel("Company:"));
        panel.add(field2);
        panel.add(new JLabel("Type:"));
        panel.add(field3);
        panel.add(new JLabel("Plane Type:"));
        panel.add(field4);
        panel.add(new JLabel("Total Seat:"));
        panel.add(field5);

        // Tambahkan label dan combo box untuk Flight ID
        panel.add(new JLabel("Flight ID:"));
        JComboBox<String> comboBoxFlightID = new JComboBox<>();
        comboBoxFlightID.addItem(selectedFlightID);
        comboBoxFlightID.setEnabled(false);
        panel.add(comboBoxFlightID);

        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.addActionListener(e -> {
            String input1 = field1.getText();
            String input2 = field2.getText();
            String input3 = field3.getText();
            String input4 = field4.getText();
            String input5 = field5.getText();
            JOptionPane.showMessageDialog(frame, "Data has been updated", "Information", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            MainMenuAdmin mainMenuAdmin = new MainMenuAdmin(11, "tono");
        });
        panel.add(backButton);

        frame.add(panel);
    }

   public void showUpdatePenerbanganWindow(boolean visible) {
        if (visible) {
            createUpdatePenerbanganWindow();
            frame.setVisible(true);
        } else {
            frame.setVisible(false);
        }
    }
}
