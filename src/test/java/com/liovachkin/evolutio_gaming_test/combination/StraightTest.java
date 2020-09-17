package com.liovachkin.evolutio_gaming_test.combination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
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
public class StraightTest {
    @Test
    public void test() {
        Straight straight  = new Straight();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.CLUBS));
        List<Card> result = straight.combination(cards).getCards();
        assertThat(result, contains(
        new Card().setRank(CardRank.JACK).setSuit(CardSuit.SPADES),
        new Card().setRank(CardRank.TEN).setSuit(CardSuit.HEARTS),
        new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS),
        new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.CLUBS),
        new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS)));
    }

    @Test
    public void testSecond() {
        Straight straight  = new Straight();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.KING).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.SPADES));
        assertThat(straight.combination(cards).getCards(), nullValue());
    }

    @Test
    public void testNotFound() {
        Straight straight  = new Straight();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        List<Card> result = straight.combination(cards).getCards();
        assertThat(result, nullValue());
    }
}
