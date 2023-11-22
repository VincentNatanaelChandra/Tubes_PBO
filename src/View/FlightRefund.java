/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;


public class FlightRefund {
    private static JTextField tiketText;
    private static JLabel resultLabel;
    private static JButton refundButton;
    


    

   
    private static void placeComponents(JPanel panel) {
    JLabel titleLabel = new JLabel("REFUND TIKET");
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER); 
    titleLabel.setBounds(120, 10, 200, 30); 

    JLabel nomorTiketLabel = new JLabel("Nomor Tiket:");
    JTextField nomorTiketField = new JTextField(20);
    nomorTiketLabel.setBounds(50, 50, 150, 25); 
    nomorTiketField.setBounds(200, 50, 150, 25); 

    JLabel boardPassNameLabel = new JLabel("Boarding name:");
    JTextField boardPassNameField = new JTextField(20);
    boardPassNameLabel.setBounds(50, 90, 150, 25); 
    boardPassNameField.setBounds(200, 90, 150, 25);

    JLabel tanggalRefundLabel = new JLabel("Tanggal Refund:");
    tanggalRefundLabel.setBounds(50, 130, 150, 25);

    JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
    dateSpinner.setEditor(dateEditor);
    dateSpinner.setBounds(200, 130, 150, 25);

    JLabel syaratLabel = new JLabel("<html><u>Syarat Refund</u></html>");
    syaratLabel.setForeground(Color.BLUE);
    syaratLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    syaratLabel.setBounds(50, 170, 250, 30);

    JCheckBox agreeCheckBox = new JCheckBox("Saya menyetujui segala prasyarat yang dibutuhkan");
    agreeCheckBox.setBounds(50, 210, 300, 25);

    JButton refundButton = new JButton("REFUND");
    refundButton.setBounds(150, 250, 100, 30);
    refundButton.addActionListener(e -> {
        if (agreeCheckBox.isSelected()) {
            // Lakukan refund
        } else {
            JOptionPane.showMessageDialog(null, "Harap setujui segala prasyarat yang dibutuhkan.");
        }
    });

    panel.setLayout(null); 
    panel.add(titleLabel);
    panel.add(nomorTiketLabel);
    panel.add(nomorTiketField);
    panel.add(boardPassNameLabel);
    panel.add(boardPassNameField);
    panel.add(tanggalRefundLabel);
    panel.add(dateSpinner);
    panel.add(syaratLabel);
    panel.add(agreeCheckBox);
    panel.add(refundButton);



    syaratLabel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel syaratPanel = new JPanel();
        syaratPanel.setLayout(new BoxLayout(syaratPanel, BoxLayout.Y_AXIS));

        JLabel tanggalRefundLabel = new JLabel("&#8226;Tanggal refund tidak kurang dari 1 hari");
        tanggalRefundLabel.setText("<html>&#8226; Tanggal refund tidak kurang dari 1 hari</html>");
        panel.add(tanggalRefundLabel);
        JLabel biayaLabel = new JLabel();
        biayaLabel.setText("<html>&#8226; Jumlah pengembalian biaya hanya 80%</html>");
        panel.add(biayaLabel);
        JLabel tiketLabel = new JLabel();
        tiketLabel.setText("<html>&#8226; Tiket yang sudah direfund tidak dapat dipakai kembali</html>");
        panel.add(tiketLabel);
        JLabel jamKerjaLabel = new JLabel();
        jamKerjaLabel .setText("<html>&#8226; Pengembalian biaya dilakukan selama jam kerja</html>");
        panel.add(jamKerjaLabel );

        syaratPanel.add(tanggalRefundLabel);
        syaratPanel.add(biayaLabel);
        syaratPanel.add(tiketLabel);
        syaratPanel.add(jamKerjaLabel);

        int option = JOptionPane.showConfirmDialog(null, syaratPanel, "Syarat Refund",
                JOptionPane.OK_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Anda setuju dengan syarat!");
           }
    }
});
    refundButton.addActionListener(e -> {
    JOptionPane.showMessageDialog(null, "Refund akan diproses");
});
}

private static JPanel createPanel(Component... components) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    for (Component component : components) {
        panel.add(component);
    }
    return panel;
}

public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Refund Tiket Pesawat");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }
private static boolean checkSyarat1() {   
    return true; 
}

private static boolean checkSyarat2() {  
    return true; 
}
private static boolean checkSyarat3() {   
    return true; 
}
private static boolean checkSyarat4() {   
    return true; 
}

// Method untuk melakukan proses refund
private static boolean processRefund(String nomorTiket) {
    boolean isTiketValid = checkDatabase(nomorTiket);
    if (isTiketValid) {
        boolean userAgrees = showConfirmationDialog();
        if (userAgrees) {
            boolean meetsConditions = checkConditions();
            if (meetsConditions) {
                return performRefund();
            } else {
                return false; 
            }
        } else {
            return false; 
        }
    } else {
        return false; 
    }
}

// Metode untuk memeriksa nomor tiket di database
private static boolean checkDatabase(String nomorTiket) {  
    return true; 
}


private static boolean showConfirmationDialog() { 
    return true; 
}


private static boolean checkConditions() {  
    
    return true; 
}

// Method untuk melaksanakan refund
private static boolean performRefund() {   
    return true; 
    }

}

