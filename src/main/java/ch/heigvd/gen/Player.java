package ch.heigvd.gen;

public class Player {
    final static int STARTING_CASH = 1500;
    private int cash;
    final private String name;
    final private Piece piece;
    final private Board board;
    final private Cup cup;

    public Player(Cup cup, String name, Board board, String pieceName) {
        this.piece = new Piece(pieceName);
        this.cash = STARTING_CASH;
        this.board = board;
        this.cup = cup;
        this.name = name;
        this.piece.setLocation(this.board.getSquares()[0]);
    }

    public void takeTurn() {
        rollDie();
        int total = getTotal();

        announceTotal(total);

        move(total);

        announceLanding();

        piece.getLocation().landedOn(this);

    }

    public void rollDie() {
        this.cup.roll();
    }

    public int getTotal() {
        return cup.getTotal();
    }

    public void announceTotal(int total) {
        System.out.println(this.name + " has rolled " + total);
    }

    public void setLocation(Square square) {
        this.piece.setLocation(square);
    }

    public void move(int total) {
        piece.setLocation(board.getSquare(piece.getLocation(), total));
    }

    public void announceLanding() {
        System.out.println(this.name + " has landed on " + this.piece.getLocation());
    }

    public Piece getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }

    public String getPieceName() {
        return this.piece.getName();
    }

    public int getNetWorth() {
        return cash;
    }

    /**
     * Works with negative sum
     *
     * @param sum can be negative
     */
    public void addCash(int sum) {
        this.cash += sum;
    }
}
