/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coffee.machine;

import javax.swing.JOptionPane;

/**
 *
 * @author saladin
 */
public class CoffeeMachine {
   
    private int cupsLimit; 
    private int cupsServed; 
    private int waterLimit; 
    private int currentWater; 
    private int beansLimit; 
    private int currentBeans;
    private boolean isClean; 
    public String Report = ""; 

    public CoffeeMachine(int cupsLimit, int waterLimit, int currentWater, int beansLimit, int currentBeans, boolean isClean) {
        this.cupsLimit = cupsLimit;
        this.waterLimit = waterLimit;
        this.currentWater = currentWater;
        this.beansLimit = beansLimit;
        this.currentBeans = currentBeans;
        this.isClean = isClean;
    }

    
    
    public void startMachine(Coffee beanOrder) throws Exception{
        Report += "Machine is Starting........\n"; 
        
        if(cupsServed == cupsLimit)
        {
            isClean = false; 
            JOptionPane.showMessageDialog(null, "The Machine Needs to be Cleaned");
        }
        if(!isClean)
            CleanTheMachine();
        
        hasEnoughWater(beanOrder);
        hasEnoughCoffee(beanOrder); 
        Report += "Grending .........\n";
        Report += "Brewing ........ \n";
        Report += "Coffee #" + (++cupsServed) + " is Done : \n";
        Report += "Calories = " + beanOrder.getCalories() + "\n";
        Report += "Caffaine = " + beanOrder.getCoffeeAmount() + "\n";
        Report += "========================================= \n"; 
        this.currentWater -= beanOrder.getWaterAmount(); 
        this.currentBeans -= beanOrder.getCoffeeAmount(); 

    }
    public int getCurrentWater() {
        return currentWater;
    }

    public int getCupsLimit() {
        return cupsLimit;
    }

    public void setCupsLimit(int cupsLimit) {
        this.cupsLimit = cupsLimit;
    }

    public void setCurrentWater(int currentWater) throws Exception {
        if(currentWater > this.waterLimit)
        {
            JOptionPane.showMessageDialog(null, "water out of Limit");
            throw new Exception("water out of Limit"); 
        }
        this.currentWater = currentWater;
    }

    public int getCurrentBeans() {
        return currentBeans;
    }

    public void setCurrentBeans(int currentBeans) throws Exception {
        if(currentBeans > this.beansLimit)
        {
            JOptionPane.showMessageDialog(null, "beans out of Limit");
            throw new Exception("beans out of Limit"); 
        }
        this.currentBeans = currentBeans;
    }

    public int getWaterLimit() {
        return waterLimit;
    }

    public void setWaterLimit(int waterLimit) {
        this.waterLimit = waterLimit;
    }

    public int getBeansLimit() {
        return beansLimit;
    }

    public void setBeansLimit(int beansLimit) {
        this.beansLimit = beansLimit;
    }

    public boolean isIsClean() {
        return isClean;
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    private void hasEnoughWater(Coffee beanOrder) throws Exception {
        int water = beanOrder.getWaterAmount(); 
        Report += "Checking if There is Enough Water..... \n"; 
        if(water > this.currentWater)
        {
            JOptionPane.showMessageDialog(null,"Not Enought water in machine"); 
            throw new Exception("Not Enought Water in Machine");
        }
    }
    private void hasEnoughCoffee(Coffee beanOrder) throws Exception {
        int beans = beanOrder.getCoffeeAmount();
        Report += "Checking if There is Enough Coffee..... \n"; 
        if(beans > this.currentBeans)
        {
            JOptionPane.showMessageDialog(null,"Not Enought Beans in machine"); 
            throw new Exception("Not Enought Beans in Machine");
        }
    }  

    private void CleanTheMachine() {
        Report += "Cleaning the Machine....... \n"; 
        Report += "Setting cups Served to Zero \n"; 
        cupsServed = 0; 
    }
    
}
