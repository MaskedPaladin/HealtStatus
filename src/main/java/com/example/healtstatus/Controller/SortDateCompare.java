package com.example.healtstatus.Controller;

import com.example.healtstatus.Model.Mood;

import java.util.Comparator;
import java.util.Date;

public class SortDateCompare implements Comparator<Mood> {
    @Override
    public int compare(Mood o1, Mood o2) {
        return o1.getActual().compareTo(o2.getActual());
    }
}
