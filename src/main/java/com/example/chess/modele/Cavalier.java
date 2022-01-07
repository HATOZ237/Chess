package com.example.chess.modele;

import java.util.ArrayList;

public class Cavalier extends Pion {

    @Override
    public void setMoves() {
        moves = new ArrayList<>();
        int y = Echiquier.axe_y.indexOf(position.substring(1));
        int x = Echiquier.axe_x.indexOf(position.substring(0, 1));
        int[] tab = {-1, 1, 2, -2};
        for(int i : tab)
        {
            for(int j : tab)
            {
                if(Math.abs(i) != Math.abs(j))
                {
                    int a = x + i;
                    int b = y + j;
                    if( (a < 8 & 0 <= a ) & (b < 8 & 0 <= b ))
                    {
                        String pos = Echiquier.axe_x.get(a) + Echiquier.axe_y.get(b);
                        Pion pion = echiquier.getPieces().get(pos);
                        if (pion != null)
                        {
                            if (pion.getCouleur() != couleur)
                            {
                                moves.add(pos);
                            }
                        }
                        else {
                            moves.add(pos);
                        }
                    }

                }
            }
        }
    }

    @Override
    public String toString() {
        return "Cavalier{" +
                "position='" + position + '\'' +
                ", couleur=" + couleur +
                '}';
    }

    public Cavalier(Echiquier echiquier, String position, Couleur couleur)
    {
        super(echiquier, position, couleur);
    }
}
