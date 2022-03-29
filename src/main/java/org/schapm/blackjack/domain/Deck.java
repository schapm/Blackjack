package org.schapm.blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author schapm
 */

public class Deck {

    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {
            this.cards.add(new Card(i, Suit.HEART));
            this.cards.add(new Card(i, Suit.DIAMOND));
            this.cards.add(new Card(i, Suit.CLUB));
            this.cards.add(new Card(i, Suit.SPADE));
        }
    }

    public Card drawCard() {
        // Pick random card
        int min = 0;
        int max = cards.size() - 1;

        Card card = cards.get((int) (Math.random() * ((max - min) + 1)) + min);
        removeCardFromDeck(card);
        return card;
    }

    public Card drawCard(boolean hidden) {
        Card card = drawCard();
        card.setHidden(true);

        return card;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int rand = random.nextInt(52);

            Card card = cards.get(i);
            Card randomCard = cards.get(rand);

            cards.set(i, randomCard); // Set current loop iteration to random card
            cards.set(rand, card); // Set the random card picked to the current loop iteration card
        }
    }

    private void removeCardFromDeck(Card card) {
        cards.remove(card);
    }

    public void print() {
        cards.forEach((card) -> {
            System.out.println(card.toString());
        });
    }

}