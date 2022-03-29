package org.schapm.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schapm
 */

public class Hand implements Comparable<Hand> {

    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        hand.forEach((card) -> {
            if (card.isHidden()) {
                System.out.println("[HIDDEN CARD]");
            } else {
                System.out.println(card.toString());
            }
        });
    }

    public int handValue() {
        // Adjust for real values
        boolean aceFound = false;
        int sum = 0;
        for (Card card : hand) {
            if (card.getValue() > 10 && card.getValue() < 14) {
                sum += 10;
            } else if (card.getValue() == 14) {
                aceFound = true;
                sum+= 1;
            } else {
                sum += card.getValue();
            }
        }

        if (aceFound && sum < 12) {
            sum+= 10;
        }

        return sum;
    }

    public void setDealerCardVisible() {
        hand.stream().filter((card) -> (card.isHidden())).forEachOrdered((card) -> {
            card.setHidden(false);
        });
    }

    public boolean isBust() {
        return handValue() > 21;
    }

    public boolean isBlackjack() {
        if (hand.size() > 2) {
            return false;
        }

        boolean isTenJQK = false;
        boolean isAce = false;
        for (Card card : hand) {
            if (card.getValue() >= 10 && card.getValue() <= 13) {
                isTenJQK = true;
            }

            if (card.getValue() == 14) {
                isAce = true;
            }
        }

        return isAce == true && isTenJQK == true;
    }

    @Override
    public int compareTo(Hand hand) {
        if (this.isBust() && hand.isBust()) {
            return 0;
        } else if (this.isBust() && !hand.isBust()) {
            return -1;
        } else if (!this.isBust() && hand.isBust()) {
            return 1;
        }

        if (this.handValue() == hand.handValue()) {
            return 0;
        }

        if (this.handValue() > hand.handValue()) {
            return 1;
        } else {
            return -1;
        }
    }

}
