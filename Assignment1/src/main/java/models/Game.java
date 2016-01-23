package models;

import java.util.ArrayList;
import models.Deck;
import java.io.Serializable;



public class Game {
    private static int COL_NUM = 4;
    private static int ROW_NUM = 13;
    private String[][] board;
    private Deck deck = new Deck();

    public Game() {
        Card card = new Card();
        board = new String[ROW_NUM][COL_NUM];
        columnInitialized();
        deck.Make();
    }

    public int columnInitialized() {
        int count = 0;
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                board[i][j] = null;
                if (board[i][j] == null)
                    count = count + 1;
            }
        }
        if (count == 52)
            return 0;
        else
            return 1;
    }


   
  
    public int deal() {
        int count = 0;          //Checks to make sure that the game board is no longer empty
        int bottom;             //Bottom of the column
        Card card;               //Card to be moved to game card
        String gameCard;        //Card to be moved to the board

        for (int i = 0; i < COL_NUM; i++) {
            //Gets the bottom of all the columns in each for loop
            bottom = getBottom(i);

            //gets the card that will be distributed to the game board
            card = deck.Deal();

            //Gets the card the will be distributed to the game board
            gameCard = card.getCode();

            //puts the card into the game board
            board[bottom][i] = gameCard;

            if (board[bottom][i] != null) {
                count++;
            }
        }
        return count;
    }



    public void Delete(int colnum)
    {
        int bottom;
        Game game = new Game();
        if(colnum == 0 )
        {
            bottom = game.getBottom(colnum);
            board[bottom][colnum] =  null;
        }
        if(colnum == 1 )
        {
            bottom = game.getBottom(colnum);
            board[bottom][colnum] =  null;
        }
        if(colnum == 2 )
        {
            bottom = game.getBottom(colnum);
            board[bottom][colnum] =  null;
        }
        if(colnum == 3 )
        {
            bottom = game.getBottom(colnum);
            board[bottom][colnum] =  null;
        }

    }
}