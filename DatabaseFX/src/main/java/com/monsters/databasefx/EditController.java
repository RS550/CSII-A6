package com.monsters.databasefx;

import javafx.beans.property.SimpleStringProperty;
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
import java.util.Random;
import java.util.ResourceBundle;

public class EditController implements Initializable {
//To Display Page
    private Stage displayStage;
    private Scene displayScene;
    private Parent displayRoot;
//To Add Page
    private Stage addStage;
    private Scene addScene;
    private Parent addRoot;

    public String[] seasonList = {"Season 1","Season 2", "Season 3", "Season 4"};
    public String[] tagList = {"Musical","Parody", "Two Part", "Holiday"};
    public String seasonSearch = "";
    public String tagSearch = "";
    public String seasonSelected = "";
    public String tagSelected = "";

    @FXML
    private Button searchB, editB, updateB;

    @FXML
    private ComboBox<String> seasonCB = new ComboBox<>();

    @FXML
    private ComboBox<String> tagCB = new ComboBox<>();

    @FXML
    private TextField burgerBox = new TextField();

    @FXML
    private TextField episodeNameBox = new TextField();

    @FXML
    private TextField episodeNumberBox = new TextField();

    @FXML
    private DatePicker airDatePicker = new DatePicker();

    @FXML
    private ListView<String> displayLV = new ListView<>();

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
    }

    @FXML
    private void getSeason(){
        displayLV.getItems().clear();

        if(seasonSelected.equals("Season 1")){
            seasonSearch = seasonSearch = "Select * From episodes e JOIN seasons s ON e.season_num = s.season_num WHERE s.season_name = \"season 1\";";
            SQLConnection.seasonSearch(seasonSearch);
            displayLV.getItems().addAll(SQLConnection.episodeSeasonSearchAL.toString());
        }else if(seasonSelected.equals("Season 2")){
            seasonSearch = seasonSearch = "Select * From episodes e JOIN seasons s ON e.season_num = s.season_num WHERE s.season_name = \"season 2\";";
            SQLConnection.seasonSearch(seasonSearch);
            displayLV.getItems().addAll(SQLConnection.episodeSeasonSearchAL.toString());
        }else if(seasonSelected.equals("Season 3")){
            seasonSearch = seasonSearch = "Select * From episodes e JOIN seasons s ON e.season_num = s.season_num WHERE s.season_name = \"season 3\";";
            SQLConnection.seasonSearch(seasonSearch);
            displayLV.getItems().addAll(SQLConnection.episodeSeasonSearchAL.toString());
        }else if(seasonSelected.equals("Season 4")){
            seasonSearch = seasonSearch = "Select * From episodes e JOIN seasons s ON e.season_num = s.season_num WHERE s.season_name = season 4;";
            SQLConnection.seasonSearch(seasonSearch);
            displayLV.getItems().addAll(SQLConnection.episodeSeasonSearchAL.toString());
        }else{
            displayLV.getItems().clear();
            displayLV.getItems().add("Stay Tuned for more seasons!");
        }
    }

    @FXML
    private void getTag(){
        displayLV.getItems().clear();

        if(tagSelected.equalsIgnoreCase("Musical")){
            tagSearch = "SELECT * FROM episodes WHERE episode_tag = \"musical\"";
            SQLConnection.tagSearch(tagSearch);
            displayLV.getItems().addAll(SQLConnection.tagSearchAL.toString());

        }
        else if(tagSelected.equalsIgnoreCase("Two Part")){
            tagSearch = "SELECT * FROM episodes WHERE episode_tag = \"twopart\"";
            SQLConnection.tagSearch(tagSearch);
            displayLV.getItems().addAll(SQLConnection.tagSearchAL.toString());

        }
        else if(tagSelected.equalsIgnoreCase("Holiday")){
            tagSearch = "SELECT * FROM episodes WHERE episode_tag = \"holiday\"";
            SQLConnection.tagSearch(tagSearch);
            displayLV.getItems().addAll(SQLConnection.tagSearchAL.toString());

        }
        else if(tagSelected.equalsIgnoreCase("Parody")){
            tagSearch = "SELECT * FROM episodes WHERE episode_tag = \"parody\"";
            SQLConnection.tagSearch(tagSearch);
            displayLV.getItems().addAll(SQLConnection.tagSearchAL.toString());

        }
    }

    @FXML
    public void updateDB(){
        String query = "UPDATE episodes\n" +
                "SET episode_name = \""+episodeNameBox.getText() +
                "\" daily_burger = \""+burgerBox.getText()+
                "\" episode_tag = \""+tagCB.getValue()+
                "\"WHERE episode_num = \""+episodeNumberBox.getText()+"\"";
        SQLConnection.update(query);
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
    public void newPage(ActionEvent event) throws IOException {
        addRoot = FXMLLoader.load(getClass().getResource("/com/monsters/databasefx/DBAdd.fxml"));
        addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        addScene = new Scene(addRoot);
        addStage.setScene(addScene);
        addStage.show();
    }

    @FXML
    public String getBurger(){return burgerBox.getText();}

    @FXML
    public String getEpisodeNumber(){return episodeNumberBox.getText();}

    @FXML
    public String getEpisodeName(){return episodeNameBox.getText();}

    @FXML
    public String getDate(){return String.valueOf(airDatePicker.getValue());}

    @FXML
    public String getAirDate(){return String.valueOf(airDatePicker.getValue());}
}

