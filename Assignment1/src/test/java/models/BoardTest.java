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

public class BoardTest extends NinjaDocTester {
    @Test
    public void testBoardDeck() {
        Board Game = new Board();
        assertNotNull(Game.remaining_deck);
    }

    @Test
    public void testBoardColumns() {
        Board game = new Board();
        assertNotNull(game.columns);
    }

    @Test
    public void testDealFour() {
        Board game = new Board();

        game.dealFour();

        // For each column
        for(int i = 0; i < game.columns.size(); i++){
            Deck column = game.columns.get(i);

            // Ensure column has 1 card
            assertTrue(column.deck.size() == 1);
        }
    }

    @Test
    public void testCanDiscardSameSuit() {
        Board game = new Board();
        game.dealFour();

        // TODO: expand test
        game.discardSelectedCard(game.remaining_deck.drawCard());
    }

    @Test
    public void testMoveCardEmpty() {
        Board game = new Board();
        game.dealFour();
        game.printColumns();
        game.moveCard(1,0);
        game.printColumns();
        Deck column0 = game.columns.get(0);
        assertTrue(column0.deck.size() == 2);
    }
}
