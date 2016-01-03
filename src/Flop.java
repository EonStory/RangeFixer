
public class Flop {
	
	//132600 = 52 * 51 * 50
	private static Flop[] allFlops = new Flop[132600];
	
	public Card[] cards;
	
	private Flop(Card c1, Card c2, Card c3) {
		this.cards = new Card[]{c1, c2, c3};
	}
}
