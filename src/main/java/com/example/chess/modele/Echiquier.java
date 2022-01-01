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
            String posj = x + "2";
            pieces.put(posj,new Pion(this, posj, playColor));
        }
        for (String x: axe_x)
        {
            String posj = x + "7";
            pieces.put(posj, new Pion(this, posj, robotColor));
        }

        pieces.put("A1", new Tour(this, "A1", playColor ));
        pieces.put("H1", new Tour(this, "H1", playColor ));
        pieces.put("B1", new Cavalier(this, "B1", playColor ));
        pieces.put("G1", new Cavalier(this, "G1", playColor ));
        pieces.put("C1", new Fou(this, "C1", playColor ));
        pieces.put("F1", new Fou(this, "F1", playColor ));
        pieces.put("D1", new Reine(this, "D1", playColor ));
        pieces.put("E1", new Roi(this, "E1", playColor ));

        pieces.put("A8", new Tour(this, "A8", robotColor ));
        pieces.put("H8", new Tour(this, "H8", robotColor ));
        pieces.put("B8", new Cavalier(this, "B8", robotColor ));
        pieces.put("G8", new Cavalier(this, "G8", robotColor ));
        pieces.put("C8", new Fou(this, "C8", robotColor ));
        pieces.put("F8", new Fou(this, "F8", robotColor ));
        pieces.put("D8", new Reine(this, "D8", robotColor ));
        pieces.put("E8", new Roi(this, "E8", robotColor ));
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
