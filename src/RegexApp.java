import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;


public class RegexApp implements ActionListener {

	private JFrame frame;
	private JPanel top;
	private JTextArea result;
	private JButton run;
	private JTextField inputField, pattern;

	public static void main(String[] args) {
		new RegexApp();
	}

	public RegexApp(){
		frame = new JFrame();
		frame.setSize(450, 350);
		frame.setTitle("Regex Tool - sananth12");

		top = new JPanel(new GridLayout(1,3));

		inputField = new JTextField("Text");
		top.add(inputField);

		pattern = new JTextField("Regex Pattern");
		top.add(pattern);

		result = new JTextArea(5, 120);
		result.setFont(new Font("Serif", Font.BOLD, 15));

		run = new JButton("Match it!");
		top.add(run);

		run.addActionListener(this);

		frame.add(top, BorderLayout.NORTH);
		frame.add(result, BorderLayout.CENTER);
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
