package ch.heigvd.gen;

public class Piece {

    private Square location;
    private String name;

    public Piece(String name) {
        this.name=name;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
