
public final class Util {
	
	//private constructor
	private Util() {		
	}
	
	public void generateAliasTable(double[] rawWeightInput) {
		//normalise it
		double[] normalisedInput = new double[rawWeightInput.length];
		
		double sum = 0;
		for (int i = 0; i < rawWeightInput.length; i++) {
			sum += rawWeightInput[i];
		}
		if (sum == 0) {
			throw new IllegalArgumentException("weights must contain at least one non zero weight!");
		}
		for (int i = 0; i < rawWeightInput.length; i++) {
			normalisedInput[i] = rawWeightInput[i] / sum;
		}
		
		
		
		int[] alias = new int[rawWeightInput.length];
		double[] prob = new double[rawWeightInput.length];
		
		double[] multiplied = new double[rawWeightInput.length];
		
		
		
		for (int i = 0; i < multiplied.length; i++){
			multiplied[i] = normalisedInput[i] * rawWeightInput.length;
		}
		
		alias = new int[rawWeightInput.length];
		for (int i = 0; i < alias.length; i++) {
			alias[i] = -2;
		}
		
		prob = new double[rawWeightInput.length];
		
		boolean[] removed = new boolean[rawWeightInput.length];
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
}
