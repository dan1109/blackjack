
public class CardColor {

	private String color;
	String[] colors = {"Spades", "Hearts", "Diamonds", "Clubs"};

	public CardColor(int index) {
		if(index >= colors.length || index < 0) {
			System.out.println("Card color out of bounds");
		} else {
			color = colors[index];
		}
	}
	
	public String returnColor() {
		return color;
	}
}
