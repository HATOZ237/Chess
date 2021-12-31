package com.example.chess.modele;

import java.util.ArrayList;

public class Roi extends Pion
{
    @Override
    protected void setMoves() {
        super.setMoves();
    }

    public Roi(Echiquier echiquier, String position, Couleur couleur) {
        super(echiquier, position, couleur);
    }
}
