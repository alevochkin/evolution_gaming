package com.liovachkin.game_evolutio_test.combination;

import static com.liovachkin.game_evolutio_test.CardCombination.cardCombination;
import static com.liovachkin.game_evolutio_test.CardCombination.notContainsCardCombination;

import com.liovachkin.game_evolutio_test.Card;
import com.liovachkin.game_evolutio_test.CardCombination;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class Straight implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        cards.sort(getCardComparator());
        for (int i = 0; i < cards.size() - 4; i++) {
            Card first = cards.get(i);
            Card second = cards.get(i + 1);
            Card third = cards.get(i + 2);
            Card fourth = cards.get(i + 3);
            Card fifth = cards.get(i + 4);
            if (first.getRank().getNext() == second.getRank()
                && second.getRank().getNext() == third.getRank()
                && third.getRank().getNext() == fourth.getRank()
                && fourth.getRank().getNext() == fifth.getRank()) {
                return cardCombination(CombinationName.STRAIGHT, List.of(fifth, fourth, third, second, first));
            }
        }
        return notContainsCardCombination();
    }

    private Comparator<Card> getCardComparator() {
        return Comparator.comparing((Card card) -> card.getRank().ordinal());
    }
}
