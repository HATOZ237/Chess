package com.example.chess.modele;

import java.util.*;

public class Echiquier {
    private HashMap<String, Pion> pieces;
    private Couleur playColor;
    private Couleur robotColor;
    private Couleur turnColor;
    private int nbreturn;
    private String selectedCase;
    private static ArrayList<String> cases;
    public static ArrayList<String> axe_x ;
    public static ArrayList<String> axe_y ;

    public Echiquier(Couleur playColor) {
        String[] axe_x = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] axe_y = {"1", "2", "3", "4", "5", "6", "7", "8"};
        pieces = new HashMap<>();
        int lengh = axe_x.length;
        Echiquier.axe_y = new ArrayList<>();
        Echiquier.axe_x = new ArrayList<>();
        for(int i = 0; i < lengh; i++)
        {
            Echiquier.axe_x.add(axe_x[i]);
            Echiquier.axe_y.add(axe_y[i]);
        }

        this.playColor = playColor;
        if (playColor == Couleur.NOIR) {
            robotColor = Couleur.BLANC;
        } else robotColor = Couleur.NOIR;
        nbreturn = 1;
        turnColor = Couleur.NOIR;
        selectedCase = null;

        setCases();
        for (String opt : cases) {
            pieces.put(opt, null);
        }
        for (String x : axe_x) {
            String posj = x + "2";
            pieces.put(posj, new Pion(this, posj, playColor));
        }
        for (String x : axe_x) {
            String posj = x + "7";
            pieces.put(posj, new Pion(this, posj, robotColor));
        }

        pieces.put("A1", new Tour(this, "A1", playColor));
        pieces.put("H1", new Tour(this, "H1", playColor));
        pieces.put("B1", new Cavalier(this, "B1", playColor));
        pieces.put("G1", new Cavalier(this, "G1", playColor));
        pieces.put("C1", new Fou(this, "C1", playColor));
        pieces.put("F1", new Fou(this, "F1", playColor));
        pieces.put("D1", new Roi(this, "D1", playColor));
        pieces.put("E1", new Reine(this, "E1", playColor));

        pieces.put("A8", new Tour(this, "A8", robotColor));
        pieces.put("H8", new Tour(this, "H8", robotColor));
        pieces.put("B8", new Cavalier(this, "B8", robotColor));
        pieces.put("G8", new Cavalier(this, "G8", robotColor));
        pieces.put("C8", new Fou(this, "C8", robotColor));
        pieces.put("F8", new Fou(this, "F8", robotColor));
        pieces.put("D8", new Roi(this, "D8", robotColor));
        pieces.put("E8", new Reine(this, "E8", robotColor));
        for (String key : cases)
        {
            Pion pion = pieces.get(key);
            if (pion != null)
            {
                pion.setMoves();
            }
        }
    }

    private static void setCases() {
        cases = new ArrayList<>();
        for (String y : axe_y) {
            for (String x : axe_x) {
                cases.add(x + y);
            }
        }
    }

    public static boolean checkPosition(String pos) {
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

    @Override
    public String toString() {
        String rep  = "";
        for (String key: cases)
        {
            Pion pion = pieces.get(key);
            if ( pion!= null)
            {
                rep += pion.toString() + pion.getMoves().toString() + "\n";
            }
        }
        return rep;
    }

    public int getNbreturn() {
        return nbreturn;
    }
}
