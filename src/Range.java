
public class Range {
	
	private double[] weights = new double[1326];
	
	public Range(double[] weights) {
		
		if (weights.length != 1326) {
			throw new IllegalArgumentException("weights must be length 2652, current length is " + weights.length);
		}
		
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] < 0 || weights[i] > 1) {
				throw new IllegalArgumentException("weights x must satisfy 0 <= x <= 1, x for value " + i + " is " + weights[i]);
			}
		}
		this.weights = weights;
		
	}
	
	public double getWeight(HoleCards hc) {
		return weights[hc.getIndex()];
	}
	
	//returns a randomly selected HoleCards
	public HoleCards randomHoleCards() {
		//unfinished!
		throw new UnsupportedOperationException();
		/*
		double[] alias = new double[1326];
		double[] prob = new double[1326];
		
		boolean[] removed = new boolean[1326];
		for (int i = 0; i < removed.length; i++) {
			removed[i] = false;
		}
		
		double[] multiplied = new double[1326];
		for (int i = 0; i < multiplied.length; i++){
			multiplied[i] = weights[i] * 1326;
		}
		
		for (int h = 1; h < weights.length - 1; h++) {
			//find pl < 1
			double small = -0.3;
			int indexOfSmall = -1;
			for (int i = 1; i < multiplied.length; i++) {		
				if (removed[i] == true) {
					continue;
				}
				if (multiplied[i] <= 1) {
					small = multiplied[i];
					indexOfSmall = i;
					break;
				}
			}
			double big = -0.3;
			int indexOfBig = -1;
			for (int i = 1; i < multiplied.length; i++) {	
				if (removed[i] == true) {
					continue;
				}
				if (i == indexOfSmall) {
					continue;
				}
				if (multiplied[i] >= 1) {
					big = multiplied[i];
					indexOfBig = i;
					break;
				}
			}
			
			prob[indexOfSmall] = small;
			alias[indexOfSmall] = indexOfBig;
			removed[indexOfSmall] = true;
			multiplied[indexOfBig] = multiplied[indexOfBig] - (1 - multiplied[indexOfSmall]);
		}		
		*/
		//throw new IllegalArgumentException();
	}
}
