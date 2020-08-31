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
public class TwoPairs implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        cards.sort(getCardComparator());
        int firstPair = -1;
        int secondPair = -1;
        for (int i = 0; i < cards.size() - 1; i++) {
            Card card = cards.get(i);
            if (card.getRank() == cards.get(i + 1).getRank()) {
                if(firstPair < 0) {
                    firstPair = i;
                } else {
                    secondPair = i;
                }
            }
        }
        if (secondPair < 0 ) {
            return notContainsCardCombination();
        } else {
            return cardCombination(CombinationName.TWO_PAIRS, List.of(cards.get(secondPair), cards.get(secondPair + 1),
                cards.get(firstPair), cards.get(firstPair + 1), cards.get(fifthIndex(cards, firstPair, secondPair))));
        }
    }

    private int fifthIndex(List<Card> cards, int firstPair, int secondPair) {
        int result = firstPair - 1;
        if(secondPair + 2 < cards.size() - 1) {
            result = cards.size() - 1;
        } else if (secondPair - 1 > firstPair + 1) {
            result = secondPair - 1;
        }
        return result;
    }

    private Comparator<Card> getCardComparator() {
        return Comparator.comparing((Card card) -> card.getRank().ordinal());
    }
}
