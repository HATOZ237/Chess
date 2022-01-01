package com.example.chess.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class Echiquier {
    private HashMap<String, Pion> pieces;
    private Couleur playColor;
    private Couleur robotColor;
    private Couleur turnColor;
    private int nbreturn;
    private String selectedCase;
    public static ArrayList<String> cases;

    public Echiquier(Couleur playColor) {
        pieces = new HashMap<>();

        this.playColor = playColor;
        if(playColor == Couleur.NOIR)
        {
            robotColor = Couleur.BLANC;
        }
        else robotColor = Couleur.NOIR;
        nbreturn = 1;
        turnColor = Couleur.NOIR;
        selectedCase = null;
        String[] axe_x = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] axe_y = {"1", "2", "3", "4", "5", "6", "7", "8"};
        setCases(axe_x, axe_y);
        for (String opt: cases)
        {
            pieces.put(opt, null);
        }
        for (String x: axe_x)
        {
            String posj = "2" + x;
            pieces.replace(posj, new Pion(this, posj, playColor));
        }
        for (String x: axe_x)
        {
            String posj = "5" + x;
            pieces.replace(posj, new Pion(this, posj, robotColor));
        }


    }

    private static void setCases(String[] X, String[] Y) {
        cases = new ArrayList<>();
        for (String y : Y) {
            for (String x : X) {
                cases.add(x + y);
            }
        }
    }

    private static boolean checkPosition(String pos) {
        return cases.contains(pos);
    }


    public Map<String, Pion> getPieces() {
        return pieces;
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
