package com.liovachkin.game_evolutio_test.combination;

import com.liovachkin.game_evolutio_test.Card;
import com.liovachkin.game_evolutio_test.CardCombination;
import java.util.List;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public interface Combination {

    int TEXAS_HOLDEM_COMBINATION_SIZE = 5;

    CardCombination combination(List<Card> cards);
}
