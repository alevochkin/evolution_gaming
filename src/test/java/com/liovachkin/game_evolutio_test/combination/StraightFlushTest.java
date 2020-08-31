package com.liovachkin.game_evolutio_test.combination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import com.liovachkin.game_evolutio_test.Card;
import com.liovachkin.game_evolutio_test.CardRank;
import com.liovachkin.game_evolutio_test.CardSuit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Copyright (c) 02.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class StraightFlushTest {
    @Test
    public void test() {
        StraightFlush straightFlush  = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.DIAMONDS));
        List<Card> result = straightFlush.combination(cards).getCards();
        assertThat(result, contains(
        new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS)));
    }

    @Test
    public void testNotFound() {
        StraightFlush straightFlush  = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        assertThat(straightFlush.combination(cards).isContains(), is(false));
    }

    @Test
    public void testNotFoundSuit() {
        StraightFlush straightFlush  = new StraightFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.DIAMONDS));
        assertThat(straightFlush.combination(cards).isContains(), is(false));
    }
}
