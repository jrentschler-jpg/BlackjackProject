package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackGameApp {
	private BlackjackPlayer blackjackPlayer;
	private Dealer blackjackDealer;
//	private Deck deckShuffle;
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
		System.out.println("*** WELCOME To The JR Casino in Colorado Springs, CO ***");
		System.out.println("                                                             ");
		System.out.println("          _____");
		System.out.println("         |A .  | _____");
		System.out.println("         | /.\\||A ^  |_____");
		System.out.println("         |(_._)|| ^^^ ||A _  |_____");
		System.out.println("         |  |  || [<>]|| ( ) ||A_ _ |");
		System.out.println("         |____V||  .  ||(_'_)||( v )|");
		System.out.println("                |____V||  |  || \\ /|");
		System.out.println("                       |____V||  .  |");
		System.out.println("                              |____V|");                                                
		System.out.println(                                                              );
		System.out.println("***          Ready to play to Blackjack?                 ***");
		System.out.println("Please enter 1: Play Blackjack Game!");
		System.out.println("Please enter 2: Quit the Blackjack Game. ");
		System.out.println("------------------------------------------------------------");
		System.out.println("=======***=======***=======***=======***=======***=======***");
		System.out.println("");
		
		
		int menuSelection = scanner.nextInt();
		switch(menuSelection) {
		case 1:
			playNewGame();
			break;
		case 2: 
			System.out.println("Already done playing!? We are sad to see you go!");
			System.out.println("Gambling Problem? Call 1-800-Gambler \n Must be 21 or older.");
			break;
			
		}
		
		
		
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
		checkingForBlackjack();

		if(blackjackDealer.getHandValue() < 21 && blackjackPlayer.getHandValue() < 21) {
			hitOrStand();
		 
		 }

	}

	private void bjackPlayerHit() {
		// add card
		// also add in methods: isBust(), thePlayerHand(), and getHandValue()
		// add if statement to either hitOrStay()
		blackjackPlayer.addCard(blackjackDealer.dealCard());
		blackjackPlayer.isBust();
		blackjackPlayer.getThePlayerHand();
		System.out.println("Blackjack Player : " + blackjackPlayer.getHandValue());
		
		if (blackjackPlayer.getHandValue() < 22) {
			hitOrStand();
		}
		keepPlayingGame();
	}

	private void bjackDealerHit() {
		// getHandValue(),
		// add card
		// also add in methods: isTwentyOne(), thePlayerHand(), and getHandValue()
		// add if statement to either hitOrStay()
		while(blackjackDealer.getHandValue() < 17) {
			blackjackDealer.addCard(blackjackDealer.dealCard());
			System.out.println("This Dealer is going to HIT!!!");
		}
		if(blackjackPlayer.isTwentyOne() && blackjackDealer.isTwentyOne()) {
			System.out.println("Uh-oh! Both Dealer and Player have hit 21!");
			clear();
		} else if (blackjackDealer.getHandValue() >16 && blackjackDealer.getHandValue() <22) {
			checkingWin();
		}
	}

	private void hitOrStand() {

		// player has the option to either hit or stand
		// create a switch statement for cleaner code
		// userinput (scanner)
		// sysouts
		System.out.println("If you would like to HIT please enter 1");
		System.out.println("If you would like to STAND please enter 2");
		int hitOrStandSelection = scanner.nextInt();
		switch(hitOrStandSelection) {
		case 1: 
			bjackPlayerHit();
			break;
		case 2:
			System.out.println("You have chosen to STAND. Now, it is the Dealer's turn.");
			//if player is lessthan/equals 21 and the dealer is lessthan 17
			//dealer will hit 
			//or the dealer will bust
			//and they will keep playing
			if(blackjackPlayer.getHandValue() <= 21 && blackjackDealer.getHandValue()<17) {
				bjackDealerHit();
				blackjackDealer.isBust();
				keepPlayingGame();
				
			}
			//if the player equals the dealers hand they will PUSH.
			//the dealer will show his hand
			//and keep playing
			if(blackjackPlayer.getHandValue() == blackjackDealer.getHandValue()) {
				System.out.println("PUSH!");
				blackjackDealer.showTheDealersHand();
				keepPlayingGame();
			//else, the dealer is greater than 16 and less than 21 
				//the player either has 21 
				//or a bust
				//and will check for win
		}else if(blackjackDealer.getHandValue() >16 && blackjackDealer.getHandValue()<21) {
			blackjackPlayer.isTwentyOne();
			blackjackPlayer.isBust();
			checkingWin();
		}
			break;
			//in case the user inputs the incorrect option, it will prompt them to select from the menuselection
			default:
				System.out.println("You're probably Bluffing! Please enter 1 or 2 from the MenuSelection.");
				hitOrStandSelection = scanner.nextInt();
				break;
		}

	}
	private void keepPlayingGame() {
		char sadFace = '\u2639';
		char smileFace = '\u263A';
//		char bjCard = '\u10cf';
		
		System.out.println("Playing Blackjack" + "\u2662" +"\u2661"+ "\u2667" +"\u2664"+ "is fun! Why not play another round and beat the Dealer?");
		System.out.println("Feeling lucky " + smileFace +    " ? Enter 1 to Play again.");
		System.out.println("Not Feeling lucky " + sadFace+ " ? Enter 2 Quit the game.");
		
		int keepPlayingSelection = scanner.nextInt();
		
		switch(keepPlayingSelection) {
		case 1:
			playNewHand();
			break;
		case 2: 
			System.out.println("You are not feeling lucky and have chosen to quit. \n Thanks for playing Blackjack! \n We hope to see you again!");
			System.out.println("Gambling Problem? Call 1-800-Gambler \n Must be 21 or older.");
			break;
			
			default:
				System.out.println("You're probably Bluffing...AGAIN! Please enter 1 or 2 from the MenuSelection.");
				keepPlayingSelection = scanner.nextInt();
				break;
		}
		
		
		
	}
	private void playNewHand() {
		clear();
//		shuffle();
		checkingDeck();
//		blackjackDealer.dealerShuffler();
		
		blackjackPlayer.addCard(blackjackDealer.dealCard());
		blackjackDealer.addCard(blackjackDealer.dealCard());
		
		blackjackPlayer.addCard(blackjackDealer.dealCard());
		blackjackDealer.addCard(blackjackDealer.dealCard());
		
		
		blackjackPlayer.getThePlayerHand();
		System.out.println("Blackjack Player 1: " + blackjackPlayer.getHandValue());
		System.out.println();
		System.out.println();
		blackjackDealer.theDealersFirstHand();
		checkingForBlackjack();
		
		if(blackjackDealer.getHandValue() < 21 && blackjackPlayer.getHandValue() < 21) {
			hitOrStand();
		 
			
		 }
		
		
	}

