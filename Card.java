
public class Card {
	private CardValue value;
	private CardColor color;
	
	public Card(CardColor color, CardValue value) {
		this.color = color;
		this.value = value;
	}

	public String returnColor() {
		return color.returnColor();
	}

	public String returnValue() {
		return value.returnValue();
	}

	public int returnIntValue() {
		return value.returnIntValue();
	}
}
