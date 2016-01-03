import java.util.Random;

public class Deck {
	public Card[] cards;
	
	public Random rng = new Random();
	
	public Deck() {
		cards = new Card[52];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Card.getCard(i);
		}
	}
	
	public void shuffle(){
		for (int i = 0; i < 51; i++) {
			int q = rng.nextInt(52 - i);
															
			Card temp = cards[i];
			cards[i] = cards[q];
			cards[q] = temp;
		}
	}
	
	public String toString() {
		String s  = "";
		for (int i = 0; i < cards.length; i++){
			s += cards[i].toString();
			s += " ";
		}
		return s;
	}
}
