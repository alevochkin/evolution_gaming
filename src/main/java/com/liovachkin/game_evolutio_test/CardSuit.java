package com.liovachkin.game_evolutio_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public enum CardSuit {

    HEARTS("h"), DIAMONDS("d"), CLUBS("c"), SPADES("s");

    private static Map<String, CardSuit> suitMap = new HashMap<>();

    static {
        Arrays.stream(CardSuit.values()).forEach(cardRank -> suitMap.put(cardRank.getSuit(), cardRank));
    }

    private String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    public static CardSuit bySuit(String suit) {
        return suitMap.computeIfAbsent(suit, s -> {
            throw new IllegalArgumentException("Suit not defined for " + suit);
        });
    }

    public String getSuit() {
        return suit;
    }
}
