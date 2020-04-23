package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class PieceTest {

    static String name;
    static String squareName = "squareTest";
    static Piece piece;
    static Piece immovablePiece;
    static Square square;

    @BeforeAll
    static void newPiece() { //it seems this was not the best name idea for the setting up method
        name = "L'inverse d'une passoire";
        piece = new Piece(name);
        immovablePiece = new Piece(name);
        square = new RegularSquare(squareName);
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
