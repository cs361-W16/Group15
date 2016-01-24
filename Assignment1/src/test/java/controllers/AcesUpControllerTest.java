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

import java.util.ArrayList;
import java.io.IOException;

public class AcesUpControllerTest extends NinjaTest {

    String URL_ACES_UP = "http://localhost:1024/deck.json";

    @Test
    public void testGetDeck() {
        String response = ninjaTestBrowser.makeJsonRequest(URL_ACES_UP);

        try {
            Deck resultDeck = new ObjectMapper().readValue(response, Deck.class);
            assertEquals(52, resultDeck.getCardsRemaining());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPostDeck() {
        Deck deck = new Deck();

        String response = ninjaTestBrowser.postJson(URL_ACES_UP, deck);

        try {
            Deck resultDeck = new ObjectMapper().readValue(response, Deck.class);
            assertEquals(48, resultDeck.getCardsRemaining());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}