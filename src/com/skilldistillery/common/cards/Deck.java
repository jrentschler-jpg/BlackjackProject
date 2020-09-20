package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
//		List<Card> deck = new ArrayList<>(52);
		cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));

			}
		}

	}

	public List<Card> getCardsInDeck() {
		return cards;
	}

	public void setCardsInDeck(List<Card> cards) {
		this.cards = cards;
	}

	public int cardsLeftInDeck() {
		return cards.size();
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void dealCard(Hand hand) {
		Card newCard = cards.remove(0);
		hand.addCard(newCard);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deck [cards =");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}

}
