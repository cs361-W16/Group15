package models;

import models.Deck;
import java.util.ArrayList;
import models.Card;

/**
 * Created by Daniel on 1/22/2016.
 */
public class Board {
    public Card[][] columns;
    public Deck remaining_deck;
    public Deck discard_pile;

    public Board() {
        columns = new Card[4][14];
        for(int i=0;i<4;i++) {
            for(int j=0;j<14;j++) {
                columns[i][j] = null;
            }
        }
        remaining_deck = new Deck();
        discard_pile = new Deck("empty");
    }

    public void dealFour() {
        int j=0;
        for(int i=0; i<4; i++) {
            while(columns[i][j] != null) {
                j++;
            }
            columns[i][j] = remaining_deck.drawCard();
            j=0;
        }
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

    public void printColumns() {
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
    }
}
