package com.example.chess.vues;

import com.example.chess.modele.Couleur;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainView {
    @FXML
    public HBox mainLayout;

    @FXML
    public void initialize() {
        AccueilDialog dialog = new AccueilDialog();
        Optional<Couleur> player1Color = dialog.showAndWait();

        if(player1Color.isPresent()) {
            System.out.println(player1Color.get());

            try {
                mainLayout.getChildren().add(new EchiquierView(player1Color.get()));
            } catch (IOException exception) {

            }
        }
    }
}
