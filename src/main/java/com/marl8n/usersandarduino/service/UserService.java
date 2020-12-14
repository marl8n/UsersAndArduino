/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.service;

import com.marl8n.usersandarduino.dao.UserDao;
import com.marl8n.usersandarduino.dao.ValidateUser;
import static com.marl8n.usersandarduino.dao.VisitDao.makeVisit;
import com.marl8n.usersandarduino.models.User;
import javax.swing.JOptionPane;

/**
 *
 * @author MIDP9
 */
public class UserService {
    public static void createUser(User user) {
        User f = UserDao.createUser(user);
        makeVisit(f);
    }
    
    public static void listUsers() {
        //
    }
    
    /**
     *
     */
    public static void deleteUser(String dpi, String password) {
        User user = ValidateUser.validate(dpi, password);
        if (user != null) {
            UserDao.deleteUser(user);
            JOptionPane.showMessageDialog(null, "User deleted");
        } else {
            JOptionPane.showMessageDialog(null, "The DPI or the password are incorrect");
        }
    }

    public static void editUser() {
        //
    }
    
    public static void signIn(String dpi, String password) {
        User userIn = UserDao.signIn(dpi, password);
        if ( userIn != null ) {
            makeVisit(userIn);
        }
    }
}
