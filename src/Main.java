import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		HoleCardsRange activeRange = FileParser.reader("range1.txt");
		HoleCardsRange foldedRange1 = FileParser.reader("range2.txt");
		HoleCardsRange foldedRange2 = FileParser.reader("range3.txt");
		HoleCardsRange foldedRange3 = FileParser.reader("range4.txt");
		HoleCardsRange foldedRange4 = FileParser.reader("range5.txt");
				
		HoleCardsRange[] foldedRanges = new HoleCardsRange[4];
		foldedRanges[0] = foldedRange1;
		foldedRanges[1] = foldedRange2;
		foldedRanges[2] = foldedRange3;
		foldedRanges[3] = foldedRange4;		
		

		HoleCardsRange fixedActiveRange = MonteCarlo.runIt(10000000l, foldedRanges, activeRange);
		fixedActiveRange.deSuit();
		System.out.println(fixedActiveRange);
		
		
	}
}
