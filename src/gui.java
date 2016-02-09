import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class gui extends JFrame {

	private JPanel contentPane;
	private JTextField oopRangeField;
	private JTextField ipRangeField;
	private JTextField foldedRange1Field;
	private JTextField foldedRange2Field;
	private JTextField foldedRange3Field;
	private JTextField foldedRange4Field;
	private JTextField foldedRange5Field;
	private JTextField foldedRange6Field;
	private JTextField foldedRange7Field;
	private JLabel lblSimulations;
	private JTextField runField;
	private JTextField oopRangeFixed;
	private JTextField ipRangeFixed;
	private JLabel lblFlopRange;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	private JLabel lblFoldedRange_4;
	private JLabel lblFoldedRange_5;
	private JLabel lblFoldedRange_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOopRange = new JLabel("OOP Range");
		lblOopRange.setBounds(5, 67, 88, 15);
		lblOopRange.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		contentPane.add(lblOopRange);
		
		oopRangeField = new JTextField();
		oopRangeField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		oopRangeField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		oopRangeField.setBounds(103, 65, 266, 20);
		contentPane.add(oopRangeField);
		oopRangeField.setColumns(10);
		
		oopRangeFixed = new JTextField();
		oopRangeFixed.setBorder(new LineBorder(new Color(0, 0, 0)));
		oopRangeFixed.setBounds(379, 65, 122, 20);
		oopRangeFixed.setEditable(false);
		contentPane.add(oopRangeFixed);
		oopRangeFixed.setColumns(10);
		
		JLabel lblIpRange = new JLabel("IP Range");
		lblIpRange.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblIpRange.setBounds(5, 91, 88, 14);
		contentPane.add(lblIpRange);
		
		ipRangeField = new JTextField();
		ipRangeField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ipRangeField.setBounds(103, 91, 266, 20);
		contentPane.add(ipRangeField);
		ipRangeField.setColumns(10);
		
		ipRangeFixed = new JTextField();
		ipRangeFixed.setBorder(new LineBorder(new Color(0, 0, 0)));
		ipRangeFixed.setEditable(false);
		ipRangeFixed.setBounds(379, 90, 122, 20);
		contentPane.add(ipRangeFixed);
		ipRangeFixed.setColumns(10);
		
		JLabel lblFoldedRange = new JLabel("Folded Range 1");
		lblFoldedRange.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange.setBounds(5, 118, 88, 14);
		contentPane.add(lblFoldedRange);
		
		foldedRange1Field = new JTextField();
		foldedRange1Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange1Field.setBounds(103, 116, 266, 20);
		contentPane.add(foldedRange1Field);
		foldedRange1Field.setColumns(10);
		
		JLabel lblFoldedRange_1 = new JLabel("Folded Range 2");
		lblFoldedRange_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_1.setBounds(5, 143, 88, 14);
		contentPane.add(lblFoldedRange_1);
		
		foldedRange2Field = new JTextField();
		foldedRange2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange2Field.setBounds(103, 141, 266, 20);
		contentPane.add(foldedRange2Field);
		foldedRange2Field.setColumns(10);
		
		JLabel lblFoldedRange_2 = new JLabel("Folded Range 3");
		lblFoldedRange_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_2.setBounds(5, 168, 88, 14);
		contentPane.add(lblFoldedRange_2);
		
		foldedRange3Field = new JTextField();
		foldedRange3Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange3Field.setBounds(103, 165, 266, 20);
		contentPane.add(foldedRange3Field);
		foldedRange3Field.setColumns(10);
		
		JLabel lblFoldedRange_3 = new JLabel("Folded Range 4");
		lblFoldedRange_3.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_3.setBounds(5, 193, 88, 14);
		contentPane.add(lblFoldedRange_3);
		
		foldedRange4Field = new JTextField();
		foldedRange4Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange4Field.setBounds(103, 190, 266, 20);
		contentPane.add(foldedRange4Field);
		foldedRange4Field.setColumns(10);
		
		lblFlopRange = new JLabel("Flop Range");
		lblFlopRange.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFlopRange.setBounds(5, 296, 88, 14);
		contentPane.add(lblFlopRange);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(103, 296, 266, 57);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblSimulations = new JLabel("Simulations x10000000");
		lblSimulations.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblSimulations.setBounds(5, 367, 145, 14);
		contentPane.add(lblSimulations);
		
		runField = new JTextField();
		runField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		runField.setBounds(137, 364, 41, 20);
		contentPane.add(runField);
		runField.setColumns(10);
		
		lblFoldedRange_4 = new JLabel("Folded Range 5");
		lblFoldedRange_4.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_4.setBounds(5, 219, 88, 14);
		contentPane.add(lblFoldedRange_4);
		
		lblFoldedRange_5 = new JLabel("Folded Range 6");
		lblFoldedRange_5.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_5.setBounds(5, 244, 88, 15);
		contentPane.add(lblFoldedRange_5);
		
		lblFoldedRange_6 = new JLabel("Folded Range 7");
		lblFoldedRange_6.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFoldedRange_6.setBounds(5, 271, 88, 14);
		contentPane.add(lblFoldedRange_6);
		
		foldedRange5Field = new JTextField();
		foldedRange5Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange5Field.setBounds(103, 216, 266, 20);
		contentPane.add(foldedRange5Field);
		foldedRange5Field.setColumns(10);
		
		foldedRange6Field = new JTextField();
		foldedRange6Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange6Field.setBounds(103, 241, 266, 20);
		contentPane.add(foldedRange6Field);
		foldedRange6Field.setColumns(10);
		
		foldedRange7Field = new JTextField();
		foldedRange7Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		foldedRange7Field.setBounds(103, 268, 266, 20);
		contentPane.add(foldedRange7Field);
		foldedRange7Field.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(379, 296, 122, 57);
		contentPane.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setSelectionColor(UIManager.getColor("Button.background"));
		scrollPane_1.setViewportView(textPane);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBackground(UIManager.getColor("Button.background"));
		
		TestButton tstbtnCopyToClipboard = new TestButton();
		tstbtnCopyToClipboard.setText("Copy to clipboard");
		tstbtnCopyToClipboard.setBounds(511, 64, 132, 20);
		contentPane.add(tstbtnCopyToClipboard);
		
		TestButton testButton = new TestButton();
		testButton.setText("Copy to clipboard");
		testButton.setBounds(511, 91, 132, 20);
		contentPane.add(testButton);
		
		TestButton tstbtnCopyToClipboard_1 = new TestButton();
		tstbtnCopyToClipboard_1.setText("Copy to clipboard");
		tstbtnCopyToClipboard_1.setBounds(511, 296, 122, 57);
		contentPane.add(tstbtnCopyToClipboard_1);
		
		TestButton tstbtnSimulate = new TestButton();
		tstbtnSimulate.setText("Simulate");
		tstbtnSimulate.setBounds(188, 364, 122, 20);
		contentPane.add(tstbtnSimulate);
		
		JTextField[] inputRangeFields = new JTextField[] {oopRangeField, ipRangeField, foldedRange1Field, foldedRange2Field, foldedRange3Field, foldedRange4Field, foldedRange5Field, foldedRange6Field, foldedRange7Field};
		
		JTextField[] outputRangeFields = new JTextField[] {oopRangeFixed, ipRangeFixed};
				
		RunListener bigEars = new RunListener(inputRangeFields, outputRangeFields, tstbtnSimulate, runField);
	}
}
