import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Range activeRange = FileParser.reader("range1.txt");
		Range foldedRange1 = FileParser.reader("range2.txt");
		Range foldedRange2 = FileParser.reader("range3.txt");
		
		System.out.println("*** printing first *** ");
		System.out.println(foldedRange1);
		System.out.println("*** printing second *** ");
		System.out.println(foldedRange2);
		
		
		Range[] foldedRanges = new Range[2];
		foldedRanges[0] = foldedRange1;
		foldedRanges[1] = foldedRange2;
		
		
		Range fixedActiveRange = MonteCarlo.runIt(100000000l, foldedRanges, activeRange);
		
		System.out.println(fixedActiveRange);
	}
}
