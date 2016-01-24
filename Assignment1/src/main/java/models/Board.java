package models;

import models.Deck;
import java.util.ArrayList;
import models.Card;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public Deck[] columns;
    public Deck remaining_deck;
    public Deck discard_pile;

    public Board() {
        columns = new Deck[4];
        remaining_deck = new Deck();
        discard_pile = new Deck();
    }

    public void dealFour() {
        for(int i=0; i<4; i++) {
            columns[i].AddtoDeck(remaining_deck.drawCard());
        }
    }

    public Deck[] getColumns() {
        return columns;
    }

}
