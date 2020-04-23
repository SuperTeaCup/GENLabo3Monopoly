package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    static int startingCash;
    static int jailPosition;
    static int goToJailPosition;
    static String pieceName;
    static Player player;
    static Player immoovablePlayer;
    static String name;
    static Cup cup;
    static Board board;

    @BeforeAll
    static void newPlayer() {
        pieceName="The TeaCup";
        name = "Jean-Test";
        board = new Board();
        startingCash=1500;
        jailPosition=10;
        goToJailPosition=30;
        cup=new Cup();
        player = new Player(cup, name, board,pieceName);
        immoovablePlayer = new Player(cup, name, board,pieceName);
    }

    @Test
    void nameTest() {
        assertEquals(player.getName(), name);
    }

    @Test
    void locationPieceTest() {
        assertEquals(immoovablePlayer.getPiece().getLocation(), board.getSquares()[0]);

        immoovablePlayer.move(4);
        immoovablePlayer.getPiece().getLocation().landedOn(immoovablePlayer);
        assertNotEquals(immoovablePlayer.getNetWorth(),startingCash);

        immoovablePlayer.addCash(-10000); // set back to 0

        immoovablePlayer.move(6);
        assertEquals(immoovablePlayer.getPiece().getLocation(), board.getSquares()[10]);

        immoovablePlayer.move(30);
        immoovablePlayer.getPiece().getLocation().landedOn(immoovablePlayer);
        assertEquals(immoovablePlayer.getNetWorth(),200);

    }

    @RepeatedTest(50)
    void rollDieTest() {
        player.rollDie();
        int total = player.getTotal();

        assertTrue(2 <= total && 12 >= total);
    }

    @RepeatedTest(50)
    void turnTest() {
        boolean getOutOfJailCard=false;
        int actualPosition = Board.indexFinder(player.getPiece().getLocation().getName(), board.getSquares());


        player.takeTurn();

        int newPosition = Board.indexFinder(player.getPiece().getLocation().getName(), board.getSquares());



        int totalMoved = Math.floorMod(newPosition - actualPosition, board.getSquares().length);

        if(Math.floorMod(actualPosition+player.getTotal(),board.getSquares().length) == goToJailPosition){
            assertEquals(newPosition,jailPosition);
            getOutOfJailCard=true;

        }


        assertTrue((2 <= totalMoved && 12 >= totalMoved) || getOutOfJailCard);
    }


}
