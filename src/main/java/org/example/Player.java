package org.example;

public class Player {
    int player;


    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Player(int player) {
        this.player = player;
    }

    public Player announcePlayer(){
        System.out.println("It's player " + player + " 's turn!");
        return null;
    }
}
