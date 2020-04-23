package ch.heigvd.gen;

public class GoSquare extends Square {
    final static int MONEY_FROM_GO = 200;

    public GoSquare() {
        super("Go");
    }

    @Override
    public void landedOn(Player player) {
        player.addCash(MONEY_FROM_GO);
    }
}
