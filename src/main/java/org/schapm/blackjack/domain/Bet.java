package org.schapm.blackjack.domain;

import org.schapm.blackjack.game.Player;

/**
 *
 * @author schapm
 */

public class Bet {

    private final Player player;
    private final Player dealer;
    private final int betSize;

    public Bet(Player player, Player dealer, int betSize) {
        this.player = player;
        this.dealer = dealer;
        this.betSize = betSize;
    }

    public boolean placeBet() {
        // First check both player & dealer have enough balance
        if (player.getBankroll().getBalance() - betSize >= 0
                && dealer.getBankroll().getBalance() - betSize >= 0) {

            player.getBankroll().remove(betSize);
            dealer.getBankroll().add(betSize);

            return true;
        }

        return false;
    }

    public void win() {
        // Return stake and winnings
        player.getBankroll().add(betSize * 2);
        dealer.getBankroll().remove(betSize * 2);
    }

    public void draw() {
        // Return stake
        player.getBankroll().add(betSize);
        dealer.getBankroll().remove(betSize);
    }

    public Player getBalanceNotEnough() {
        // Who doesn't have enough balance to settle the bet
        if (player.getBankroll().getBalance() - betSize < 0) {
            return player;
        }

        return dealer;
    }

}
