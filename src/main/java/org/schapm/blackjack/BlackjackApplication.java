package org.schapm.blackjack;

import org.schapm.blackjack.domain.Bankroll;
import org.schapm.blackjack.game.Game;
import org.schapm.blackjack.game.Player;

/**
 *
 * @author schapm
 */

public class BlackjackApplication {

    public static void main(String[] args) {
        // New player with default bankroll
        Player player = new Player("John", new Bankroll());
        // New dealer with £1,000 bankroll
        Player dealer = new Player("The House", new Bankroll(1_000));

        // Start new game with player and dealer
        Game game = new Game(player, dealer);
        // Start game
        game.start();
    }
}