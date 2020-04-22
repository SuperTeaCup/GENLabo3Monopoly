package ch.heigvd.gen;

import java.util.Random;

public class Die {

    final static int NB_FACES=6;
    private int faceValue;
    private Random rng;

    public Die(){
        rng = new Random();
    }

    public void roll(){
        faceValue = rng.nextInt(NB_FACES)+1;
    }

    //returns 0 if not rolled beforehand
    public int getFaceValue() {
        return faceValue;
    }
}
