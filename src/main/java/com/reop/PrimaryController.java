package com.reop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private Label primaryLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Label errorText;
    @FXML
    private Button exitButton;
    @FXML
    private TextArea characterTextArea;
    @FXML
    private Button saveButton;
    @FXML
    private TextArea artPromptTextArea;
    @FXML
    private Button submitRandomPromptButton;
    
    //declare as global variable for now (may change this later)
    private Character character;
    
    //Initialize
    void initialize() {
        
    }
    
    //Stop Program
    @FXML
    private void stop(ActionEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    
    //Submit character gen button and make character a new character.
    @FXML
    private void submitCharacterGen(ActionEvent event) {
        character = new Character();
        characterTextArea.setText(character.getCharacterDetails());
        saveButton.setVisible(true);
        characterTextArea.setDisable(false);
    }

    @FXML
    private void saveCharacter(ActionEvent event) {
        character.writeCharacterToFile(characterTextArea.getText());
    }

    //Submit art prompt gen button and make a new art prompt
    @FXML
    private void submitArtPromptGen(ActionEvent event) {
        ArtPrompt prompt = new ArtPrompt();
        artPromptTextArea.setText(prompt.getArtPromptDetails());
        //saveButton.setVisible(true); not needed right now
        artPromptTextArea.setDisable(false);
    }
    
    

}
