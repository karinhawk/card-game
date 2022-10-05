package org.example;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final Integer value;
    private Suit suit;

    enum Suit{
        HEART, DIAMOND, CLUB, SPADE
    }
    private String symbol;

    public Card(String symbol, Suit suit) {
        this.symbol = symbol;
        this.suit = suit;
        this.value = assignValues(symbol);
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnicode(Suit suit){
        switch(suit){
            case HEART:
                return "U+2661";
            case DIAMOND:
                return "U+25C7";
            case CLUB:
                return "U+2667";
            case SPADE:
                return "U+2664";
            default:
                return ":)";
        }
    }

    public Integer assignValues(String symbol){
        Map<String, Integer> symbolValues  = new HashMap<>();
        symbolValues.put("2", 2);
        symbolValues.put("3", 3);
        symbolValues.put("4", 4);
        symbolValues.put("5", 5);
        symbolValues.put("6", 6);
        symbolValues.put("7", 7);
        symbolValues.put("8", 8);
        symbolValues.put("9", 9);
        symbolValues.put("10", 10);
        symbolValues.put("J", 11);
        symbolValues.put("Q", 12);
        symbolValues.put("K", 13);
        symbolValues.put("A", 14);
        return symbolValues.get(symbol);
    }

    public Integer getValue() {
        return value;
    }

    public Card describeCard(Player player) {
        System.out.println(player.getPlayer() + " pulls a " + symbol + " of " + suit.toString().toLowerCase() + "s.");
        return null;
    }

//    Has a String suit. Use the unicode characters of heart, club, diamond and spade.
//    Has a String symbol (2,3,4,5,6,7,8,9,10,J,Q,K,A)
//    Has an int value (2,3,4,5,6,7,8,9,10,11,12,13,14)
}
