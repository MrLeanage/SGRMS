/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;


public class FeedbackPerformance {
    private String category = null;
    private int count = 0;
    private double percentage = 0.0;

    public FeedbackPerformance(){
        
    }
    public FeedbackPerformance(String category, double percentage){
        this.category = category;
        this.percentage = percentage;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    
    
    
}
