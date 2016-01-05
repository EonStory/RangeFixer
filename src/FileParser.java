
public class FileParser {

	public static Range reader(String fileName) {
		double[] weights = new double[2652];
		for(int i = 0 ; i<2652 ; i++)
			weights[i] = 0;
		for(int i = 0 ; i<fileName.length() ; ){
			int coma = fileName.indexOf(",",i);
			int colon = fileName.indexOf(":",i);
			if (colon == -1 && coma == -1 && fileName.length() > 0){
				if(fileName.length() == 2){
					
				}
				else if(fileName.length() == 3){
					
				}
				else if(fileName.length() == 4){
					Card card1 = Card.getCard(fileName.substring(0, 1), fileName.substring(1, 2));
					Card card2 = Card.getCard(fileName.substring(2, 3), fileName.substring(3, 4));
					int index = HoleCards.getIndex(card1, card2);
					weights[index] = 1;
					i=fileName.length();
				}
				else
					i=fileName.length();
			}
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Range r = new Range(weights);
		return r;
	}
	
	
	
	
	
	public static void main(String[] args) {
		FileParser f = new FileParser();
		Range r = f.reader("AhAd");
		Card a = Card.getCard(1);
		Card b = Card.getCard(2);
		HoleCards h = HoleCards.getHoleCards(a,b);
		String nl = "HEllo World";
		String n = nl.substring(1, 4);		
		System.out.println(n.indexOf(":",0));
		
	}
}


/////////////public static Card getCard(int x) {
////////////	return allCards[x];
////////////   }

//		public static int getIndex(Card c1, Card c2) {		
//return allHoleCards[c1.getIndex() * 51 + c2.getIndex()].index;




//	public static Card getCard(String rank, String suit) {