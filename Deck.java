import java.util.Arrays;
import java.util.Collections;


public class Deck {

	Card[] cards = new Card[52];
	
	public Deck() {
		for(int color = 0; color < 4; color++) {
			for(int value = 0; value < 13; value++) {
				cards[(color*13)+value] = new Card(new CardColor(color), new CardValue(value));
			}
		}
	}
	
	void shuffle() {
		Collections.shuffle(Arrays.asList(cards));
	}
	
	Card pop() {
		if(this.cardsInDeck() < 1) {
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
		int arrSize = this.cardsInDeck()+1;
		
		Card[] newDeck = new Card[arrSize];
		
		for(int i = 0; i < arrSize; i++) {
			newDeck[i] = this.pop();
		}
		newDeck[arrSize-1] = card;
		
		this.cards = newDeck;
	}
	
	int cardsInDeck() {
		if(cards == null) {
			return 0;
		} else {
			return cards.length;
		}
	}
}
