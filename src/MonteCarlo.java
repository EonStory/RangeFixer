import java.util.Random;

public class MonteCarlo {
	
	public static void runIt(long simulationCount, Range[] foldedRanges, Range activeRange) {
		Deck deck = new Deck();
		
		long[] counter = new long[2652];
		long succesfulSimulations = 0;
		
		Random rng = new Random();
		
		
		mainloop:
		for (long i = 0; i < simulationCount; i++) {
			deck.shuffle();
			
			//structure of deck is: [folded cards, active cards, flop, unused cards]
			
			//check all folded cards are actually folded		
			for (int j = 0; j < foldedRanges.length; j++) {
				HoleCards hc = HoleCards.getHoleCards(deck.cards[j * 2], deck.cards[j * 2 + 1]);
				double weightOfHand = foldedRanges[j].getWeight(hc);
				double q = rng.nextDouble();
				if (q > weightOfHand) {
					continue mainloop;
				}
			}
			
			//check activehand is active
			HoleCards hc = HoleCards.getHoleCards(deck.cards[foldedRanges.length * 2], deck.cards[foldedRanges.length * 2 + 1]);
			double weightOfHand = activeRange.getWeight(hc);
			double q = rng.nextDouble();
			if (q > weightOfHand) {
				continue mainloop;
			}
			
			counter[HoleCards.getIndex(deck.cards[foldedRanges.length * 2], deck.cards[foldedRanges.length * 2 + 1])]++;
			succesfulSimulations++;
		}
	}
}
