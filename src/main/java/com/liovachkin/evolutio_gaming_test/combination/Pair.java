package com.liovachkin.evolutio_gaming_test.combination;

import static com.liovachkin.evolutio_gaming_test.CardCombination.cardCombination;
import static com.liovachkin.evolutio_gaming_test.CardCombination.notContainsCardCombination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class Pair implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        cards.sort(getCardComparator());
        for (int i = 0; i < cards.size() - getCount()  + 1; i++) {
            if (hasCombination(cards, i)) {
                return cardCombination(combinationName(), populateResult(cards, i));
            }
        }
        return notContainsCardCombination();
    }

    protected CombinationName combinationName() {
        return CombinationName.PAIR;
    }

    private boolean hasCombination(List<Card> cards, int i) {
        return cards.subList(i, i + getCount()).stream().map(Card::getRank).distinct().count() == 1;
    }

    protected int getCount() {
        return 2;
    }

    private List<Card> populateResult(List<Card> cards, int i) {
        List<Card> result = new ArrayList<>(cards.subList(i, i + getCount()));
        int j = cards.size() - 1;
        while (i + getCount() - 1 < j) {
            result.add(cards.get(j--));
        }
        j = i - 1;
        while (result.size() < TEXAS_HOLDEM_COMBINATION_SIZE) {
            result.add(cards.get(j--));
        }
        return result;
    }

    private Comparator<Card> getCardComparator() {
        return Comparator.comparing((Card card) -> card.getRank().ordinal());
    }
}
