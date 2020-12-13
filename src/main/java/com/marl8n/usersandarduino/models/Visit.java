/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.models;

import java.sql.Date;

/**
 *
 * @author MIDP9
 */
public class Visit {
    private int visitId;
    private User user;
    private Date dateVisited;
    private int active;

    public Visit(){
        
    }
    
    public Visit(User user) {
        this.user = user;
    }
    
    
}
