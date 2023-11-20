/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
 import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author KATANA
 */
public class FlightTrans  extends JFrame {

  
    private String airline;
    private String departureTime;
    private Map<String, List<String>> bookedSeats;
private Map<String, Integer> bookedSeatCounts;

    public FlightTrans(String airline, String departureTime) {
        this.airline = airline;
        this.departureTime = departureTime;
        this.bookedSeats = new HashMap<>();
        this.bookedSeats.put("Business", new ArrayList<>());
        this.bookedSeats.put("Economy", new ArrayList<>());
        this.bookedSeatCounts = new HashMap<>();
        this.bookedSeatCounts.put("Business", 0);
        this.bookedSeatCounts.put("Economy", 0);
    }

    public int getBookedSeatCount(String seatClass) {
        return bookedSeatCounts.getOrDefault(seatClass, 0);
    }

    public boolean bookSeat(String seatClass, String seatNumber) {
        List<String> seats = bookedSeats.get(seatClass);
        if (seats != null && !seats.contains(seatNumber)) {
            seats.add(seatNumber);
            bookedSeatCounts.put(seatClass, bookedSeatCounts.get(seatClass) + 1);
            return true;
        }
        return false;
    }

    private JComboBox<String> airlineComboBox;
    private JComboBox<String> seatClassComboBox;
    private JComboBox<String> mealComboBox;
    private List<FlightTrans> flights;

    public FlightTrans() {
        setTitle("Flight Booking");

        airlineComboBox = new JComboBox<>();
        airlineComboBox.addItem("Air Dunia");
        airlineComboBox.addItem("CountryLink");
        airlineComboBox.addItem("BalikpapanAir");

        seatClassComboBox = new JComboBox<>();
        seatClassComboBox.addItem("Business");
        seatClassComboBox.addItem("Economy");
        seatClassComboBox.addItem("First Class");

        mealComboBox = new JComboBox<>();
        mealComboBox.addItem("Korean Food");
        mealComboBox.addItem("Asia Food");
        mealComboBox.addItem("Western Food");
        mealComboBox.addItem("Indonesia Food");
        mealComboBox.addItem("Japanese Food");

        JButton generateTicketButton = new JButton("Generate Ticket");
        generateTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTicket();
            }
        });

        flights = new ArrayList<>();
        flights.add(new FlightTrans("Air Dunia", "08:00"));
        flights.add(new FlightTrans("Air Dunia", "08:30"));
        flights.add(new FlightTrans("Air Dunia", "09:00"));
        flights.add(new FlightTrans("CountryLink", "10:00"));
        flights.add(new FlightTrans("CountryLink", "12:00"));
        flights.add(new FlightTrans("CountryLink", "13:00"));
        flights.add(new FlightTrans("BalikpapanAir", "12:00"));
        flights.add(new FlightTrans("BalikpapanAir", "12:00"));
        flights.add(new FlightTrans("BalikpapanAir", "14:00"));
        
        

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(airlineComboBox);
        panel.add(seatClassComboBox);
        panel.add(mealComboBox);
        panel.add(generateTicketButton);

        add(panel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateTicket() {
    String airline = (String) airlineComboBox.getSelectedItem();
    String seatClass = (String) seatClassComboBox.getSelectedItem();
    String meal = (String) mealComboBox.getSelectedItem();

    FlightTrans selectedFlight = getRandomFlight(airline);

    if (selectedFlight != null) {
        String seatNumber = generateSeatNumber(selectedFlight, seatClass);
        if (seatNumber != null) {
            selectedFlight.bookSeat(seatClass, seatNumber);
            int bookedSeats = selectedFlight.getBookedSeatCount(seatClass);
            System.out.println("Ticket generated for: " +
                    "\nAirline: " + selectedFlight.getAirline() +
                    ", \nDeparture: " + selectedFlight.getDepartureTime() +
                    ", \nSeat: " + seatNumber +
                    ", \nClass: " + seatClass +
                    ", \nMeal: " + meal +
                    ", \nBooked Seats: " + bookedSeats); // Menampilkan jumlah seat yang telah dibook
        } else {
            System.out.println("No available seats for selected class on this flight.");
        }
    } else {
        System.out.println("No flights available for selected airline.");
    }
}

    private FlightTrans getRandomFlight(String airline) {
        List<FlightTrans> availableFlights = new ArrayList<>();
        for (FlightTrans flight : flights) {
            if (flight.getAirline().equals(airline)) {
                availableFlights.add(flight);
            }
        }
        if (!availableFlights.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availableFlights.size());
            return availableFlights.get(randomIndex);
        }
        return null;
    }

    private String generateSeatNumber(FlightTrans flight, String seatClass) {
    List<String> availableSeats = flight.getAvailableSeatsForClass(seatClass); // Mendapatkan daftar kursi yang tersedia langsung dari objek flight

    if (availableSeats != null) {
        int totalSeats = seatClass.equals("Business") ? 10 : 20; // Ganti dengan jumlah kursi bisnis dan ekonomi

        if (availableSeats.size() < totalSeats) {
            Set<String> allSeats = new HashSet<>();
            for (int i = 1; i <= totalSeats; i++) {
                allSeats.add(seatClass + i);
            }
            allSeats.removeAll(availableSeats); // Menghilangkan kursi yang sudah dipesan

            // Mengambil kursi secara acak dari kursi yang tersedia
            if (!allSeats.isEmpty()) {
                List<String> availableSeatsList = new ArrayList<>(allSeats);
                Random random = new Random();
                int randomIndex = random.nextInt(availableSeatsList.size());
                return availableSeatsList.get(randomIndex);
            }
        }
    }
    return null;
}




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlightTrans();
            }
        });
    }
private String getSeatClass() {
    return (String) seatClassComboBox.getSelectedItem();
}
private String getOrDefault() {
    throw new UnsupportedOperationException("Not supported yet.");
}
    private int getBookedSeatCount(int seatClass) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private String getAirline() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getDepartureTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getBookedSeats() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<String> getAvailableSeatsForClass(String seatClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
