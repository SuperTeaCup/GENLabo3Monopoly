package ch.heigvd.gen;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Die dice[]; //no cup in iter 1

    public Player(Die[] die, String name, Board board) {
        this.board = board;
        this.dice = die;
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
        for (Die d : dice) {
            d.roll();
        }
    }

    public int getTotal() {
        int total = 0;
        for (Die d : dice) {
            total += d.getFaceValue();
        }
        return total;
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
