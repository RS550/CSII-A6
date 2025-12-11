package com.monsters.databasefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class DBApp extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DBApp.class.getResource("/com/monsters/databasefx/DBSearchResults.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600 ,410);
        stage.setTitle("Bobs Burgers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}