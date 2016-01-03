
public class HoleCards {
	
	//using 2652 instead of 1326 because indexing holecards will be faster this way.
	//computing the addres of holecards[x,y] takes far less resources this way
	private static HoleCards[] allHoleCards = new HoleCards[2652];
	
	private Card[] cards = new Card[2];
	
	private HoleCards(Card firstCard, Card secondCard) {
		cards[0] = firstCard;
		cards[1] = secondCard;
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
	
	public String toString() {
		return cards[0].toString() + cards[1].toString();
	}
}
