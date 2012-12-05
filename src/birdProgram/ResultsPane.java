package birdProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
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
	private Color background;
	private String sortCategory;

	public ResultsPane(Dimension currScreen, Controller c, Color background) {
		this.currScreen = currScreen;
		this.background = background;
		this.c = c;
		
		sortCategory = "name";
		smallSize = (int)currScreen.getWidth()/110;
		largeSize = (int)currScreen.getWidth()/80;
		
		JRadioButton SortByName = new JRadioButton("Name");
		SortByName.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		SortByName.setSelected(true);
		RadioListener nameSort = new RadioListener(SortByName, c, "results");
		SortByName.addMouseListener(nameSort);
		SortByName.setBackground(background);
		
		JRadioButton SortByFamily = new JRadioButton("Family");
		SortByFamily.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener famSort = new RadioListener(SortByFamily, c, "results");
		SortByFamily.addMouseListener(famSort);
		SortByFamily.setBackground(background);
		
		JRadioButton SortByLocation = new JRadioButton("Location");
		SortByLocation.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener locSort = new RadioListener(SortByLocation, c, "results");
		SortByLocation.addMouseListener(locSort);
		SortByLocation.setBackground(background);

		JRadioButton SortByColor = new JRadioButton("Color");
		SortByColor.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener colSort = new RadioListener(SortByColor, c, "results");
		SortByColor.addMouseListener(colSort);
		SortByColor.setBackground(background);
		
		JRadioButton SortBySize = new JRadioButton("Size");
		SortBySize.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		RadioListener sizeSort = new RadioListener(SortBySize, c, "results");
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
	
	public void setSortCategory(String sortCategory){
		this.sortCategory = sortCategory;
	}
	
	public void displayResults(){
		BirdSearch last = c.getLastSearch();
		if(last != null){
			gl_resultsPane.removeLayoutComponent(birds);
			try{
				birds.removeAll();
			}
			catch(Exception e){
				birds = new JPanel();
				birds.setBackground(background);
			}
			GroupLayout gl_birdsBlock = new GroupLayout(birds);
			ParallelGroup horizontal = gl_birdsBlock.createParallelGroup(Alignment.LEADING);
			SequentialGroup vertical = gl_birdsBlock.createSequentialGroup();
			List<Bird> results = SortManager.getSortedBirds(last.getBirds(), sortCategory);
			if(results.isEmpty()){
				JLabel NoResults = new JLabel("No Results Found.");
				NoResults.setFont(new Font("TimesNewRoman", Font.PLAIN, smallSize*2));
				horizontal.addComponent(NoResults, (int)currScreen.getWidth() - 50, (int)currScreen.getWidth() - 50, (int)currScreen.getWidth() - 50);
				vertical.addComponent(NoResults, largeSize*5, largeSize*5, largeSize*5);
			}
			for(Bird b: results){
				JPanel birdBox = MakeBirdBox.makeBirdBox(b, currScreen, c);
				birdBox.setBackground(background);
				horizontal.addComponent(birdBox, (int)currScreen.getWidth() -50, (int)currScreen.getWidth() -50, (int)currScreen.getWidth() -50);
				vertical.addGap(30).addComponent(birdBox, largeSize*5+2, largeSize*5+2, largeSize*5+2);
			}
			gl_birdsBlock.setHorizontalGroup(horizontal);
			gl_birdsBlock.setVerticalGroup(vertical);
			birds.setLayout(gl_birdsBlock);
		}else{
			birds = new JPanel();
			birds.setBackground(background);
		}
		horizB.addComponent(birds);
		vert.addComponent(birds);
	}
}
