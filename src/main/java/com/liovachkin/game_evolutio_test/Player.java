package com.liovachkin.game_evolutio_test;

import com.liovachkin.game_evolutio_test.combination.Combination;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (c) 30.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
@Data
@Accessors(chain = true)
public class Player {
    private List<Card> cards;
    private CardCombination bestCombination;

    public String printCards() {
        return cards.stream().map(Card::toString).collect(Collectors.joining(""));
    }
}
