package View;

import javax.swing.*;
import java.awt.*;

public class UpdatePenerbangan {
    private JFrame frame;

    public UpdatePenerbangan() {
        createUpdatePenerbanganWindow();
    }

    private void createUpdatePenerbanganWindow() {
        frame = new JFrame("Update Flight Menu");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

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
        panel.add(Box.createVerticalGlue());

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
    frame.add(panel);
    
    JButton backButton = new JButton("Back");
    backButton.addActionListener(e -> {
    });
    panel.add(backButton);
    frame.add(panel);
}

    public void showUpdatePenerbanganWindow(boolean visible) {
        frame.setVisible(visible);
    }

}
