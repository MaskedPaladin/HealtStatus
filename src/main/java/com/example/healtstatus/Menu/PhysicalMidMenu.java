package com.example.healtstatus.Menu;

import com.example.healtstatus.Controller.MoodController;
import com.example.healtstatus.Controller.SortDateCompare;
import com.example.healtstatus.Main;
import com.example.healtstatus.Model.Mood;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class PhysicalMidMenu implements Initializable {
    @FXML
    private LineChart<Date, Number> best_physic_chart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MoodController moodController;
        moodController = new MoodController();
        ArrayList<Mood> all = null;
        try {
            all = moodController.load("database.db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
    public void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(),300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
