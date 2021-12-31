package com.example.chess.modele;
import java.util.ArrayList;

public class Pion
{
    protected Echiquier echiquier;
    protected String position;
    protected boolean ismoved;
    protected Couleur couleur;
    protected ArrayList<String> moves;

    public String getPosition() {
        return position;
    }

    public boolean alreadyMoved() {
        return ismoved;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    protected void setMoves() {
        this.moves = null;
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
