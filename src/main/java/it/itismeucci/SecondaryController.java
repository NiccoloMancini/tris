package it.itismeucci;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SecondaryController implements Initializable {

    @FXML
    private GridPane field;

    @FXML
    private Label interactiveText;

    private int cont = 0;

    @FXML
    private void getCoordinates(ActionEvent e) {
        Button btn = (Button) e.getSource();
        Game.setSign(GridPane.getRowIndex(btn), GridPane.getColumnIndex(btn), Game.playerTurn());
        cont++;
        btn.setText(Game.playerTurn().getSign());
        btn.setOnAction(null);
        setVictory();
    }

    private void changeText() {
        interactiveText.setText(Game.playerTurn().getNickname() + " è il tuo turno!");
    }

    private void setVictory() {
        if (Game.victory()) {
            interactiveText.setText(Game.playerTurn().getNickname() + " hai vinto!!");
            disableButton();
        } else if (cont == 9) {
            interactiveText.setText("Questa volta è finita in pareggio :(");
        } else {
            Game.changeTurn();
            changeText();
        }
    }

    private void disableButton() {
        for (Node node : field.getChildren()) {
            Button b = (Button) node;
            b.setOnAction(null);
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        changeText();
    }
}