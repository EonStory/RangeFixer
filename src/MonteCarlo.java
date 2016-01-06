import java.util.Random;

public class MonteCarlo {
	
	public static void runIt(long simulationCount, Range[] foldedRanges, Range activeRange) {
		
		long[] counter = new long[1326];
		long succesfulSimulations = 0;
		
		HoleCards[] randomlySelectedHoleCards = new HoleCards[foldedRanges.length + 1];
		
		mainloop:
		for (long i = 0; i < simulationCount; i++) {
			randomlySelectedHoleCards[0] = activeRange.randomHoleCards();
			for (int j = 1; j < randomlySelectedHoleCards.length; j++) {
				randomlySelectedHoleCards[j] = foldedRanges[j].randomHoleCards();
			}
			
			if (HoleCards.isCollision(randomlySelectedHoleCards)) {
				continue mainloop;
			}
						
			counter[randomlySelectedHoleCards[0].getIndex()]++;
			succesfulSimulations++;
		}
	}
}
