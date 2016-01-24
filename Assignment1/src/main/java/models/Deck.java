package models;

import java.util.ArrayList;
import models.Card;
import java.io.Serializable;


/**
 * Created by nic on 1/20/16.
 */

public class Deck implements Serializable {

    private static final int NUM_CARDS = 52;
    public ArrayList<Card> deck = new ArrayList<Card>(NUM_CARDS);
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

            deck.add(i, new Card((i % 13), ranks[i % 13], suits[suitsIdx], newColor));
        }
    }

    // Pop card off deck
    public Card drawCard(){
        int deckIndex = deck.size() - 1;

        // Get the top card
        Card card = deck.get(deckIndex);

        deck.remove(deckIndex);
        
        return card;

    }

    public void AddtoDeck(Card card) {
        int deckIndex = getCardsRemaining() - 1;

        if(top < deckIndex) {
            deck.add(top - 1, card);
            top++;
        }
    }

    public Card GetTop(){
        if(top > 0) {
            Card card = deck.get(top);
            top--;
            return card;
        }
        else {
            return null;
        }
    }

    // Returns number of cards left in deck
    public int getCardsRemaining() {
        
        return deck.size();
    }

    // Returns current score
    public int getScore(){ return (NUM_CARDS - 1) - getCardsRemaining(); }

    public int getSize(){ return NUM_CARDS; }

    public void shuffleDeck() {
        int deckIndex = getCardsRemaining() - 1;
        
        for(int i=0; i<=deckIndex; i++) {
            int r = i + (int) (Math.random() * (52-i));
            Card temp = deck.get(r);
            deck.add(r, deck.get(i));
            deck.add(i, temp);
        }
    }
}
