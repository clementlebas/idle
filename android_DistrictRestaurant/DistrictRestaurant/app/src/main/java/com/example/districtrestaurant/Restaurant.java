package com.example.districtrestaurant;

public class Restaurant {

    private String restaurantName;
    private int id;
    private int note;

    public Restaurant(String restaurantName, int note, int id) {
        this.restaurantName= restaurantName;
        this.note= note;
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setDistrictName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString()  {
        return this.restaurantName+" (note: "+ this.note+")";
    }
}