package com.skilldistillery.common.cards;

import java.util.List;

public class BlackjackPlayer extends Player{
	private BlackjackHand thePlayerHand;
	private int theHandValue;
	
	public BlackjackPlayer () {
		thePlayerHand = new BlackjackHand();
		super.setName("Blackjack Player 1");
	}
	public void addCard(Card card) {
		thePlayerHand.addCard(card);
	}
	public int getHandValue() {
		theHandValue = thePlayerHand.getHandValue();
		return theHandValue;
	}
	public void getThePlayerHand() {
		List<Card> thePlayerCards = thePlayerHand.getCards();
		System.out.print("Blackjack Player 1 has ");
		for (Card card : thePlayerCards) {
			System.out.println(card + " ");
		}
		System.out.println();
	}
	public boolean isBlackJack() {
		if(getHandValue() == 21) {
			System.out.println("The Blackjack Player 1 got Blackjack! Player 1 WINS!!!");
			List<Card> thePlayerCards = thePlayerHand.getCards();
			for (Card card : thePlayerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if(getHandValue()> 21) {
			System.out.println("The Blackjack Player 1 is BUSTED!!!");
			return true;
		}
		return false;
	}
	public boolean isTwentyOne() {
		if(getHandValue()==21) {
			System.out.println("The Blackjack Player 1 hit 21! !!!");
			List<Card> thePlayerCards = thePlayerHand.getCards();
			for (Card card : thePlayerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}
	public void clear() {
		thePlayerHand.clear();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackPlayer [thePlayerHand= " );
		builder.append(thePlayerHand);
//		builder.append(", theHandValue=");
//		builder.append(theHandValue);
		builder.append("]");
		return builder.toString();
	}	
	
	
	
	}


