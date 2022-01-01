package com.example.chess.vues;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.fxml.FXMLLoader;

import com.example.chess.modele.Couleur;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class AccueilDialog extends Dialog<Couleur> {

    @FXML
    public ChoiceBox<Couleur> couleurChoiceBox;

    public AccueilDialog() {
        super();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/accueil_dialog.fxml"));
        fxmlLoader.setController(this);

        setTitle("Configuration");

        try {
            setDialogPane(fxmlLoader.load());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        couleurChoiceBox.getItems().addAll(Couleur.NOIR, Couleur.BLANC);
        couleurChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void OnFinishButtonClicked() {
        setResult(couleurChoiceBox.getValue());
    }

    @FXML
    public void OnCancelButtonClicked() {
        Stage s = (Stage) getDialogPane().getScene().getWindow();
        s.close();
    }
}
