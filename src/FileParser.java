import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {

	public static Range reader(String fileName) throws IOException {
		BufferedReader readFile = new BufferedReader(new FileReader(fileName));
		String range = readFile.readLine();
		readFile.close();
		double[] weights = new double[1326];
		for (int i = 0; i < 1326; i++)
			weights[i] = 0;
		///////////////////////////////////////////////////////////////////////// we
		///////////////////////////////////////////////////////////////////////// convert
		///////////////////////////////////////////////////////////////////////// the
		///////////////////////////////////////////////////////////////////////// string
		///////////////////////////////////////////////////////////////////////// to
		///////////////////////////////////////////////////////////////////////// hand:weight
		///////////////////////////////////////////////////////////////////////// format
		for (int n = 0; n < range.length();) {
			int coma = range.indexOf(",", n);
			if (coma != -1 && (range.substring(n, coma)).indexOf(":") == -1) {
				range = range.substring(0, coma) + ":1" + range.substring(coma);
				n = (range.substring(0, coma)).length() + 3;
			} else if (coma == -1 && range.indexOf(":", n) == -1) {
				range = range + ":1";
				n = range.length();
			} else if (coma != -1 && (range.substring(n, coma)).indexOf(":") != -1) {
				n = (range.substring(0, coma)).length() + 1;
			} else
				n = range.length();
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < range.length();) {
			int coma = range.indexOf(",", i);
			int colon = range.indexOf(":", i);
			if (range.substring(0, colon).length() == 2) {
				if (range.substring(0, 1).equals(range.substring(1, 2))) {
					int[] index = new int[6];
					index = KK(range.substring(0, 1), range.substring(1, 2));
					if (coma != -1) {
						for (int j = 0; j < 6; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, coma));
						}
						range = range.substring(coma + 1, range.length());

					} else {
						for (int j = 0; j < 6; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, range.length()));
						}
						i = range.length();
					}
				} else {
					int[] index = new int[16];
					index = AK(range.substring(0, 1), range.substring(1, 2));
					if (coma != -1) {
						for (int j = 0; j < 16; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, coma));
						}
						range = range.substring(coma + 1, range.length());
					} else {
						for (int j = 0; j < 16; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, range.length()));
						}
						i = range.length();
					}
				}
			} else if (range.substring(0, colon).length() == 3) {
				if (range.substring(2, 3).equals("o")) {
					int[] index = new int[12];
					index = AKo(range.substring(0, 1), range.substring(1, 2));
					if (coma != -1) {
						for (int j = 0; j < 12; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, coma));
						}
						range = range.substring(coma + 1, range.length());
					} else {
						for (int j = 0; j < 12; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, range.length()));
						}
						i = range.length();
					}
				} else if (range.substring(2, 3).equals("s")) {
					int[] index = new int[4];
					index = AKs(range.substring(0, 1), range.substring(1, 2));
					if (coma != -1) {
						for (int j = 0; j < 4; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, coma));
						}
						range = range.substring(coma + 1, range.length());
					} else {
						for (int j = 0; j < 4; j++) {
							weights[index[j]] = Double.parseDouble(range.substring(colon + 1, range.length()));
						}
						i = range.length();
					}
				} else if (coma != -1)
					range = range.substring(coma + 1, range.length());
				else
					i = range.length();
			} else if (range.substring(0, colon).length() == 4) {
				Card card1 = Card.getCard(range.substring(0, 1), range.substring(1, 2));
				Card card2 = Card.getCard(range.substring(2, 3), range.substring(3, 4));
				if (coma != -1) {
					weights[HoleCards.getIndex(card1, card2)] = Double.parseDouble(range.substring(colon + 1, coma));
					range = range.substring(coma + 1, range.length());
				} else {
					weights[HoleCards.getIndex(card1, card2)] = Double
							.parseDouble(range.substring(colon + 1, range.length()));
					i = range.length();
				}

			} else if (coma != -1)
				range = range.substring(coma + 1, range.length());
			else
				i = range.length();

		}

		return new Range(weights);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static int[] AK(String card1, String card2) {
		String[] suitNames = new String[] { "s", "h", "d", "c" };
		int counter = 0;
		int[] solution = new int[16];
		for (int i = 0; i < 4; i++) {
			Card card11 = Card.getCard(card1, suitNames[i]);
			for (int j = 0; j < 4; j++) {
				solution[counter] = HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
				counter++;
			}
		}
		return solution;
	}

	private static int[] KK(String card1, String card2) {
		String[] suitNames = new String[] { "s", "h", "d", "c" };
		int counter = 0;
		int[] solution = new int[6];
		for (int i = 0; i < 4; i++) {
			Card card11 = Card.getCard(card1, suitNames[i]);
			for (int j = i + 1; j < 4; j++) {
				if (card11 == Card.getCard(card2, suitNames[j])) {
					continue;
				}
				solution[counter] = HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
				counter++;
			}
		}
		return solution;
	}

	private static int[] AKo(String card1, String card2) {
		String[] suitNames = new String[] { "s", "h", "d", "c" };
		int counter = 0;
		int[] solution = new int[12];
		for (int i = 0; i < 4; i++) {
			Card card11 = Card.getCard(card1, suitNames[i]);
			for (int j = 0; j < 4; j++) {
				if (suitNames[i].equals(suitNames[j])) {
					continue;
				}
				solution[counter] = HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
				counter++;
			}
		}
		return solution;
	}

	private static int[] AKs(String card1, String card2) {

		String[] suitNames = new String[] { "s", "h", "d", "c" };
		int counter = 0;
		int[] solution = new int[4];
		for (int i = 0; i < 4; i++) {
			Card card11 = Card.getCard(card1, suitNames[i]);
			for (int j = 0; j < 4; j++) {
				if (!(suitNames[i].equals(suitNames[j]))) {
					continue;
				}
				solution[counter] = HoleCards.getIndex(card11, Card.getCard(card2, suitNames[j]));
				counter++;
			}
		}
		return solution;
	}
}
