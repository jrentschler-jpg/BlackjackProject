package com.skilldistillery.common.cards;

public class Player {
	private String name;
//	private int playerHandValue;
//	private int BlackjackHand;
	
	
	public Player() {
		
		
	}
	
// call the isBlackjack() from the BlackjackHand class?
//	@Override
//	public int getHandValue() {
//		playerHandValue = 0;
//		BlackjackHand = 0;
//		for (Card card : cards) {
//			playerHandValue += card.getValue();
//			BlackjackHand += card.getValue();
//		}
//		return playerHandValue;
//		return BlackjackHand;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name= ");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
