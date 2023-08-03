package com.example.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    public Label L1,L2,L3,L4,L5,L6,L7,L8,L9;
    public Rectangle R1,R2,R3,R4,R5,R6,R7,R8,R9;
    public Rectangle[] Rectangles;
    public Label[] Labels;
    public TextField StName;
    public ColorPicker StColor;
    public Label ErrorLabel;
//-------------------------------------------------------------------------------------------------------
    String Blank = "";
    String NameText;

    ArrayList<Integer> AlreadyUsed = new ArrayList<>();

    ArrayList<String> Names = new ArrayList<>();

    ArrayList<Color> Colours = new ArrayList<>();

//-------------------------------------------------------------------------------------------------------
    @FXML
    public void initialize() {
        Rectangles = new Rectangle[]{R1, R2, R3, R4, R5, R6, R7, R8, R9};
        Labels = new Label[]{L1, L2, L3, L4, L5, L6, L7, L8, L9};
    }
    public void AddStudent(ActionEvent actionEvent) {

        if(StName.getText().trim().equals(Blank)){
            ErrorLabel.setText("Error student name field empty");
        }else if(AlreadyUsed.size() == 9){
            ErrorLabel.setText("All the seats are filled.");
        }else if(Names.contains(StName.getText().toLowerCase())){
            ErrorLabel.setText("Name Already in Use!");
        }else if(Colours.contains(StColor.getValue())){
            ErrorLabel.setText("Color Already in Use!");
        } else{
            ErrorLabel.setText("");
            NameText = StName.getText();
            Random random = new Random();
            int Caunt = random.nextInt(9);
            while(AlreadyUsed.contains(Caunt)){
                Caunt = random.nextInt(9);
            }
            AlreadyUsed.add(Caunt);
            Rectangle rec = Rectangles[Caunt];
            rec.setFill(StColor.getValue());
            Label label = Labels[Caunt];
            label.setText(NameText);
            Names.add(NameText.toLowerCase());
            Colours.add(StColor.getValue());
            StName.setText("");

        }
    }
}