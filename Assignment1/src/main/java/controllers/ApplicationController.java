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


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


@Singleton
public class ApplicationController {
    public Deck deck = new Deck();
    public Board AcesUp;

    public Result index() {

        return Results.html();
    }

    public Result acesUp() {
        AcesUp = new Board();
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }


    public Result JsonDeckGet() {
        Board board = new Board();

        return Results.json().render(board);
    }


    public Result JsonDeckPost(Context context, Board board) {

        // Debugging
        System.out.print("Received Size: " + board.remaining_deck.deck.size() + "\n\n");

        // Basic functionality for now
        board.dealFour();

        // board.printColumns();


        // Debugging
        System.out.print("\n\nSending Size: " + board.remaining_deck.deck.size() + "\n\n--------------------------\n\n");


        return Results.json().render(board);

    }
}
