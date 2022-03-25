package org.schapm.blackjack.game;

import org.schapm.blackjack.domain.Bankroll;

/**
 *
 * @author schapm
 */

public class Player {

    private final String name;
    private final Bankroll bankroll;

    public Player(String name, Bankroll bankroll) {
        this.name = name;
        this.bankroll = bankroll;
    }

    public String getName() {
        return this.name;
    }

    public Bankroll getBankroll() {
        return bankroll.getBankroll();
    }

}
