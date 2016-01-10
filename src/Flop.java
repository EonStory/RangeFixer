
public class Flop {
	
	//132600 = 52 * 51 * 50
	private static Flop[] allFlops = new Flop[132600];
	
	public Card[] cards;
	public int index;
	
	static {
		int counter = 0;
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				for (int k = 0; k < 52; k++) {
					if (i == j || i == k || j == k) {//skip when two cards are the same
						continue;
					}
					allFlops[counter] = new Flop(Card.getCard(i), Card.getCard(j), Card.getCard(k));
					counter++;
				}
			}
		}
	}
	
	private Flop(Card c1, Card c2, Card c3) {
		this.cards = new Card[]{c1, c2, c3};
		index = c1.index * 51 * 50 + c2.index * 50 + c3.index; 
	}
	
	public Flop getFlop(Card c1, Card c2, Card c3) {
		return allFlops[c1.index * 51 * 50 + c2.index * 50 + c3.index];
	}
}
