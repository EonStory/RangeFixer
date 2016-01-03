
public class WeightMatrix {
	public double[][] weights;
	
	public WeightMatrix() {
		weights = new double[52][52];
	}
	
	public void addHand(int card0, int card1, double weight) {
		weights[card0][card1] = weight;
	}
}
