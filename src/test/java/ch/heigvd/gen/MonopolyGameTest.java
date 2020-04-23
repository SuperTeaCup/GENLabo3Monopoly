package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MonopolyGameTest {

    static Random rng=new Random();
    static int playerNumber;
    static int c = 0;
    static String name = "lex";
    static String names[];
    static String tooManynNames[];
    static String notEnoughNames[];
    static MonopolyGame mg;

    @BeforeEach
    void newMonopolyGame(){
        playerNumber= rng.nextInt(6)+2;
        names=new String[playerNumber];
        tooManynNames=new String[playerNumber+7];
        notEnoughNames=new String[playerNumber % 2];

        for(int i=0;i<names.length;i++){
            names[i]= ((char) (c+65)) + name;
            c= (c+1) % 26;
        }

        for(int i=0;i<tooManynNames.length;i++){
            tooManynNames[i]= ((char) (c+65)) + name;
            c= (c+1) % 26;
        }

        for(int i=0;i<notEnoughNames.length;i++){
            notEnoughNames[i]= ((char) (c+65)) + name;
            c= (c+1) % 26;
        }


        mg = new MonopolyGame(names);
    }

    @RepeatedTest(5)
    void runGame(){
        mg.playGame();
        assertEquals(20,mg.getRoundCnt());
    }

    @Test
    void incorrectPlayerNumber(){
        mg=new MonopolyGame(tooManynNames);
        mg.playGame();
        assertEquals(0,mg.getRoundCnt());

        mg=new MonopolyGame(notEnoughNames);
        mg.playGame();
        assertNotEquals(20,mg.getRoundCnt());

    }


}
