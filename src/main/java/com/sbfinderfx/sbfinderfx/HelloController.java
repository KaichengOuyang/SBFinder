package com.sbfinderfx.sbfinderfx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Core.Utilities.Importer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.tools.Utils;
import org.w3c.dom.Text;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> APIKeys;

    @FXML
    private MenuItem APIKeysMenuItem;

    @FXML
    private MenuItem CloseMenuItem;

    @FXML
    private ListView<String> Players;

    @FXML
    private Button Search;

    @FXML
    private static TextField UIDField;

    @FXML
    private MenuItem UsernameMenuItem;

    @FXML
    public static TextField Output;


    @FXML
    void ImportUsername(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
            try{
                Importer.getPlayerUsernameCSV(file.getAbsolutePath());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Players.getItems().clear();
        Players.getItems().addAll(Importer.PlayerUsername);
    }


    @FXML
    void ImportAPI(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
            try{
                Importer.getAPIKeysFromCSV(file.getAbsolutePath());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        APIKeys.getItems().clear();
        APIKeys.getItems().addAll(Importer.APIKeys);

    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert APIKeys != null : "fx:id=\"APIKeys\" was not injected: check your FXML file 'Main.fxml'.";
        assert APIKeysMenuItem != null : "fx:id=\"APIKeysMenuItem\" was not injected: check your FXML file 'Main.fxml'.";
        assert CloseMenuItem != null : "fx:id=\"CloseMenuItem\" was not injected: check your FXML file 'Main.fxml'.";
        assert Players != null : "fx:id=\"Players\" was not injected: check your FXML file 'Main.fxml'.";
        assert Search != null : "fx:id=\"Search\" was not injected: check your FXML file 'Main.fxml'.";
        assert UIDField != null : "fx:id=\"UIDField\" was not injected: check your FXML file 'Main.fxml'.";
        assert UsernameMenuItem != null : "fx:id=\"UsernameMenuItem\" was not injected: check your FXML file 'Main.fxml'.";

    }

    public static String getUID(){
        return UIDField.getText();
    }

}
