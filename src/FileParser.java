
public class FileParser {

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

	
	public static Range reader(String fileName) {
		double[] weights = new double[2652];
		for(int i = 0 ; i<2652 ; i++)
			weights[i] = 0;
		for(int i = 0 ; i<fileName.length() ; ){
			int coma = fileName.indexOf(",",i);
			int colon = fileName.indexOf(":",i);
			if (colon == -1 && coma == -1 && fileName.length() > 0){
				if(fileName.length() == 2){
					Card card1 = Card.getCard(fileName.substring(0, 1), "h");
					Card card11 = Card.getCard(fileName.substring(0, 1), "d");
					Card card111 = Card.getCard(fileName.substring(0, 1), "c");
					Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
					Card card2 = Card.getCard(fileName.substring(1, 2), "h");
					Card card22 = Card.getCard(fileName.substring(1, 2), "d");
					Card card222 = Card.getCard(fileName.substring(1, 2), "c");
					Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
					weights[HoleCards.getIndex(card1, card2)] = 1;
					weights[HoleCards.getIndex(card1, card22)] = 1;
					weights[HoleCards.getIndex(card1, card222)] = 1;
					weights[HoleCards.getIndex(card1, card2222)] = 1;
					weights[HoleCards.getIndex(card11, card2)] = 1;
					weights[HoleCards.getIndex(card11, card22)] = 1;
					weights[HoleCards.getIndex(card11, card222)] = 1;
					weights[HoleCards.getIndex(card11, card2222)] = 1;
					weights[HoleCards.getIndex(card111, card2)] = 1;
					weights[HoleCards.getIndex(card111, card22)] = 1;
					weights[HoleCards.getIndex(card111, card222)] = 1;
					weights[HoleCards.getIndex(card111, card2222)] = 1;
					weights[HoleCards.getIndex(card1111, card2)] = 1;
					weights[HoleCards.getIndex(card1111, card22)] = 1;
					weights[HoleCards.getIndex(card1111, card222)] = 1;
					weights[HoleCards.getIndex(card1111, card2222)] = 1;
					
					//alternate code
					/*
					Card[] firstCard = getAllCardsOfThisRank(fileName.substring(0, 1));
					Card[] secondCard = getAllCardsOfThisRank(fileName.substring(1, 2));
					for (int j = 0; j < 4; j++) {
						for (int k = j + 1; k < 4; k++) {
							weights[HoleCards.getIndex(firstCard[i], secondCard[i])] = 1;
						}
					}
					*/
					
					i=fileName.length();
				}
				else if(fileName.length() == 3){
					if (fileName.substring(2, 3).equals("o")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card22)] = 1;
						weights[HoleCards.getIndex(card1, card222)] = 1;
						weights[HoleCards.getIndex(card1, card2222)] = 1;
						weights[HoleCards.getIndex(card11, card2)] = 1;
						weights[HoleCards.getIndex(card11, card222)] = 1;
						weights[HoleCards.getIndex(card11, card2222)] = 1;
						weights[HoleCards.getIndex(card111, card2)] = 1;
						weights[HoleCards.getIndex(card111, card22)] = 1;
						weights[HoleCards.getIndex(card111, card2222)] = 1;
						weights[HoleCards.getIndex(card1111, card2)] = 1;
						weights[HoleCards.getIndex(card1111, card22)] = 1;
						weights[HoleCards.getIndex(card1111, card222)] = 1;
						i=fileName.length();
					}
					else if (fileName.substring(2, 3).equals("s")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card2)] = 1;
						weights[HoleCards.getIndex(card11, card22)] = 1;
						weights[HoleCards.getIndex(card111, card222)] = 1;
						weights[HoleCards.getIndex(card1111, card2222)] = 1;
						i=fileName.length();
					}
					else
						i=fileName.length();
				}
				else if(fileName.length() == 4){
					Card card1 = Card.getCard(fileName.substring(0, 1), fileName.substring(1, 2));
					Card card2 = Card.getCard(fileName.substring(2, 3), fileName.substring(3, 4));
					weights[HoleCards.getIndex(card1, card2)] = 1;
					i=fileName.length();
				}
				else
					i=fileName.length();
			}
			
			if (colon != -1 && coma == -1 && fileName.length() > 0){

				if((fileName.substring(0, colon)).length() == 2){
					Card card1 = Card.getCard(fileName.substring(0, 1), "h");
					Card card11 = Card.getCard(fileName.substring(0, 1), "d");
					Card card111 = Card.getCard(fileName.substring(0, 1), "c");
					Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
					Card card2 = Card.getCard(fileName.substring(1, 2), "h");
					Card card22 = Card.getCard(fileName.substring(1, 2), "d");
					Card card222 = Card.getCard(fileName.substring(1, 2), "c");
					Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
					weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card11, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card11, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card11, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card11, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card111, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card111, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card111, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card111, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1111, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1111, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1111, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					weights[HoleCards.getIndex(card1111, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					i=fileName.length();
				}
				else if((fileName.substring(0, colon)).length() == 3){
					if (fileName.substring(2, 3).equals("o")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card11, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card11, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card11, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card111, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card111, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card111, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1111, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1111, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1111, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						i=fileName.length();
					}
					else if (fileName.substring(2, 3).equals("s")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card11, card22)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card111, card222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						weights[HoleCards.getIndex(card1111, card2222)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
						i=fileName.length();
					}
					else
						i=fileName.length();
				}
				else if((fileName.substring(0, colon)).length() == 4){
					Card card1 = Card.getCard(fileName.substring(0, 1), fileName.substring(1, 2));
					Card card2 = Card.getCard(fileName.substring(2, 3), fileName.substring(3, 4));
					weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(fileName.substring(colon+1, fileName.length()));
					i=fileName.length();
				}
				else
					i=fileName.length();
			}

			if (colon == -1 && coma != -1 && fileName.length() > 0){
				if(fileName.length() == 2){
					Card card1 = Card.getCard(fileName.substring(0, 1), "h");
					Card card11 = Card.getCard(fileName.substring(0, 1), "d");
					Card card111 = Card.getCard(fileName.substring(0, 1), "c");
					Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
					Card card2 = Card.getCard(fileName.substring(1, 2), "h");
					Card card22 = Card.getCard(fileName.substring(1, 2), "d");
					Card card222 = Card.getCard(fileName.substring(1, 2), "c");
					Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
					weights[HoleCards.getIndex(card1, card2)] = 1;
					weights[HoleCards.getIndex(card1, card22)] = 1;
					weights[HoleCards.getIndex(card1, card222)] = 1;
					weights[HoleCards.getIndex(card1, card2222)] = 1;
					weights[HoleCards.getIndex(card11, card2)] = 1;
					weights[HoleCards.getIndex(card11, card22)] = 1;
					weights[HoleCards.getIndex(card11, card222)] = 1;
					weights[HoleCards.getIndex(card11, card2222)] = 1;
					weights[HoleCards.getIndex(card111, card2)] = 1;
					weights[HoleCards.getIndex(card111, card22)] = 1;
					weights[HoleCards.getIndex(card111, card222)] = 1;
					weights[HoleCards.getIndex(card111, card2222)] = 1;
					weights[HoleCards.getIndex(card1111, card2)] = 1;
					weights[HoleCards.getIndex(card1111, card22)] = 1;
					weights[HoleCards.getIndex(card1111, card222)] = 1;
					weights[HoleCards.getIndex(card1111, card2222)] = 1;
					i=fileName.length();
				}
				else if(fileName.length() == 3){
					if (fileName.substring(2, 3).equals("o")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card22)] = 1;
						weights[HoleCards.getIndex(card1, card222)] = 1;
						weights[HoleCards.getIndex(card1, card2222)] = 1;
						weights[HoleCards.getIndex(card11, card2)] = 1;
						weights[HoleCards.getIndex(card11, card222)] = 1;
						weights[HoleCards.getIndex(card11, card2222)] = 1;
						weights[HoleCards.getIndex(card111, card2)] = 1;
						weights[HoleCards.getIndex(card111, card22)] = 1;
						weights[HoleCards.getIndex(card111, card2222)] = 1;
						weights[HoleCards.getIndex(card1111, card2)] = 1;
						weights[HoleCards.getIndex(card1111, card22)] = 1;
						weights[HoleCards.getIndex(card1111, card222)] = 1;
						i=fileName.length();
					}
					else if (fileName.substring(2, 3).equals("s")){
						Card card1 = Card.getCard(fileName.substring(0, 1), "h");
						Card card11 = Card.getCard(fileName.substring(0, 1), "d");
						Card card111 = Card.getCard(fileName.substring(0, 1), "c");
						Card card1111 = Card.getCard(fileName.substring(0, 1), "s");
						Card card2 = Card.getCard(fileName.substring(1, 2), "h");
						Card card22 = Card.getCard(fileName.substring(1, 2), "d");
						Card card222 = Card.getCard(fileName.substring(1, 2), "c");
						Card card2222 = Card.getCard(fileName.substring(1, 2), "s");
						weights[HoleCards.getIndex(card1, card2)] = 1;
						weights[HoleCards.getIndex(card11, card22)] = 1;
						weights[HoleCards.getIndex(card111, card222)] = 1;
						weights[HoleCards.getIndex(card1111, card2222)] = 1;
						i=fileName.length();
					}
					else
						i=fileName.length();
				}
				else if(fileName.length() == 4){
					Card card1 = Card.getCard(fileName.substring(0, 1), fileName.substring(1, 2));
					Card card2 = Card.getCard(fileName.substring(2, 3), fileName.substring(3, 4));
					weights[HoleCards.getIndex(card1, card2)] = 1;
					i=fileName.length();
				}
				else
					i=fileName.length();
				
			}
			if (colon != -1 && coma != -1 && fileName.length() > 0){
				
			}
				
		}	
		
		Range r = new Range(weights);
		return r;
	}
	
	public static Card[] getAllCardsOfThisRank(String cardString) {
		Card[] cardInAllSuits = new Card[4];
		cardInAllSuits[0] = Card.getCard(cardString, "h");
		cardInAllSuits[1] = Card.getCard(cardString, "d");
		cardInAllSuits[2] = Card.getCard(cardString, "c");
		cardInAllSuits[3] = Card.getCard(cardString, "s");
		return cardInAllSuits;
	}
	
	
	
	public static void main(String[] args) {
		FileParser f = new FileParser();
		Card a = Card.getCard(0);
		Card b = Card.getCard(1);
		HoleCards h = HoleCards.getHoleCards(a,b);
		String nl = "0.7";		
		String n = nl.substring(0,1);
		double aDouble = Double.parseDouble(nl);
		for(int i=0;i<16;i++)
		System.out.println(""+HoleCards.getIndex(a, b));
		
	}
}


/////////////public static Card getCard(int x) {
////////////	return allCards[x];
////////////   }

//		public static int getIndex(Card c1, Card c2) {		
//return allHoleCards[c1.getIndex() * 51 + c2.getIndex()].index;




//	public static Card getCard(String rank, String suit) {