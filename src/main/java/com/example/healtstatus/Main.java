package com.example.healtstatus;

import com.example.healtstatus.Controller.MoodController;
import com.example.healtstatus.Controller.SortByPhysic;
import com.example.healtstatus.Controller.SortDateCompare;
import com.example.healtstatus.Model.Mood;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {
    @FXML
    private Button add_menu;
    @FXML
    private Button chart_menu;
    @FXML
    private Button mental_mid;
    @FXML
    private Button physic_mid;
    @FXML
    private Button most_eated_food;
    @FXML
    private Button best_mental;
    @FXML
    private Button best_physic;
    @FXML
    private LineChart<Date, Number> best_physic_chart;
    @FXML
    private Axis<Number> xAxis;
    @FXML
    private Axis<Date> yAxis;
    private MoodController moodController;
    ArrayList<Mood> all;

    @Override
    public void start(Stage stage) throws Exception {
        final int X = 300;
        final int Y = 300;

        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==add_menu){
            stage = (Stage) add_menu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("add_menu.fxml"));
        }
        else if(event.getSource()==mental_mid){
            stage = (Stage) mental_mid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("mental_mid.fxml"));
        }
        else if(event.getSource()==physic_mid){
            stage = (Stage) physic_mid.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("physic_mid.fxml"));
        }
        else if(event.getSource()==most_eated_food){
            stage = (Stage) most_eated_food.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("most_eated.fxml"));
        }
        else if(event.getSource()==best_mental){
            stage = (Stage) best_mental.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("best_mental.fxml"));
        }
        else if(event.getSource()==best_physic){
            stage = (Stage) best_physic.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("best_physic.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
