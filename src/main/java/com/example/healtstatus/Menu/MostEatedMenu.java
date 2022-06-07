package com.example.healtstatus.Menu;

import com.example.healtstatus.Controller.MoodController;
import com.example.healtstatus.Model.Mood;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MostEatedMenu implements Initializable {

    @FXML
    private CategoryAxis food_axis;

    @FXML
    private BarChart<?, ?> food_chart;

    @FXML
    private NumberAxis food_quantity_axis;

    private ArrayList<Mood> all;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MoodController moodController = new MoodController();
        try {
            all = moodController.load("database.db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int[] quantity = new int[9];
        ArrayList<String> types = new ArrayList<>();
        types.add("llet");
        types.add("cereals");
        types.add("pasta");
        types.add("fruita");
        types.add("vegetals");
        types.add("llegums");
        types.add("aigua");
        types.add("alcohol");
        types.add("sucs");

        ArrayList<XYChart.Series> series = new ArrayList<>();
        for(Mood e : all){
            for(String t : e.getFoodTypes()){
                if(t.equals("llet")){quantity[0]++;}
                if(t.equals("cereals")){quantity[1]++;}
                if(t.equals("pasta")){quantity[2]++;}
                if(t.equals("fruita")){quantity[3]++;}
                if(t.equals("vegetals")){quantity[4]++;}
                if(t.equals("llegums")){quantity[5]++;}
                if(t.equals("aigua")){quantity[6]++;}
                if(t.equals("alcohol")){quantity[7]++;}
                if(t.equals("sucs")){quantity[8]++;}
            }
        }
        for (int i = 0; i < quantity.length; i++) {
            series.add(new XYChart.Series<>());
            series.get(i).getData().add(new XYChart.Data<>(types.get(i), quantity[i]));
        }
        for(XYChart.Series e : series){
            food_chart.getData().addAll(e);
        }
    }
}
