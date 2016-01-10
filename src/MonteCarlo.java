
public class MonteCarlo {
	
	public static Range runIt(long simulationCount, Range[] foldedRanges, Range activeRange) {
		
		long[] counter = new long[1326];
		long succesfulSimulations = 0;
		
		HoleCards[] randomlySelectedHoleCards = new HoleCards[foldedRanges.length + 1];
		
		Card[] cardsDealt = new Card[randomlySelectedHoleCards.length * 2];
			
		for (long i = 0; i < simulationCount; i++) {
			
			randomlySelectedHoleCards[0] = activeRange.getRandomHoleCards();
						
			for (int j = 1; j < randomlySelectedHoleCards.length; j++) {
				randomlySelectedHoleCards[j] = foldedRanges[j - 1].getRandomHoleCards();
				//System.out.println(i + "??? " + j + ", " + randomlySelectedHoleCards[j]);
			}
						
			for (int j = 0; j < randomlySelectedHoleCards.length; j++) {
				cardsDealt[j * 2] =     randomlySelectedHoleCards[j].cards[0];
				cardsDealt[j * 2 + 1] = randomlySelectedHoleCards[j].cards[1];
			}	
			
			if (isCollision(cardsDealt) == false) {
				counter[randomlySelectedHoleCards[0].getIndex()]++;
				succesfulSimulations++;
			}			
		}
				
		//convert from long back to double
		double[] fixedRange = new double[1326];
		double max = 0;
		for (int i = 0; i < 1326; i++) {
			fixedRange[i] = counter[i] / ((double) succesfulSimulations);
			if (fixedRange[i] > max) {
				max = fixedRange[i];
			}
		}
		//normalise it, so the most common hand has weight 1
		for (int i = 0; i < 1326; i++) {
			fixedRange[i] = fixedRange[i] * (1.0 / max);
		}		
		
		return new Range(fixedRange);		
	}
	
	//can be optimised more by not comparing cards from within a holecards (they're guaranteed to be different)
	public static boolean isCollision(Card[] cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].index == cards[j].index) {
					return true;
				}
			}
		}
		return false;
	}
}
