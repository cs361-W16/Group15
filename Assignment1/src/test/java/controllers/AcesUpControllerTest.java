package controllers;


import models.Card;
import org.junit.Test;

import ninja.NinjaTest;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import models.Deck;
import models.Board;
import ninja.Results;

import java.util.ArrayList;
import java.io.IOException;

public class AcesUpControllerTest extends NinjaTest {
    String URL_ACES_UP = "http://localhost:1024/";

    @Test
    public void testGetDeck() {
        String response = ninjaTestBrowser.makeJsonRequest(URL_ACES_UP + "/deck.json");

        try {
            Board resultBoard = new ObjectMapper().readValue(response, Board.class);
            assertEquals(52, resultBoard.remaining_deck.getCardsRemaining());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostDeck() {
        Board board = new Board();

        String response = ninjaTestBrowser.postJson(URL_ACES_UP + "/deck.json", board);

        try {
            Board resultBoard = new ObjectMapper().readValue(response, Board.class);
            assertEquals(48, resultBoard.remaining_deck.getCardsRemaining());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test 
    public void testDiscard() {
        Board board = new Board();

        String response = ninjaTestBrowser.postJson(URL_ACES_UP + "/discard.json", board);

        try {
            Board resultBoard = new ObjectMapper().readValue(response, Board.class);
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}