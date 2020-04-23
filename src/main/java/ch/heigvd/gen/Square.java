package ch.heigvd.gen;

public class Square {

    private final String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
