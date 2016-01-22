/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;


import models.Card;
import org.junit.Test;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import models.Deck;

import java.util.ArrayList;

public class ApiControllerDocTesterTest extends NinjaDocTester {
    
    String URL_INDEX = "/";
    String URL_ACES_UP = "/AcesUp";
    
    @Test
    public void testGetIndex() {

        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString("Hello World!"));
        assertThat(response.payload, containsString("BAM!"));
    }

    @Test
    public void testAcesUp() {
        Response response = makeRequest(
                Request.GET().url(
                        testServerUrl().path(URL_ACES_UP)));

        assertThat(response.payload, containsString("Aces Up"));
        assertThat(response.payload, containsString("columnOfCards"));
    }

    @Test
    public void testDeckExists(){
        Deck deck = new Deck();

        assertNotNull(deck);
    }

    @Test
    public void testDeckSize(){
        Deck deck = new Deck();

        assertEquals(52, deck.getCardsRemaining());
    }

    @Test
    public void testDeckCardsCorrect() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            Card card = deck.drawCard();
            System.out.print(card.getRank() + " " + card.getSuit() + " " + card.getColor() + "\n");
        }
        System.out.print("\n");
    }

    @Test
    public void testDeckShuffle() {
        Deck deck = new Deck();
        deck.shuffleDeck();
        for(int i = 0; i<52; i++) {
            Card card = deck.drawCard();
            System.out.print(card.getRank() + " " + card.getSuit() + " " + card.getColor() + "\n");
        }
        System.out.print("\n");
    }




}
