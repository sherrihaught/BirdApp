package birdProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;

public class ResultsPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private int smallSize;
	private int largeSize;
	private Dimension currScreen;
	private Controller c;
	private GroupLayout gl_resultsPane;
	private SequentialGroup vert;
	private ParallelGroup horizB;
	private JPanel birds;

	public ResultsPane(Dimension currScreen, Controller c) {
		this.currScreen = currScreen;
		this.c = c;
		
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
		gl_resultsPane = new GroupLayout(this);
		SequentialGroup horiz = gl_resultsPane.createSequentialGroup(); 
		vert = gl_resultsPane.createSequentialGroup();
		horizB = gl_resultsPane.createParallelGroup(Alignment.LEADING);		
		
		horizB.addComponent(SortBy).addGroup(gl_resultsPane.createSequentialGroup()
				.addGap(largeSize*3)
				.addComponent(SortByName, largeSize*14, largeSize*14, largeSize*14)
				.addComponent(SortByFamily, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortByLocation, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortByColor, largeSize*8, largeSize*8, largeSize*8)
				.addComponent(SortBySize, largeSize*8, largeSize*8, largeSize*8));
		
		vert.addContainerGap().addComponent(SortBy).addGap(20).addGroup(gl_resultsPane.createParallelGroup()
				.addComponent(SortByName, largeSize, largeSize, largeSize)
				.addComponent(SortByFamily, largeSize, largeSize, largeSize)
				.addComponent(SortByLocation, largeSize, largeSize, largeSize)
				.addComponent(SortByColor, largeSize, largeSize, largeSize)
				.addComponent(SortBySize, largeSize, largeSize, largeSize)).addGap(10);
	
		displayResults();
		
		gl_resultsPane.setHorizontalGroup(horiz.addGroup(horizB));
		gl_resultsPane.setVerticalGroup(vert);
		setLayout(gl_resultsPane);
		repaint();
	}
	
	public void displayResults(){
		BirdSearch last = c.getLastSearch();
		if(last != null){
			gl_resultsPane.removeLayoutComponent(birds); //remove panel from layout
			birds.removeAll();							 //clear panel
														 //change panel contents...
			GroupLayout gl_birdsBlock = new GroupLayout(birds);
			ParallelGroup horizontal = gl_birdsBlock.createParallelGroup(Alignment.LEADING);
			SequentialGroup vertical = gl_birdsBlock.createSequentialGroup();
			List<Bird> results = last.getBirds();
			for(Bird b: results){
				JPanel birdBox = makeBirdBox(b);
				horizontal.addComponent(birdBox, (int)currScreen.getWidth() -50, (int)currScreen.getWidth() -50, (int)currScreen.getWidth() -50);
				vertical.addGap(20).addComponent(birdBox, largeSize*5+2, largeSize*5+2, largeSize*5+2);
			}
			gl_birdsBlock.setHorizontalGroup(horizontal);
			gl_birdsBlock.setVerticalGroup(vertical);
			birds.setLayout(gl_birdsBlock);
		}else{
			birds = new JPanel();
		}
		horizB.addComponent(birds);
		vert.addComponent(birds);
	}
	
	public JPanel makeBirdBox(Bird b){
		JPanel bBox = new JPanel();
		bBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JButton Name = new JButton(b.getName().toString());
		Name.setFont(new Font("Times New Roman", Font.PLAIN, (4*largeSize)/3));
		BirdListener selecter = new BirdListener(b, c);
		Name.addActionListener(selecter);
		
		DefaultListModel<BirdFamily> famList = new DefaultListModel<BirdFamily>();
		List<BirdFamily> bFam = b.getFamilies();
		for(BirdFamily fam: bFam){
			famList.addElement(fam);
		}
		JScrollPane Family = new JScrollPane(new JList<BirdFamily>(famList));
		Family.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		DefaultListModel<BirdLocation> locList = new DefaultListModel<BirdLocation>();
		List<BirdLocation> bLoc = b.getLocations();
		for(BirdLocation loc: bLoc){
			locList.addElement(loc);
		}
		JScrollPane Location = new JScrollPane(new JList<BirdLocation>(locList));
		Location.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		DefaultListModel<BirdColor> colorList = new DefaultListModel<BirdColor>();
		List<BirdColor> bColor = b.getColors();
		for(BirdColor color: bColor){
			colorList.addElement(color);
		}
		JScrollPane Color = new JScrollPane(new JList<BirdColor>(colorList));
		Color.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		JLabel Size = new JLabel(b.getSize().toString());
		Size.setFont(new Font("Times New Roman", Font.PLAIN, (3*smallSize)/2));
		
		JButton Favorite = new JButton();
		FavoriteButtonListener checkFav = new FavoriteButtonListener(Favorite, b, c);
		Favorite.addActionListener(checkFav);
		
		GroupLayout gl_bBox = new GroupLayout(bBox);
		gl_bBox.setHorizontalGroup(gl_bBox.createSequentialGroup()
				.addGap(largeSize*3)
				.addComponent(Name, largeSize*12, largeSize*12, largeSize*12)
				.addGap(largeSize*2)
				.addComponent(Family, largeSize*6, largeSize*6, largeSize*6)
				.addGap(largeSize*2)
				.addComponent(Location, largeSize*6, largeSize*6, largeSize*6)
				.addGap(largeSize*2)
				.addComponent(Color, largeSize*6, largeSize*6, largeSize*6)
				.addGap(largeSize*2)
				.addComponent(Size, largeSize*6, largeSize*6, largeSize*6)
				.addGap(largeSize*2)
				.addComponent(Favorite, largeSize*3, largeSize*3, largeSize*3)
				.addGap(largeSize*4));
		
		gl_bBox.setVerticalGroup(gl_bBox.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_bBox.createParallelGroup(Alignment.LEADING))
					.addComponent(Name, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Family, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Location, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Color, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Size, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Favorite, largeSize*3, largeSize*3, largeSize*3));
		bBox.setLayout(gl_bBox);
		return bBox;
	}
}
