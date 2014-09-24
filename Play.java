class Play {

	public static void main(String args[]) {
		Deck d = new Deck();

		d.shuffle();

		// svältTheFox stf = new svältTheFox(d);
		// stf.play();
		BlackJack blackJack = new BlackJack(d);
		blackJack.play();


	}
}

class svältTheFox {
	Deck d;

	svältTheFox(Deck d) {
		d.shuffle();
		this.d = d;
	}


	public void play() {

		STFHand p1 = new STFHand(d);
		STFHand p2 = new STFHand(d);

		//Two decks
		//First player begins
		//Then computer tries to win that card
		//If computer wins -> he/she takes pile
		//If you win -> you take pile
		//Else he serves the next card
		Deck deckOnTable = new Deck();
		deckOnTable.cards = null;

		while(p1.cardsInDeck() != 0 && p2.cardsInDeck() != 0) {
			Card playerCard		= p1.pop();
			Card computerCard	= p2.pop();

			System.out.println(playerCard.returnColor());
			System.out.println(computerCard.returnColor());

			if(playerCard.returnColor() == computerCard.returnColor()) {
				if(playerCard.returnIntValue() > computerCard.returnIntValue()) {
					p1.push(deckOnTable);
					deckOnTable.cards = null;
				} else if(computerCard.returnIntValue() > playerCard.returnIntValue()) {
					p2.push(deckOnTable);
					deckOnTable.cards = null;
				}
			} else {
				deckOnTable.push(playerCard);
				deckOnTable.push(computerCard);
			}
		}
	}
}

class STFHand {
	Card[] cards = new Card[26];

	STFHand(Deck d) {
		for(int i = 0; i < cards.length; i++) {
			cards[i] = d.pop();
		}
	}

	Card pop() {
		if(cards.length < 1) {
			System.out.println("Can not pop from an empty array");
			return null;
		}

		int arrSize = cards.length-1;
		Card returnedCard = cards[arrSize];
		Card[] tmp = new Card[arrSize];

		for(int i = 0; i < arrSize; i++) {
			tmp[i] = cards[i];
		}

		cards = tmp;
		return returnedCard;
	}

	void push(Card card) {
		int arrSize = this.cardsInDeck();
		Card[] newHand = new Card[arrSize];

		for(int i = 0; i < arrSize; i++) {
			newHand[i] = cards[i];
		}
		newHand[arrSize-1] = card;
	}

	void push(Deck d) {
		int arrSize = this.cardsInDeck()+d.cardsInDeck();

		Card[] newHand = new Card[arrSize];

		int i = 0;
		for(; i < cards.length; i++) {
			newHand[i] = cards[i];
		}

		for(int j = 0; j < d.cardsInDeck(); j++) {
			newHand[i+j] = d.pop();
		}
	}

	int cardsInDeck() {
		return cards.length;
	}
}
