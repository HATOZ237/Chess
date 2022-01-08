package com.example.chess.vues;

import com.example.chess.modele.Echiquier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CaseView extends Rectangle {
    private final String Case;
    private CaseViewState State;

    public CaseView(String p_case) {
        super();
        Case = p_case;
        State = CaseViewState.UNSELECTED;

        adjustCoordinates();
        adjustColor();

        System.out.println(getX());
    }

    public Color getBaseColor() {
        int x = Echiquier.axe_x.indexOf(String.valueOf(Case.charAt(0)));
        int y = Echiquier.axe_y.indexOf(String.valueOf(Case.charAt(1)));

        return (((x % 2) == 0 && (y % 2) == 0) || ((x % 2) != 0 && (y % 2) != 0))
                ? Color.GRAY : Color.WHITE;
    }

    public void adjustCoordinates() {
        int x = Echiquier.axe_x.indexOf(String.valueOf(Case.charAt(0)));
        int y = 7 - Echiquier.axe_y.indexOf(String.valueOf(Case.charAt(1)));

        setX(x * 72); setY(y * 72);
        setWidth(70); setHeight(70);
    }

    public void adjustColor() {
        switch (State) {
            case UNSELECTED -> setFill(getBaseColor());
            case SELECTED -> setFill(Color.RED);
            case MOVE -> setFill(Color.ORANGE);
        }
    }

    public void changeCaseState(CaseViewState p_state) {
        if(p_state != State) {
            State = p_state;
            adjustColor();
        }
    }

    public enum CaseViewState { UNSELECTED, SELECTED, MOVE; }
}