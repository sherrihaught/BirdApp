package birdProgram;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FavoritesPane extends JPanel {
	private static final long serialVersionUID = 1L;

	public FavoritesPane(Dimension currScreen) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout gl_favoritesPane = new GroupLayout(this);
		setLayout(gl_favoritesPane);
	}

}
