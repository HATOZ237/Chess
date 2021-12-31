package com.example.chess.modele;

import java.util.ArrayList;
import java.util.Map;

public class Echiquier {
    private Map<String, Pion> Pieces;
    private Couleur playColor;
    private Couleur turnColor;
    private int nbreturn;
    private String selectedCase;

    public Echiquier(Couleur playColor) {
        this.playColor = playColor;
        nbreturn = 1;
        playColor = playColor;
        turnColor = Couleur.NOIR;
        selectedCase = null;
    }

    public Map<String, Pion> getPieces() {
        return Pieces;
    }

    public Couleur getPlayColor() {
        return playColor;
    }

    public Couleur getTurnColor() {
        return turnColor;
    }

    public int getNbreturn() {
        return nbreturn;
    }
}
