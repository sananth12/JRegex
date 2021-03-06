package core;

import utils.InputHint;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/*
 *  @author Anantha Natarajan S, May 2015	
 *  http://ananth.co.in
 * 
 *  JRegex is a simple GUI tool to quickly check if a text matches a pattern or not
 *  
 */

public class JRegex implements ActionListener {

	private JFrame frame;
	private JPanel top, bottom;
	private JTextArea result, inputField;
	private JButton run;
	private JTextField pattern;

	public static void main(String[] args) {
		new JRegex();
	}

	public JRegex(){
		
		// GUI setup, need to segregate this part.
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.setTitle("Regex Tool - sananth12");

		top = new JPanel(new GridLayout(3,1));
		
		bottom = new JPanel(new GridLayout(1, 2));
		bottom.add(new JLabel("Made by Anantha Natarajan S"));
		bottom.add(new JLabel("http://ananth.co.in"), BorderLayout.EAST );
		
		inputField = new JTextArea(3, 120);
		inputField.setFont(new Font("Serif", Font.PLAIN, 13));
		inputField.setUI(new InputHint("Enter text", true));
		top.add(inputField);

		pattern = new JTextField();
		pattern.setUI(new InputHint("Enter Regex pattern", true));;
		top.add(pattern);

		result = new JTextArea(3, 80);
		result.setFont(new Font("Serif", Font.PLAIN, 14));

		run = new JButton("Match it!");
		run.setSize(45, 20);
		top.add(run);

		run.addActionListener(this);

		frame.add(top, BorderLayout.NORTH);
		frame.add(result, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.setVisible(true);

	}
	
	// Checks for Regex pattern in text
	
	public void actionPerformed(ActionEvent e) {

		String text = inputField.getText();
		String patt = pattern.getText();
		result.setText("");

		Pattern r = Pattern.compile(patt);
		Matcher m = r.matcher(text);

		if (m.find( )) {
			
		result.append("Found values/groups("+m.groupCount()+"):\n");
			for(int i=1;i<=m.groupCount();i++)
				result.append(m.group(i)+"\n");
		} else {
			result.append("NO MATCH");
		}

	}
}
