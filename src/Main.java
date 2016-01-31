import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		HoleCardsRange activeRange = FileParser.reader("range1.txt");
		HoleCardsRange foldedRange1 = FileParser.reader("range2.txt");
		HoleCardsRange foldedRange2 = FileParser.reader("range3.txt");
		HoleCardsRange foldedRange3 = FileParser.reader("range4.txt");
		HoleCardsRange foldedRange4 = FileParser.reader("range5.txt");
		
		HoleCardsRange foldedRange5 = FileParser.reader("range6.txt");
		HoleCardsRange foldedRange6 = FileParser.reader("range7.txt");
		HoleCardsRange foldedRange7 = FileParser.reader("range8.txt");
		
		
		
		
		
				
		HoleCardsRange[] foldedRanges = new HoleCardsRange[7];
		foldedRanges[0] = foldedRange1;
		foldedRanges[1] = foldedRange2;
		foldedRanges[2] = foldedRange3;
		foldedRanges[3] = foldedRange4;		
		
		foldedRanges[4] = foldedRange5;
		foldedRanges[5] = foldedRange6;
		foldedRanges[6] = foldedRange7;		
		

		HoleCardsRange fixedActiveRange = MonteCarlo.runHoleCards(1000000000l, foldedRanges, activeRange);
		fixedActiveRange.deSuit();
		System.out.println(fixedActiveRange);
		//combinadics are simple
		
	}
}
