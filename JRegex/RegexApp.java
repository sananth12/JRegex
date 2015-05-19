package JRegex;

import utils.InputHint;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


public class RegexApp implements ActionListener {

	private JFrame frame;
	private JPanel top,top2, bottom;
	private JTextArea result, inputField;
	private JButton run;
	private JTextField pattern;

	public static void main(String[] args) {
		new RegexApp();
	}

	public RegexApp(){
		frame = new JFrame();
		frame.setSize(450, 450);
		frame.setTitle("Regex Tool - sananth12");

		top = new JPanel(new GridLayout(3,1));
		top2 = new JPanel(new GridLayout(1,3));
		
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
