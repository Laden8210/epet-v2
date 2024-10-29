package com.example.consumetric.model;

public class Food {

    private String name;
    private int calories;
    private String description;

    private String portion;


    public Food(String name, int calories, String description, String portion) {
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.portion = portion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }
}
