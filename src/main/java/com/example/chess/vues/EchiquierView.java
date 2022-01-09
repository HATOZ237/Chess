package com.example.chess.vues;

import com.example.chess.modele.ChessException;
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
    private List<PieceView> pieceViews;

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

        pieceViews = new ArrayList<>();
        for (Map.Entry<String, Pion> pair : echiquier.getPieces().entrySet()) {
            Pion value = pair.getValue();
            if(value != null) {
                pieceViews.add(new PieceView(value));
            }
        }

        getChildren().addAll(caseViews.values());
        getChildren().addAll(pieceViews);
    }

    private void onMouseClicked(MouseEvent event) {
        int x = (int) Math.floor(event.getX() / 72);
        int y = 7 - (int) Math.floor(event.getY() / 72);
        String pos = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y);

        System.out.println(echiquier.getTurnColor());

        for (String move : lastMoves) {
            caseViews.get(move).changeCaseState(CaseView.CaseViewState.UNSELECTED);
        }

        if(Echiquier.checkPosition(selectedCase))
            caseViews.get(selectedCase).changeCaseState(CaseView.CaseViewState.UNSELECTED);

        try {
            echiquier.selectCase(pos);
            lastMoves = (List<String>) echiquier.getMoves().clone();
            selectedCase = (echiquier.getSelectedPiece() != null) ?
                    echiquier.getSelectedPiece().getPosition() : "";

            for (String move : lastMoves) {
                caseViews.get(move).changeCaseState(CaseView.CaseViewState.MOVE);
            }
            if(Echiquier.checkPosition(selectedCase))
                caseViews.get(selectedCase).changeCaseState(CaseView.CaseViewState.SELECTED);

            for(PieceView p : pieceViews) {
                try {
                    p.adjustCoordinates();
                } catch (ChessException e) {
                    pieceViews.remove(p);
                    getChildren().remove(p);
                }
            }
        } catch (ChessException e) {

        }

    }
}
