package org.schapm.blackjack.game;

import org.schapm.blackjack.domain.Bet;
import org.schapm.blackjack.domain.Deck;
import org.schapm.blackjack.domain.Hand;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

                // Deal cards
                playerHand.add(deck.drawCard());
                playerHand.add(deck.drawCard());

                dealerHand.add(deck.drawCard());
                dealerHand.add(deck.drawCard(true)); // Card hidden

                printHands();

                playerTurn();
                dealerTurn();

                gameState = GameState.GAME_END;
            }

            // GAME_END ------------------------------------------------------->
            while (gameState == GameState.GAME_END) {
                whoWonLostOrDraw();
                
                System.out.println("\nPlay again? (y/n)");
                System.out.print("> ");

                if (validateUserInput("y|n", scanner.nextLine()).equals("y")) {
                    gameState = GameState.GAME_START;
                } else {
                    gameState = GameState.STOP;
                }
            }

            // STOP ----------------------------------------------------------->
            if (gameState == GameState.STOP) {

                break;
            }
        }
    }

    private void playerTurn() {
        while (true) {
            if (playerHand.isBust()) {
                System.out.println("\n" + player.getName().toUpperCase() + " IS BUST!");
                gameState = GameState.GAME_END;

                break;
            }

            System.out.println("\nHit or stand, " + player.getName() + "? (h/s)");
            System.out.print("> ");

            if (validateUserInput("h|s", scanner.nextLine()).equals("h")) {
                playerHand.add(deck.drawCard());

                System.out.println("\n" + player.getName() + ":");
                playerHand.print();
            } else {
                break;
            }
        }
    }

    private void dealerTurn() {
        // Set dealer's card visible & print hand
        dealerHand.setDealerCardVisible();
        System.out.println("\n" + dealer.getName() + ":");
        dealerHand.print();

        while (true) {
            // Wait a short time to improve gameplay
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ie) {
                System.out.println("Error: " + ie.getMessage());
            }

            if (dealerHand.isBust()) {
                System.out.println("\n" + dealer.getName().toUpperCase() + " IS BUST!");
                gameState = GameState.GAME_END;

                break;
            }

            // Dealer stands on soft 16
            if (dealerHand.handValue() < 16) {
                dealerHand.add(deck.drawCard());

                System.out.println("\n" + dealer.getName() + ":");
                dealerHand.print();
            } else {

                break;
            }
        }
    }

    private void whoWonLostOrDraw() {
        int compareHands = playerHand.compareTo(dealerHand);
        if (compareHands > 0) {
            System.out.println("\nResult: " + player.getName() + " Wins!");
            bet.win();
        } else if (compareHands == 0) {
            System.out.println("\nResult: Draw!");
            bet.draw();
        } else {
            System.out.println("\nResult: " + player.getName() + " Lost!"); // Don't need to do anything else
        }

        gameState = GameState.GAME_END;
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
