
public class HoleCards {
	
	private static HoleCards[] allHoleCards = new HoleCards[1326];
	
	private Card[] cards = new Card[2];
	
	private HoleCards(Card firstCard, Card secondCard) {
		cards[0] = firstCard;
		cards[1] = secondCard;
	}
	
	static {
		int counter = 0;
		for (int i = 0; i < 52; i++) {
			for (int j = i + 1; j < 52; j++) {
				allHoleCards[counter] = new HoleCards(Card.getCard(i), Card.getCard(j));
			}
		}
	}
}
