package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Good Evening! How many cards: ");
		try {
			int numberOfCards = scanner.nextInt();
//		                      > 52
			if (numberOfCards > deck.checkDeckSize()) {
				System.out.println("Too many cards");
			} else {
				int value = 0;
				for (int i = 0; i < numberOfCards; i++) {
					Card c = deck.dealCard();
					value += c.getValue();
					System.out.println(c);
				}
				System.out.println("Your value is " + value);
			}
		} catch (Exception e) {
			System.out.println("Please enter a number");
		}
		scanner.close();

//	Dealing d = new Dealing();
//	d.run();

	}

//	private void run() {
//	Deck deck = new Deck();
//	Scanner scanner = new Scanner(System.in);

}
