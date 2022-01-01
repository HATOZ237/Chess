package com.example.chess;

import com.example.chess.modele.Couleur;
import com.example.chess.modele.Echiquier;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApplication.class.getResource("/main_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        Echiquier echiquier = new Echiquier(Couleur.NOIR);
        System.out.println(echiquier.getPieces());
    }

    public static void main(String[] args) {
        launch();
    }
}