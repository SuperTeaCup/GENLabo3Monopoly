package ch.heigvd.gen;

public class Piece {

    private Square location;

    public Piece(){
        this.location= new Square("GO");
    }
    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
