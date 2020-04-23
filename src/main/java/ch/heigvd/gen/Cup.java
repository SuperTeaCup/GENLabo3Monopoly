package ch.heigvd.gen;

public class Cup {

    private Die dice[]; //no cup in iter 1
    private final int NB_DIE = 2;

    public Cup() {
        this.dice = new Die[NB_DIE];
        for (int i = 0; i < NB_DIE; i++) {
            this.dice[i] = new Die();
        }
    }

    public void roll() {
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
}
