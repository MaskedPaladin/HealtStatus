package com.example.healtstatus.Menu;

import com.example.healtstatus.Controller.MoodController;
import com.example.healtstatus.Controller.SortDateCompare;
import com.example.healtstatus.Model.Mood;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PhysicalMidMenu extends Application {
    @FXML
    private LineChart<Date, Number> best_physic_chart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        MoodController moodController;
        moodController = new MoodController();
        ArrayList<Mood> all = moodController.load("database.db");

        all.sort(new SortDateCompare());

        XYChart.Series series = new XYChart.Series();
        series.setName("Physical mid");
        int allCount = all.size();
        int counter = 0;
        for(Mood m : all){
            System.out.println(m);
            series.getData().add(new XYChart.Data(counter, m.getPhysic()/allCount));
            counter++;
        }
        best_physic_chart.getData().add(series);
    }
    @Override
    public void start(Stage stage) throws Exception {

    }
}
