
public class FileParser {
	
	public static double[] reader(String fileName) {
		double[] weights = new double[1326];
		for(int i = 0 ; i<1326 ; i++)
			weights[i] = 0; 
/////////////////////////////////////////////////////////////////////////we convert the string to hand:weight format
		for(int n = 0 ; n<fileName.length() ; ){
			int coma = fileName.indexOf(",",n);
			if (coma != -1 && (fileName.substring(n, coma)).indexOf(":") == -1){
				fileName = fileName.substring(0, coma) + ":1" + fileName.substring(coma);
				n = (fileName.substring(0, coma)).length()+3;
				}
			else if (coma == -1 && fileName.indexOf(":",n) == -1){
				fileName = fileName + ":1";
				n = fileName.length();
			}
			else if (coma != -1 && (fileName.substring(n, coma)).indexOf(":") != -1){
				n = (fileName.substring(0, coma)).length()+1;
			}
			else
				n = fileName.length();
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////
		for(int i = 0 ; i<fileName.length() ;){
			int coma = fileName.indexOf(",",i);
			int colon = fileName.indexOf(":",i);
			if(fileName.substring(0, colon).length() == 2){
				if(fileName.substring(0, 1).equals(fileName.substring(1, 2))){
					int[] index = new int[6];
					index = KK(fileName.substring(0, 1), fileName.substring(1, 2));
					if(coma!=-1){
						for(int j=0 ; j<6 ; j++){
						weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, coma));
					}
					fileName = fileName.substring(coma+1, fileName.length());

					}
					else{
						for(int j=0 ; j<6 ; j++){
							weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						}
						i=fileName.length();
					}
				}
				else {
					int[] index = new int[16]; 
					index = AK(fileName.substring(0, 1), fileName.substring(1, 2));
					if(coma!=-1){
						for(int j=0 ; j<16 ; j++){
						weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, coma));
					}
					fileName = fileName.substring(coma+1, fileName.length());
					}
					else{
						for(int j=0 ; j<16 ; j++){
							weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						}
						i=fileName.length();
					}
				}
			}
			else if(fileName.substring(0, colon).length() == 3){
				if (fileName.substring(2, 3).equals("o")){
					int[] index = new int[12]; 
					index = AKo(fileName.substring(0, 1), fileName.substring(1, 2));
					if(coma!=-1){
						for(int j=0 ; j<12 ; j++){
						weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, coma));
					}
					fileName = fileName.substring(coma+1, fileName.length());
					}
					else{
						for(int j=0 ; j<12 ; j++){
							weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						}
						i=fileName.length();
					}
				}
				else if (fileName.substring(2, 3).equals("s")){
					int[] index = new int[4]; 
					index = AKs(fileName.substring(0, 1), fileName.substring(1, 2));
					if(coma!=-1){
						for(int j=0 ; j<4 ; j++){
						weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, coma));
					}
					fileName = fileName.substring(coma+1, fileName.length());
					}
					else{
						for(int j=0 ; j<4 ; j++){
							weights[index[j]] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						}
						i=fileName.length();
					}
				}
				else
					if(coma!=-1)
						fileName = fileName.substring(coma+1, fileName.length());
					else
						i=fileName.length();
			}
			else if(fileName.substring(0, colon).length() == 4){
				Card card1 = Card.getCard(fileName.substring(0, 1), fileName.substring(1, 2));
				Card card2 = Card.getCard(fileName.substring(2, 3), fileName.substring(3, 4));
				if(coma!=-1){
					weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(fileName.substring(colon+1, coma));
					fileName = fileName.substring(coma+1, fileName.length());
				}
				else{
					weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					i=fileName.length();
				}

			}
			else
				if(coma!=-1)
					fileName = fileName.substring(coma+1, fileName.length());
				else
					i=fileName.length();
					
		}
		return weights;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] AK(String card1, String card2) {
		String[] suitNames = new String[] {"s","h","d","c"};
		int counter=0;
		int[] solution = new int[16];
			for(int i=0 ; i<4 ; i++){
				Card card11 = Card.getCard(card1, suitNames[i]);
				for(int j=0 ; j<4 ; j++){
					solution[counter]=HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
					counter++;
				}
			}
			return solution;
		}

	private static int[] KK(String card1, String card2) {
		String[] suitNames = new String[] {"s","h","d","c"};
		int counter=0;
		int[] solution = new int[6];
			for(int i=0 ; i<4 ; i++){
				Card card11 = Card.getCard(card1, suitNames[i]);
				for(int j=i+1 ; j<4 ; j++){
					if (card11 == Card.getCard(card2, suitNames[j])) {
						continue;
					}
					solution[counter]=HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
					counter++;
				}
			}
			return solution;
		}
	
	private static int[] AKo(String card1, String card2) {
		String[] suitNames = new String[] {"s","h","d","c"};
		int counter=0;
		int[] solution = new int[12];
			for(int i=0 ; i<4 ; i++){
				Card card11 = Card.getCard(card1, suitNames[i]);
				for(int j=0 ; j<4 ; j++){
					if (suitNames[i].equals(suitNames[j])) {
						continue;
					}
					solution[counter]=HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
					counter++;
				}
			}
			return solution;
		}
	
	private static int[] AKs(String card1, String card2) {
		
		String[] suitNames = new String[] {"s","h","d","c"};
		int counter=0;
		int[] solution = new int[4];
			for(int i=0 ; i<4 ; i++){
				Card card11 = Card.getCard(card1, suitNames[i]);
				for(int j=0 ; j<4 ; j++){
					if (! (suitNames[i].equals(suitNames[j]))) {
						continue;
					}
					solution[counter]=HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
					counter++;
				}
			}
			return solution;
		}
	}

