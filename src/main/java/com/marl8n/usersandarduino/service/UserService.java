/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.service;

import com.marl8n.usersandarduino.dao.UserDao;
import static com.marl8n.usersandarduino.dao.VisitDao.makeVisit;
import com.marl8n.usersandarduino.models.User;

/**
 *
 * @author MIDP9
 */
public class UserService {
    public static void createUser(User user) {
        UserDao.createUser(user);
    }
    
    public static void listUsers() {
        //
    }
    
    /**
     *
     */
    public static void deleteUser(String dpi, String password) {
        //
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
