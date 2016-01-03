
public class Card {
	
	private static Card[] allCards = new Card[52];
	
	int rank;
	int suit;
	
	private static String[] rankNames = new String[] {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	private static String[] suitNames = new String[] {"s","h","d","c"};
	
	public String toString() {
		return rankNames[rank] + suitNames[suit];
	}
	
	
	//new cards cannot be constructed outside of this class
	private Card(int rank, int suit) {
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
	
	public static Card getCard(int x) {
		return allCards[x];
	}
}
