import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.text.JTextComponent;

public class CopyListener implements ActionListener {

	JTextComponent field;
	
	public CopyListener(JButton button, JTextComponent field) {
		button.addActionListener(this);
		this.field = field;		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = field.getText();
		
		StringSelection stringSelection = new StringSelection(s);
		
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(stringSelection, null);
	}

}
