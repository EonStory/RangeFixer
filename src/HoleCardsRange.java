import java.util.Random;

public class HoleCardsRange {
	
	private double[] weights;
	private double[] prob;
	private int[] alias;
	private double sum;
	
	Random rng = new Random();	
		
	public HoleCardsRange(double[] weights) {	
		if (weights.length != 1326) {
			throw new IllegalArgumentException("weights must be length 1326, current length is " + weights.length);
		}
		
		double sum = 0;
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] < 0 || weights[i] > 1) {
				throw new IllegalArgumentException("weights x must satisfy 0 <= x <= 1, x for value " + i + " is " + weights[i]);
			}
			sum += weights[i];			
		}
		
		if (sum == 0) {
			throw new IllegalArgumentException("weights must contain at least one non zero weight!");
		}
		this.sum = sum;
		
		this.weights = new double[1326];
		//normalisation, making all weights sum to 1.
		for (int i = 0; i < weights.length; i++) {
			this.weights[i] = weights[i] * (1.0 / sum);
		}		
		
		generateAliasTable();
	}
	
	public double getWeight(HoleCards hc) {
		return weights[hc.index];
	}
	
	public HoleCards getRandomHoleCards() {
		int randomIndex = rng.nextInt(alias.length);
		double randomDouble = rng.nextDouble();
		
		if (randomDouble < prob[randomIndex]) {
			return HoleCards.getHoleCards(randomIndex);
		}
		else {
			return HoleCards.getHoleCards(alias[randomIndex]);
		}		
	}
	
	public void generateAliasTable() {		
		double[] multiplied = new double[1326];
		for (int i = 0; i < multiplied.length; i++){
			multiplied[i] = weights[i] * 1326;
		}
		
		alias = new int[1326];
		for (int i = 0; i < alias.length; i++) {
			alias[i] = -2;
		}
		
		prob = new double[1326];
		
		boolean[] removed = new boolean[1326];
		for (int i = 0; i < removed.length; i++) {
			removed[i] = false;
		}	
		
		for (int h = 0; h < prob.length - 1; h++) {
			//find pl < 1
			double small = -0.3;
			int indexOfSmall = -1;
			for (int i = 0; i < multiplied.length; i++) {		
				if (removed[i] == true) {
					continue;
				}
				if (multiplied[i] <= 1) {
					small = multiplied[i];
					indexOfSmall = i;
					removed[i] = true;
					break;
				}
			}
			
			int indexOfBig = -666;
			for (int i = 0; i < multiplied.length; i++) {	
				if (removed[i] == true) {
					continue;
				}
				if (i == indexOfSmall) {
					continue;
				}
				if (multiplied[i] >= 1) {
					indexOfBig = i;
					break;
				}
			}			
			
			prob[indexOfSmall] = small;
			alias[indexOfSmall] = indexOfBig;
			removed[indexOfSmall] = true;
			multiplied[indexOfBig] = multiplied[indexOfBig] - (1 - multiplied[indexOfSmall]);			
		}		
		
		for (int i = 0; i < removed.length; i++) {
			if (removed[i] == false) {
				prob[i] = 1;
				alias[i] = -66;//alias number is irrelevant because probability of it being used is 0
			}
		}
	}
	
	public String toString() {		
		String s = "";
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] == 0) {
				continue;
			}
			s += HoleCards.getHoleCards(i) + ":" + weights[i] * sum + ",\n";
		}
		return s;
	}
}
