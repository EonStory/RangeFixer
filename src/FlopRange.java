import java.util.Random;

public class FlopRange {
	private double[] weights;
	private double[] prob;
	private int[] alias;
	private double sum;
	
	Random rng = new Random();	
		
	public FlopRange(double[] weights) {	
		if (weights.length != Flop.numberOfFlops) {
			throw new IllegalArgumentException("weights must be length 22100, current length is " + weights.length);
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
		
		this.weights = new double[Flop.numberOfFlops];
		//normalisation, making all weights sum to 1.
		for (int i = 0; i < weights.length; i++) {
			this.weights[i] = weights[i] * (1.0 / sum);
		}		
		
		generateAliasTable();
	}
	
	public double getWeight(Flop f) {
		return weights[f.index];
	}
	
	public Flop getRandomFlop() {
		int randomIndex = rng.nextInt(alias.length);
		double randomDouble = rng.nextDouble();
		
		if (randomDouble < prob[randomIndex]) {
			return Flop.getFlop(randomIndex);
		}
		else {
			return Flop.getFlop(alias[randomIndex]);
		}		
	}
	
	public void generateAliasTable() {		
		double[] multiplied = new double[22100];
		for (int i = 0; i < multiplied.length; i++){
			multiplied[i] = weights[i] * 22100;
		}
		
		alias = new int[Flop.numberOfFlops];
		for (int i = 0; i < alias.length; i++) {
			alias[i] = -2;
		}
		
		prob = new double[Flop.numberOfFlops];
		
		boolean[] removed = new boolean[22100];
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
			s += Flop.getFlop(i) + ":" + weights[i] * sum + ",\n";
		}
		return s;
	}
	
	public static FlopRange parse(String range) {
		double[] weights = new double[Flop.numberOfFlops];
		
		
		String[] flops = range.split("[\n]");
		
		for (int i = 0; i < flops.length; i++) {
			
			Card[] cards = new Card[3];
			for (int j = 0; j < 3; j++) {
				cards[j] = Card.getCard(flops[i].substring(i * 2, i * 2 + 1), flops[i].substring(i * 2 + 1, i * 2 + 2));
			}
						
			weights[Flop.indexOf(cards[0], cards[1], cards[2])] = Double.parseDouble(range.substring(1));
		}
		
		return new FlopRange(weights);
	}
}
