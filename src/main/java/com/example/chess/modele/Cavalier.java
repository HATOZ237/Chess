package com.example.chess.modele;

import java.util.ArrayList;

public class Cavalier extends Pion {

    @Override
    public ArrayList<String> getmoves()
    {
        return super.getmoves();
    }

    public Cavalier(Echiquier echiquier, String position, Couleur couleur)
    {
        super(echiquier, position, couleur);
    }
}
