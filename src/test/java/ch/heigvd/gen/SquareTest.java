package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    static final String TESTNAME = "square x";
    static Square square;

    @BeforeAll
    static void newSquare() {
        square = new Square(TESTNAME);
    }

    @Test
     void nameTest() {
        assertEquals(square.getName(), TESTNAME);
    }


}
