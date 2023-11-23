package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}