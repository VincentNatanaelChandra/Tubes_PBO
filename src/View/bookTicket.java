/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.DateLabelFormatter;
import java.awt.Font;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author ASUS
 */
public class bookTicket {
    public bookTicket(int id){
        bookingTicket(id);
    }
    
    private void bookingTicket(int id){
        //=============BAGIAN CONTAINER================
        JFrame form = new JFrame("Booking Ticket Menu");
        form.setSize(365, 360);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);
        //================END CONTAINER=================

        JLabel labelTitle = new JLabel("Fill your Purchase!!!");
        Font fontTitle = new Font("Mont", Font.BOLD, 15);
        labelTitle.setFont(fontTitle);
        labelTitle.setBounds(20, 5, 250, 30);
        form.add(labelTitle);
        
        //City Departure
        JLabel labelCityDeparture = new JLabel("City Departure :");
        labelCityDeparture.setBounds(20, 40, 150, 30);
        form.add(labelCityDeparture);
        //ComboBox City Departure
        String depertureCity[] = {"Bandung", "Jakarta", "Semarang", "Surabaya"};
        JComboBox cbDepartureCity =new JComboBox(depertureCity);
        cbDepartureCity.setBounds(150, 40, 150, 30);
        form.add(cbDepartureCity);
        
        //City Arrival
        JLabel labelCityArrival = new JLabel("City Arrival :");
        labelCityArrival.setBounds(20, 75, 150, 30);
        form.add(labelCityArrival);
        //ComboBox City Arrival
        String arrivalCity[] = {"Bandung", "Jakarta", "Semarang", "Surabaya"};
        JComboBox cbArrivalCity =new JComboBox(arrivalCity);
        cbArrivalCity.setBounds(150, 75, 150, 30);
        form.add(cbArrivalCity);
        
        //Tanggal Berangkat
        JLabel labelDateFly = new JLabel("Date Flight :");
        labelDateFly.setBounds(20, 110, 150, 30);
        form.add(labelDateFly);
        //Isian Tanggal Berangkat
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(150, 113, 150, 30);
        form.add(datePicker);
        
        //Airlines Company
        JLabel labelCompany = new JLabel("Airlines LineUp :");
        labelCompany.setBounds(20, 145, 150, 30);
        form.add(labelCompany);
        //ComboBox Airlines Company
        String company[] = {"Dunia Air", "CountryLink", "Balikpapan Air"};
        JComboBox cbCompany =new JComboBox(company);
        cbCompany.setBounds(150, 145, 150, 30);
        form.add(cbCompany);
        
        //Flight Preference
        JLabel labelPref = new JLabel("Flight Preference : ");
        labelPref.setBounds(20, 175, 150, 30);
        form.add(labelPref);
        JRadioButton radioOverNight = new JRadioButton();
        radioOverNight.setText("Over Night");
        radioOverNight.setBounds(150, 175, 100, 30);
        JRadioButton radioLateNight = new JRadioButton();
        radioLateNight.setText("Late Night");
        radioLateNight.setBounds(250, 175, 100, 30);
        form.add(radioOverNight);
        form.add(radioLateNight);
        //Group Button
        ButtonGroup buttonPref = new ButtonGroup();
        buttonPref.add(radioOverNight);
        buttonPref.add(radioLateNight);
        
        //FnB Choose
        JLabel labelFnB = new JLabel("Food : ");
        labelFnB.setBounds(20, 210, 50, 30);
        form.add(labelFnB);
        JRadioButton radioIndoFood = new JRadioButton();
        radioIndoFood.setText("Indonesian Food");
        radioIndoFood.setBounds(70, 210, 130, 30);
        JRadioButton radioWestFood = new JRadioButton();
        radioWestFood.setText("Western Food");
        radioWestFood.setBounds(200, 210, 150, 30);
        form.add(radioIndoFood);
        form.add(radioWestFood);
        //Group Button
        ButtonGroup buttonFnB = new ButtonGroup();
        buttonFnB.add(radioIndoFood);
        buttonFnB.add(radioWestFood);
        
        JLabel captionFood = new JLabel("Free Indonesia Food, Western Food +Rp.20000,-");
        Font fontCaptionFood = new Font("Arial", Font.PLAIN, 9);
        captionFood.setFont(fontCaptionFood);
        captionFood.setBounds(20, 245, 250, 10);
        form.add(captionFood);
        
        JButton buttonPayment = new JButton("Go to Payment");
        buttonPayment.setBounds(100, 265, 150, 30);
        form.add(buttonPayment);
        
        //ActionListener
        
        form.setVisible(true);
    }
    
    public static void main(String[] args) {
        new bookTicket(1);
    }
}
