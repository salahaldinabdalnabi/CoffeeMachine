/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.coffee.machine;

/**
 *
 * @author saladin
 */
public abstract class Coffee {
    private String type;
    private int coffeeAmount; 
    private int waterAmount; 
    private float calories;
    private boolean isDouble; 

    public Coffee(String type, int coffeeAmount, int waterAmount, boolean isDouble, boolean isAmericano) {
        this.type = type; 
        if(isDouble && !isAmericano)
        {
            this.coffeeAmount = coffeeAmount * 2;
            this.waterAmount = waterAmount * 2;
            
        }
        if(isDouble && isAmericano)
        {
            this.coffeeAmount = coffeeAmount * 2;
            this.waterAmount = 220;
        }
        else
        {
            this.coffeeAmount = coffeeAmount; 
            this.waterAmount = waterAmount; 
        }
        this.isDouble = isDouble;
        calculateCalories(); 
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public boolean isIsDouble() {
        return isDouble;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public void setIsDouble(boolean isDouble) {
        this.isDouble = isDouble;
    }

    private void calculateCalories() {
        if(type.equals("Arabica"))
            this.calories = 1f * this.coffeeAmount; 
        if(type.equals("Robusta"))
            this.calories = 2f * this.coffeeAmount; 
        if(type.equals("Blend"))
            this.calories = 1.5f * this.coffeeAmount; 
    }
    
}
