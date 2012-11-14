package birdProgram;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BirdPane extends JPanel {
	private static final long serialVersionUID = 1L;

	public BirdPane(Dimension currScreen) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout gl_birdPane = new GroupLayout(this);
		setLayout(gl_birdPane);
	}
}
