package birdProgram;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;

public class ResultsPane extends JPanel {
	private static final long serialVersionUID = 1L;

	public ResultsPane(Dimension currScreen) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout gl_resultsPane = new GroupLayout(this);
		setLayout(gl_resultsPane);
	}

}
