package com.liovachkin.evolutio_gaming_test.combination;

import static com.liovachkin.evolutio_gaming_test.CardCombination.cardCombination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class HighCard implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        cards.sort(getCardComparator());
        return cardCombination(CombinationName.HIGH_CARD, cards.subList(0, 5));
    }

    private Comparator<Card> getCardComparator() {
        return Comparator.comparing((Card card) -> card.getRank().ordinal()).reversed();
    }
}
