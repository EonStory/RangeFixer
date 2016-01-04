
public class FileParser {
	
	public static Range reader(String fileName) {
		double[] w = new double[2652];
		for(int i = 0 ; i<2652 ; i++)
		w[i] = 0;
		Range r = new Range(w);
		return r;
	}
	public static void main(String[] args) {
		FileParser f = new FileParser();
		Range r = f.reader("AhAd");
		for(int i = 0 ; i<2652 ; i++)
		System.out.println(r[i]);
	}
}
