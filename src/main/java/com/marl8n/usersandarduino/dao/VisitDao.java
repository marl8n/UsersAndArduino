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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MIDP9
 */
public class VisitDao {
    public static void makeVisit(User user) {
        InitConnection dbConnection = new InitConnection();
        String query = "INSERT INTO visits (user_id) VALUES (?)";
        try ( Connection connection = dbConnection.getConnection() ) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Visit created");
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
