/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Vincent
 */
public class Gamelist {
    public Gamelist(int id) {
        form(id);
    }

    private void form(int id) {
        JFrame f = new JFrame("List Games");
        Controller con = new Controller();

        //Name
        JLabel labelName = new JLabel("Name: ");
        JTextField textName = new JTextField();
        labelName.setBounds(10, 100, 200, 20);
        textName.setBounds(200, 100, 200, 20);

        //Genre
        JLabel labelGenre = new JLabel("Genre: ");
        JTextField textGenre = new JTextField();
        labelGenre.setBounds(10, 130, 200, 20);
        textGenre.setBounds(200, 130, 200, 20);
        
        //Price
        JLabel labelPrice = new JLabel("Price: ");
        JTextField textPrice = new JTextField();
        labelPrice.setBounds(10, 160, 200, 20);
        textPrice.setBounds(200, 160, 200, 20);

        //foto
        JLabel labelFoto = new JLabel("Foto: ");
        JButton fotoChooser = new JButton("Choose File:");
        JLabel pathFoto = new JLabel("No file selected");
        labelFoto.setBounds(10, 190, 200, 20);
        fotoChooser.setBounds(200, 190, 200, 20);
        pathFoto.setBounds(200, 210, 300, 20);
        fotoChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnValue = jf.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jf.getSelectedFile();
                    String pathFile = selectedFile.getAbsolutePath();
                    pathFoto.setText(pathFile);
                }
            }
        });

        //tombol submit
        JButton insertData = new JButton("Buy Game");
        insertData.setBounds(200, 250, 200, 30);
        insertData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String genre = textGenre.getText();
                double priceDouble = Double.parseDouble(textPrice.getText());
                int priceInt = (int)priceDouble;
                
                
                if (name.isEmpty() || genre.isEmpty() || priceInt == 0 ||  pathFoto.getText().equals("No file selected")) {
                    JOptionPane.showMessageDialog(f, "Data belum komplit", "Lengkapi Data", JOptionPane.WARNING_MESSAGE);
                } else {
                    int idGames = con.getIdGames(name, genre, priceInt);
                    boolean succeed = con.inputData(id,idGames);
                    f.dispose();
                    if (succeed) {
                        JOptionPane.showMessageDialog(f, "Data berhasil disimpan");
                        new Gamelist(id);
                        f.dispose();
                    }
                }

            }
        });
        
        JButton buttonTransaction = new JButton("Transactions");
        buttonTransaction.setBounds(150, 30, 100, 30);
        buttonTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idUser  = id;
                new Transactions(idUser);
                f.dispose();
            }
        });
        f.add(insertData);
        f.add(buttonTransaction);
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(160, 350, 150, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new MainMenu();
            }
        });

        f.add(labelName);
        f.add(textName);
        f.add(labelGenre);
        f.add(textGenre);
        f.add(labelPrice);
        f.add(textPrice);
        f.add(labelFoto);
        f.add(fotoChooser);
        f.add(pathFoto);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}
