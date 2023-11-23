/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenuUser {
    
    public MainMenuUser(int id, String nama){
        MenuUser(id, nama);
    }
    
    private void MenuUser(int id, String nama){
        JFrame formMenuAdmin = new JFrame("Menu User ");
        formMenuAdmin.setSize(320, 300);
        formMenuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formMenuAdmin.setLocationRelativeTo(null);
        formMenuAdmin.setLayout(null);
        
        JLabel labelTitle = new JLabel("MENU USER");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(110, 5, 100, 30);
        formMenuAdmin.add(labelTitle);
        JLabel welcome = new JLabel("Welcome, ");
        Font welcomeFont = new Font("Mont", Font.PLAIN, 12); 
        welcome.setFont(welcomeFont);
        welcome.setBounds(35, 29, 400, 30);
        formMenuAdmin.add(welcome);

        JLabel nametext = new JLabel(nama); 
        Font nameFont = new Font("Mont", Font.BOLD, 20); 
        nametext.setFont(nameFont);
        nametext.setBounds(35, 45, 400, 30);
        formMenuAdmin.add(nametext);

        
        JButton buttonUpdateSchedule = new JButton("Transaction");
        buttonUpdateSchedule.setBounds(30, 80, 250, 30);
        formMenuAdmin.add(buttonUpdateSchedule);
        
        JButton buttonUpdatePromo = new JButton("Refund");
        buttonUpdatePromo.setBounds(30, 115, 250, 30);
        formMenuAdmin.add(buttonUpdatePromo);
        
        JButton buttonConfirmationReschedule = new JButton("Reschedule");
        buttonConfirmationReschedule.setBounds(30,150, 250, 30);
        formMenuAdmin.add(buttonConfirmationReschedule);
        
        JButton buttonConfirmationRefund = new JButton("View Status Refund or Reschedule");
        buttonConfirmationRefund.setBounds(30, 185, 250, 30);
        formMenuAdmin.add(buttonConfirmationRefund);
        
        JButton buttonBacktoLogin = new JButton("⬅");
        buttonBacktoLogin.setBounds(30, 5, 50, 30); // Menempatkan tombol "Back" di pojok kiri atas
        formMenuAdmin.add(buttonBacktoLogin);
        Font fontback = new Font("Mont", Font.BOLD, 16);
        buttonBacktoLogin.setFont(fontback);
        
        JButton buttonViewHistory = new JButton("🎟");
        int formWidth = formMenuAdmin.getWidth();
        buttonViewHistory.setBounds(formWidth - 90, 5, 50, 30); // Menempatkan tombol "View History" di pojok kanan atas
        Font fonttiket = new Font("Mont", Font.BOLD, 16);
        buttonViewHistory.setFont(fonttiket);

        formMenuAdmin.add(buttonViewHistory);
        
        formMenuAdmin.setVisible(true);
    }
    

}
