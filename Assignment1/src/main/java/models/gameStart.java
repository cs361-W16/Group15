package models;
import models.Card;
import models.Deck;

/**
 * Created by Alex on 1/21/2016.
 */
// Shuffle once as soon as "Start" is pressed
public class gameStart {
    Card[][] c1 = new Card[4][14];
    Deck deck = new Deck();

    public gameStart(){
        deck.shuffleDeck();

    }
    public void
}
