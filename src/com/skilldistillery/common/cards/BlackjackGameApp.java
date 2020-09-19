package com.skilldistillery.common.cards;

import java.util.Scanner;

public class BlackjackGameApp {
	private BlackjackPlayer blackjackPlayer;
	private Dealer blackjackDealer;
	private Scanner scanner;

	public static void main(String[] args) {
		BlackjackGameApp app = new BlackjackGameApp();
		app.run();

	}

	private void run() {

		scanner = new Scanner(System.in);

		mainMenuScreen();

	}

	private void mainMenuScreen() {
		//add sysouts prompting the user to play the game
		//add a switch statement calling the different methods
		System.out.println("=======***=======***=======***=======***=======***=======***");
		System.out.println("*** WELCOME To The Tropicana Casino in Atlantic City, NJ ***");
		System.out.println("                                                             ");
		System.out.println("          _____");
		System.out.println("         |A .  | _____");
		System.out.println("         | /.\\ ||A ^  |_____");
		System.out.println("         |(_._)|| ^^^ ||A _  |_____");
		System.out.println("         |  |  || <>> || ( ) ||A_ _ |");
		System.out.println("         |____V||  .  ||(_'_)||( v )|");
		System.out.println("                |____V||  |  || \\ / |");
		System.out.println("                       |____V||  .  |");
		System.out.println("                              |____V|");                                                
		System.out.println(                                                              );
		System.out.println("=======***=======***=======***=======***=======***=======***");
		System.out.println("");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
	}

	private void playNewGame() {
		blackjackPlayer = new BlackjackPlayer();
		blackjackDealer = new Dealer();
		blackjackDealer.dealerShuffler();

		// dealer deals 1 cards
		blackjackPlayer.addCard(blackjackDealer.dealCard());
		blackjackDealer.addCard(blackjackDealer.dealCard());

		// dealer deals 2nd card
		blackjackPlayer.addCard(blackjackDealer.dealCard());
		blackjackDealer.addCard(blackjackDealer.dealCard());

		blackjackPlayer.getThePlayerHand();
		System.out.println("Blackjack Player 1: " + blackjackPlayer.getHandValue());
		System.out.println();
		System.out.println();

		blackjackDealer.theDealersFirstHand();

		// checkingForBlackjack();

	}

	private void bjackPlayerHit() {
		// add card
		// also add in methods: isBust(), thePlayerHand(), and getHandValue()
		// add if statement to either hitOrStay()
	}

	private void bjackDealerHit() {
		// getHandValue(),
		// add card
		// also add in methods: isTwentyOne(), thePlayerHand(), and getHandValue()
		// add if statement to either hitOrStay()
	}

	private void hitOrStand() {

		// player has the option to either hit or stand
		// create a switch statement for cleaner code
		// userinput (scanner)
		// sysouts

	}

	private void checkingDeck() {
		//
	}

	private boolean checkingForBlackjack() {
		return false;
		//
	}

	private void checkingWin() {
		//
	}

	private void clear() {
		//
	}

}
