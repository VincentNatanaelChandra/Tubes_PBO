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
    
    public MainMenuUser(int id, int idMember, String nama){
        MenuUser(id, idMember, nama);
    }
    
    private void MenuUser(int id, int idMember, String nama){
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

        
        JButton buttonTransaction = new JButton("Transaction");
        buttonTransaction.setBounds(30, 80, 250, 30);
        formMenuAdmin.add(buttonTransaction);
        
        JButton buttonRefund = new JButton("Refund");
        buttonRefund.setBounds(30, 115, 250, 30);
        formMenuAdmin.add(buttonRefund);
        
        JButton buttonReschedule = new JButton("Reschedule");
        buttonReschedule.setBounds(30,150, 250, 30);
        formMenuAdmin.add(buttonReschedule);
        
        JButton buttonViewStatus = new JButton("View Status Refund or Reschedule");
        buttonViewStatus.setBounds(30, 185, 250, 30);
        formMenuAdmin.add(buttonViewStatus);
        
        JButton buttonBooking= new JButton("Buy Ticket");
        buttonBooking.setBounds(30, 220, 250, 30);
        formMenuAdmin.add(buttonBooking);
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
   
    public static void main(String[] args) {
       new MainMenuUser(1,"CIPELI PAM PAM");
    }
}
