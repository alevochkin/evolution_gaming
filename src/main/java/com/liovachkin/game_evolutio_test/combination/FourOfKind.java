package com.liovachkin.game_evolutio_test.combination;

import com.liovachkin.game_evolutio_test.Card;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 31.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class FourOfKind extends Pair {

    @Override
    protected CombinationName combinationName() {
        return CombinationName.FOUR_OF_A_KING;
    }

    @Override
    protected int getCount() {
        return 4;
    }
}
