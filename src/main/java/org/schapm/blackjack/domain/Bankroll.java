package org.schapm.blackjack.domain;

/**
 *
 * @author schapm
 */

public class Bankroll {

    private final static int DEFAULT_BANKROLL = 250;
    private int balance;

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

    protected void add(int toAdd) {
        this.balance+= toAdd;
    }

    protected void remove(int toRemove) {
        this.balance-= toRemove;
    }

}
