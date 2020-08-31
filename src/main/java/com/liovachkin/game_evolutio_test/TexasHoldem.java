package com.liovachkin.game_evolutio_test;

import com.liovachkin.game_evolutio_test.combination.Combination;
import com.liovachkin.game_evolutio_test.combination.Flush;
import com.liovachkin.game_evolutio_test.combination.FourOfKind;
import com.liovachkin.game_evolutio_test.combination.FullHouse;
import com.liovachkin.game_evolutio_test.combination.HighCard;
import com.liovachkin.game_evolutio_test.combination.Pair;
import com.liovachkin.game_evolutio_test.combination.RoyalFlush;
import com.liovachkin.game_evolutio_test.combination.Straight;
import com.liovachkin.game_evolutio_test.combination.StraightFlush;
import com.liovachkin.game_evolutio_test.combination.ThreeOfKind;
import com.liovachkin.game_evolutio_test.combination.TwoPairs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (c) 30.07.2020 NOOGA DEVELOPMENT All rights reserved Author: Aliaksandr Liovachkin
 */
@Data
@Accessors(chain = true)
public class TexasHoldem {

    private List<Player> players;

    public TexasHoldem(String line) {
        String[] split = line.split("\\s");
        if (split[0].length() != 10) {
            throw new IllegalArgumentException("Bord card must be 5");
        }
        final List<Card> board = convertToCards(split[0]);
        players = createPlayers(split, board);
    }

    public String results() {
        players.sort(Comparator.comparing(Player::getBestCombination));
        var result = new ArrayList<String>();
        var tmpList = new ArrayList<String>();
        for (int i = 0; i < players.size(); i++) {
            var current = players.get(i);
            tmpList.add(current.printCards());
            if (i < players.size() - 1) {
                var next = players.get(i + 1);
                if(current.getBestCombination().compareTo(next.getBestCombination()) != 0) {
                    tmpList.sort(String::compareTo);
                    result.add(String.join("=", tmpList));
                    tmpList = new ArrayList<>();
                }
            } else {
                result.add(String.join("=", tmpList));
            }
        }
        return String.join(" ", result);
    }

    private List<Player> createPlayers(String[] split, List<Card> board) {
        List<Player> result = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            List<Card> cards = convertToCards(split[i]);
            result.add(new Player()
                .setCards(cards)
                .setBestCombination(calculateCombination(new ArrayList<>(cards), board)));
        }
        return result;
    }

    private CardCombination calculateCombination(List<Card> cards, List<Card> board) {
        cards.addAll(board);
        for (Combination combination : combinations()) {
            CardCombination cardCombination = combination.combination(cards);
            if (cardCombination.isContains()) {
                return cardCombination;
            }
        }
        throw new IllegalArgumentException("Can not found combination.");
    }

    private Combination[] combinations() {
        return new Combination[]{
            new RoyalFlush(), new StraightFlush(), new FourOfKind(), new FullHouse(), new Flush(), new Straight(),
            new ThreeOfKind(), new TwoPairs(), new Pair(), new HighCard()
        };
    }

    private List<Card> convertToCards(String s) {
        return Arrays.stream(s.split("(?<=\\G..)"))
            .map(this::createCard)
            .collect(Collectors.toList());
    }

    private Card createCard(String str) {
        return new Card()
            .setRank(CardRank.byRank(str.substring(0, 1)))
            .setSuit(CardSuit.bySuit(str.substring(1, 2)));
    }
}
