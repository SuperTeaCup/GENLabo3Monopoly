package ch.heigvd.gen;

import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Random rng=new Random();
        int playerNumber= rng.nextInt(6)+2;
        String name = "lex";
        char c = 'A';
        String names[]=new String[playerNumber];
        for(int i=0;i<playerNumber;i++){
            names[i]= c + name;
            c++;
        }

        MonopolyGame mg = new MonopolyGame(names);
        mg.playGame();



    }
}
