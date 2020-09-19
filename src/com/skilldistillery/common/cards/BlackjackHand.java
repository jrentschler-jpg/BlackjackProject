package com.skilldistillery.common.cards;

import com.skilldistillery.common.cards.*;

public class BlackjackHand extends Hand {
	// player's hand value:
	private int playerHandValue;

	public BlackjackHand() {
	}

	@Override
	public int getHandValue() {
		playerHandValue = 0;
		for (Card card : cards) {
			playerHandValue += card.getValue();
		}
		return playerHandValue;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;

	}
	public boolean isBust() {
		if(getHandValue() > 21) {
			return true;
		}
		return false;
	}
	//Optional: public boolean isHard() {}
	//Optional: public boolean isSoft() {}
}
