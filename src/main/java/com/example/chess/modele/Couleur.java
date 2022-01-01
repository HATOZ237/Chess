package com.example.chess.modele;

public enum Couleur {
    BLANC("Blanc"),
    NOIR("Noir");

    private String name;
    Couleur(String s) { name = s; }

    @Override
    public String toString() {
        return name;
    }
}
