import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Range activeRange = FileParser.reader("range1.txt");
		Range foldedRange1 = FileParser.reader("range2.txt");
		
		Range[] foldedRanges = new Range[1];
		foldedRanges[0] = foldedRange1;
		
		
		Range fixedActiveRange = MonteCarlo.runIt(10000000l, foldedRanges, activeRange);
		
		System.out.println(fixedActiveRange);
	}
}
