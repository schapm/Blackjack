package org.schapm.blackjack.ui;

/**
 *
 * @author schapm
 */

public class Text {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static final String UNICODE_BLACK_SPADE = "♠";
    public static final String UNICODE_BLACK_HEART = "♥";
    public static final String UNICODE_BLACK_CLUB = "♣";
    public static final String UNICODE_BLACK_DIAMOND = "♦";

    public static String colorText(String text, String color) {
        return color + text + ANSI_RESET;
    }
}
