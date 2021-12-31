package com.example.chess.modele;

import java.util.ArrayList;

public class Roi extends Pion
{
    @Override
    public ArrayList<String> getmoves() {
        return super.getmoves();
    }

    public Roi(Echiquier echiquier, String position, Couleur couleur) {
        super(echiquier, position, couleur);
    }
}
