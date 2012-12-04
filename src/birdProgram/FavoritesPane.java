package birdProgram;

import java.awt.Color;
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
	private Color background;
	private String sortCategory;

	public FavoritesPane(Dimension currScreen, Controller c, Color background) {
		this.currScreen = currScreen;
		this.background = background;
		this.c = c;
		favs = new JPanel();
		favs.setBackground(background);
		sortCategory = "name";
		
		smallSize = (int)currScreen.getWidth()/110;
		largeSize = (int)currScreen.getWidth()/80;
		
		JRadioButton SortByName = new JRadioButton("Name");
		SortByName.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		SortByName.setSelected(true);
		RadioListener nameSort = new RadioListener(SortByName, c, "favorites");
		SortByName.addMouseListener(nameSort);
		SortByName.setBackground(background);
		
		JRadioButton SortByFamily = new JRadioButton("Family");
		SortByFamily.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener famSort = new RadioListener(SortByFamily, c, "favorites");
		SortByFamily.addMouseListener(famSort);
		SortByFamily.setBackground(background);
		
		JRadioButton SortByLocation = new JRadioButton("Location");
		SortByLocation.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener locSort = new RadioListener(SortByLocation, c, "favorites");
		SortByLocation.addMouseListener(locSort);
		SortByLocation.setBackground(background);

		JRadioButton SortByColor = new JRadioButton("Color");
		SortByColor.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener colSort = new RadioListener(SortByColor, c, "favorites");
		SortByColor.addMouseListener(colSort);
		SortByColor.setBackground(background);
		
		JRadioButton SortBySize = new JRadioButton("Size");
		SortBySize.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener sizeSort = new RadioListener(SortBySize, c, "favorites");
		SortBySize.addMouseListener(sizeSort);
		SortBySize.setBackground(background);
		
		ButtonGroup SortRadios = new ButtonGroup();
		SortRadios.add(SortByName);
		SortRadios.add(SortByFamily);
		SortRadios.add(SortByLocation);
		SortRadios.add(SortByColor);
		SortRadios.add(SortBySize);
		
		JLabel SortBy = new JLabel("Sort Results by: "); 
		SortBy.setFont(new Font("Times New Roman", Font.PLAIN, largeSize));
		SortBy.setBackground(background);
		
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
	
	public void setSortCategory(String sortCategory){
		this.sortCategory = sortCategory;
	}
	
	public void displayFavorites(){
		List<Bird> favorites = SortManager.getSortedBirds(c.getFavorites(), sortCategory);
		
		//System.out.println("favorites inside pane: " + c.getFavorites());
		
		if(favorites != null){ //if no favorites, empty panel is displayed
			gl_favoritesPane.removeLayoutComponent(favs);
			favs.removeAll();
			GroupLayout gl_birdsBlock = new GroupLayout(favs);
			ParallelGroup horizontal = gl_birdsBlock.createParallelGroup(Alignment.LEADING);
			SequentialGroup vertical = gl_birdsBlock.createSequentialGroup();
			for(Bird b: favorites){
				JPanel birdBox = c.getResultsPane().makeBirdBox(b);
				birdBox.setBackground(background);
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