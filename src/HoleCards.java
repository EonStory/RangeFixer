import java.util.Arrays;

public class HoleCards {
	private static HoleCards[] allHoleCards = new HoleCards[1326];
	
	public static final int numberOfHoleCards = 1326;
	
	public Card[] cards = new Card[2];
	public final int index;	
	
	public static int[][] equivs;
	
	private HoleCards(Card c1, Card c2, int index) {
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
		
		equivs = new int[1326][12];
		
		for (int i = 0; i < equivs.length; i++) {
			for (int j = 0; j < equivs[i].length; j++) {
				equivs[i][j] = -1;
			}
		}
		
		Card[][] simple = new Card[1326][];
		for (int i = 0; i < simple.length; i++) {
			Card[] temp = HoleCards.getHoleCards(i).cards;
			temp = Card.cardsSimplified(temp);
			simple[i] = temp;
			
			//System.out.println("simple: " + HoleCards.getHoleCards(i)+ " -> " + simple[i][0] + "" + simple[i][1]);
		}
	
		
		for (int i = 0; i < equivs.length; i++) {
			int index = HoleCards.getHoleCards(simple[i][0], simple[i][1]).index;
			
			//see if its clear to add
			for (int j = 0; j < equivs[index].length; j++) {
				if (equivs[index][j] == -1) {
					equivs[index][j] = i;
					break;
				}
			}			
		}
		
		//clean up equivs
		for (int i = 0; i < equivs.length; i++) {
			//count how many are entered here
			int count = 0;
			for (int j = 0; j < equivs[i].length; j++) {
				if (equivs[i][j] != -1) {
					count++;
				}
			}
			
			int[] temp = new int[count];
			for (int j = 0; j < temp.length; j++) {
				temp[j] = equivs[i][j];
			}
			equivs[i] = temp;
		}
		//make all results go well
		for (int i = 0; i < equivs.length; i++) {
			equivs[i] = equivs[HoleCards.getHoleCards(simple[i][0], simple[i][1]).index];
		}
		
		for (int i = 0; i < equivs.length; i++) {
			//System.out.print(i + ": ");
			for (int j = 0; j < equivs[i].length; j++) {
				//System.out.print(allHoleCards[equivs[i][j]] + ", ");
			}
			//System.out.println();
		}
	}
		
	public static int getIndex(Card c1, Card c2) {
		if (c1.index == c2.index) {
			throw new IllegalArgumentException("cant be the same card! card with index " + c1.index + " is used twice");
		}
				
		//bigger card always goes second!		
		int smallCard = Math.min(c1.index, c2.index);
		int bigCard = Math.max(c1.index, c2.index);
		
		//triangular numbers!
		int cardsBefore = 0;
		for (int i = 0; i < smallCard; i++) {
			cardsBefore += 51 - i;
		}
		cardsBefore += bigCard - smallCard - 1;
		
		return cardsBefore;			
	}
	
	public static int getIndex(Card[] c) {	
		if (c.length != 2) {
			throw new IllegalArgumentException("no! must be length 2");
		}
		return getIndex(c[0], c[1]);			
	}
	
	
	public static HoleCards getHoleCards(Card c1, Card c2) {
		if (c1.index == c2.index) {
			throw new IllegalArgumentException("cant be the same card! card with index " + c1.index + " is used twice");
		}
		
		return allHoleCards[getIndex(c1, c2)];		
	}
		
	
	public static HoleCards getHoleCards(int index) {	
		return allHoleCards[index];		
	}
	
	public String toString() {
		return cards[0].toString() + cards[1].toString();
	}
	
	
}