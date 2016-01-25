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

    // Tests if selected card can be removed from columns
    // Returns true if discarded, else false (likely illegal move)
    public boolean discardSelectedCard(Card selectedCard){
        boolean canDiscard = false;

        // For each column
        for(int i = 0; i < 4; i++){
            Deck column = columns.get(i);

            // For each card in column
            for(int j = 0; j < column.getCardsRemaining(); j++){
                Card currentCard = column._get(j);

                // If not same card as selectedCard
                if(!Card.equals(currentCard, selectedCard)){
                    // Check if card suit same as selectedCard AND card val > selectedCard
                    boolean sameSuit = currentCard.getSuit().equals(selectedCard.getSuit());
                    boolean higherRank = currentCard.getValue() > selectedCard.getValue();

                    // If the above is true, it is okay to remove selectedCard
                    if(sameSuit && higherRank){
                        canDiscard = true;
                    }
                }
            }
        }

        if(canDiscard){
            // Search for selected cards column index, and index within that column
            int selectedColIdx = -1;
            int selectedDeckIdx = -1;

            // For each column
            for(int i = 0; i < 4; i++){
                Deck column = columns.get(i);

                // For each card in column
                for(int j = 0; j < column.getCardsRemaining(); j++){
                    Card currentCard = column._get(j);

                    // If same card as selectedCard
                    if(Card.equals(currentCard, selectedCard)){
                        // Record indices
                        selectedColIdx = i;
                        selectedDeckIdx = j;
                    }
                }
            }

            if(selectedColIdx == -1 || selectedDeckIdx == -1){
                System.out.println("ERROR");

                return false;
            }else{
                // Pop card off column into discarded
                discard_pile.addToDeck(columns.get(selectedColIdx).getAt(selectedDeckIdx));

                return true;
            }
        }else{
            return false;
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

    //Might come in handy later -Nic
    /*
    public Card _get(String arg, int idx){
        if(arg.equals("remaining")){
            return this.remaining_deck._get(idx);
        }else if(arg.equals("discard")){
            return this.discard_pile._get(idx);
        }else{
            return null;
        }
    }
    */

}
