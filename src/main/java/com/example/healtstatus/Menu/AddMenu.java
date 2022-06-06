package com.example.healtstatus.Menu;

import com.example.healtstatus.Controller.MoodController;
import com.example.healtstatus.Model.Mood;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AddMenu extends Application {
    @FXML
    private Label labelMental;
    @FXML
    private Label labelPhysic;
    @FXML
    private Label labelFood;

    @FXML
    private TextField mental;
    @FXML
    private TextField physic;
    @FXML
    private TextField food;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, ClassNotFoundException {
        MoodController moodController = new MoodController();
        ArrayList<Mood> allEntries = moodController.load("database.db");
        Mood entry = new Mood();
        if (mental.getText().length()>0 && physic.getText().length()>0 && food.getText().length()>0){
            int m = Integer.parseInt(mental.getText());
            int p = Integer.parseInt(physic.getText());
            if(m < 0 || m > 5 || p < 0 || p > 5){
                System.out.println("Invalid ranges");
            }
            else{
                String[] f = food.getText().split(",");
                ArrayList<String> foods = new ArrayList<>();
                Collections.addAll(foods, f);
                ArrayList<String> validFoods = new ArrayList<>();
                validFoods.add("llet");
                validFoods.add("cereals");
                validFoods.add("pasta");
                validFoods.add("fruita");
                validFoods.add("vegetals");
                validFoods.add("llegums");
                validFoods.add("aigua");
                validFoods.add("alcohol");
                validFoods.add("sucs");
                for(String e : foods){
                    if(!validFoods.contains(e)){
                        System.out.println("Invalid food type/types");
                        break;
                    }
                }
                Date date = new Date();
                entry.setActual(date);
                entry.setMental(m);
                entry.setPhysic(p);
                entry.setFoodTypes(foods);
                allEntries.add(entry);
                moodController.save(allEntries, "database.db");
                System.out.println(entry);
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
