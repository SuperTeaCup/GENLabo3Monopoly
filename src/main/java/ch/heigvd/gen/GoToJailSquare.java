package ch.heigvd.gen;

public class GoToJailSquare extends Square {

    private final Square jail;

    public GoToJailSquare(Square jail) {
        super("Go to jail");
        this.jail = jail;
    }

    @Override
    public void landedOn(Player player) {
        player.setLocation(this.jail);
        //no monetary punishment
    }
}
