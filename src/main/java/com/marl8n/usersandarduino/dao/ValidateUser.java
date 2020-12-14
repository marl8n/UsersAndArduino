/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.dao;

import com.marl8n.usersandarduino.connectiontodb.InitConnection;
import com.marl8n.usersandarduino.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MIDP9
 */
public class ValidateUser {
    public static User validate(String dpi, String password) {
        InitConnection dbConnection = new InitConnection();
        try ( Connection connection = dbConnection.getConnection() ) {
            String query = "SELECT user_id, name, dpi, birthdate, genre, password FROM users WHERE dpi = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, dpi);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User(
                    Integer.valueOf(rs.getInt("user_id")),
                    String.valueOf("name"),
                    String.valueOf(dpi),
                    String.valueOf("password")
            );
            if ( password.equals(user.getPassword())) {
                return user;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }
}
