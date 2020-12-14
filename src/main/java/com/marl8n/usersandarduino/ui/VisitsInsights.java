/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.ui;

import com.marl8n.usersandarduino.connectiontodb.InitConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MIDP9
 */
public class VisitsInsights {
    public static void howManyVisits() {
        String query = "SELECT COUNT(*) FROM visits WHERE active = 1;";
        InitConnection dbConnection = new InitConnection();
        try (Connection connection = dbConnection.getConnection() ) {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(null, rs.getInt("COUNT(*)"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void lessVisits() {
        InitConnection dbConnection = new InitConnection();
        String query = "SELECT u.name, COUNT(*) AS times_visited FROM visits AS v\n" +
"JOIN users AS u ON v.user_id = u.user_id\n" +
"GROUP BY u.user_id\n" +
"ORDER BY times_visited\n" +
"LIMIT 1;";
        
        try (Connection connection = dbConnection.getConnection() ) {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            JOptionPane.showMessageDialog(null, rs.getString("u.name") + ": " + rs.getInt("times_visited"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
