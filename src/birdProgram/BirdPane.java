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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class BirdPane extends JPanel {

    private static final long serialVersionUID = 1L;
    private FavoriteButtonListener Favorite;
    private Bird bird;
    private Dimension currScreen;

    public BirdPane(Dimension currScreen, Bird bird, Controller c) { 
    	this.currScreen = currScreen;
    	this.bird = bird;
    	if(bird != null){
    		setPane(bird, c);
    	}
    }
    
    public Bird getBird(){
    	return bird;
    }
    
    public void setPane(Bird bird, Controller c){
    	removeAll();
    	this.bird = bird;
    	int largeSize = (int)currScreen.getWidth()/10;
    	int medSize = (int)currScreen.getWidth()/90;
    	int smallSize = (int)currScreen.getWidth()/110;
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        

        JButton favorite = new JButton();
        Favorite = new FavoriteButtonListener(favorite, bird, c);
        favorite.addActionListener(Favorite);

		JLabel Name = new JLabel(bird.getName().toString());
		Name.setFont(new Font("Arial", Font.BOLD, medSize *2));
		
		JLabel Fams = new JLabel("Families:" );
		Fams.setFont(new Font("Arial", Font.BOLD, smallSize));
		
		DefaultListModel<BirdFamily> famList = new DefaultListModel<BirdFamily>();
		List<BirdFamily> bFam = bird.getFamilies();
		for(BirdFamily fam: bFam){
			famList.addElement(fam);
		}
		JScrollPane Family = new JScrollPane(new JList<BirdFamily>(famList));
		Family.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		
		JLabel Locs = new JLabel("Regions found in:" );
		Locs.setFont(new Font("Arial", Font.BOLD, smallSize));
		
		DefaultListModel<BirdLocation> locList = new DefaultListModel<BirdLocation>();
		List<BirdLocation> bLoc = bird.getLocations();
		for(BirdLocation loc: bLoc){
			locList.addElement(loc);
		}
		JScrollPane Location = new JScrollPane(new JList<BirdLocation>(locList));
		Location.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		Location.setBackground(new Color(139, 123, 139));
		
		JLabel Colors = new JLabel("Colors:" );
		Colors.setFont(new Font("Arial", Font.BOLD, smallSize));
		
		DefaultListModel<BirdColor> colorList = new DefaultListModel<BirdColor>();
		List<BirdColor> bColor = bird.getColors();
		for(BirdColor color: bColor){
			colorList.addElement(color);
		}
		JScrollPane Color = new JScrollPane(new JList<BirdColor>(colorList));
		Color.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));

		JLabel Size = new JLabel("Size:" );
		Size.setFont(new Font("Arial", Font.BOLD, smallSize));
		
        JLabel BirdSize = new JLabel(bird.getSize().toString());
        BirdSize.setHorizontalAlignment(SwingConstants.LEFT);
        BirdSize.setFont(new Font("Times New Roman", Font.BOLD, smallSize));

		JLabel Time = new JLabel("Activity Time:" );
		Time.setFont(new Font("Arial", Font.BOLD, smallSize));
		
        JLabel BirdActiveTime = new JLabel(bird.getTimeActive().toString());
        BirdActiveTime.setHorizontalAlignment(SwingConstants.LEFT);
        BirdActiveTime.setFont(new Font("Times New Roman", Font.BOLD, smallSize));

        JTextArea BirdDescriptionDisplay = new JTextArea(bird.getDescription().toString());
        BirdDescriptionDisplay.setEditable(false);
        BirdDescriptionDisplay.setLineWrap(true);
        BirdDescriptionDisplay.setWrapStyleWord(true);
        BirdDescriptionDisplay.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
        BirdDescriptionDisplay.setBackground(new Color(139, 123, 139));
        BirdDescriptionDisplay.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        JScrollPane DescriptionScroll = new JScrollPane(BirdDescriptionDisplay);
        DescriptionScroll.setOpaque(false);
        DescriptionScroll.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        GroupLayout birdPaneLayout = new GroupLayout(this);
        
        birdPaneLayout.setHorizontalGroup(birdPaneLayout.createSequentialGroup()
					.addGap((int)currScreen.getWidth() /10)
					.addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Name, largeSize*2, largeSize*2, largeSize*2)
									.addGap(medSize*3)
									.addComponent(favorite, medSize*3, medSize*3, medSize*3))
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Fams, medSize*7, medSize*7, medSize*7)
									.addGap(medSize*2)
									.addComponent(Family, medSize*7, medSize*7, medSize*7))
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Locs, medSize*7, medSize*7, medSize*7)
									.addGap(medSize*2)
									.addComponent(Location, medSize*7, medSize*7, medSize*7))
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Colors, medSize*7, medSize*7, medSize*7)
									.addGap(medSize*2)
									.addComponent(Color, medSize*7, medSize*7, medSize*7))
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Size, medSize*7, medSize*7, medSize*7)
									.addGap(medSize*2)
									.addComponent(BirdSize, medSize*7, medSize*7, medSize*7))
							.addGroup(birdPaneLayout.createSequentialGroup()
									.addComponent(Time, medSize*7, medSize*7, medSize*7)
									.addGap(medSize*2)									
									.addComponent(BirdActiveTime, medSize*7, medSize*7, medSize*7))
							.addComponent(DescriptionScroll, largeSize*3, largeSize*3, largeSize*3)));
						
        birdPaneLayout.setVerticalGroup(birdPaneLayout.createSequentialGroup()
        		.addGap((int) currScreen.getHeight() / 10)
        		.addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
        				.addComponent(Name, 3*medSize, 3*medSize, 3*medSize)
        				.addComponent(favorite, 3*medSize, 3*medSize, 3*medSize))
                .addGap(largeSize/5)  
                .addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                		.addComponent(Fams, 2*medSize, 2*medSize, 2*medSize)
                		.addComponent(Family, 4*medSize, 4*medSize, 4*medSize))
                .addGap(largeSize/7)
                .addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                		.addComponent(Locs, 2*medSize, 2*medSize, 2*medSize)
                		.addComponent(Location, 6*medSize, 6*medSize, 6*medSize))
                .addGap(largeSize/7)
                .addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                		.addComponent(Colors, 2*medSize, 2*medSize, 2*medSize)
                		.addComponent(Color, 6*medSize, 6*medSize, 6*medSize))
                .addGap(largeSize/7)
                .addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                		.addComponent(Size, 2*medSize, 2*medSize, 2*medSize)
                		.addComponent(BirdSize, 2*medSize, 2*medSize, 2*medSize))
                .addGap(largeSize/7)
                .addGroup(birdPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                		.addComponent(Time, 2*medSize, 2*medSize, 2*medSize)
                		.addComponent(BirdActiveTime, 2*medSize, 2*medSize, 2*medSize))
                .addGap(largeSize/3)
                .addComponent(DescriptionScroll, largeSize*3, largeSize*3, largeSize*3));

        setLayout(birdPaneLayout);
    }
    
//    private void imageStuff(){
//      if(favorite.isSelected()==false){
//      try {
//          Image img = ImageIO.read(getClass().getResource("notMyFav.jpg"));
//          favorite.setIcon(new ImageIcon(img));
//      } catch (IOException ex) {
//          Logger.getLogger(BirdPane.class.getName()).log(Level.SEVERE, null, ex);
//      }
//  }
//  else{
//      try {
//          Image img2 = ImageIO.read(getClass().getResource("myFav.jpg"));
//          favorite.setIcon(new ImageIcon(img2));
//      } catch (IOException ex) {
//          Logger.getLogger(BirdPane.class.getName()).log(Level.SEVERE, null, ex);
//      }
//  }
//    }
}
