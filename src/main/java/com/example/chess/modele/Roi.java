package com.example.chess.modele;

import java.util.ArrayList;

public class Roi extends Pion
{
    @Override
    public void setMoves() {
        super.setMoves();
    }

    public Roi(Echiquier echiquier, String position, Couleur couleur) {
        super(echiquier, position, couleur);
    }
}
