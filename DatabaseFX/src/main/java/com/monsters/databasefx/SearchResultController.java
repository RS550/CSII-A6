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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Random;
import java.util.ResourceBundle;


public class SearchResultController implements Initializable{
//To Edit Page
    private Stage editorStage;
    private Scene editorScene;
    private Parent editorRoot;
//To Add Page
    private Stage addStage;
    private Scene addScene;
    private Parent addRoot;

    public String[] tagList = {"Musical","Parody", "Two Part", "Holiday"};

    public String seasonSearch = " s.season_num = ";
    public String tagSearch = " e.episode_tag = ";
    public String seasonSelected = " 1";
    public String tagSelected = " Musical";
    public int epCount = 67;

    @FXML
    private Button randomB, editB, newB, searchB;

    @FXML
    private ComboBox<String> seasonCB = new ComboBox<>();

    @FXML
    private ComboBox<String> tagCB = new ComboBox<>();

    @FXML
    private ListView<String> displayLV = new ListView<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SQLConnection.getEpisodes();
        SQLConnection.getSeasons();
        SQLConnection.getTags();

        seasonCB.getItems().addAll(SQLConnection.seasonsAL);
        seasonCB.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                seasonSelected = seasonCB.getValue();
                getSeason();
            }
        });

        tagCB.getItems().addAll(tagList);
        tagCB.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tagSelected = tagCB.getValue();
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
    private void getRandom(){
        Random rand = new Random();
        int x = rand.nextInt(epCount);
        //String x = String.valueOf(rand.nextInt(epCount));
        //String random = "SELECT * FROM episodes WHERE episode_id = ' " + x + "'";
        Episode randomEp = SQLConnection.episodeAL.get(x);
        displayLV.getItems().clear();
        displayLV.getItems().add(randomEp.toString());
        //connect(random);
    }


    @FXML
    private void getResults(){
        displayLV.getItems().setAll();
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
    public void newPage(ActionEvent event) throws IOException {
        addRoot = FXMLLoader.load(getClass().getResource("/com/monsters/databasefx/DBAdd.fxml"));
        addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        addScene = new Scene(addRoot);
        addStage.setScene(addScene);
        addStage.show();
    }

    @FXML
    public void getAirDate(){}
}
