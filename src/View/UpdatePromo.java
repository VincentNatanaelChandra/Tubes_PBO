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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Update Promo");
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1, 10, 10));
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

            panel.add(Box.createVerticalGlue()); // Untuk membuat jarak di tengah

            JButton updateButton = new JButton("Update");
            updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            updateButton.addActionListener(e -> {
                String promoCode = field1.getText();
                String promoType = field2.getText();
                Date destinaton_depatureDate = (Date) dateSpinner.getValue();
                
                JOptionPane.showMessageDialog(frame, "Data sudah diupdate", "Notification", JOptionPane.INFORMATION_MESSAGE);
            });
            panel.add(updateButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
    private static JSpinner createDescendingDateSpinner() {
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


    


    // Metode untuk membuat panel dengan label dan field
    private static JPanel createFieldPanel(String labelText, JTextField textField) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));

        fieldPanel.add(new JLabel(labelText));
        fieldPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Untuk spasi antara label dan field
        fieldPanel.add(textField);

        return fieldPanel;
    }
}

