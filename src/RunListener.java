import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public class RunListener implements ActionListener {

	//index 0 and 1 are OOP and IP
	JTextComponent[] inputFields;
	
	JTextComponent flopOutputField;
	JTextComponent flopInputField;
	
	JTextComponent[] outputFields;
	
	JTextField simCount;
	
	JButton runButton;
	
	public RunListener(JTextComponent[] inputFields, JTextComponent[] outputField, JButton runButton, JTextField simCount, JTextComponent flopInputField, JTextComponent flopOutputField) {
		if (inputFields.length != 9) {
			throw new IllegalArgumentException("must be 9 text fields, not " + inputFields.length + "!");
		}
		
		this.inputFields = inputFields;
		this.outputFields = outputField;
		this.simCount = simCount;
		this.runButton = runButton;
		this.flopOutputField = flopOutputField;
		this.flopInputField = flopInputField;
		runButton.addActionListener(this);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		long numberOfSims = Long.parseLong(simCount.getText()) * 1000000;
		
		int foldedRangeCount = 0;
		
		for (int i = 2; i < inputFields.length; i++) {
			if (inputFields[i].getText().isEmpty() == false) {
				foldedRangeCount++;
			}
		}
		
		HoleCardsRange[] foldedRangesWithEmptyRemoved = new HoleCardsRange[foldedRangeCount];
		
		for (int i = 2, foldsSoFar = 0; i < 9; i++) {
			if (inputFields[i].getText().isEmpty() == false) {
				foldedRangesWithEmptyRemoved[foldsSoFar] = HoleCardsRange.parse(inputFields[i].getText());
				foldsSoFar++;
			}			
		}
		
		String outputField1 = "";
		String outputField2 = "";
		String outputField3 = "";
		
				
		//run for 1st range
		if (foldedRangeCount > 0 && inputFields[0].getText() != "") {
			outputField1 = MonteCarlo.runHoleCards(numberOfSims, foldedRangesWithEmptyRemoved, HoleCardsRange.parse(inputFields[0].getText())).toString();
		}
		//run for second
		if (foldedRangeCount > 0 && inputFields[1].getText() != "") {
			outputField2 = MonteCarlo.runHoleCards(numberOfSims, foldedRangesWithEmptyRemoved, HoleCardsRange.parse(inputFields[1].getText())).toString();
		}
		if (flopInputField.getText().isEmpty() == false) {
			FlopRange fr = FlopRange.parse(flopInputField.getText());
			outputField3 = MonteCarlo.runFlop(numberOfSims, foldedRangesWithEmptyRemoved, fr).toString();
		}
		else {
			System.out.println("Nothing to run.");
		}
				
		outputFields[0].setText(outputField1);
		outputFields[1].setText(outputField2);
		flopOutputField.setText(outputField3);		
	}

}
