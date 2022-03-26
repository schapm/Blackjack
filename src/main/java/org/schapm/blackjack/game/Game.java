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
                // Reset
                deck = new Deck();
                deck.shuffle();
                playerHand = new Hand();
                dealerHand = new Hand();

                // Start game
                System.out.println("\n=================");
                System.out.println("Starting New Hand");
                System.out.println("=================");
                System.out.println(player.getName() + "'s bankroll is £" + player.getBankroll().getBalance());
                System.out.println(dealer.getName() + "'s bankroll is £" + dealer.getBankroll().getBalance());

                // Place bet
                System.out.println("\n" + player.getName() + "'s Stake");
                System.out.print("> ");
                bet = new Bet(player, dealer, Integer.valueOf(validateUserInput("[0-9]+", scanner.nextLine())));

            }

            // GAME_END ------------------------------------------------------->
            while (gameState == GameState.GAME_END) {

            }

            // STOP ----------------------------------------------------------->
            if (gameState == GameState.STOP) {

            }
        }
    }

    private void printHands() {
        System.out.println("\n" + dealer.getName() + ":");
        dealerHand.print();

        System.out.println("\n" + player.getName() + ":");
        playerHand.print();
    }

    private String validateUserInput(String regex, String userInput) {
        if (!userInput.matches(regex)) {
            while (true) {
                System.out.println("\nIncorrect option, try again");
                System.out.print("> ");
                String answer = scanner.nextLine().trim();

                if (answer.matches(regex)) {
                    return answer;
                }
            }
        }

        return userInput;
    }

}
