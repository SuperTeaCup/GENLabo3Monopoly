package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    String squareName="squareTest";
    Piece piece;
    Square square;
    Square startSquare;

    @BeforeAll
    void newPiece(){ //it seems this was not the best name idea for the setting up method
        piece = new Piece();
        square = new Square(squareName);
        startSquare = new Square("GO");
    }

    @Test
    void startPosition(){
        assertEquals(piece.getLocation(),startSquare);
    }

    @Test
    void correctDeplacement(){
        piece.setLocation(square);
        assertEquals(piece.getLocation(),square);
    }
}
