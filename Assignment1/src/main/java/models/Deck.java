package models;

import java.util.ArrayList;
import models.Card;
import java.io.Serializable;

/**
 * Created by nic on 1/20/16.
 */

public class Deck implements Serializable {

    private static final int NUM_CARDS = 52;
    public Card[] deck = new Card[NUM_CARDS];
    private int deckIndex = 51;
    private int top = 1;

    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Deck(){
        // Setup deck with 52 cards
        int suitsIdx = 0;

        for(int i = 0; i < NUM_CARDS; i++){
            if(i != 0 && i % 13 == 0){
                suitsIdx++;
            }

            // Decide color
            String newColor;
            if(suits[suitsIdx].equals("Diamonds")){
                newColor = "Red";
            }else if(suits[suitsIdx].equals("Hearts")){
                newColor = "Red";
            }else{
                newColor = "Black";
            }

            deck[i] = new Card((i % 13), ranks[i % 13], suits[suitsIdx], newColor);
        }
    }

    public Deck(int i) {
        deck = new Card[i];
        for(int j=0; j<14; j++) {
            deck[j] = new Card(0,"N","N","N");
        }
        deckIndex = i;
    }

    // Pop card off deck
    public Card drawCard(){
        if(deckIndex >= 0){
            Card card = deck[deckIndex];
            deckIndex--; // "Pop" card off

            return card;
        }else{
            return null;
        }
    }

    public void AddtoDeck(Card card) {
        if(top < deckIndex) {
            deck[top - 1] = card;
            top++;
        }
    }

    public Card GetTop(){
        if(top > 0) {
            Card card = deck[top];
            top--;
            return card;
        }
        else {
            return null;
        }
    }

    // Returns number of cards left in deck
    public int getCardsRemaining() {
        return deckIndex + 1;
    }

    public void shuffleDeck() {
        for(int i=0; i<=deckIndex; i++) {
            int r = i + (int) (Math.random() * (52-i));
            Card temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }
}
