package models;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public Deck[] columns;
    public Deck remaining_deck;
    public Deck discard_pile;

    public Board() {
        columns = new Deck[4];
        for(int i=0; i<4; i++) {
            columns[i] = new Deck(14);
        }
        remaining_deck = new Deck();
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
