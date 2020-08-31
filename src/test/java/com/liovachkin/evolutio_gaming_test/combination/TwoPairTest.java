package com.liovachkin.evolutio_gaming_test.combination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardRank;
import com.liovachkin.evolutio_gaming_test.CardSuit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Copyright (c) 02.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class TwoPairTest {

    @Test
    public void test() {
        TwoPairs pair = new TwoPairs();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.FOUR).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.FOUR).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.THREE).setSuit(CardSuit.DIAMONDS));
        List<Card> result = pair.combination(cards).getCards();
        assertThat(result, contains(
            new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.FOUR).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.FOUR).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS)));
    }

    @Test
    public void secondTest() {
        TwoPairs pair = new TwoPairs();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.FIVE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.FOUR).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.THREE).setSuit(CardSuit.DIAMONDS));
        List<Card> result = pair.combination(cards).getCards();
        assertThat(result, contains(
            new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.SIX).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.FIVE).setSuit(CardSuit.DIAMONDS)));
    }
}
