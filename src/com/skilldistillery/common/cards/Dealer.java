package com.skilldistillery.common.cards;

import java.util.Collections;
import java.util.List;
import com.skilldistillery.common.cards.*;

public class Dealer extends Player {
//	name the classes that have "like" traits declare fields here for Dealer:
	private BlackjackHand theDealerHand;
	private Deck cards;
	private int theHandValue;

	public Dealer() {
//	call the classes and instantiate them for the Dealer	
		super();
		cards = new Deck();
		theDealerHand = new BlackjackHand();
		super.setName("Blackjack Dealer");
	}
//  the Dealer will add a card 
	public void addCard(Card card) {
		theDealerHand.addCard(card);
	}
//  the Dealer with deal a card 
	public Card dealCard() {
		return cards.dealCard();
	}
//  the Dealer will get the hand value 
	public int getHandValue() {
		theHandValue = theDealerHand.getHandValue();
		return theHandValue;

	}
//  the Dealer will deal the first hand. Call on the List of cards, for, if/else to display what the dealer has drawn 	
	public void theDealersFirstHand() {
		List<Card> dealerCards = theDealerHand.getCards();
		System.out.print("The Blackjack Dealer has ");
		for (int i = 0; i < dealerCards.size(); i++) {
			if(i == 0) {
//				make a prettier sysout line for visual esthetics 
				System.out.println(" of ");
			}else {
				System.out.println(dealerCards.get(i));
			}
			
		}
	}
	public void showTheDealersHand() {
		List<Card> dealerCards = theDealerHand.getCards();
		System.out.print("The Blackjack Dealer has ");
		for (int i = 0; i < dealerCards.size(); i++) {
			System.out.println(dealerCards.get(i) + " ");
			
		}
	}
	public boolean isBlackJack() {
		if(getHandValue() == 21) {
			System.out.println("The Blackjack Dealer got Blackjack!! The Dealer WINS!!!");
			List<Card> dealerCards = theDealerHand.getCards();
			for (Card card : dealerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}
	public boolean isBust() {
		if(getHandValue()> 21) {
			System.out.println("The Blackjack Dealer is BUSTED!!!");
			showTheDealersHand();
			return true;
		}
		return false;
	}
	public boolean isTwentyOne() {
		if(getHandValue()==21) {
			System.out.println("The Blackjack Dealer hit 21! !!!");
			List<Card> dealerCards = theDealerHand.getCards();
			for (Card card : dealerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
		
	}
	public void printDeckofCards() {
		List<Card> cardDeck = cards.getCardsInDeck();
		for (Card card : cardDeck) {
			System.out.println(card);
		}
		
		}
		public void dealerShuffler() {
			List<Card> cardDeck = cards.getCardsInDeck();
			Collections.shuffle(cardDeck);
		}
		public int getDeckSize() {
			List<Card> cardDeck = cards.getCardsInDeck();
			return cardDeck.size();
			
		}
		public void clear() {
			theDealerHand.clear();
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Dealer [theDealerHand= ");
			builder.append(theDealerHand);
			builder.append(", cards=");
			builder.append(cards);
//			builder.append(", theHandValue=");
//			builder.append(theHandValue);
			builder.append("]");
			return builder.toString();
		}

}
