package com.liovachkin.evolutio_gaming_test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
@Data
@Accessors(chain = true)
public class Card implements Comparable<Card> {
    private CardRank rank;
    private CardSuit suit;

    @Override
    public int compareTo(Card other) {
        int result = Integer.compare(this.suit.ordinal(), other.suit.ordinal());
        if(result == 0) {
            result = Integer.compare(this.rank.ordinal(), other.rank.ordinal());
        }
        return result;
    }

    @Override
    public String toString() {
        return getRank().getRank() + getSuit().getSuit();
    }
}
