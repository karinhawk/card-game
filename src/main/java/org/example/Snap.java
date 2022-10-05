package org.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player activePlayer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("time to play snap!");
        cardGame.populateDeck();
        cardGame.shuffleDeck();
        Card oldCard = null;
        Card dealtCard;

        activePlayer = player1;
        scanner.nextLine();
        activePlayer.announcePlayer();
        dealtCard = cardGame.dealCard();
        dealtCard.describeCard(activePlayer);
        activePlayer = player2;
        do {
            scanner.nextLine();
            activePlayer.announcePlayer();
            oldCard = dealtCard;
            dealtCard = cardGame.dealCard();
            dealtCard.describeCard(activePlayer);
            if (activePlayer == player1){
                activePlayer = player2;
            } else if (activePlayer == player2){
                activePlayer = player1;
            }
        } while (!Objects.equals(dealtCard.getSymbol(), oldCard.getSymbol()));
        if (activePlayer == player2){
            System.out.println("type snap to win");
            Timer timer = new Timer();
            TimerTask snap = new TimerTask() {
                public void run() {
                    if (scanner.nextLine().equals("snap")) {
                        System.out.println("you win!");
                    } else {
                        System.out.println("you lose!");
                    }
                }
            };
            timer.schedule( snap, 2*1000 );
            timer.cancel();
        } else {
            System.out.println("player 2 wins!");
        }
    }
}
