package com.example.chess.modele;

import java.util.ArrayList;

public class Pion {
    protected Echiquier echiquier;
    protected String position;
    protected boolean ismoved;
    protected Couleur couleur;
    protected ArrayList<String> moves;
    protected boolean bigMove;

    public Pion(Echiquier echiquier, String position, Couleur couleur) {
        this.echiquier = echiquier;
        this.position = position;
        this.couleur = couleur;
        ismoved = false;
        bigMove = false;
        //setMoves();

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean alreadyMoved() {
        return ismoved;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves() {
        moves = new ArrayList<>();
        int y = Echiquier.axe_y.indexOf(position.substring(1));
        int x = Echiquier.axe_x.indexOf(position.substring(0, 1));
        int b;
        int a;
        if (couleur == echiquier.getPlayColor()) {
            if (y < 7) {
                String pos = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y + 1);
                if (echiquier.getPieces().get(pos) == null) {
                    moves.add(pos);
                }
                if (x >= 1) {
                    String pos1 = Echiquier.axe_x.get(x - 1) + Echiquier.axe_y.get(y + 1);
                    if (echiquier.getPieces().get(pos1) != null) {
                        if (echiquier.getPieces().get(pos1).getCouleur() != couleur) {
                            moves.add(pos1);
                        }
                    }
                }
                if (x < 7) {
                    String pos1 = Echiquier.axe_x.get(x + 1) + Echiquier.axe_y.get(y + 1);
                    if (echiquier.getPieces().get(pos1) != null) {
                        if (echiquier.getPieces().get(pos1).getCouleur() != couleur) {
                            moves.add(pos1);
                        }
                    }
                }
            }
            if (!ismoved) {
                String pos1 = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y + 2);
                if (echiquier.getPieces().get(pos1) == null) {
                    moves.add(pos1);
                }
            }

        } else
        {
            if (y >= 1) {
                String pos = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y - 1);
                if (echiquier.getPieces().get(pos) == null) {
                    moves.add(pos);
                }
                if (x >= 1) {
                    String pos1 = Echiquier.axe_x.get(x - 1) + Echiquier.axe_y.get(y - 1);
                    if (echiquier.getPieces().get(pos1) != null) {
                        if (echiquier.getPieces().get(pos1).getCouleur() != couleur) {
                            moves.add(pos1);
                        }
                    }
                }
                if (x < 7) {
                    String pos1 = Echiquier.axe_x.get(x + 1) + Echiquier.axe_y.get(y - 1);
                    if (echiquier.getPieces().get(pos1) != null) {
                        if (echiquier.getPieces().get(pos1).getCouleur() != couleur) {
                            moves.add(pos1);
                        }
                    }
                }
            }
            if (!ismoved) {
                String pos1 = Echiquier.axe_x.get(x) + Echiquier.axe_y.get(y - 2);
                if (echiquier.getPieces().get(pos1) == null) {
                    moves.add(pos1);
                }
            }
        }

    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Pion{" +
                "position='" + position + '\'' +
                ", couleur=" + couleur +
                '}';
    }
}
