package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class PieceTest {

    static String squareName = "squareTest";
    static Piece piece;
    static Piece immovablePiece;
    static Square square;

    @BeforeAll
    static void newPiece() { //it seems this was not the best name idea for the setting up method
        piece = new Piece();
        immovablePiece = new Piece();
        square = new Square(squareName);
    }

    @Test
     void startPosition() {
        assertNull(immovablePiece.getLocation());
    }

    @Test
    void correctDeplacement() {
        piece.setLocation(square);
        assertEquals(piece.getLocation(), square);
    }
}
