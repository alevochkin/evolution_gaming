package com.liovachkin.evolutio_gaming_test.combination;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardCombination;
import java.util.List;

/**
 * Copyright (c) 24.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public interface Combination {

    int TEXAS_HOLDEM_COMBINATION_SIZE = 5;

    CardCombination combination(List<Card> cards);
}
