package com.liovachkin.game_evolutio_test.combination;

import static com.liovachkin.game_evolutio_test.CardCombination.cardCombination;
import static com.liovachkin.game_evolutio_test.CardCombination.notContainsCardCombination;

import com.liovachkin.game_evolutio_test.Card;
import com.liovachkin.game_evolutio_test.CardCombination;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class FullHouse implements Combination {

    @Override
    public CardCombination combination(List<Card> cards) {
        ThreeOfKind threeOfKind = new ThreeOfKind();
        CardCombination combination = threeOfKind.combination(cards);
        if (combination.isContains()) {
            var combinationCards = combination.getCards();
            final var finalCombination = combinationCards.subList(0, 3);
            final List<Card> other = cards.stream()
                .filter(card -> !finalCombination.contains(card))
                .sorted(Comparator.comparing((Card card) -> card.getRank().ordinal()))
                .collect(Collectors.toList());
            //TODO use Pair
            for(int i = 0; i < other.size() - 2; i++ ){
                Card card = other.get(i);
                if (card.getRank() == other.get(i + 1).getRank()) {
                    return cardCombination(CombinationName.FULL_HOUSE, List.of(combinationCards.get(0),
                        combinationCards.get(1), combinationCards.get(2), other.get(i), other.get(i + 1)));
                }
            }
        }
        return notContainsCardCombination();
    }
}
