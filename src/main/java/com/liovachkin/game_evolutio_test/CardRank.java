package com.liovachkin.game_evolutio_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public enum CardRank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("T"), JACK("J"),
    QUEEN("Q"), KING("K"), ACE("A");

    private static final Map<String, CardRank> rankMap = new HashMap<>();

    static {
        Arrays.stream(CardRank.values()).forEach(cardRank -> rankMap.put(cardRank.getRank(), cardRank));
    }

    private final String rank;

    CardRank(String rank) {
        this.rank = rank;
    }

    public static CardRank byRank(String rank) {
        return rankMap.computeIfAbsent(rank, s -> {
            throw new IllegalArgumentException("Rank not defined for " + rank);
        });
    }

    public CardRank getNext() {
        return CardRank.values()[ordinal() + 1];
    }

    public String getRank() {
        return rank;
    }
}
