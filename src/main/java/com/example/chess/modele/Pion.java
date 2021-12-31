package com.example.chess.modele;
import java.util.ArrayList;

public class Pion
{
    protected Echiquier echiquier;
    protected String position;
    protected boolean ismoved;
    protected Couleur couleur;

    public String getPosition() {
        return position;
    }

    public boolean alreadyMoved() {
        return ismoved;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<String> getmoves() {
        if (ismoved)
        {
            if (couleur == echiquier.getPlayColor())
            {

            }
        }
        return null;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Pion(Echiquier echiquier, String position, Couleur couleur) {
        this.echiquier = echiquier;
        this.position = position;
        this.couleur = couleur;
        ismoved = false;
    }
}
