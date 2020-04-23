package ch.heigvd.gen;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final static int NB_SQUARE = 40;
    private List<Square> boardList;

    public Board() {
        this.boardList = new ArrayList<Square>();

        this.boardList.add(new Square("Go"));

        for (int i = 1; i < NB_SQUARE; i++) {
            this.boardList.add( new Square("Square " + i));
        }

    }

    /**
     * This methods compute and gives the resulting square after a move
     *
     * @param curentSquare
     * @param fvTot it's the number of square we have to move,
     *              I do not know what fvTot means but it's named that in the book
     * @return
     */

    public Square getSquare(Square currentSquare, int fvTot) {

        if(fvTot < 2){
            throw new IllegalArgumentException();
        }

        int squareNumber = boardList.indexOf(currentSquare); //should never be -1 as the currentSquare has to come from the board
        int newSquareNumber = (squareNumber + fvTot) % NB_SQUARE;

        return getSquares()[newSquareNumber];
    }

    /**
     * method that makes testing better
     * @return
     */
    public Square[] getSquares(){
        return this.boardList.toArray(new Square[NB_SQUARE]);
    }

}
