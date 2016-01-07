
public class HoleCards {
	private static HoleCards[] allHoleCards = new HoleCards[1326];
	
	private Card[] cards = new Card[2];
	private int index;
	
	private HoleCards(Card c1, Card c2, int index) {
		
		if (c2.getIndex() <= c1.getIndex()) {
			throw new IllegalArgumentException("second card cant be bigger or equal to first card");
		}
		
		cards[0] = c1;
		cards[1] = c2;
		this.index = index;
	}
	
	static {
		int counter = 0;
		for (int i = 0; i < 52; i++) {
			for (int j = i + 1; j < 52; j++) {				
				allHoleCards[counter] = new HoleCards(Card.getCard(i), Card.getCard(j), counter);
				counter++;
			}
		}
	}
	
	public int getIndex() {
		return index;
	}
	
	public static int getIndex(Card c1, Card c2) {
		if (c1.getIndex() == c2.getIndex()) {
			throw new IllegalArgumentException("cant be the same card! card with index " + c1.getIndex() + " is used twice");
		}
		
		int x;
		int y;
		
		//bigger card always goes second!
		if (c1.getIndex() < c2.getIndex()) {
			x = c1.getIndex();
			y = c2.getIndex();
		}
		else {
			x = c2.getIndex();
			y = c1.getIndex();
		}
		
		//triangular numbers!
		int cardsBefore = 0;
		if(x<=y){
		for (int i = 0; i < x; i++) {
			cardsBefore += 51 - i;
		}
		cardsBefore += y - x - 1;	
		
		return cardsBefore;	
		}
		else{
			for (int i = 0; i < y; i++) {
				cardsBefore += 51 - i;
			}
			cardsBefore += x - y - 1;	
			
			return cardsBefore;	
		}
			
	}
	
	public static HoleCards getHoleCards(Card c1, Card c2) {
		if (c1.getIndex() == c2.getIndex()) {
			throw new IllegalArgumentException("cant be the same card! card with index " + c1.getIndex() + " is used twice");
		}
		
		return allHoleCards[getIndex(c1, c2)];		
	}
	
	public String toString() {
		return cards[0].toString() + cards[1].toString();
	}	
}