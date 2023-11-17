/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Vincent
 */
public class Transaction {
    private int id;
    private int user_id;
    private int games_id;

    public Transaction(int id, int user_id, int games_id) {
        this.id = id;
        this.user_id = user_id;
        this.games_id = games_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGames_id() {
        return games_id;
    }

    public void setGames_id(int games_id) {
        this.games_id = games_id;
    }
    
    
}
