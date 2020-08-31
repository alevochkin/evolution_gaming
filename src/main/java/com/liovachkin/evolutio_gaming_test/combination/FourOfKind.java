package com.liovachkin.evolutio_gaming_test.combination;

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
