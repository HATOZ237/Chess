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
        Tour tour = new Tour(echiquier, position, couleur);
        Fou fou = new Fou(echiquier, position, couleur);
        tour.setMoves();
        fou.setMoves();
        moves.addAll(tour.getMoves());
        moves.addAll(fou.getMoves());
    }
}
