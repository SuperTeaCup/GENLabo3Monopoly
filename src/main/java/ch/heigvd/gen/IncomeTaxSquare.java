package ch.heigvd.gen;

public class IncomeTaxSquare extends Square {

    private static final int MAXIMUM_INCOME = 200;

    public IncomeTaxSquare() {
        super("Income tax");
    }

    @Override
    public void landedOn(Player player) {
        player.addCash(-1 * Math.min(MAXIMUM_INCOME, (int) (player.getNetWorth() * 0.1)));
    }
}
