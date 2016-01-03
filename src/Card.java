
public class Card {
	
	public static Card[] allCards = new Card[52];
	
	int rank;
	int suit;
	
	public static String[] rankNames = new String[] {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	public static String[] suitNames = new String[] {"s","h","d","c"};
	
	public String toString() {
		return rankNames[rank] + suitNames[suit];
	}
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	//create all cards
	static {		
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				allCards[counter] = new Card(j, i);
				counter++;
			}
		}
	}
}
