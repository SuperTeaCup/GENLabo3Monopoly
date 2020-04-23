package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonopolyGameTest {

    static Random rng=new Random();
    static int playerNumber;
    static int c = 0;
    static String name = "lex";
    static String names[];
    static MonopolyGame mg;

    @BeforeEach
    void newMonopolyGame(){
        playerNumber= rng.nextInt(6)+2;
        names=new String[playerNumber];
        for(int i=0;i<playerNumber;i++){
            names[i]= ((char) (c+65)) + name;
            c= (c+1) % 26;
        }
        mg = new MonopolyGame(names);
    }

    @RepeatedTest(5)
    void runGame(){
        mg.playGame();
        assertEquals(20,mg.getRoundCnt());
    }


}
