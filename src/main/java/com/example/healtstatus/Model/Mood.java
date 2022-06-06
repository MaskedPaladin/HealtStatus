package com.example.healtstatus.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Mood implements Serializable {
    private Date actual;
    private int mental;
    private int physic;
    private ArrayList<String> foodTypes = new ArrayList<String>();

    public Mood() {
    }

    public Mood(Date actual, int mental, int physic, ArrayList<String> foodTypes) {
        this.actual = actual;
        this.mental = mental;
        this.physic = physic;
        this.foodTypes = foodTypes;
    }

    public Date getActual() {
        return actual;
    }

    public void setActual(Date actual) {
        this.actual = actual;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public ArrayList<String> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(ArrayList<String> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public int getPhysic() {
        return physic;
    }

    public void setPhysic(int physic) {
        this.physic = physic;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "actual='" + actual + '\'' +
                ", mental=" + mental +
                ", physic=" + physic +
                ", foodTypes=" + foodTypes +
                '}';
    }
}
