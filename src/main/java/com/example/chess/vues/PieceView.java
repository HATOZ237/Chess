package com.example.chess.vues;

import com.example.chess.modele.Couleur;
import com.example.chess.modele.Echiquier;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;

public class PieceView extends ImageView {
    private final Couleur couleur;
    private final String name;

    public PieceView(String p_name, Couleur p_couleur, String pos) {
        couleur = p_couleur;
        name = p_name.toLowerCase();

        adjustCoordinates(pos);
        initImage();
    }

    public void adjustCoordinates(String pos) {
        int x = Echiquier.axe_x.indexOf(String.valueOf(pos.charAt(0)));
        int y = 7 - Echiquier.axe_y.indexOf(String.valueOf(pos.charAt(1)));

        setFitWidth(70); setFitHeight(70);
        setX(x * 72); setY(y * 72);
    }

    private void initImage() {
        String url = getClass().getResource("/images/" +
                name + "_" + couleur.toString().toLowerCase() + ".png").toString();
        Image image = new Image(url);
        setImage(image);
    }
}
