package ch.heigvd.gen;

public class Piece {

    private Square location;

    public Piece() {
        this.location = new Square("Go");
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
