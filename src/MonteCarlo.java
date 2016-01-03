import java.util.Random;

public class MonteCarlo {
	
	public static void runIt(int simulationCount, Range[] foldedRanges, Range activeRange) {
		Deck deck = new Deck();
		
		
		Random rng = new Random();
		
		mainloop:
		for (int i = 0; i < simulationCount; i++) {
			deck.shuffle();
			
			//structure of deck is: [folded cards, active cards, flop, unused cards]
			
			//check all folded cards are actually folded		
			for (int j = 0; j < foldedRanges.length; j++) {
				double weightOfHand = foldedRanges[j].getWeight(HoleCards.getHoleCards(deck.cards[j * 2], deck.cards[j * 2 + 1]));
				double q = rng.nextDouble();
				if (q > weightOfHand) {
					continue mainloop;
				}
			}
			
			double weightOfHand = activeRange.getWeight(HoleCards.getHoleCards(deck.cards[foldedRanges.length * 2], deck.cards[foldedRanges.length * 2 + 1]));
			double q = rng.nextDouble();
			if (q > weightOfHand) {
				continue mainloop;
			}
		}
	}
}
