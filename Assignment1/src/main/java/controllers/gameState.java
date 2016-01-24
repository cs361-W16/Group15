package controllers;

import models.Card;
import models.Deck;

/**
 * Created by Alex on 1/21/2016.
 */
public class gameState {
    // deck (array)
    // apply game rules to the data, then send it back to the model
    Card[][] c1 = new Card[4][14];
    int deckIndex;
    Card[] deck = new Card[52];


    public gameState(int deckSize, Card[] _deck){
    this.c1 = ;
        this.deckIndex = deckSize;
    this.deck = _deck;
    }

    public gameState(String jsonData){
    // parse

    }
}
