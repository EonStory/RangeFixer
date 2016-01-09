import java.util.Random;

public class MonteCarlo {
	
	public static void runIt(long simulationCount, Range[] foldedRanges, Range activeRange) {
		
		long[] counter = new long[1326];
		long succesfulSimulations = 0;
		
		HoleCards[] randomlySelectedHoleCards = new HoleCards[foldedRanges.length + 1];
		
		Card[] cardsDealt = new Card[foldedRanges.length * 2 + 2];
		
		for (long i = 0; i < simulationCount; i++) {
			randomlySelectedHoleCards[0] = activeRange.getRandomHoleCards();
			for (int j = 1; j < randomlySelectedHoleCards.length; j++) {
				randomlySelectedHoleCards[j] = foldedRanges[j].getRandomHoleCards();
			}
			
			for (int j = 0; j < randomlySelectedHoleCards.length; j++) {
				cardsDealt[j * 2] = randomlySelectedHoleCards[j * 2].cards[0];
				cardsDealt[j * 2 + 1] = randomlySelectedHoleCards[j * 2 + 1].cards[1];
			}
			
			//make this work with cards somehow.
			/*
			if (isCollision(randomlySelectedHoleCards)) {
				continue mainloop;
			}
			*/
			
			counter[randomlySelectedHoleCards[0].getIndex()]++;
			succesfulSimulations++;
		}
	}
	
	//can be optimised more by not comparing cards from within a holecards (they're gauranteed to be different)
	public static boolean isCollision(Card[] cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].index == cards[j].index) {
					return false;
				}
			}
		}
		return true;
	}
}
