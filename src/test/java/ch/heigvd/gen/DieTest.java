package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DieTest {
    Die dice;

    @BeforeEach
    void newDice(){
        dice = new Die();
    }

    @Test
    void noRollTest(){
        assertEquals(dice.getFaceValue(),0);
    }

    @RepeatedTest(50)
    void multiRollTest(){
        dice.roll();
        assertTrue(dice.getFaceValue()<=6 && dice.getFaceValue() >= 1);
    }
}
