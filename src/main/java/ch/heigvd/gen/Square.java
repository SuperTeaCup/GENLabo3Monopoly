package ch.heigvd.gen;

abstract class Square {

    private final String name;

    public Square(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void landedOn(Player player);

    @Override
    public String toString() {
        return this.name;
    }


}
