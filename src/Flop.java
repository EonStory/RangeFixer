
public class Flop {
	
	//52 choose 3 = 22100
	private static Flop[] allFlops = new Flop[22100];
	
	public Card[] cards;
	public int index;
	
	static {
		int counter = 0;
		for (int i = 0; i < 52; i++) {
			for (int j = i + 1; j < 52; j++) {
				for (int k = j + 1; k < 52; k++) {
					allFlops[counter] = new Flop(Card.getCard(i), Card.getCard(j), Card.getCard(k), counter);
					counter++;
				}
			}
		}
	}
	
	private Flop(Card c1, Card c2, Card c3, int index) {
		this.cards = new Card[]{c1, c2, c3};
		this.index = index;
	}
	
	public static Flop getFlop(Card c1, Card c2, Card c3) {
		return allFlops[c1.index * 51 * 50 + c2.index * 50 + c3.index];
	}
	
	public static Flop getFlop(int index) {
		return allFlops[index];
	}
	
}
