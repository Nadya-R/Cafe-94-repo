package com.example.cafeo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TakeawayManagementSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
      
Parent root = FXMLLoader.load(TakeawayManagementSystem.class.getResource("hello-view.fxml"));

  

            primaryStage.setTitle("Takeaway Management System");

            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
