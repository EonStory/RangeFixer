
public class HoleCards {
	
	//using 2652 instead of 1326 because indexing holecards will be faster this way.
	//computing the address of holecards[x,y] takes far less resources this way
	private static HoleCards[] allHoleCards = new HoleCards[2652];
	
	private Card[] cards = new Card[2];
	private int index;
	
	private HoleCards(Card c1, Card c2) {
		cards[0] = c1;
		cards[1] = c2;
		index = c1.getIndex() * 51 + c2.getIndex();
	}
	
	static {
		int counter = 0;
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				//skip if both cards are the same
				if (i == j) {
					continue;
				}
				allHoleCards[counter] = new HoleCards(Card.getCard(i), Card.getCard(j));
			}
		}
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getIndex(Card c1, Card c2) {		
		return allHoleCards[c1.getIndex() * 51 + c2.getIndex()].index;
	}
	
	public static HoleCards getHoleCards(Card c1, Card c2) {
		return allHoleCards[c1.getIndex() * 51 + c2.getIndex()];
	}
	
	public String toString() {
		return cards[0].toString() + cards[1].toString();
	}
}
