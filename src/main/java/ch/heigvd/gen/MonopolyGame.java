package ch.heigvd.gen;

public class MonopolyGame {

    final static int NB_ROUND=20;
    private int roundCnt;
    private Die dice[];
    private Board board;
    private Player player[];

    public MonopolyGame(String[] playerNames){

        this.roundCnt=0;
        this.dice = new Die[2];
        this.dice[0]=new Die();
        this.dice[1]=new Die();
        this.board=new Board();
        this.player=new Player[playerNames.length];//we assume nb player is always correct
        int i=0;
        for(String s:playerNames){
            this.player[i++]=new Player(this.dice,s,this.board);
        }
    }

    public void playGame(){
        for(;roundCnt<NB_ROUND;roundCnt++){
            System.out.println("Round "+(roundCnt+1));
            this.playRound();
        }

        System.out.println("The winner is the bank");
        System.out.println("Congraturation");

    }

    private void playRound(){
        for(Player p:player){
            System.out.println();
            p.takeTurn();
            System.out.println();

        }

    }

    public int getRoundCnt() {
        return roundCnt;
    }
}
