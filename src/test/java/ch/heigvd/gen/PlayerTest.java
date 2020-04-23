package ch.heigvd.gen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    static Player player;
    static Player immoovablePlayer;
    static String name;
    static Die die[];
    static Board board;

    @BeforeAll
    static void newPlayer() {
        name = "Jean-Test";
        board = new Board();
        die = new Die[2];
        die[0] = new Die();
        die[1] = new Die();
        player = new Player(die, name, board);
        immoovablePlayer = new Player(die, name, board);
    }

    @Test
    void nameTest() {
        assertEquals(player.getName(), name);
    }

    @Test
    void locationPieceTest() {
        assertEquals(immoovablePlayer.getPiece().getLocation(), board.getSquares()[0]);

        immoovablePlayer.move(10);

        assertEquals(immoovablePlayer.getPiece().getLocation(), board.getSquares()[10]);
    }

    @RepeatedTest(50)
    void rollDieTest() {
        player.rollDie();
        int total = player.getTotal();

        assertTrue(2 <= total && 12 >= total);
    }

    @RepeatedTest(50)
    void turnTest() {
        int actualPosition = Board.indexFinder(player.getPiece().getLocation().getName(), board.getSquares());

        System.out.println("act " + actualPosition);

        player.takeTurn();

        int newPosition = Board.indexFinder(player.getPiece().getLocation().getName(), board.getSquares());

        System.out.println("new " + newPosition);

        int totalMoved = Math.floorMod(newPosition - actualPosition, board.getSquares().length);

        System.out.println("tot " + totalMoved);

        assertTrue(2 <= totalMoved && 12 >= totalMoved);
    }


}
