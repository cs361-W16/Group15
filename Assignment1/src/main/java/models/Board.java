package models;

import models.Deck;
import java.util.ArrayList;
import models.Card;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public ArrayList<Card> columns = new ArrayList<Card>(4);
    public ArrayList<Card> remaining_deck = new ArrayList<Card>();
    public ArrayList<Card> discard_pile = new ArrayList<Card>();

    public Board() {
        columns = new Deck[4];
        remaining_deck = new Deck();
        discard_pile = new Deck();
    }

    public void DealFour() {
        for(int i=0; i<4; i++) {
            columns[i].AddtoDeck(remaining_deck.drawCard());
        }
    }

    public Deck[] getColumns() {
        return columns;
    }

}
