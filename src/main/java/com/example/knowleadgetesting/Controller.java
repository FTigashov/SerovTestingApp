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
                    "std::cout << '' < endl",
                    "System.out.println()"}),
            new Questions("Найдите ошибку.\npublic static void Main(String[] args) {\nSystem.out.print('Hello world'}", new String[] {
                "Верно будет Console.WriteLine('Hello world')",
                "Верно будет System.out.print('Hello world');",
                "Необходимо написать void Main(String[] args)",
                "Название метода со строчной буквы"}),
            new Questions("Как указать индекс последнего элемента массива?", new String[] {
                    "array.size",
                    "array.size - 1",
                    "array.length",
                    "array.length - 1"}),
            new Questions("Какой результат работы данного кода?\n" +
                    "public static void main(String[] args) {       \n" +
                    "double a = 5;       \n" +
                    "System.out.println(a / 2);   \n" +
                    "}", new String[] {
                    "unhandled exception",
                    "2",
                    "1",
                    "2.5"}),
            new Questions("Какой результат работы данного кода?\npublic static void main(String[] args) {\n" +
                    "  int[] array = new int[]{11, 5, -4, 8, 4, 7};\n" +
                    "  for (int i = 0; i < array.length; i += 2) {\n" +
                    "     System.out.print(i+\" \");\n" +
                    "  }\n" +
                    "}", new String[] {
                    "ArrayIndexOutOfBoundsException",
                    "11",
                    "11 -4 4",
                    "0 2 4"}),
            new Questions("Какой результат работы данного кода?\npublic static void main(String[] args) { \n" +
                    "  String test = \"Hello\"; \n" +
                    "  String test2 = \"Hello\"; \n" +
                    "  System.out.println(test==test2);\n" +
                    "}", new String[] {
                    "null",
                    "Hello world",
                    "false",
                    "true"}),
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
                    System.out.println("Ответ не верный");
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

                questionId.setText("Количество правильно отвеченных вопросов: " + correctAnswers);
            }
        });
    }

}
