/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Ticket {
    public Ticket(){
        Ticket();
    }
    
    private void Ticket(){
     //=============BAGIAN CONTAINER================
        JFrame ticket = new JFrame("TICKET");
        ticket.setSize(300, 380);
        ticket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticket.setLocationRelativeTo(null);
        ticket.setLayout(null);
        //================END CONTAINER=================
        
        JLabel labelTitle = new JLabel("--- Success BookTicket ---");
        Font fontTitle = new  Font("Arial", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(45, 5, 500, 50);
        ticket.add(labelTitle);
        
        JLabel lineTicket1 = new JLabel("_________________");
        lineTicket1.setBounds(82, 32, 150, 30);
        ticket.add(lineTicket1);
        
        JLabel labelKodeTicket = new JLabel("| No. Ticket   : ");
        labelKodeTicket.setBounds(80, 45, 90, 30);
        ticket.add(labelKodeTicket);
        
        JLabel kodeTicket = new JLabel("9485 |");
        kodeTicket.setBounds(165, 45, 80, 30);
        ticket.add(kodeTicket);
        
        JLabel lineTicket2 = new JLabel("_________________");
        lineTicket2.setBounds(82, 47, 150, 30);
        ticket.add(lineTicket2);
        
        JLabel labelPlaneCode = new JLabel("PLANE CODE");
        labelPlaneCode.setFont(fontTitle);
        labelPlaneCode.setBounds(10, 70, 110, 30);
        ticket.add(labelPlaneCode);
        
        JLabel planeCode = new JLabel("ADN-001");
        Font fontPlaneCode = new Font("Arial", Font.BOLD, 30);
        planeCode.setFont(fontPlaneCode);
        planeCode.setBounds(80, 90, 200, 50);
        ticket.add(planeCode);
        
        Font fontTitleAtribute = new Font("Arial", Font.PLAIN, 13);
        Font fontAtribute = new Font("Arial", Font.BOLD, 17);
        int formWidth = ticket.getWidth();   
        
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10, 130, 100, 30);
        labelName.setFont(fontTitleAtribute);
        ticket.add(labelName);
        
        JLabel name = new JLabel("Vincent");
        name.setFont(fontAtribute);
        name.setBounds(10, 150, 100, 30);
        ticket.add(name);
        
        JLabel labelClass = new JLabel("Class");
        labelClass.setBounds(10, 180, 100, 30);
        labelClass.setFont(fontTitleAtribute);
        ticket.add(labelClass);
        
        JLabel lClass = new JLabel("Economy");
        lClass.setBounds(10, 200, 100, 30);
        lClass.setFont(fontAtribute);
        ticket.add(lClass);
        
        JLabel labelId = new JLabel("ID");
        labelId.setBounds(formWidth - 42, 130, 50, 30);
        labelId.setFont(fontTitleAtribute);
        ticket.add(labelId);
        
        JLabel id = new JLabel("1");
        id.setFont(fontAtribute);
        id.setBounds(formWidth - 40, 150, 100, 30);
        ticket.add(id);
        
        JLabel labelSeat = new JLabel("Seat");
        labelSeat.setBounds(formWidth - 55, 180, 100, 30);
        labelSeat.setFont(fontTitleAtribute);
        ticket.add(labelSeat);
        
        JLabel seat = new JLabel("E1");
        seat.setBounds(formWidth - 50, 200, 100, 30);
        seat.setFont(fontAtribute);
        ticket.add(seat);
        
        JButton buttonPrintTicket = new JButton("Print Ticket");
        buttonPrintTicket.setBounds(15, 245, 255, 30);
        ticket.add(buttonPrintTicket);
        
        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(15, 285, 255, 30);
        ticket.add(buttonBack);
        
        
        
        ticket.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Ticket();
    }
}
