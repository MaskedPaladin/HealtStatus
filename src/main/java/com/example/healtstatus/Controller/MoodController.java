package com.example.healtstatus.Controller;

import com.example.healtstatus.Model.Mood;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MoodController {
    public void save(ArrayList<Mood> mood, String fileName)throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(mood);
        oos.close();
        fos.close();
    }
    public ArrayList<Mood> load(String fileName) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(fileName));
            ArrayList<Mood> moods = (ArrayList<Mood>) inFile.readObject();
            inFile.close();
            return moods;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
