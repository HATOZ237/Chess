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

public class EchiquierView extends AnchorPane {

    private final Echiquier echiquier;
    private List<PieceView> pieces;

    public EchiquierView(Couleur firstPlayerColor) throws IOException {
        echiquier = new Echiquier(firstPlayerColor);

        setMaxSize(560, 560);

        char letters[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

        for(int i = 0; i < letters.length; i++) {
            char col = letters[i];

            for (int row = 8; row >= 1; row--) {
                String coordinates = String.valueOf(col) + row;
                Color color = Color.WHITE;

                if((i % 2 == 0 && (row - 1) % 2 == 0) || (i % 2 != 0 && (row - 1) % 2 != 0)) {
                    color = Color.GRAY;
                }

                CaseView caseView = new CaseView(coordinates, color);
                getChildren().add(caseView);
                AnchorPane.setTopAnchor(caseView, (8 - row) * 70.0);
                AnchorPane.setLeftAnchor(caseView, i * 70.0);
            }
        }

        pieces = new ArrayList<>();

        for (Pion pion : echiquier.getPieces().values()) {
            if(pion != null) {
                pieces.add(new PieceView(pion));
            }
        }

        getChildren().addAll(pieces);
    }
}
