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

public class CardTest extends NinjaDocTester {
    @Test
    public void testCard() {
        Card card = new Card(0, "Ace", "Clubs", "Black");

        assertTrue(
            card.getValue() == 0 &&
            card.getRank().equals("Ace") &&
            card.getSuit().equals("Clubs") &&
            card.getColor().equals("Black")
        );
    }
}
