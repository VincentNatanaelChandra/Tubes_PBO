/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Vincent
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public boolean inputData(int userId, int gamesId) {
        conn.connect();
        String query = "INSERT INTO transactions (user_id, games_id) VALUES (?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, gamesId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getIdGames(String name, String genre, int price) {
        conn.connect();
        String query = "SELECT id, name, genre, price FROM games WHERE name = '" + name +"' AND genre = '" + genre +"' AND price = '" + price +"'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }
    
    public int getIdUser(String email) {
        conn.connect();
        String query = "SELECT id FROM users WHERE email = '" + email +"'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = (rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (id);
    }
    
    public static boolean getUser(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";
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
    
    public ArrayList<String> getTransaction(int id) {
        conn.connect();
        String query = "SELECT t.user_id, t.games_id FROM transactions "
                + "JOIN users u on t.user_id = u.id"
                + "JOIN games g on t.games_id = g.id"
                + "WHERE t.user_id = '" + id + "'";
        ArrayList<String> listTransaction = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransaction);
    }
}
