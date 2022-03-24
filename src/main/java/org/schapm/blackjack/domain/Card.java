package org.schapm.blackjack.domain;

/**
 *
 * @author schapm
 */

public class Card {

    private int value;
    private Suit suit;
    private boolean hidden;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be 2 - 14");
        }

        this.value = value;
        this.suit = suit;
        this.hidden = false;
    }

    @Override
    public String toString() {
        String cardValue = String.valueOf(value);
        switch (value) {
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            case 14:
                cardValue = "A";
                break;
            default:
                break;
        }

        return cardValue + " " + suit;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

}
