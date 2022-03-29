package org.schapm.blackjack.domain;

import org.schapm.blackjack.ui.Text;

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

        switch (suit) {
            case DIAMOND:
                return cardValue + "\t" + Text.colorText(Text.UNICODE_BLACK_DIAMOND, Text.ANSI_RED);
            case HEART:
                return cardValue + "\t" + Text.colorText(Text.UNICODE_BLACK_HEART, Text.ANSI_RED);
            case SPADE:
                return cardValue + "\t" + Text.UNICODE_BLACK_SPADE;
            case CLUB:
                return cardValue + "\t" + Text.UNICODE_BLACK_CLUB;
            default:
                return cardValue + "\t" + suit;
        }
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
