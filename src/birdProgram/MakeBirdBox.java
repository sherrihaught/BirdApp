package birdProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

abstract public class MakeBirdBox {

	public static JPanel makeBirdBox(Bird b, Dimension currScreen, Controller c){
		
		int smallSize = (int)currScreen.getWidth()/110;
		int largeSize = (int)currScreen.getWidth()/80;
		
		JPanel bBox = new JPanel();
		bBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JButton Name = new JButton(b.getName().toString());
		Name.setFont(new Font("Times New Roman", Font.PLAIN, (4*largeSize)/3));
		BirdListener selecter = new BirdListener(b, c);
		Name.addActionListener(selecter);
		Name.setBackground(Color.WHITE);
		
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
		Favorite.setBackground(new Color(255, 255, 255));
		
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
					.addComponent(Name, largeSize*3, largeSize*3, largeSize*3)
					.addComponent(Family, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Location, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Color, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Size, largeSize*5, largeSize*5, largeSize*5)
					.addComponent(Favorite, largeSize*3, largeSize*3, largeSize*3));
		bBox.setLayout(gl_bBox);
		return bBox;
	}

}
