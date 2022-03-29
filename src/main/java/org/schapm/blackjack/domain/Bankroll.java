package org.schapm.blackjack.domain;

import org.schapm.blackjack.game.Player;

/**
 *
 * @author schapm
 */

public class Bankroll {

    private final static int DEFAULT_BANKROLL = 250;
    private int balance;
    private Player player;

    public Bankroll() {
        this.balance = DEFAULT_BANKROLL;
    }

    public Bankroll(int bankroll) {
        this.balance = bankroll;
    }

    public Bankroll getBankroll() {
        return this;
    }

    public int getBalance() {
        return this.balance;
    }

    public Player getPlayer() {
        return player;
    }

    protected void add(int toAdd) {
        this.balance+= toAdd;
    }

    protected void remove(int toRemove) {
        this.balance-= toRemove;
    }

}
