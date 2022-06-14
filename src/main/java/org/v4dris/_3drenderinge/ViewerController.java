package org.v4dris._3drenderinge;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}