package com.example.chess.modele;

import java.util.ArrayList;

public class Fou extends Pion
{
    public Fou(Echiquier echiquier, String position, Couleur couleur) {
        super(echiquier, position, couleur);
    }

    @Override
    public String toString() {
        return "Fou{" +
                "position='" + position + '\'' +
                ", couleur=" + couleur +
                '}';
    }

    @Override
    public void setMoves() {
        moves = new ArrayList<>();
        int y = Echiquier.axe_y.indexOf(position.substring(1));
        int x = Echiquier.axe_x.indexOf(position.substring(0, 1));
        int b =  y;
        int a = x;
        while (a < 7 && b < 7)
        {
            a++;
            b++;
            String pos = Echiquier.axe_x.get(a) + Echiquier.axe_y.get(b);
            Pion pion = echiquier.getPieces().get(pos);
            if (pion == null)
            {
                moves.add(pos);
            }
            else
            {
                if (pion.getCouleur() != couleur)
                {
                    moves.add(pos);
                }
                break;
            }
        }
        b =  y;
        a = x;
        while (a > 0 && b < 7)
        {
            a--;
            b++;
            String pos = Echiquier.axe_x.get(a) + Echiquier.axe_y.get(b);
            Pion pion = echiquier.getPieces().get(pos);
            if (pion == null)
            {
                moves.add(pos);
            }
            else
            {
                if (pion.getCouleur() != couleur)
                {
                    moves.add(pos);
                }
                break;
            }
        }
        b =  y;
        a = x;
        while (a < 7 && b > 0)
        {
            a++;
            b--;
            String pos = Echiquier.axe_x.get(a) + Echiquier.axe_y.get(b);
            Pion pion = echiquier.getPieces().get(pos);
            if (pion == null)
            {
                moves.add(pos);
            }
            else
            {
                if (pion.getCouleur() != couleur)
                {
                    moves.add(pos);
                }
                break;
            }
        }
        b =  y;
        a = x;
        while (a > 0 && b > 0)
        {
            a--;
            b--;
            String pos = Echiquier.axe_x.get(a) + Echiquier.axe_y.get(b);
            Pion pion = echiquier.getPieces().get(pos);
            if (pion == null)
            {
                moves.add(pos);
            }
            else
            {
                if (pion.getCouleur() != couleur)
                {
                    moves.add(pos);
                }
                break;
            }
        }
        b = y;
        a = x;
    }
}
