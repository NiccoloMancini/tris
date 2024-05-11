package it.itismeucci;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField p1;

    @FXML
    private TextField p2;

    @FXML
    private void switchToSecondary() throws IOException {
        checkName();
        Game.resetField();
        App.setRoot("secondary");
    }

    public void checkName() {
        if (!(p1.getText().equals(""))) {
            Game.getP1().setNickname(p1.getText());
            ;
        }
        if (!(p2.getText().equals(""))) {
            Game.getP2().setNickname(p2.getText());
        }
    }
}
