package com.liovachkin.evolutio_gaming_test.combination;

import com.liovachkin.evolutio_gaming_test.Card;
import java.util.Comparator;

/**
 * Copyright (c) 03.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public enum CombinationName {
    HIGH_CARD,
    PAIR,
    TWO_PAIRS,
    THREE_OF_A_KING,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KING,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;

    private static Comparator<Card> getRankReversedComparator() {
        return Comparator.comparing((Card card) -> card.getRank().ordinal()).reversed();
    }
}
