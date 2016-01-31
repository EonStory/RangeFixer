
public class MonteCarlo {
	
	public static HoleCardsRange runHoleCards(long simulationCount, HoleCardsRange[] foldedRanges, HoleCardsRange activeRange) {
		
		long[] counter = new long[HoleCards.numberOfHoleCards];
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
				counter[randomlySelectedHoleCards[0].index]++;
				succesfulSimulations++;
			}			
		}
				
		//convert from long back to double
		double[] fixedRange = new double[HoleCards.numberOfHoleCards];
		double max = 0;
		for (int i = 0; i < HoleCards.numberOfHoleCards; i++) {
			fixedRange[i] = counter[i] / ((double) succesfulSimulations);
			if (fixedRange[i] > max) {
				max = fixedRange[i];
			}
		}
		//normalise it, so the most common hand has weight 1
		for (int i = 0; i < HoleCards.numberOfHoleCards; i++) {
			fixedRange[i] = fixedRange[i] * (1.0 / max);
		}		
		
		return new HoleCardsRange(fixedRange);		
	}
	
	
	public static FlopRange runFlop(long simulationCount, HoleCardsRange[] foldedRanges, FlopRange flopList) {
		
		long[] counter = new long[Flop.numberOfFlops];
		long succesfulSimulations = 0;
		
		Flop bobby;
		
		HoleCards[] randomlySelectedHoleCards = new HoleCards[foldedRanges.length];
		
		Card[] cardsDealt = new Card[foldedRanges.length * 2 + 3];
			
		for (long i = 0; i < simulationCount; i++) {
			
			bobby = flopList.getRandomFlop();
			cardsDealt[0] = bobby.cards[0];
			cardsDealt[1] = bobby.cards[1];
			cardsDealt[2] = bobby.cards[2];			
			
			for (int j = 0; j < randomlySelectedHoleCards.length; j++) {
				randomlySelectedHoleCards[j] = foldedRanges[j].getRandomHoleCards();
				cardsDealt[3 + j * 2] = 	randomlySelectedHoleCards[j].cards[0];
				cardsDealt[3 + j * 2 + 1] = randomlySelectedHoleCards[j].cards[1];
			}			
			
			if (isCollision(cardsDealt) == false) {
				counter[bobby.index]++;
				succesfulSimulations++;
			}			
		}
				
		//convert from long back to double
		double[] fixedRange = new double[Flop.numberOfFlops];
		double max = 0;
		for (int i = 0; i < Flop.numberOfFlops; i++) {
			fixedRange[i] = counter[i] / ((double) succesfulSimulations);
			if (fixedRange[i] > max) {
				max = fixedRange[i];
			}
		}
		//normalise it, so the most common hand has weight 1
		for (int i = 0; i < Flop.numberOfFlops; i++) {
			fixedRange[i] = fixedRange[i] * (1.0 / max);
		}		
		
		return new FlopRange(fixedRange);		
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
