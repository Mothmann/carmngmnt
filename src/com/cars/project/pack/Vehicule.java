/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cars.project.pack;
import java.io.*;
/**
 *
 * @author Admin
 */

public class Vehicule{
    
    private String brand;
    private String model;
    private int License_Plate;
    private int kilometre;
    private boolean status;
    private boolean reserved;

    public Vehicule(String brand, String model, int License_Plate, int kilometre, boolean status, boolean reserved) {
        this.brand = brand;
        this.model = model;
        this.License_Plate = License_Plate;
        this.kilometre = kilometre;
        this.status = status;
        this.reserved = reserved;
    }

    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLicense_Plate() {
        return License_Plate;
    }

    public void setLicense_Plate(int License_Plate) {
        this.License_Plate = License_Plate;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
}
