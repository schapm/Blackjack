package org.schapm.blackjack.game;

import org.schapm.blackjack.domain.Bet;
import org.schapm.blackjack.domain.Deck;
import org.schapm.blackjack.domain.Hand;

import java.util.Scanner;

/**
 *
 * @author schapm
 */

public class Game {

    private final Scanner scanner;
    private final Player player;
    private final Player dealer;

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private GameState gameState;
    private Bet bet;

    public Game(Player player, Player dealer) {
        this.scanner = new Scanner(System.in);
        this.player = player;
        this.dealer = dealer;
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
        this.gameState = GameState.STOP;
    }

    public void start() {
        gameState = GameState.GAME_START;

        // Main game loop
        while (true) {

            // GAME_START------------------------------------------------------>
            while (gameState == GameState.GAME_START) {

            }

            // GAME_END ------------------------------------------------------->
            while (gameState == GameState.GAME_END) {

            }

            // STOP ----------------------------------------------------------->
            if (gameState == GameState.STOP) {

            }
        }
    }

}
