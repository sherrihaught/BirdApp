package birdProgram;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.border.EmptyBorder;

public class FavoritesPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private GroupLayout gl_favoritesPane;
	private ParallelGroup horizB;
	private SequentialGroup vert;
	private Dimension currScreen;
	private JPanel favs;
	private Controller c;
	private int smallSize;
	private int largeSize;

	public FavoritesPane(Dimension currScreen, Controller c) {
		this.currScreen = currScreen;
		this.c = c;
		favs = new JPanel();
		
		smallSize = (int)currScreen.getWidth()/110;
		largeSize = (int)currScreen.getWidth()/80;
		
		JRadioButton SortByName = new JRadioButton("Name");
		SortByName.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		SortByName.setSelected(true);
		
		JRadioButton SortByFamily = new JRadioButton("Family");
		SortByFamily.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		JRadioButton SortByLocation = new JRadioButton("Location");
		SortByLocation.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));

		JRadioButton SortByColor = new JRadioButton("Color");
		SortByColor.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		JRadioButton SortBySize = new JRadioButton("Size");
		SortBySize.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		ButtonGroup SortRadios = new ButtonGroup();
		SortRadios.add(SortByName);
		SortRadios.add(SortByFamily);
		SortRadios.add(SortByLocation);
		SortRadios.add(SortByColor);
		SortRadios.add(SortBySize);
		
		JLabel SortBy = new JLabel("Sort Results by: "); 
		SortBy.setFont(new Font("Times New Roman", Font.PLAIN, largeSize));
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		gl_favoritesPane = new GroupLayout(this);
		SequentialGroup horiz = gl_favoritesPane.createSequentialGroup(); 
		vert = gl_favoritesPane.createSequentialGroup();
		horizB = gl_favoritesPane.createParallelGroup(Alignment.LEADING);		
		
		horizB.addComponent(SortBy).addGroup(gl_favoritesPane.createSequentialGroup()
				.addGap(largeSize*3)
				.addComponent(SortByName, largeSize*14, largeSize*14, largeSize*14)
				.addComponent(SortByFamily, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortByLocation, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortByColor, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortBySize, largeSize*8, largeSize*8, largeSize*8));
		
		vert.addContainerGap().addComponent(SortBy).addGap(20).addGroup(gl_favoritesPane.createParallelGroup()
				.addComponent(SortByName, largeSize, largeSize, largeSize)
				.addComponent(SortByFamily, largeSize, largeSize, largeSize)
				.addComponent(SortByLocation, largeSize, largeSize, largeSize)
				.addComponent(SortByColor, largeSize, largeSize, largeSize)
				.addComponent(SortBySize, largeSize, largeSize, largeSize)).addGap(10);
	
		displayFavorites();
		
		gl_favoritesPane.setHorizontalGroup(horiz.addGroup(horizB));
		gl_favoritesPane.setVerticalGroup(vert);
		setLayout(gl_favoritesPane);
		repaint();
	}
	
	public void displayFavorites(){
		List<Bird> favorites = c.getFavorites();
		if(favorites != null){ //if no favorites, empty panel is displayed
			gl_favoritesPane.removeLayoutComponent(favs);
			favs.removeAll();
			GroupLayout gl_birdsBlock = new GroupLayout(favs);
			ParallelGroup horizontal = gl_birdsBlock.createParallelGroup(Alignment.LEADING);
			SequentialGroup vertical = gl_birdsBlock.createSequentialGroup();
			for(Bird b: favorites){
				JPanel birdBox = c.getResultsPane().makeBirdBox(b);
				horizontal.addComponent(birdBox, (int)currScreen.getWidth()-50, (int)currScreen.getWidth()-50, (int)currScreen.getWidth()-50);
				vertical.addGap(20).addComponent(birdBox, largeSize*5+2, largeSize*5+2, largeSize*5+2);
			}
			gl_birdsBlock.setHorizontalGroup(horizontal);
			gl_birdsBlock.setVerticalGroup(vertical);
			favs.setLayout(gl_birdsBlock);
		}
		horizB.addComponent(favs);
		vert.addComponent(favs);
	}
}