/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.connectiontodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MIDP9
 */
public class InitConnection {
    
    Connection connection = null;
    
    public Connection getConnection () {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_of_visits", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return connection;
    }
}
