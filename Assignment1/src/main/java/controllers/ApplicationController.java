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

import ninja.Result;
import ninja.Results;
import ninja.Context;
import models.Board;
import models.Card;
import models.Deck;



import com.google.inject.Singleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


@Singleton
public class ApplicationController {

    public Board AcesUp;

    public Result index() {

        return Results.html();
    }

    public Result acesUp() {
        AcesUp = new Board();
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }


    public Result JsonDeckGet() {
        Deck deck = new Deck();

        return Results.json().render(deck.deck);
    }

    public Result JsonDeckPost(Context context, Deck deck) {

    
        // Basic functionality for now
        // Card[] dealt_cards = new Card[4];

        // for (int i = 0; i < 4; i++) {
        //     dealt_cards[i] = deck.drawCard();
        // }

        return Results.json().render(deck);
       
      

    }

}
