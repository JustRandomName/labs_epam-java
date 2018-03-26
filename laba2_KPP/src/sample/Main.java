package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 */

public class Main extends Application {
    private Human human;
    private TextField textField = new TextField();
    private TextField textFieldtaste = new TextField();
    private Label nameLabel = new Label("You name: ");
    private ComboBox comboBoxType = new ComboBox();
    private Label pourLabel = new Label();
    private Label drinkLabel = new Label();

    private ComboBox initComboBoxType() {
        comboBoxType.getItems().addAll(
                "Juise",
                "Water"
        );
        comboBoxType.setPromptText("Drink");
        return comboBoxType;
    }

    private Button pour = new Button("Pour out");
    private Button drink = new Button("Drink it!!!");
    private Button fillBottle = new Button("Fill the Bottle");

    @Override
    public void start(Stage primaryStage) throws Exception {
        textField.setPromptText("Name");
        textFieldtaste.setPromptText("Taste");
        fillBottle.setVisible(false);
        pourLabel.setVisible(false);
        textFieldtaste.setVisible(false);
        nameLabel.setVisible(false);
        pour.setVisible(false);
        drink.setVisible(false);
        comboBoxType.valueProperty().addListener((observable, oldValue, newValue) -> {
            String type = comboBoxType.getValue().toString();
            fillBottle.setVisible(true);
            if (type.equals("Juise")) {
                textFieldtaste.setVisible(true);
            } else {
                textFieldtaste.setVisible(false);
            }
        });
        pour.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                human.setName(textField.getText());
                String s = comboBoxType.getValue().toString();
                s = human.pour(s, textFieldtaste.getText()).getLic();
                pourLabel.setText("You pour: " + s);
                pourLabel.setVisible(true);
                drink.setVisible(true);
            }
        });
        fillBottle.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pour.setVisible(true);
                nameLabel.setVisible(true);
                human = new Human();
                human.setName(textField.getText());
                nameLabel.setText("Name: " + human.getName());
                human.initBottle();
            }
        });
        drink.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                drinkLabel.setText("You drink: " + human.drinkLiq());
                pour.setVisible(false);
                pourLabel.setVisible(false);
                drink.setVisible(false);
            }
        });
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        root.getChildren().add(initPane());
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }

    private GridPane initPane() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setGridLinesVisible(false);
        gridPane.add(textField, 0, 0);
        gridPane.add(nameLabel, 1, 0);
        gridPane.add(initComboBoxType(), 0, 1);
        gridPane.add(textFieldtaste, 1, 1);
        gridPane.add(fillBottle, 0, 2);
        gridPane.add(pour, 1, 2);
        gridPane.add(drink, 2, 2);
        gridPane.add(pourLabel, 0, 3);
        gridPane.add(drinkLabel, 0, 3);
        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
