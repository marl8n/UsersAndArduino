/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.dao;

import com.marl8n.usersandarduino.connectiontodb.InitConnection;
import com.marl8n.usersandarduino.models.User;
import com.marl8n.usersandarduino.models.Visit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public static ArrayList<Object[]> getVisitsBetween(Date dateBegin, Date dateEnd) {
        InitConnection dbConnection = new InitConnection();
        ArrayList<Object[]> visits = new ArrayList();
        String query = "SELECT u.name, v.date_visited, COUNT(*) AS visits_quantity\n" +
"FROM visits AS v\n" +
"JOIN users AS u\n" +
"ON u.user_id = v.user_id\n" +
"GROUP BY v.user_id\n" +
"HAVING v.date_visited BETWEEN ? AND ?\n" +
"ORDER BY visits_quantity;";
        try ( Connection connection = dbConnection.getConnection() ) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, dateBegin);
            ps.setDate(2, dateEnd);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                visits.add(
                        new Object[] {
                            rs.getString("name"),
                            rs.getTimestamp("date_visited"),
                            rs.getInt("visits_quantity")
                        }
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return visits;
    } 
}
