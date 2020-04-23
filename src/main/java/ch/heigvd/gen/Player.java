package ch.heigvd.gen;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Cup cup;

    public Player(Cup cup, String name, Board board) {
        this.board = board;
        this.cup = cup;
        this.name = name;

        this.piece = new Piece();
        this.piece.setLocation(this.board.getSquares()[0]);
    }

    public void takeTurn() {
        rollDie();
        int total = getTotal();

        announceTotal(total);

        move(total);

        announceLanding();

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

}