//	public void shuffle() {
//		List<Card> cards = new ArrayList<Card>();
//		Collections.shuffle(cards);
//	}

	private void checkingDeck() {
		if(blackjackDealer.getDeckSize() < 14) {
			System.out.println("Shuffling the Deck.");
			blackjackDealer = new Dealer();
			blackjackDealer.dealerShuffler();
		}
	}

	private boolean checkingForBlackjack() {
		if(blackjackDealer.isBlackJack()) {
			keepPlayingGame();
			return true;
		}
		if(blackjackDealer.getHandValue() < 21 && blackjackPlayer.isBlackJack()) {
			keepPlayingGame();
			return true;
		}else {
			
			return false;
		}
		
	}

	private void checkingWin() {
		if(blackjackPlayer.getHandValue() == blackjackDealer.getHandValue()) {
			System.out.println("PUSH!");
		}
		if (blackjackPlayer.getHandValue() > blackjackDealer.getHandValue() || blackjackDealer.getHandValue() > 21) {
			System.out.println("Blackjack Player 1 WINS!!!");
		}
		if (blackjackPlayer.getHandValue() < blackjackDealer.getHandValue() || blackjackPlayer.getHandValue() > 21) {
			System.out.println("Blackjack Dealer WINS!!!");
		}
		blackjackDealer.showTheDealersHand();
		keepPlayingGame();
			
		
	}

	private void clear() {
		blackjackPlayer.clear();
		blackjackDealer.clear();
	}

}
