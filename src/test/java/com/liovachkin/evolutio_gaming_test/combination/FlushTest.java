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
public class FlushTest {

    @Test
    public void test() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.DIAMONDS));
        List<Card> result = flush.combination(cards).getCards();
        assertThat(result, contains(
            new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.JACK).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.NINE).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.DIAMONDS),
            new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS)
        ));
    }

    @Test
    public void test1() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.KING).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.NINE).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.SPADES));
        cards.add(new Card().setRank(CardRank.FOUR).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.FOUR).setSuit(CardSuit.HEARTS));
        List<Card> result = flush.combination(cards).getCards();
        assertThat(result, contains(
            new Card().setRank(CardRank.ACE).setSuit(CardSuit.SPADES),
            new Card().setRank(CardRank.KING).setSuit(CardSuit.SPADES),
            new Card().setRank(CardRank.NINE).setSuit(CardSuit.SPADES),
            new Card().setRank(CardRank.EIGHT).setSuit(CardSuit.SPADES),
            new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.SPADES)
        ));
    }

    @Test
    public void testNotFound() {
        Flush flush = new Flush();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card().setRank(CardRank.JACK).setSuit(CardSuit.HEARTS));
        cards.add(new Card().setRank(CardRank.QUEEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.TEN).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.TWO).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.CLUBS));
        cards.add(new Card().setRank(CardRank.SEVEN).setSuit(CardSuit.DIAMONDS));
        cards.add(new Card().setRank(CardRank.ACE).setSuit(CardSuit.DIAMONDS));
        List<Card> result = flush.combination(cards).getCards();
        assertThat(result, nullValue());
    }
}
