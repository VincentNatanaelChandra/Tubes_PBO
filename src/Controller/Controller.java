package Controller;

import Model.Destination;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vincent
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean getUser(String username, String password) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE cust_name = '" + username + "' AND cust_password = '" + password + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean RegisterCustomerData(String username, String password) {
        conn.connect();
        String query = "INSERT INTO customer (cust_name, cust_password) VALUES (?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean RegisterMemberData(String email, String pinPay, int id) {
        conn.connect();
        String query = "INSERT INTO member (member_email, member_pinPay, cust_id) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, pinPay);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIdUser(String username) {
        conn.connect();
        String query = "SELECT cust_id FROM customer WHERE cust_name = '" + username + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("cust_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }

    public boolean getCustomer(String username) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE cust_name = '" + username + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public static boolean getUserAdmin(String username, String password) {
        conn.connect();
        String query = "SELECT * FROM customer c JOIN admin a on c.cust_id = a.cust_id WHERE"
                + "cust_name = '" + username + "' AND cust_password = '" + password + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }

    public boolean getRefund() {
        conn.connect();
        String query = "SELECT * FROM refund";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getReschedule() {
        conn.connect();
        String query = "SELECT * FROM reschedule";

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    
    public int getIdMember(String username) {
        conn.connect();
        String query = "SELECT m.member_id FROM member m JOIN customer c ON m.cust_id = c.cust_id WHERE c.cust_name = '" + username + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("member_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }
    
    public boolean getFlight(int flight_id) {
        conn.connect();
        String query = "SELECT * FROM flight WHERE flight_id = '" + flight_id + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }
    
    public boolean getDestination(int destination_id) {
        conn.connect();
        String query = "SELECT * FROM destination WHERE destination_id = '" + destination_id + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }
    
    public boolean getPromo(int promo_id) {
        conn.connect();
        String query = "SELECT * FROM promo WHERE promo_id = '" + promo_id + "'";
        boolean exists = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return exists;
    }
    
    public boolean updateFlight(int flightInput, int flight_id, ArrayList<Destination> listDestination,String flight_planeCode, String flight_company, String flight_type, String flight_planeType, int flight_totalSeat){
        conn.connect();
        String query = "UPDATE flight"
                + " SET flight_id='" + flight_id + "',"
                + "destination_id='"+ listDestination + "',"
                + "flight_planeCode='"+ flight_planeCode + "',"
                + "flight_company'"+ flight_company + "',"
                + "flight_type='"+ flight_type + "',"
                + "flight_planeType='"+ flight_planeType + "',"
                + "flight_totalSeat='"+ flight_totalSeat + "',"
                + "WHERE flight_id = " + flightInput;
        PreparedStatement stm;
        try {
            stm = conn.con.prepareStatement(query);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    
    
    public boolean updateDestination(int destinationInput, int destination_id, String destination_departure,String destination_arrival, Date destination_departureDate){
        conn.connect();
        String query = "UPDATE destination"
                + " SET destination_id='" + destination_id + "',"
                + "destination_departure='"+ destination_departure + "',"
                + "destination_arrival='"+ destination_arrival + "',"
                + "destination_departureDate='"+ destination_departureDate + "',"
                + "WHERE destination_id = " + destinationInput;
        PreparedStatement stm;
        try {
            stm = conn.con.prepareStatement(query);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    public boolean updatePromo(int promoInput, int promo_id, String promo_code,String promo_type, Date promo_expiredDate){
        conn.connect();
        String query = "UPDATE promo"
                + " SET promo_id='" + promo_id + "',"
                + "promo_code='"+ promo_code + "',"
                + "promo_type='"+ promo_type + "',"
                + "promo_expiredDate='"+ promo_expiredDate + "',"
                + "WHERE promo_id = " + promoInput;
        PreparedStatement stm;
        try {
            stm = conn.con.prepareStatement(query);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<String> getDeparture() {
        ArrayList<String> listDeparture = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT destination_departure FROM destination";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listDeparture.add(rs.getString("destination_departure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listDeparture);
    }
    
    public ArrayList<String> getArrival() {
        ArrayList<String> listArrival = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT destination_arrival FROM destination";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listArrival.add(rs.getString("destination_arrival"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listArrival);
    }
    
    public ArrayList<String> getAirline() {
        ArrayList<String> listAirline = new ArrayList<>();
        conn.connect();
        String query = "SELECT DISTINCT flight_company FROM flight";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listAirline.add(rs.getString("flight_company"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listAirline);
    }
    
    public ArrayList<Destination> getKTP() {
        conn.connect();
        String query = "SELECT * FROM destination";
        ArrayList<Destination> destinations = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Destination destination = new Destination();
                destination.setDestination_departure(rs.getString("destination_departure"));
                destination.setDestination_arrival(rs.getString("destination_arrival"));
                destination.setDestination_departureDate(rs.getDate("destination_departureDate"));
                destinations.add(destination);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (destinations);
    }
    
    public String getUsernameMember(int id) {
        conn.connect();
        String query = "SELECT cust_name FROM customer c WHERE cust_id = '" + id + "'";
        String username = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                username = (rs.getString("cust_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (username);
    }
    
    public boolean getSeatPrice(String code) {
        conn.connect();
        String query = "SELECT Class_price FROM classes WHERE Class_name = '" + classes + "'";
        int price = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = (rs.getInt("Class_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pric);
    }
    
    public int getPromoPrice(String classes) {
        conn.connect();
        String query = "SELECT Class_price FROM classes WHERE Class_name = '" + classes + "'";
        int price = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = (rs.getInt("Class_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (price);
    }
    
    public ArrayList<String> getSeatClass() {
        ArrayList<String> listClass = new ArrayList<>();
        conn.connect();
        String query = "SELECT Class_name FROM classes";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listClass.add(rs.getString("Class_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listClass);
    }
    
    public ArrayList<String> getSeatNumber() {
        ArrayList<String> listSeat = new ArrayList<>();
        conn.connect();
        String query = "SELECT seat_number FROM planeseat WHERE seat_state = 0";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                listSeat.add(rs.getString("seat_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listSeat);
    }
}