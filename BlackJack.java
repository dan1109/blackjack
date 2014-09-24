import javax.swing.JOptionPane;

public class BlackJack {
	
	Deck d;

	BlackJackHand playerHand = new BlackJackHand();
	BlackJackHand bankHand = new BlackJackHand();

	int playerCardsOnHand = 0;
	int bankCardsOnHand = 0;

	public BlackJack(Deck d) {
		this.d = d;
	}
	
	public String checkWin() {
		if(playerHand.points > 21 && bankHand.points > 21) {			
			return "You and the bank got fat, someone wins!";
		} else if(playerHand.points > 21) {
			return "You got fat, the bank wins!";
		} else if(bankHand.points > 21) {
			return "The bank got fat, you win!";
		} else if(playerHand.points > bankHand.points) {
			return "You have more points than the bank, you win!";
		} else if(playerHand.points == bankHand.points) {
			return "It's a draw, bank automatically wins!";
		} else {
			return "Bank wins!";
		}
	}
	
	public void play() {
		boolean askUser = true;
		for(int i = 0; i < 11; i++) {
			Card newCard = null;
			
			if(bankHand.points <= 17) {
				newCard = d.pop();
				bankHand.getPoints(newCard);
				bankHand.cards[bankCardsOnHand++] = newCard;
			}
			
			while(bankHand.points > 21 && bankHand.nAces > 0) {
				bankHand.points -= 11;
				bankHand.points += 1;
				bankHand.nAces--;
			}

			if(askUser == true) {
				String wantCard = JOptionPane.showInputDialog("Want a card? (y)");
	
				if(wantCard == null) {
					askUser = false;
					wantCard = "";
				}
	
				if(wantCard.equalsIgnoreCase("y")) {
					newCard = d.pop();
					playerHand.getPoints(newCard);

					playerHand.cards[playerCardsOnHand++] = newCard;
					if(playerHand.points > 21) {
						int oldNAces = playerHand.nAces;
						while(playerHand.points > 21 && playerHand.nAces > 0) {
							playerHand.points -= 11;
							playerHand.points += 1;
							playerHand.nAces--;
						}
						if(playerHand.points > 21) {
							askUser = false;
							continue;
						} else {
							JOptionPane.showMessageDialog(null, oldNAces-playerHand.nAces + " aces converted to save you!");
						}
					} else if(playerHand.points == 21) {
						JOptionPane.showMessageDialog(null, "Black Jack!");
					} 
					JOptionPane.showMessageDialog(null, "After drawing a: "+ newCard.returnValue() +", you've got: " + playerHand.points + " points!");
				} else {
					askUser = false;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "You have: " + playerHand.points + " points!");
		JOptionPane.showMessageDialog(null, "Bank has: " + bankHand.points + " points!");
		
		JOptionPane.showMessageDialog(null, checkWin());
		
		System.out.println("Players hand: " + playerHand.points);
		for(int i = 0; i < playerCardsOnHand; i++) {
			System.out.println(playerHand.cards[i].returnValue() + ":" +playerHand.cards[i].returnColor());
		}
		
		System.out.println("\nBanks hand: " + bankHand.points);
		for(int i = 0; i < bankCardsOnHand; i++) {
			System.out.println(bankHand.cards[i].returnValue() + ":" +bankHand.cards[i].returnColor());
		}
	}
}
