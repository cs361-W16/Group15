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

package models;

import models.Card;
import org.junit.Test;

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import models.Deck;
import models.Board;

import java.util.ArrayList;

public class DeckTest extends NinjaDocTester {
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
    public void testDeckGetCardsRemaining() {
        Deck deck = new Deck();

        assertEquals(52, deck.getCardsRemaining());
    }

    @Test
    public void testDeckShuffle() {
        Deck deck = new Deck();
        Deck orig = new Deck(deck); // Copy first deck
        deck.shuffleDeck();

        // Compare original and shuffled deck cards
        int matching = 0;
        for(int i = 0; i < 52; i++) {
            Card shuffled = deck._get(i);
            Card original = orig._get(i);

            System.out.println(shuffled.getValue() + " - " + original.getValue());

            // If matching
            if(original.getValue() == shuffled.getValue() && original.getSuit().equals(shuffled.getSuit())){
                matching++;
            }
        }

        // Calculate similarity
        double similarity = ((double)matching) / 52.0;
        System.out.println("Matching: " + matching + " - Total: " + 52);

        // Assert that the shuffled deck differs from the original by at least 85%
        assertTrue(similarity >= 0.15 == false);
    }

    @Test
    public void testDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();

        assertTrue(card.getValue() > 0 && card.getValue() < 14);
        assertTrue(card.getSuit().length() > 0); // Assert suit string not empty
    }

    @Test
    public void testGetAt(){
        Deck deck = new Deck();

        Card card = deck.getAt(0);

        assertNotNull(card);
    }
}
