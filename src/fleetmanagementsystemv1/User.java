/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetmanagementsystemv1;

import java.io.*;
/**
 *
 * @author Admin
 */
public class User{
    // name, position, status (activated/no), and an account type.
    private int ID;
    private String name ; 
    private String fonction;
    private String position; 
    private boolean status;
    private String role;
    private String password;
    
    
    public User(){}
    
    public User(int ID,String name, String fonction,String position, boolean status, String role,String password) {
        this.ID = ID;
        this.name = name;
        this.fonction = fonction;
        this.position = position;
        this.status = status;
        this.role = role;
        this.password = password;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}






