	//this is a testing comment
//Expert level analysis by Kreiger(TM)
public class helloworld {
		public static void main(String[] args) {
			//throw new UnsupportedOperationException();
			
			
			for (int i = 0; i < 52; i++) {
				for (int j = i + 1; j < 52; j++) {
					HoleCards bob = HoleCards.getHoleCards(Card.getCard(j), Card.getCard(i));
					System.out.println("i is " + i + ", j is " + j + ", index are " + Card.getCard(i).getIndex() + ", " + Card.getCard(j).getIndex() + ", index is " + bob.getIndex());
				}				
			}
			
		}
}
