package com.liovachkin.game_evolutio_test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TexasHoldemTest {

    @Test
    public void firstTest() {
        TexasHoldem texasHoldem = new TexasHoldem("4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d");
        List<Player> players = texasHoldem.getPlayers();
        assertThat(players.size(), is(5));
        assertThat(players.get(0).getCards(), containsInAnyOrder(card("A", "d"), card("4", "s")));
        assertThat(players.get(1).getCards(), containsInAnyOrder(card("A", "c"), card("4", "d")));
        assertThat(players.get(2).getCards(), containsInAnyOrder(card("A", "s"), card("9", "s")));
        assertThat(players.get(3).getCards(), containsInAnyOrder(card("K", "h"), card("K", "d")));
        assertThat(players.get(4).getCards(), containsInAnyOrder(card("5", "d"), card("6", "d")));
        assertThat(texasHoldem.results(), is("Ac4d=Ad4s 5d6d As9s KhKd"));
    }

    @Test
    public void secondTest() {
        TexasHoldem texasHoldem = new TexasHoldem("2h3h4h5d8d KdKs 9hJh");
        assertThat(texasHoldem.results(), is("KdKs 9hJh"));
    }

    private Card card(String rank, String suit) {
        return new Card()
            .setRank(CardRank.byRank(rank))
            .setSuit(CardSuit.bySuit(suit));
    }

    @Test
    public void test() {
        assertThat("Ac4d".compareTo("Ad4s"), is(-1));
    }
}

