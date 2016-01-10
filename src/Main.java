import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Range loadedRange = FileParser.reader("range1.txt");
		System.out.println(loadedRange);
	}
}
