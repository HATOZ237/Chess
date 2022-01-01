package com.example.chess.vues;

import com.example.chess.modele.Couleur;
import com.example.chess.modele.Echiquier;
import com.example.chess.modele.Pion;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.math.*;

public class EchiquierView extends AnchorPane {

    private final Echiquier echiquier;
    private List<PieceView> pieces;

    public EchiquierView(Couleur firstPlayerColor) throws IOException {
        echiquier = new Echiquier(firstPlayerColor);

        setMaxSize(560, 560);

        char letters[] = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

        for(int i = 0; i < 64; i++) {
            char col = letters[i];
            int row = (int) Math.floor(i / 8) + 1 ;

            String coordinates = String.valueOf(col) + row;
            Color color = Color.GRAY;

            if((i % 2 == 0 && (row - 1) % 2 == 0) || (i % 2 != 0 && (row - 1) % 2 != 0)) {
                color = Color.WHITE;
            }

            CaseView caseView = new CaseView(coordinates, color);
            getChildren().add(caseView);
            AnchorPane.setTopAnchor(caseView, (8 - row) * 70.0);
            AnchorPane.setLeftAnchor(caseView, i * 70.0);
        }

        pieces = new ArrayList<>();

        for (Pion pion : echiquier.getPieces().values()) {
            pieces.add(new PieceView(pion));
        }

        getChildren().addAll(pieces);
    }
}