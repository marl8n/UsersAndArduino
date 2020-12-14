/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marl8n.usersandarduino.models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author MIDP9
 */
public class User {
    private int userId;
    private String name;
    private String dpi;
    private Date birthDate;
    private String genre;
    private String password;
    
    public User () {
        
    }

    public User(String name, String dpi, Date birthDate, String genre, String password) {
        this.name = name;
        this.dpi = dpi;
        this.birthDate = birthDate;
        this.genre = genre;
        this.password = password;
    }

    public User(int userId, String name, String dpi, String password) {
        this.userId = userId;
        this.name = name;
        this.dpi = dpi;
        this.password = password;
    }
    
    

    public User(String name, String dpi) {
        this.name = name;
        this.dpi = dpi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDpi() {
        return dpi;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getPassword() {
        return password;
    }
    
    
}
