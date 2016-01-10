import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Range activeRange = FileParser.reader("range1.txt");
		Range foldedRange1 = FileParser.reader("range2.txt");
		Range foldedRange2 = FileParser.reader("range3.txt");
		Range foldedRange3 = FileParser.reader("range4.txt");
		Range foldedRange4 = FileParser.reader("range5.txt");
		
	
		
		
		Range[] foldedRanges = new Range[4];
		foldedRanges[0] = foldedRange1;
		foldedRanges[1] = foldedRange2;
		foldedRanges[2] = foldedRange3;
		foldedRanges[3] = foldedRange4;
		
		
		Range fixedActiveRange = MonteCarlo.runIt(10000000l, foldedRanges, activeRange);
		
		System.out.println(fixedActiveRange);
	}
}
