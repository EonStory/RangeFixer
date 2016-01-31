
public class Flop {
	
	//52 choose 3 = 22100
	public static Flop[] allFlops = new Flop[22100];
	
	public Card[] cards;
	public final int index;
	public static final int numberOfFlops = 22100;
	
	
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
		return allFlops[Util.combinadic(new int[] {c1.index, c2.index, c3.index})];
	}
	
	public static int indexOf(Card c1, Card c2, Card c3) {
		return Util.combinadic(new int[] {c1.index, c2.index, c3.index});
	}	
	
	public static Flop getFlop(int index) {
		return allFlops[index];
	}
	
	public String toString() {
		return cards[0].toString() + cards[1].toString() + cards[2].toString();
	}
	
}
