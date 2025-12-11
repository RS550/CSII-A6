package com.monsters.databasefx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
//To Display Page
    private Stage displayStage;
    private Scene displayScene;
    private Parent displayRoot;
//To Edit Page
    private Stage editorStage;
    private Scene editorScene;
    private Parent editorRoot;

    public String[] seasonList = {"Season 1","Season 2", "Season 3", "Season 4"};
    public String[] tagList = {"Musical","Parody", "Two Part", "Holiday"};
    public String seasonSearch = "";
    public String seasonSelected = "";
    public String tagSearch = "";
    public String tagSelected = "";

    @FXML
    private Button addB, searchB, editB;

    @FXML
    private ComboBox<String> seasonCB = new ComboBox<>();

    @FXML
    private ComboBox<String> tagCB = new ComboBox<>();

    @FXML
    private DatePicker airDatePicker = new DatePicker();

    @FXML
    private TextField episodeNumberBox = new TextField();

    @FXML
    private TextField episodeNameBox = new TextField();

    @FXML
    private TextField burgerBox = new TextField();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seasonCB.getItems().addAll(seasonList);
        seasonCB.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                seasonSelected = seasonCB.getValue();
            }
        });

        tagCB.getItems().addAll(tagList);
        tagCB.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tagSelected = seasonCB.getValue();
            }
        });
        SQLConnection.seasonSearch("SEARCH * FROM episodes WHERE episode.season_id = 1");
    }

    @FXML
    private void getSeason(){
        String season = "1";
        if(seasonSelected.equalsIgnoreCase("Season 1")){season = "1";}
        else if(seasonSelected.equalsIgnoreCase("Season 2")){season = "2";}
        else if(seasonSelected.equalsIgnoreCase("Season 3")){season = "3";}
        else if(seasonSelected.equalsIgnoreCase("Season 4")){season = "4";}
        seasonSearch = "SELECT * FROM episodes WHERE season_num =" + season;
    }

    @FXML
    private String getTag(){
        String tag = "";
        if(tagSelected.equalsIgnoreCase("Musical")){tag = "Musical";}
        else if(tagSelected.equalsIgnoreCase("Parody")){tag = "Parody";}
        else if(tagSelected.equalsIgnoreCase("Two Part")){tag = "TwoPart";}
        else if(tagSelected.equalsIgnoreCase("Holiday")){tag = "Holiday";}
        return tag;
    }

    @FXML
    public void addEpisode(){
        //Need to add
    }

    @FXML
    public void searchPage(ActionEvent event) throws IOException {
        displayRoot = FXMLLoader.load(getClass().getResource("/com/monsters/databasefx/DBSearchResults.fxml"));
        displayStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        displayScene = new Scene(displayRoot);
        displayStage.setScene(displayScene);
        displayStage.show();
    }

    @FXML
    public void editPage(ActionEvent event) throws IOException {
        editorRoot = FXMLLoader.load(getClass().getResource("/com/monsters/databasefx/DBEditNew.fxml"));
        editorStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        editorScene = new Scene(editorRoot);
        editorStage.setScene(editorScene);
        editorStage.show();
    }

    @FXML
    public String getBurger(){return burgerBox.getText();}

    @FXML
    public String getEpisodeNumber(){return episodeNumberBox.getText();}

    @FXML
    public String getEpisodeName(){return episodeNameBox.getText();}

    @FXML
    public String getAirDate(){return String.valueOf(airDatePicker.getValue());}
}