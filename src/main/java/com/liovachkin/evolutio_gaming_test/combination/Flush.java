package com.liovachkin.evolutio_gaming_test.combination;

import static com.liovachkin.evolutio_gaming_test.CardCombination.cardCombination;
import static com.liovachkin.evolutio_gaming_test.CardCombination.notContainsCardCombination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class Flush implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        cards.sort(getCardComparator());
        for (int i = 0; i < cards.size() - 4; i++) {
            Card first = cards.get(i);
            Card second = cards.get(i + 1);
            Card third = cards.get(i + 2);
            Card fourth = cards.get(i + 3);
            Card fifth = cards.get(i + 4);
            if (first.getSuit() == second.getSuit()
                && second.getSuit() == third.getSuit()
                && third.getSuit() == fourth.getSuit()
                && fourth.getSuit() == fifth.getSuit()) {
                return cardCombination(CombinationName.FLUSH, List.of(fifth, fourth, third, second, first));
            }
        }
        return notContainsCardCombination();
    }

    private Comparator<Card> getCardComparator() {
        return Comparator.comparing((Card card) -> card.getSuit().ordinal())
            .thenComparing(card -> card.getRank().ordinal());
    }
}
