
public class Card {
	
	private static Card[] allCards = new Card[52];
	
	public final int rank;
	public final int suit;
	public final int index;
	
	private static String[] rankNames = new String[] {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	private static String[] suitNames = new String[] {"s","h","d","c"};
	
	public String toString() {
		return rankNames[rank] + suitNames[suit];
	}	
	
	//new cards cannot be constructed outside of this class
	private Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
		index = suit * 13 + rank;
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
	
	public static int getIndex(Card c) {
		return c.index;
	}
	
	public static Card getCard(int x) {
		return allCards[x];
	}
	
	public static boolean sameSuit(Card c1, Card c2) {
		if (c1.suit == c2.suit) {
			return true;
		}
		return false;
	}
	
	public static boolean sameRank(Card c1, Card c2) {
		if (c1.rank == c2.rank) {
			return true;
		}
		return false;
	}
	public static Card getCard(String rank, String suit) {
		int r = -1;
		int s = -1;
		
		for (int i = 0; i < 13; i++) {
			if (rank.equals(rankNames[i])) {
				r = i;
				break;
			}
		}
		
		for (int j = 0; j < 4; j++) {
			if (suit.equals(suitNames[j])) {
				s = j;
				break;
			}
		}
			
		return Card.getCard(s * 13 + r);
	}	
}
