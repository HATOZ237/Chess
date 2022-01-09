package com.example.chess.modele;

import java.util.ArrayList;

public class Reine extends Pion
{
    public Reine(Echiquier echiquier, String position, Couleur couleur) {
        super(echiquier, position, couleur);
    }

    @Override
    public String toString() {
        return "Reine{" +
                "position='" + position + '\'' +
                ", couleur=" + couleur +
                '}';
    }

    @Override
    public void setMoves() {
        moves = new ArrayList<>();
        /*oves.addAll((new Tour(echiquier, position, couleur).getMoves()));
        moves.addAll((new Fou(echiquier, position, couleur).getMoves()));*/
    }
}
