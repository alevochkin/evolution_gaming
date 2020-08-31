package com.liovachkin.game_evolutio_test.combination;

import static com.liovachkin.game_evolutio_test.CardCombination.notContainsCardCombination;

import com.liovachkin.game_evolutio_test.Card;
import com.liovachkin.game_evolutio_test.CardCombination;
import com.liovachkin.game_evolutio_test.CardRank;
import java.util.Comparator;
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
