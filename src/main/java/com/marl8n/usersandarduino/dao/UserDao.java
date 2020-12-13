/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.dao;

import com.marl8n.usersandarduino.connectiontodb.InitConnection;
import com.marl8n.usersandarduino.models.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MIDP9
 */
public class UserDao {
    
    public static void createUser(User user) {
        InitConnection dbConnection = new InitConnection();
        try (Connection connection = dbConnection.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO users (name, dpi, birthdate, genre, password) VALUES (?, ?, ?, ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, user.getName());
                ps.setString(2, user.getDpi());
                ps.setDate(3, user.getBirthDate());
                ps.setString(4, user.getGenre());
                ps.setString(5, user.getPassword());
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "User created!!!");
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error ocurred, person not created");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error ocurred, person not created");
        }
    }
    
    public static ArrayList<User> getUser() {
        ArrayList<User> users = new ArrayList();
        InitConnection dbConnection = new InitConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection connection = dbConnection.getConnection()) {
            String query = "SELECT u.dpi, u.name FROM users AS u;";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                String[] us = new String[2];
                us[0] = "" + (rs.getString("dpi"));
                us[1] = "" + rs.getString("name");
                //JOptionPane.showConfirmDialog(null, us[1]);
                users.add(new User(us[1], us[0]));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error ocurred, person not created");
        }
        return users;
    }
    
    public static ArrayList<User> getUserVisits() {
        ArrayList<User> users = new ArrayList();
        InitConnection dbConnection = new InitConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection connection = dbConnection.getConnection()) {
            String query = "SELECT u.name, COUNT(*) AS vistis_quantity\n" +
"FROM visits as v\n" +
"JOIN users as u ON u.user_id = v.user_id\n" +
"GROUP BY v.user_id;";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                String[] us = new String[2];
                us[0] = "" + (rs.getString("vistis_quantity"));
                us[1] = "" + rs.getString("u.name");
                //JOptionPane.showConfirmDialog(null, us[1]);
                users.add(new User(us[1], us[0]));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error ocurred, person not created");
        }
        return users;
    }
    
    public static void deleteUser(User user) {
        //
    }
    
    public static void actualizeUser(User user) {
        //
    }
    
    public static User signIn(String dpi, String password) {
        InitConnection dbConnection = new InitConnection();
        String query = "SELECT user_id, name, dpi, birthdate, genre, password FROM users WHERE dpi = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try ( Connection connection = dbConnection.getConnection() ) {
            ps = connection.prepareStatement(query);
            ps.setString(1, dpi);
            rs = ps.executeQuery();
            rs.next();
            User user = new User (
                        Integer.valueOf(rs.getInt("user_id")),
                        String.valueOf( rs.getString("name")),
                        String.valueOf( rs.getString("dpi")),
                        String.valueOf( rs.getString("password"))
                );
            if ( password.equals(user.getPassword()) ) {
                return user;
            }else {
                JOptionPane.showMessageDialog(null, rs.getString("password"));
                JOptionPane.showMessageDialog(null, password);
            }
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }
}
