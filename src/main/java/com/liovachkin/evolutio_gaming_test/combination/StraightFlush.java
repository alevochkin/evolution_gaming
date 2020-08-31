package com.liovachkin.evolutio_gaming_test.combination;

import static com.liovachkin.evolutio_gaming_test.CardCombination.notContainsCardCombination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import java.util.List;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class StraightFlush extends Straight {

    @Override
    public CardCombination combination(List<Card> cards) {
        CardCombination result = super.combination(cards);
        if(result.isContains() && sameSuit(result)) {
            return result.setCombinationName(CombinationName.STRAIGHT_FLUSH);
        }
        return notContainsCardCombination();
    }

    private boolean sameSuit(CardCombination cardCombination) {
        return cardCombination.getCards().stream().map(Card::getSuit).distinct().count() == 1;
    }
}
