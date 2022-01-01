package com.example.chess.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CaseView extends Rectangle {
    private final String coordinates;

    public CaseView(String _coordinates, Color color) {
        super();
        coordinates = _coordinates;

        setHeight(70);
        setWidth(70);
        setFill(color);
    }

    public String getCoordinates() {
        return coordinates;
    }

    public boolean matchCoordinates(String c) {
        return coordinates == c;
    }
}
