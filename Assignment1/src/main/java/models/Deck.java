package models;

import java.util.ArrayList;
import models.Card;
import java.io.Serializable;
import java.util.Collections;

/**
 * Created by nic on 1/20/16.
 */

public class Deck implements Serializable {

    private static final int NUM_CARDS = 52;
    public ArrayList<Card> deck;
    private int top = 1;

    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    // Full deck
    public Deck(){
        // Setup deck with 52 cards
        this.deck = new ArrayList<Card>(NUM_CARDS);

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

    // Empty deck
    public Deck(String arg){
        if (arg.equals("empty")) {
            this.deck = new ArrayList<Card>(1);
        }
    }

    // Return the size of column decks
    int sizeDeck() {
        return deck.size();
    }

    // Return the card at index
    Card getIndex(int i) {
        return deck.get(i);
    }

    // Copy constructor
    public Deck(Deck input){
        this.deck = new ArrayList<Card>(NUM_CARDS);

        // Arraylist deep copy, since Java wants to copy references by default
        for(int i = 0; i < 52; i++){
            if(input.deck.get(i) != null){
                this.deck.add(input.deck.get(i));
            }
        }
        this.top = input.top;
    }

    // Pop card off deck
    public Card drawCard(){
        if(deck.size() > 0){
            return deck.remove(deck.size() - 1);
        }else{
            return null;
        }
    }

    public void addToDeck(Card card) {
        deck.add(card);
    }

    public Card GetTop(){
        if(deck.size() > 0) {
            return deck.get(deck.size()-1);
        }
        else {
            return null;
        }
    }

    // Returns number of cards left in deck
    public int getCardsRemaining() {
        return deck.size();
    }

    public ArrayList<Card> getCurrent(){
        return deck;
    }


    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public int getIndex(){
        return deck.size() - 1;
    }

    // DEBUG
    public Card _get(int idx){
        if(deck.get(idx) != null){
            return deck.get(idx);
        }else{
            return null;
        }
    }

    public void _printDeck(){
        System.out.println("SIZE: " + deck.size());
        for(int i = 0; i < deck.size(); i++){
            Card card = deck.get(i);
            System.out.println(card.getRank() + " - " + card.getSuit());
        }
    }
}
