package com.liovachkin.evolutio_gaming_test;

import com.liovachkin.evolutio_gaming_test.combination.CombinationName;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (c) 28.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
@Data
@Accessors(chain = true)
public class CardCombination implements Comparable<CardCombination> {

    public static CardCombination cardCombination(CombinationName combinationName, List<Card> cards) {
        return new CardCombination()
            .setContains(true)
            .setCombinationName(combinationName)
            .setCards(cards);
    }

    public static CardCombination notContainsCardCombination() {
        return new CardCombination()
            .setContains(false);
    }

    private List<Card> cards;
    private CombinationName combinationName;
    private boolean contains;

    @Override
    public int compareTo(CardCombination other) {
       int result = Integer.compare(this.getCombinationName().ordinal(), other.getCombinationName().ordinal());
       if (result == 0) {
           for (int i = 0; i < cards.size() && result == 0; i++) {
               result = cards.get(i).getRank().compareTo(other.cards.get(i).getRank());
           }
       }
        return result;
    }
}
