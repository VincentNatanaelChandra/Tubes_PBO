/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Controller.DateLabelFormatter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.sql.Date;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author ASUS
 */
public class bookTicket {
    public bookTicket(int id_user){
        bookingTicket(id_user);
    }
    
    private void bookingTicket(int id_user){
        //=============BAGIAN CONTAINER================
        JFrame form = new JFrame("Booking Ticket Menu");
        form.setSize(365, 425);
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
        String depertureCity[] = Controller.getInstance().getDeparture().toArray(new String [Controller.getInstance().getDeparture().size()]);
        JComboBox cbDepartureCity =new JComboBox(depertureCity);
        cbDepartureCity.setBounds(150, 40, 150, 30);
        form.add(cbDepartureCity);
        
        //City Arrival
        JLabel labelCityArrival = new JLabel("City Arrival :");
        labelCityArrival.setBounds(20, 75, 150, 30);
        form.add(labelCityArrival);
        //ComboBox City Arrival
        String arrivalCity[] = Controller.getInstance().getArrival().toArray(new String [Controller.getInstance().getArrival().size()]);
        JComboBox cbArrivalCity =new JComboBox(arrivalCity);
        cbArrivalCity.setBounds(150, 75, 150, 30);
        form.add(cbArrivalCity);
        
        //Tanggal Berangkat
        JLabel labelDateFly = new JLabel("Date Flight :");
        labelDateFly.setBounds(20, 110, 150, 30);
        form.add(labelDateFly);
        
        //Isian Tanggal Berangkat
        SqlDateModel model = new SqlDateModel();
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
        String company[] = Controller.getInstance().getAirline().toArray(new String [Controller.getInstance().getAirline().size()]);
        JComboBox cbCompany =new JComboBox(company);
        cbCompany.setBounds(150, 145, 150, 30);
        form.add(cbCompany);
        
        String departureValue = (String) cbDepartureCity.getSelectedItem();
        String arrivalValue = (String) cbArrivalCity.getSelectedItem();
        String airlinesValue = (String) cbCompany.getSelectedItem();
        
        int flightId = Controller.getInstance().getFlightId(airlinesValue, departureValue, arrivalValue);
        System.out.println(departureValue);
        System.out.println(arrivalValue);
        System.out.println(airlinesValue);
        System.out.println(flightId);
        //Class
        JLabel labelClass = new JLabel("Class :");
        labelClass.setBounds(20, 180, 150, 30);
        form.add(labelClass);
        //ComboBox Class
        String classPlane[] = Controller.getInstance().getSeatClass().toArray(new String [Controller.getInstance().getSeatClass().size()]);
        JComboBox cbClass = new JComboBox(classPlane);
        cbClass.setBounds(150, 180, 150, 30);
        form.add(cbClass);
        
        //Seat Number
        JLabel labelSeatClass = new JLabel("Seat :");
        labelSeatClass.setBounds(20, 215, 150, 30);
        form.add(labelSeatClass);
        //ComboBox Class
        String seatPlane[] = Controller.getInstance().getSeatNumber(flightId).toArray(new String [Controller.getInstance().getSeatClass().size()]);
        JComboBox cbSeat = new JComboBox(seatPlane);
        cbSeat.setBounds(150, 215, 150, 30);
        form.add(cbSeat);
        
        //Flight Preference
        JLabel labelPref = new JLabel("Flight Preference : ");
        labelPref.setBounds(20, 250, 150, 30);
        form.add(labelPref);
        JRadioButton radioOverNight = new JRadioButton();
        radioOverNight.setText("Over Night");
        radioOverNight.setBounds(150, 250, 100, 30);
        JRadioButton radioLateNight = new JRadioButton();
        radioLateNight.setText("Late Night");
        radioLateNight.setBounds(250, 250, 100, 30);
        form.add(radioOverNight);
        form.add(radioLateNight);
        //Group Button
        ButtonGroup buttonPref = new ButtonGroup();
        buttonPref.add(radioOverNight);
        buttonPref.add(radioLateNight);
        
        //FnB Choose
        JLabel labelFnB = new JLabel("Food : ");
        labelFnB.setBounds(20, 285, 50, 30);
        form.add(labelFnB);
        JRadioButton radioIndoFood = new JRadioButton();
        radioIndoFood.setText("Indonesian Food");
        radioIndoFood.setBounds(70, 285, 130, 30);
        JRadioButton radioWestFood = new JRadioButton();
        radioWestFood.setText("Western Food");
        radioWestFood.setBounds(200, 285, 150, 30);
        form.add(radioIndoFood);
        form.add(radioWestFood);
        //Group Button
        ButtonGroup buttonFnB = new ButtonGroup();
        buttonFnB.add(radioIndoFood);
        buttonFnB.add(radioWestFood);
        
        JLabel captionFood = new JLabel("Free Indonesia Food, Western Food +Rp.20000,-");
        Font fontCaptionFood = new Font("Arial", Font.PLAIN, 9);
        captionFood.setFont(fontCaptionFood);
        captionFood.setBounds(20, 320, 250, 10);
        form.add(captionFood);
        
        JButton buttonPayment = new JButton("Go to Payment");
        buttonPayment.setBounds(100, 340, 150, 30);
        form.add(buttonPayment);
        
        buttonPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String departureValue = (String) cbDepartureCity.getSelectedItem();
                String arrivalValue = (String) cbArrivalCity.getSelectedItem();
                java.util.Date dateFlight = (java.util.Date) datePicker.getModel().getValue();
                String airlinesValue = (String) cbCompany.getSelectedItem();
                String classValue = (String) cbClass.getSelectedItem();
                String seatValue = (String) cbSeat.getSelectedItem();
                String prefValue = radioOverNight.isSelected() ? "Over Night" : "Late Night";
                String FnBValue = radioIndoFood.isSelected() ? "Indonesian Food" : "Western Food";
                String name = Controller.getInstance().getUsernameMember(id_user);
                int ticketPrice = Controller.getInstance().getSeatPrice(classValue);
                if ("Western Food".equals(FnBValue)) {
                    ticketPrice += 20000;
                }
                

                boolean status = false;
                if (cbDepartureCity.getSelectedItem() == null
                        || cbArrivalCity.getSelectedItem() == null
                        || datePicker.getModel().getValue() == null
                        || cbCompany.getSelectedItem() == null
                        || cbClass.getSelectedItem() == null
                        || cbSeat.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(form, "Please fill out all fields", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    int promo_id = 0;
                    int promoDisc = 0;
                    form.dispose();
                    new Payment(id_user, name, departureValue, arrivalValue, dateFlight, airlinesValue, classValue, seatValue, prefValue, FnBValue, ticketPrice, promo_id, promoDisc, flightId);
                }
             }
        });
        
        form.setVisible(true);
    }
}