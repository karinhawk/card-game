package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    ArrayList <Card> deckOfCards = new ArrayList<>();
    String[] allSymbols = {"2" ,"3" ,"4" ,"5" ,"6" ,"7" ,"8" ,"9" ,"10" ,"J" ,"Q" , "K", "A"};

    public void populateDeck(){
        for (String symbol : allSymbols){
            Card cardHeart = new Card(symbol, Card.Suit.HEART);
            deckOfCards.add(cardHeart);
            Card cardDiamond = new Card(symbol, Card.Suit.DIAMOND);
            deckOfCards.add(cardDiamond);
            Card cardClub = new Card(symbol, Card.Suit.CLUB);
            deckOfCards.add(cardClub);
            Card cardSpade = new Card(symbol, Card.Suit.SPADE);
            deckOfCards.add(cardSpade);
        }
    }

    public void getDeck(Player player){
        for (Card card : deckOfCards){
            card.describeCard(player);
        }
    }
    public Card dealCard(){
        Card chosenCard = deckOfCards.get(0);
        deckOfCards.remove(chosenCard);
        deckOfCards.add(deckOfCards.size()-1, chosenCard);
        return chosenCard;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        deckOfCards.sort(Comparator.comparing(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
