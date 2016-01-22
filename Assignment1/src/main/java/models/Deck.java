package models;

import java.util.ArrayList;
import models.Card;

/**
 * Created by nic on 1/20/16.
 */

public class Deck {
    private static final int NUM_CARDS = 52;
    Card[] deck = new Card[NUM_CARDS];
    private int deckIndex = 51;

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
