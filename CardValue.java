
public class CardValue {
	private String value;
	private int intValue;
	
	String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	int[] intValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; 					
	
	public CardValue(int index) {
		if(index >= values.length || index < 0) {
			System.out.println("Card value out of bounds");
		} else {
			value		= values[index];
			intValue	= intValues[index];
		}
	}
	
	public String returnValue() {
		return value;
	}
	
	public int returnIntValue() {
		return intValue;
	}
}
