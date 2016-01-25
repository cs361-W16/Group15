package models;

import models.Deck;
import java.util.ArrayList;
import java.util.jar.Pack200;

import models.Card;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public ArrayList<Deck> columns = new ArrayList<Deck>(4);
    public Deck remaining_deck;
    public Deck discard_pile;

    public Board() {
        // Init columns to empty decks
        for(int i = 0; i < 4; i++) {
            columns.add(new Deck("empty"));
        }
        remaining_deck = new Deck();
        discard_pile = new Deck("empty");
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++) {
            Deck current = columns.get(i);

            current.addToDeck(remaining_deck.drawCard());
        }
    }

    public void printColumns() {
        for(int i=0; i<4; i++) {
            System.out.println("Column " + i);
            Deck current = columns.get(i);
            for(int j=0;j<current.sizeDeck();j++) {
                Card currentCard = current.getIndex(j);
                System.out.println(currentCard.getSuit() + " - " + currentCard.getValue());
            }
        }
    }

    public void moveCard(int source, int destination) {
        Deck destinationDeck = columns.get(destination);
        Deck sourceDeck = columns.get(source);
        if( destinationDeck.sizeDeck() == 0 ) {
            Card sourceCard = sourceDeck.drawCard();
            destinationDeck.addToDeck(sourceCard);
        }
        else {
            Card topDestination = destinationDeck.GetTop();
            Card topSource = sourceDeck.GetTop();
            if( topDestination.getValue() > topSource.getValue() && topDestination.getSuit() == topSource.getSuit() ) {
                Card sourceCard = sourceDeck.drawCard();
                destinationDeck.addToDeck(sourceCard);
            }
        }

    }

    /* TODO
    public void discardSameSuit(Card selectedCard){
        // Scan columns for card of same suit but lower rank
        boolean canDiscard = false;
        for(int colIdx = 0; colIdx < 4; colIdx++){
            for(int deckIdx = 0; deckIdx < columns[colIdx]._get(deckIdx); deckIdx++){

            }
        }

    }*/

    // DEBUG
    public Card _get(String arg, int idx){
        if(arg.equals("remaining")){
            return this.remaining_deck._get(idx);
        }else if(arg.equals("discard")){
            return this.discard_pile._get(idx);
        }else{
            return null;
        }
    }

}
