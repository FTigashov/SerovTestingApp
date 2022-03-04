package com.example.knowleadgetesting;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button beginTest;


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
    private Text questionId;


    private Questions[] questions = new Questions[] {
            new Questions("В каком из вариантов представлен корректный формат?", new String[] {
                    "Console.Write()",
                    "print()",
                    "System.out.println()",
                    "std::cout << '' < endl;"}),
            new Questions("Найдите ошибку.\npublic static void Main(String[] args) {\nSystem.out.print('Hello world'}", new String[]{
                "Ошибка в выводе. Необходимо выводить Console.WriteLine('Hello world')",
                "Название методов должно начинаться со строчной буквы. Правильно main",
                "Правильно будет написать void Main(String[] args)",
                "Привильно будет написать public static void Main() {\nSystem.out.print('Hello world'}"})
    };

    private int nowQuestion = 0, correctAnswers;

    @FXML
    void initialize() {
        questionId.setVisible(false);
        answerBtn.setVisible(false);
        answerF.setVisible(false);
        answerS.setVisible(false);
        answerTh.setVisible(false);
        answerFo.setVisible(false);

        beginTest.setOnAction(event -> {
            questionId.setVisible(true);
            answerBtn.setVisible(true);
            answerF.setVisible(true);
            answerS.setVisible(true);
            answerTh.setVisible(true);
            answerFo.setVisible(true);

            beginTest.setVisible(false);
        });

        answerBtn.setOnAction(event -> {
            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if (selectedRadio != null) {
                String toggleGroup = selectedRadio.getText();

                if (toggleGroup.equals(questions[nowQuestion].correctAnswer())) {
                    System.out.println("Верный ответ");
                    correctAnswers++;
                }
                else {
                    System.out.println("Ответ не верынй");
                }
            }
            if (nowQuestion + 1 != questions.length) {
                nowQuestion++;

                questionId.setText(questions[nowQuestion].getQuestion());
                String[] answers = questions[nowQuestion].getAnswers();

                List<String> stringList = Arrays.asList(answers);
                Collections.shuffle(stringList);

                answerF.setText(stringList.get(0));
                answerS.setText(stringList.get(1));
                answerTh.setText(stringList.get(2));
                answerFo.setText(stringList.get(3));

                selectedRadio.setSelected(false);
            }
            else {
                answerF.setVisible(false);
                answerS.setVisible(false);
                answerTh.setVisible(false);
                answerFo.setVisible(false);

                answerBtn.setVisible(false);

                questionId.setText("Вы ответили правильно на " + correctAnswers + " вопросов");
            }
        });
    }

}
