
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
		throw new IllegalArgumentException();
	}
}
