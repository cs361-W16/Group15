package models;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public Deck[] Columns;
    public Deck AcesUpDeck;
    public Deck DiscardPile;

    public Board() {
        Columns = new Deck[4];
        for(int i=0; i<4; i++) {
            Columns[i] = new Deck(14);
        }
        AcesUpDeck = new Deck();
    }

    public void DealFour() {
        for(int i=0; i<4; i++) {
            Columns[i].AddtoDeck(AcesUpDeck.drawCard());
        }
    }

    public Deck[] getColumns() {
        return Columns;
    }

}
