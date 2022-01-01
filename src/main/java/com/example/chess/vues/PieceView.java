package com.example.chess.vues;

import com.example.chess.modele.Pion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Arrays;

public class PieceView extends ImageView {
    private final Pion pion;

    public PieceView(Pion p) throws IOException {
        setFitWidth(70);
        setFitHeight(70);

        pion = p;

        String imageName = pion.getClass().getName() + "_" + pion.getCouleur().toString().toLowerCase();
        Image img = new Image(getClass().getResource("/images/" + imageName).toString());
        setImage(img);

        adjustPosition();
    }

    public void adjustPosition() throws IOException {
        int[] pos = getCasesFromPosition(pion.getPosition());

        setX(pos[0]);
        setY(pos[1]);
    }

    public int[] getCasesFromPosition(String pos) throws IOException {
        Character[] letters = new Character[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        Character[] numbers = new Character[] { '1', '2', '3', '4', '5', '6', '7', '8' };

        if (pos.length() == 2 && Arrays.asList(letters).contains(pos.charAt(0))){
            if (Arrays.asList(numbers).contains(pos.charAt(1))) {
                int x = Arrays.asList(letters).indexOf(pos.charAt(0)) + 1;
                int y = Arrays.asList(numbers).indexOf(pos.charAt(1)) + 1;

                return new int[] { x, y };
            }
        }

        throw new IOException("The position format is not correct");
    }
}
