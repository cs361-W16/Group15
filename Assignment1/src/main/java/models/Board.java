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
    // Returns true if card discarded, false if illegal move
    // TODO: adjust to work with controller later
    public boolean discardSelectedCard(Card selectedCard){
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
                    if(sameSuit && higherRank){
                        // TODO: Remove card
                        return true;
                    }
                }
            }
        }

        // Requested move was illegal
        return false;
    }

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

    /*public void printColumns() {
        int j=0;
        Card card;
        for(int i=0;i<4;i++) {
            System.out.print("Column " + (i+1) + ": ");
            while(columns[i][j] != null) {
                card = columns[i][j];
                j++;
                System.out.print(card.getRank() + " " + card.getSuit() + " " + card.getColor() + "\n");
            }
            j=0;
        }
    }*/
}
