package com.example.chess.vues;

import com.example.chess.modele.ChessException;
import com.example.chess.modele.Couleur;
import com.example.chess.modele.Echiquier;
import com.example.chess.modele.Pion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;

public class PieceView extends ImageView {
    private final Pion pion;

    public PieceView(Pion p_pion) {
        pion = p_pion;

        try {
            adjustCoordinates();
        } catch (ChessException e) {

        }

        initImage();
    }

    public void adjustCoordinates() throws ChessException {
        if(pion != null) {
            int x = Echiquier.axe_x.indexOf(String.valueOf(pion.getPosition().charAt(0)));
            int y = 7 - Echiquier.axe_y.indexOf(String.valueOf(pion.getPosition().charAt(1)));

            setFitWidth(70); setFitHeight(70);
            setX(x * 72); setY(y * 72);
        } else {
            throw new ChessException("Pion doesn't exist anymore");
        }
    }

    private void initImage() {
        String url = getClass().getResource("/images/" +
                pion.getClass().getSimpleName().toLowerCase() + "_" + pion.getCouleur().toString().toLowerCase() + ".png").toString();
        Image image = new Image(url);
        setImage(image);
    }
}
