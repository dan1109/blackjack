public class BlackJackHand {
	Card[] cards = new Card[11];
	int points = 0;
	int nAces  = 0;

	int getPoints(Card cv) {
		String value = cv.returnValue();
		
		if(value == "Ace") {
			nAces++;
		}
		
		switch (value) {
		case "2": 
			points += 2;
			break;
		case "3": 
			points += 3;
			break;
		case "4": 
			points += 4;
			break;
		case "5": 
			points += 5;
			break;
		case "6": 
			points += 6;
			break;
		case "7": 
			points += 7;
			break;
		case "8": 
			points += 8;
			break;
		case "9": 
			points += 9;
			break;
		case "10": 
			points += 10;
			break;
		case "Jack": 
			points += 10;
			break;
		case "Queen": 
			points += 10;
			break;
		case "King": 
			points += 10;
			break;
		case "Ace": 
			points += 11;
			break;
		}
		
		return 0;
	}

}
