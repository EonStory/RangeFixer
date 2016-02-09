import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class RunListener implements ActionListener {

	//idnex 0 and 1 are OOP and IP
	JTextField[] tfields;
	
	JTextField[] outputFields;
	
	JTextField simCount;
	
	public RunListener(JTextField[] inputFields, JTextField[] outputField, JButton runButton, JTextField simCount) {
		if (inputFields.length != 9) {
			throw new IllegalArgumentException("must be 9 text fields, not " + inputFields.length + "!");
		}
		
		this.tfields = inputFields;
		this.outputFields = outputField;
		this.simCount = simCount;
		runButton.addActionListener(this);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		long numberOfSims = Long.parseLong(simCount.getText());
		
		int foldedRangeCount = 0;
		
		for (int i = 2; i < tfields.length; i++) {
			if (tfields[i].getText().isEmpty() == false) {
				foldedRangeCount++;
			}
		}
		
		HoleCardsRange[] topKek = new HoleCardsRange[foldedRangeCount];
		
		for (int i = 2, foldsSoFar = 0; i < 9; i++) {
			if (tfields[i].getText().isEmpty() == false) {
				System.out.println("its not empty, its_" + tfields[i].getText());
				topKek[foldsSoFar] = HoleCardsRange.parse(tfields[i].getText());
				foldsSoFar++;
			}			
		}
		
		String outputField1 = "";
		String outputField2 = "";
		
		//run for 1st range
		if (foldedRangeCount > 0 && tfields[0].getText() != "") {
			outputField1 = MonteCarlo.runHoleCards(numberOfSims, topKek, HoleCardsRange.parse(tfields[0].getText())).toString();
		}
		//run for second
		if (foldedRangeCount > 0 && tfields[1].getText() != "") {
			outputField2 = MonteCarlo.runHoleCards(numberOfSims, topKek, HoleCardsRange.parse(tfields[1].getText())).toString();
		}
		
		outputFields[0].setText(outputField1);
		outputFields[1].setText(outputField2);
		
	}

}
