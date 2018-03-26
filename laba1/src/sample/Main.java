package sample;

/**
 * @author N.Zhuchkevich
 * crip text by ascii
 * @version 1.0
*/
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Button crip;
    private Button unCrip;
    private Label uncripLabel = new Label("Нешифрованный текст");
    private Label cripLabel = new Label("Зашифрованный текст");
    private TextField inputUcripText = new TextField();
    private TextField inputCripText = new TextField();
    private Label cripVisText = new Label("Расшифрованный текст: ");;
    private Label ucripVisText = new Label("Зашифрованный текст: ");;
    private Button cleanBtn = new Button("Clear all");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("laba 1");
        crip = new Button("Зашифровать");
        crip.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (inputUcripText.getText().isEmpty()) {
                    uncripLabel.setText("Нешифрованный текст:");
                    cripLabel.setText("Зашифрованный текст:");
                    inputCripText.clear();
                    inputUcripText.clear();
                    ucripVisText.setText("Зашифрованный текст: ");
                    cripVisText.setText("Расшифрованный текст: ");
                    return;
                }
                cripText();
            }
        });
        unCrip = new Button("Расшифровать");
        unCrip.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (inputCripText.getText().isEmpty()) {
                    uncripLabel.setText("Нешифрованный текст:");
                    cripLabel.setText("Зашифрованный текст:");
                    inputCripText.clear();
                    return;
                }
                unCripText();
            }
        });
        cleanBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                inputCripText.clear();
                inputUcripText.clear();
                ucripVisText.setText("Зашифрованный текст: ");
                cripVisText.setText("Расшифрованный текст: ");
            }
        });

        root.getChildren().add(init(root));
        primaryStage.setScene(new Scene(root, 800, 200.0));
        primaryStage.show();
    }

    private void unCripText() {
        char[] crip = inputCripText.getText().toLowerCase().toCharArray();
        String cripTmp = "";
        for (int i = 0; i < crip.length; i++) {
            crip[i] = (char) ('a' + ('z' - (int) crip[i]));
            cripTmp += crip[i];
        }
        cripVisText.setText("Расшифрованный текст: " + cripTmp);
    }

    private Pane init(Pane root) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        GridPane.setConstraints(uncripLabel, 0, 0);
        grid.getChildren().add(uncripLabel);
        GridPane.setConstraints(inputUcripText, 1, 0);
        grid.getChildren().add(inputUcripText);
        GridPane.setConstraints(ucripVisText, 2, 0);
        grid.getChildren().add(ucripVisText);
        GridPane.setConstraints(crip, 3, 0);
        grid.getChildren().add(crip);

        GridPane.setConstraints(cripLabel, 0, 1);
        grid.getChildren().add(cripLabel);
        GridPane.setConstraints(inputCripText, 1, 1);
        grid.getChildren().add(inputCripText);
        GridPane.setConstraints(cripVisText, 2, 1);
        grid.getChildren().add(cripVisText);
        GridPane.setConstraints(unCrip, 3, 1);
        grid.getChildren().add(unCrip);
        GridPane.setConstraints(cleanBtn, 1,2);
        grid.getChildren().add(cleanBtn);
        return grid;
    }

    private void cripText() {
        char[] crip = inputUcripText.getText().toLowerCase().toCharArray();
        String cripTmp = "";
        for (int i = 0; i < crip.length; i++) {
            crip[i] = (char) ('a' + ('z' - (int) crip[i]));
            cripTmp += crip[i];
        }
        ucripVisText.setText("Зашифрованный текст: " + cripTmp);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
