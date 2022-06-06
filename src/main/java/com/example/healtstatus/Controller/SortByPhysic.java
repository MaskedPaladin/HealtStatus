package com.example.healtstatus.Controller;

import com.example.healtstatus.Model.Mood;

import java.util.Comparator;

public class SortByPhysic implements Comparator<Mood> {
    @Override
    public int compare(Mood o1, Mood o2) {
        if (o1.getPhysic() > o2.getPhysic()){
            return 1;
        }
        else if (o1.getPhysic() < o2.getPhysic()){
            return -1;
        }
        else {
            return 0;
        }
    }
}