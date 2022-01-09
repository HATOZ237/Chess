package com.example.chess.vues;

import com.example.chess.modele.Couleur;
import com.example.chess.modele.Echiquier;
import com.example.chess.modele.Pion;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EchiquierView extends Pane {
    private final Echiquier echiquier;
    private String selectedCase;
    private List<String> lastMoves;
    private Map<String, CaseView> caseViews;
    private Map<String, PieceView> pieceViews;

    public EchiquierView(Couleur playerColor) {
        selectedCase = "";
        lastMoves = new ArrayList<>();
        echiquier = new Echiquier(playerColor);

        initUi();
        setOnMouseClicked(mouseEvent -> onMouseClicked(mouseEvent));
    }

    private void initUi() {
        setMinSize(560, 560); setMaxSize(565, 565);

        caseViews = new HashMap<>();
        for (String c : Echiquier.getCases()) {
            caseViews.put(c, new CaseView(c));
        }

        pieceViews = new HashMap<>();
        for (Map.Entry<String, Pion> pair : echiquier.getPieces().entrySet()) {
            Pion value = pair.getValue();
            if(value != null) {
                String key = pair.getKey();
                pieceViews.put(key,
                        new PieceView(value.getClass().getSimpleName(), value.getCouleur(), key));
            }
        }

        getChildren().addAll(caseViews.values());
        getChildren().addAll(pieceViews.values());
    }

    private void onMouseClicked(MouseEvent event) {
        int x = (int) Math.floor(event.getX() / 72);
        int y = 7 - (int) Math.floor(event.getY() / 72);
        String pos = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y);

        System.out.println(echiquier.getTurnColor());

        if(lastMoves.contains(pos)) {
            echiquier.selectCase(pos);
            pieceViews.get(selectedCase).adjustCoordinates(pos);
            PieceView p = pieceViews.remove(selectedCase);
            pieceViews.put(pos, p);

            for (String move : lastMoves) {
                caseViews.get(move).changeCaseState(CaseView.CaseViewState.UNSELECTED);
            }
            caseViews.get(selectedCase).changeCaseState(CaseView.CaseViewState.UNSELECTED);
            selectedCase = "";
            lastMoves.clear();
        } else {
            if (Echiquier.checkPosition(selectedCase)) {
                caseViews.get(selectedCase).changeCaseState(CaseView.CaseViewState.UNSELECTED);
                for (String move : lastMoves) {
                    caseViews.get(move).changeCaseState(CaseView.CaseViewState.UNSELECTED);
                }
            }

            lastMoves.clear();

            if (pos != selectedCase & Echiquier.checkPosition(pos)
                    & echiquier.getPieces().get(pos) != null) {

                if(echiquier.getPieces().get(pos).getCouleur() == echiquier.getTurnColor()) {
                    echiquier.selectCase(pos);
                    caseViews.get(pos).changeCaseState(CaseView.CaseViewState.SELECTED);

                    lastMoves = (List<String>) echiquier.getMoves().clone();
                    for (String move : lastMoves) {
                        caseViews.get(move).changeCaseState(CaseView.CaseViewState.MOVE);
                    }

                    selectedCase = pos;
                }
            }
        }
    }
}
