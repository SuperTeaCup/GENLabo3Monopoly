package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PieceTest {

    static String squareName = "squareTest";
    static Piece piece;
    static Square square;

    @BeforeAll
    static void newPiece() { //it seems this was not the best name idea for the setting up method
        piece = new Piece();
        square = new Square(squareName);
    }

    @Test
     void startPosition() {
        assertEquals(piece.getLocation(), null);
    }

    @Test
    void correctDeplacement() {
        piece.setLocation(square);
        assertEquals(piece.getLocation(), square);
    }
}
