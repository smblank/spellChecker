import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Editor extends JFrame implements ActionListener {
	DamerauLevenshtein automata;
	JTextPane text;
	JFrame frame;

	public Editor(DamerauLevenshtein dl) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		automata = dl;

		frame = new JFrame("Spell Checker");

		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());

		text = new JTextPane();
		JButton checkSpelling = new JButton("Check Spelling");
		checkSpelling.addActionListener(this);

		JPanel topPanel = new JPanel ( new FlowLayout(FlowLayout.LEFT));
		topPanel.add(checkSpelling);


		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(text);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String action = actionEvent.getActionCommand();
		List<IncorrectWords> incorrectWordsList = new ArrayList<>();

		if (action.equals("Check Spelling")) {
			incorrectWordsList = automata.checkSpelling(text.getText());
		}

		try {
			text.setText("");
			markIncorrectWord(incorrectWordsList.get(0).word, incorrectWordsList.get(0).replacements, 0, 0);
		}
		catch (BadLocationException e) {}
	}

	void markIncorrectWord (String word, List<String> replacements, int ind, int pos) throws BadLocationException {
		SimpleAttributeSet red = new SimpleAttributeSet();
		StyleConstants.setForeground(red, Color.RED);
		SimpleAttributeSet black = new SimpleAttributeSet();
		StyleConstants.setForeground(black, Color.BLACK);

		if (replacements.isEmpty()) {
			text.getDocument().insertString(0, word, black);
		}
		else {
			text.getDocument().insertString(0, word, red);
		}
	}
}
