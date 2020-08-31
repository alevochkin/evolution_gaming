package com.liovachkin.evolutio_gaming_test.combination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import com.liovachkin.evolutio_gaming_test.Card;
import com.liovachkin.evolutio_gaming_test.CardRank;
import com.liovachkin.evolutio_gaming_test.CardSuit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Copyright (c) 02.08.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
public class RoyalFlushTest {
    @Test
    public void test() {
        RoyalFlush royalFlush  = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.KING).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.CLUBS));
        List<Card> result = royalFlush.combination(cards).getCards();
        assertThat(result, contains(
        new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.KING).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS)));
    }

    @Test
    public void testNotFound() {
        RoyalFlush royalFlush  = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.KING).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS));
        assertThat(royalFlush.combination(cards).isContains(), is(false));
    }

    @Test
    public void testNotFoundSuit() {
        RoyalFlush royalFlush  = new RoyalFlush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.KING).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.CLUBS));
        assertThat(royalFlush.combination(cards).isContains(), is(false));
    }
}
