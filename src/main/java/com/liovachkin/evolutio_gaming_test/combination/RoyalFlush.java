package com.liovachkin.evolutio_gaming_test.combination;

import static com.liovachkin.evolutio_gaming_test.CardCombination.notContainsCardCombination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import com.liovachkin.evolutio_gaming_test.CardRank;
import java.util.List;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class RoyalFlush extends StraightFlush {

    @Override
    public CardCombination combination(List<Card> cards) {
        CardCombination result = super.combination(cards);
        if(result.isContains() && result.getCards().get(0).getRank() == CardRank.ACE) {
            return result.setCombinationName(CombinationName.ROYAL_FLUSH);
        }
        return notContainsCardCombination();
    }
}
