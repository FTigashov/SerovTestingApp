package com.example.knowleadgetesting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button answerBtn;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton answerF;

    @FXML
    private RadioButton answerFo;

    @FXML
    private RadioButton answerS;

    @FXML
    private RadioButton answerTh;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text labelQuestion;

    @FXML
    private Text numQuestion;

    @FXML
    private Text questionId;

    @FXML
    private Text timer;

    @FXML
    private Text timerText;

    @FXML
    void initialize() {
        answerBtn.setOnAction(event -> {
            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if (selectedRadio != null) {
                String toggleGroup = selectedRadio.getText();
            }
        });
    }

}
