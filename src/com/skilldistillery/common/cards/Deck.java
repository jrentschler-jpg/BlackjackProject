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
//		cards = createDeck();

	}

//	private List<Card> createDeck() {
//		List<Card> deck = new ArrayList<>(52);
//		for (Suit suit : Suit.values()) {
//			for (Rank rank : Rank.values()) {
//				deck.add(new Card(suit, rank));
//				
//			}
//		}
//		return deck;
	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

}
