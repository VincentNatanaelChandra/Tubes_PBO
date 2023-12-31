package Controller;

import Model.Destination;
import Model.Refund;
import Model.RefundEnum;
import Model.Reschedule;
import Model.RescheduleEnum;
import Model.Transaction;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Vincent
 */
public class Controller {
    
    private static Controller instance;

    public static synchronized Controller getInstance() {
        if (instance == null) // Lazy instantiation
        {
            instance = new Controller();
        }
        return instance;
    }
    
    static DatabaseHandler conn = new DatabaseHandler();
    
    //Menu login
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
        String query = "SELECT * FROM customer c JOIN admin a on c.cust_id = a.cust_id WHERE "
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
    // reschedule
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
    
    public boolean getPromo(String promo_kode) {
        conn.connect();
        String query = "SELECT * FROM promo WHERE promo_code = '" + promo_kode + "'";
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
    
    public ArrayList<Destination> getInsertDestination() {
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
    
    public ArrayList<String> getSeatNumber(int id) {
        ArrayList<String> listSeat = new ArrayList<>();
        conn.connect();
        String query = "SELECT seat_number FROM planeseat WHERE seat_state = 0 && flight_id = "+id+"";
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
    
    public boolean requestRefund(int ticket_id, RefundEnum refund_status, double refund_total, String refund_reason) {
        conn.connect();
        String query = "INSERT INTO refund (ticket_id, refund_status, refund_total, refund_reason) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, ticket_id);
            stmt.setString(2, refund_status.toString());
            stmt.setDouble(3, refund_total);
            stmt.setString(4, refund_reason);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean requestReshcedule(int ticket_id, RescheduleEnum reschedule_status, String reschedule_reason, Date reschedule_date, String reschedule_seat) {
        conn.connect();
        String query = "INSERT INTO reschedule (ticket_id, reschedule_status, reschedule_reason, reschedule_date, reschedule_seat) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, ticket_id);
            stmt.setString(2, reschedule_status.toString());
            stmt.setString(3, reschedule_reason);
            stmt.setDate(4, reschedule_date);
            stmt.setString(5, reschedule_seat);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public double getPromoPercent(String code) {
        conn.connect();
        String query = "SELECT promo_percent FROM promo WHERE promo_code = '" + code + "'";
        double promo = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                promo = (rs.getDouble("promo_percent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return promo;
    }
    
    public int getSeatPrice(String classes) {
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
    
    public int getFlightId(String company, String departure, String arrival) {
        conn.connect();
        String query = "SELECT f.flight_id FROM flight f JOIN destination d ON f.destination_id = d.destination_id WHERE f.flight_company = '" + company + "' && d.destination_departure = '" + departure +"' && d.destination_arrival = '" + arrival + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }
    
    public boolean registerTicket(int flight, String ticket, Date dateTicket, String preference) {
        conn.connect();
        String query = "INSERT INTO ticket (flight_id, ticket_code, ticket_date, ticket_preference) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, flight);
            stmt.setString(2, ticket);
            stmt.setDate(3, dateTicket);
            stmt.setString(4, preference);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registerTransaction(int ticket, String method, int seatPrice, int promo, int total, int promoId, int memberId) {
        conn.connect();
        String query = "INSERT INTO transaction (ticket_id, transaction_payMethod, transaction_seatPrice, transation_promoDiscount, transaction_totalPrice, promo_id, member_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, ticket);
            stmt.setString(2, method);
            stmt.setInt(3, seatPrice);
            stmt.setInt(4, promo);
            stmt.setInt(5, total);
            stmt.setInt(6, promoId);
            stmt.setInt(7, memberId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public String getPinpayMember(int id) {
        conn.connect();
        String query = "SELECT member_pinPay FROM member WHERE member_id = '" + id + "'";
        String pinpay = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pinpay = (rs.getString("member_pinPay"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pinpay);
    }
    public ArrayList<Transaction> getHistoryMember1(int member_id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM transaction WHERE member_id ='" + member_id + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction trans = new Transaction();
                trans.setTransaction_id(rs.getInt("transaction_id"));
                trans.setTransaction_payMethod(rs.getString("transaction_payMethod"));
                trans.setTransaction_seatPrice(rs.getDouble("transaction_seatPrice"));
                trans.setTransaction_mealPrice(rs.getDouble("transaction_mealPrice"));
                trans.setTransaction_promoDiscount(rs.getDouble("transaction_promoDiscount"));
                trans.setTransaction_totalPrice(rs.getDouble("transaction_totalPrice"));
                
                transactions.add(trans);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (transactions);
    }
    
    public ArrayList<Transaction> getHistoryAdmin() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM transaction";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction trans = new Transaction();
                trans.setTransaction_id(rs.getInt("transaction_id"));
                trans.setTransaction_payMethod(rs.getString("transaction_payMethod"));
                trans.setTransaction_seatPrice(rs.getDouble("transaction_seatPrice"));
                trans.setTransaction_mealPrice(rs.getDouble("transaction_mealPrice"));
                trans.setTransaction_promoDiscount(rs.getDouble("transaction_promoDiscount"));
                trans.setTransaction_totalPrice(rs.getDouble("transaction_totalPrice"));
                
                transactions.add(trans);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (transactions);
    }
    public int getTicketId(String ticket) {
        conn.connect();
        String query = "SELECT ticket_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("ticket_id");
            }
            ticket = String.valueOf((int) (Math.random() * 10000));
            System.out.println(ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }
    public int getPromoId(String promo_kode) {
        conn.connect();
        String query = "SELECT promo_id FROM promo WHERE promo_code = '" + promo_kode + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("promo_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return id;
    }
    
    public int getTicketIdInt(String ticket) {
        conn.connect();
        String query = "SELECT ticket_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("ticket_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }
    
    public boolean updateFlight(int flight, String plane, String airline, String type, String planetype, int totalSeat) {
        conn.connect();
        String query = "UPDATE flight"
                + " SET flight_planeCode='" + plane + "',"
                + "flight_company='" + airline + "',"
                + "flight_type='" + type + "',"
                + "flight_planeType='" + planetype + "',"
                + "flight_totalSeat='" + totalSeat + "' "
                + "WHERE flight_id = " + flight;
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateDestination(int destination, String departure, String arrival, Date destinationDate) {
        conn.connect();
        String query = "UPDATE destination"
                + " SET destination_departure='" + departure + "',"
                + "destination_arrival='" + arrival + "',"
                + "destination_departureDate='" + destinationDate + "' "
                + "WHERE destination_id = " + destination;
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePromo(int promo, String code, String type, Date expired, double percent) {
        conn.connect();
        String query = "UPDATE promo"
                + " SET promo_code='" + code + "',"
                + "promo_type='" + type + "',"
                + "promo_expiredDate='" + expired + "',"
                + "promo_percent='" + percent + "' "
                + "WHERE promo_id = " + promo;
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateSeat(String seat) {
        conn.connect();
        String query = "UPDATE planeseat"
                + " SET seat_state= " + 1 + " "
                + "WHERE seat_number = '" + seat + "'";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getFlightId(String ticket) {
        conn.connect();
        String query = "SELECT flight_id FROM ticket WHERE ticket_code = '" + ticket + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }
    
    public boolean getTicket(String ticket) {
        conn.connect();
        String query = "SELECT ticket_code FROM ticket WHERE ticket_code = '" + ticket + "'";
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
    public ArrayList<Refund> getViewRefund() {
        ArrayList<Refund> refund = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM refund";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String refundStatusString = rs.getString("refund_status");
            RefundEnum refundStatus = RefundEnum.valueOf(refundStatusString);
            while (rs.next()) {
                Refund refunds = new Refund();
                refunds.setRefund_id(rs.getInt("refund_id"));
                refunds.setTicket_id(rs.getInt("ticket_id"));
                refunds.setRefund_status(refundStatus);
                refunds.setRefund_total(rs.getInt("refund_total"));
                refunds.setRefund_reason(rs.getString("refund_reason"));
                
                refund.add(refunds);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (refund);
    }
    
    public ArrayList<Reschedule> getViewReschedule() {
        ArrayList<Reschedule> reschedules = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM reschedule";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String rescheduleStatusString = rs.getString("reschedule_status");
            RescheduleEnum rescheduleStatus = RescheduleEnum.valueOf(rescheduleStatusString);
            while (rs.next()) {
                Reschedule listReschedules = new Reschedule();
                listReschedules.setReschedule_id(rs.getInt("reschedule_id"));
                listReschedules.setTicket_id(rs.getInt("ticket_id"));
                listReschedules.setReschedule_status(rescheduleStatus);
                listReschedules.setReschedule_reason(rs.getString("reschedule_reason"));
                listReschedules.setReschedule_date(rs.getDate("reschedule_date"));
                listReschedules.setReschedule_seat(rs.getString("reschedule_Seat"));
                
                reschedules.add(listReschedules);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (reschedules);
    }
    
    public boolean updateRefund(int ticket_id, String action) {
    conn.connect();
    String statusToUpdate = (action.equals("accept")) ? "REFUNDSUCCESS" : "REFUNDDENIED";

    String query = "UPDATE refund"
            + " SET refund_status= ? "
            + " WHERE ticket_id = ?";
    PreparedStatement stmt;
    try {
        stmt = conn.con.prepareStatement(query);
        stmt.setString(1, statusToUpdate);
        stmt.setInt(2, ticket_id);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean updateReschedule(int ticket_id, String action) {
        conn.connect();
        String statusToUpdate = (action.equals("accept")) ? "RESCHEDULESUCCESS" : "RESCHEDULEDENIED";
        String query = "UPDATE reschedule"
                + " SET reschedule_status= ?' "
                + "WHERE ticket_id = ? ";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Object> getHistory() {
        ArrayList<Object> histories = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT c.cust_name, m.member_id, tck.ticket_id, tck.ticket_code, tck.ticket_date, tck.ticket_preference, t.transaction_id, t.transaction_payMethod, "
                    + "t.transaction_seatPrice, t.transation_promoDiscount, t.transaction_totalPrice, p.promo_id, p.promo_code "
                    + "FROM customer c JOIN member m ON c.cust_id = m.member_id "
                    + "JOIN transaction t ON m.member_id = t.member_id "
                    + "JOIN ticket tck ON t.ticket_id = tck.ticket_id "
                    + "JOIN promo p ON t.promo_id = p.promo_id";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                histories.add(rs.getString("cust_name"));
                histories.add(rs.getInt("member_id"));
                histories.add(rs.getInt("ticket_id"));
                histories.add(rs.getString("ticket_code"));
                histories.add(rs.getDate("ticket_date"));
                histories.add(rs.getString("ticket_preference"));
                histories.add(rs.getInt("transaction_id"));
                histories.add(rs.getString("transaction_payMethod"));
                histories.add(rs.getInt("transaction_seatPrice"));
                histories.add(rs.getInt("transation_promoDiscount"));
                histories.add(rs.getInt("transaction_totalPrice"));
                histories.add(rs.getInt("promo_id"));
                histories.add(rs.getInt("promo_code"));
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (histories);
    }
    
    public ArrayList<Object> getHistoryMember(int member_id) {
        ArrayList<Object> histories = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT c.cust_name, m.member_id, tck.ticket_id, tck.ticket_code, tck.ticket_date, tck.ticket_preference, t.transaction_id, t.transaction_payMethod, "
                    + "t.transaction_seatPrice, t.transation_promoDiscount, t.transaction_totalPrice, p.promo_id, p.promo_code "
                    + "FROM customer c JOIN member m ON c.cust_id = m.member_id "
                    + "JOIN transaction t ON m.member_id = t.member_id "
                    + "JOIN ticket tck ON t.ticket_id = tck.ticket_id "
                    + "JOIN promo p ON t.promo_id = p.promo_id WHERE m.member_id = " + member_id +"";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                histories.add(rs.getString("cust_name"));
                histories.add(rs.getInt("member_id"));
                histories.add(rs.getInt("ticket_id"));
                histories.add(rs.getString("ticket_code"));
                histories.add(rs.getDate("ticket_date"));
                histories.add(rs.getString("ticket_preference"));
                histories.add(rs.getInt("transaction_id"));
                histories.add(rs.getString("transaction_payMethod"));
                histories.add(rs.getInt("transaction_seatPrice"));
                histories.add(rs.getInt("transation_promoDiscount"));
                histories.add(rs.getInt("transaction_totalPrice"));
                histories.add(rs.getInt("promo_id"));
                histories.add(rs.getInt("promo_code"));
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        } 
        return (histories);    
    }
    
    public int getTotalPrice(int ticket) {
        conn.connect();
        String query = "SELECT transaction_totalPrice FROM transaction WHERE ticket_id = '" + ticket + "'";
        int price = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = (rs.getInt("transaction_totalPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (price);
    }
    
     public ArrayList<String> getAllFlightCode() {
        conn.connect();
        String query = "SELECT flight_planeCode FROM flight";
        ArrayList<String> codes = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                codes.add(rs.getString("flight_planeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (codes);
    }
     
     public int getFlightIdFromPlane(String plane) {
        conn.connect();
        String query = "SELECT flight_id FROM flight WHERE flight_planeCode = '" + plane + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("flight_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return id;
    }
     
     public ArrayList<Integer> getDestinationId() {
        conn.connect();
        String query = "SELECT destination_id FROM destination ";
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ids.add(rs.getInt("destination_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ids;
    }
     
     public ArrayList<Integer> getPromoId() {
        conn.connect();
        String query = "SELECT promo_id FROM promo ";
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ids.add(rs.getInt("promo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return ids;
    }
     
     public String getPlaneCode(int id) {
        conn.connect();
        String query = "SELECT flight_planeCode FROM flight WHERE flight_id = '" + id + "'";
        String code = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                code = (rs.getString("flight_planeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (code);
    }
}