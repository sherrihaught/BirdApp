package birdProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SearchPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private TextEntryListener nameEntered;
	private TextEntryListener familyEntered;
	private DropDownListener locationChosen;
	private DropDownListener colorChosen;
	private DropDownListener sizeChosen;
	private RadioListener nightListener;
	private RadioListener dayListener;
	private RadioListener anyListener;
	

	public SearchPane(Dimension currScreen, Controller c, Color background){
		int largeSize = (int)currScreen.getWidth()/10;
		int medSize = (int)currScreen.getWidth()/90;
		int smallSize = (int)currScreen.getWidth()/110;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel NameCriteriaLabel = new JLabel("Name: ");
		NameCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		NameCriteriaLabel.setBackground(background);
		
		JTextField NameCriteriaEntry = new JTextField();
		NameCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		nameEntered = new TextEntryListener(NameCriteriaEntry);
		
		JLabel FamilyCriteriaLabel = new JLabel("Family: ");
		FamilyCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FamilyCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		FamilyCriteriaLabel.setBackground(background);
		
		JTextField FamilyCriteriaEntry = new JTextField();
		FamilyCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		familyEntered = new TextEntryListener(FamilyCriteriaEntry);
		
		JLabel RegionCriteriaLabel = new JLabel("Region: ");
		RegionCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		RegionCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		RegionCriteriaLabel.setBackground(background);
		
		JComboBox<BirdLocation> RegionDropDown = new JComboBox<BirdLocation>(c.getPossibleLocations());
		RegionDropDown.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		locationChosen = new DropDownListener(RegionDropDown);
		RegionDropDown.addMouseListener(locationChosen);
		
		JLabel ColorCriteriaLabel = new JLabel("Color: ");
		ColorCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ColorCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		ColorCriteriaLabel.setBackground(background);
		
		JComboBox<BirdColor> ColorDropDown = new JComboBox<BirdColor>(c.getPossibleColors());
		ColorDropDown.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		colorChosen = new DropDownListener(ColorDropDown);
		ColorDropDown.addMouseListener(colorChosen);
		
		JLabel SizeCriteriaLabel = new JLabel("Size: ");
		SizeCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SizeCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		SizeCriteriaLabel.setBackground(background);
		
		JComboBox<BirdSize> SizeDropDown = new JComboBox<BirdSize>(c.getPossibleSizes());
		SizeDropDown.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		sizeChosen = new DropDownListener(SizeDropDown);
		SizeDropDown.addMouseListener(sizeChosen);
		
		JLabel ActivityCriteriaLabel = new JLabel("Activity Time: ");
		ActivityCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ActivityCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		ActivityCriteriaLabel.setBackground(background);
		
		JRadioButton NightRadioButton = new JRadioButton("Night Only");
		NightRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		nightListener = new RadioListener(NightRadioButton, c, "search");
		NightRadioButton.addMouseListener(nightListener);
		NightRadioButton.setBackground(background);
		
		JRadioButton DayRadioButton = new JRadioButton("Day Only");
		DayRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		dayListener = new RadioListener(DayRadioButton, c, "search");
		DayRadioButton.addMouseListener(dayListener);
		DayRadioButton.setBackground(background);
		
		JRadioButton BothRadioButton = new JRadioButton("All hours");
		BothRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		BothRadioButton.setBackground(background);

		
		JRadioButton AnyRadioButton = new JRadioButton("Any hours");
		AnyRadioButton.setSelected(true);
		AnyRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, smallSize));
		anyListener = new RadioListener(AnyRadioButton, c, "search");
		AnyRadioButton.addMouseListener(anyListener);
		AnyRadioButton.setBackground(background);
		
		ButtonGroup ActivityRadios = new ButtonGroup();
		ActivityRadios.add(NightRadioButton);
		ActivityRadios.add(DayRadioButton);
		ActivityRadios.add(BothRadioButton);
		ActivityRadios.add(AnyRadioButton);
		
		JButton ExecuteSearchButton = new JButton("  Search  ");
		ExecuteSearchButton.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		ExecuteSearchButton.addActionListener(new SearchButtonActionListener(this, c));
		ExecuteSearchButton.setBackground(Color.WHITE);
		
		JButton ResetCriteriaButton = new JButton("Reset");
		ResetCriteriaButton.setFont(new Font("Times New Roman", Font.PLAIN, medSize));
		ResetCriteriaButton.addActionListener(new ResetButtonActionListener(this));
		ResetCriteriaButton.setBackground(Color.WHITE);
		
		GroupLayout gl_searchPane = new GroupLayout(this);
		gl_searchPane.setHorizontalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(NameCriteriaLabel, largeSize, largeSize, largeSize)
						.addComponent(RegionCriteriaLabel, largeSize, largeSize, largeSize)
						.addComponent(FamilyCriteriaLabel, largeSize, largeSize, largeSize)
						.addComponent(ColorCriteriaLabel, largeSize, largeSize, largeSize)
						.addComponent(SizeCriteriaLabel, largeSize, largeSize, largeSize)
						.addComponent(ActivityCriteriaLabel, largeSize, largeSize, largeSize))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(NameCriteriaEntry, largeSize*2, largeSize*2, largeSize*2)
						.addComponent(FamilyCriteriaEntry, largeSize*2, largeSize*2, largeSize*2)
						.addComponent(RegionDropDown, largeSize*2, largeSize*2, largeSize*2)
						.addComponent(ColorDropDown, largeSize*2, largeSize*2, largeSize*2)
					.addGroup(gl_searchPane.createSequentialGroup()
							.addComponent(DayRadioButton)
							.addGap(smallSize)
							.addComponent(NightRadioButton)
							.addGap(smallSize)
							.addComponent(BothRadioButton)
							.addGap(smallSize)
							.addComponent(AnyRadioButton))
					.addGroup(gl_searchPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(SizeDropDown, largeSize*2, largeSize*2, largeSize*2)
							.addComponent(ExecuteSearchButton)
							.addComponent(ResetCriteriaButton)))
					.addContainerGap(2*(int)currScreen.getWidth()/3, Short.MAX_VALUE))
		);
		gl_searchPane.setVerticalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addGap(largeSize/2)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(NameCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(NameCriteriaEntry, 2*medSize, 2*medSize, 2*medSize))
					.addGap(largeSize/5)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(FamilyCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(FamilyCriteriaEntry, 2*medSize, 2*medSize, 2*medSize))
					.addGap(largeSize/5)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(RegionCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(RegionDropDown, 2*medSize, 2*medSize, 2*medSize))
					.addGap(largeSize/5)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ColorCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(ColorDropDown, 2*medSize, 2*medSize, 2*medSize))
					.addGap(largeSize/5)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(SizeCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(SizeDropDown, 2*medSize, 2*medSize, 2*medSize))
					.addGap(largeSize/5)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ActivityCriteriaLabel, 2*medSize, 2*medSize, 2*medSize)
						.addComponent(NightRadioButton)
						.addComponent(DayRadioButton)
						.addComponent(BothRadioButton)
						.addComponent(AnyRadioButton))
					.addGap(largeSize/5)
					.addComponent(ExecuteSearchButton)
					.addGap(largeSize/5)
					.addComponent(ResetCriteriaButton)
					.addContainerGap(5*largeSize, Short.MAX_VALUE))
		);
		setLayout(gl_searchPane);
	}
	
	/**@return List<Object> in order name, family, location, color, size, time active
	 */
	public List<Object> getStates(){
		List<Object> states = new ArrayList<Object>();
		if(nameEntered.getTextEntered().equals("")){
			states.add(null);
		}else{
			states.add(new BirdName(nameEntered.getTextEntered()));
		}
		if(familyEntered.getTextEntered().equals("")){
			states.add(null);
		}else{
			states.add(new BirdFamily(familyEntered.getTextEntered()));
		}
		states.add(locationChosen.getSelected());
		states.add(colorChosen.getSelected());
		states.add(sizeChosen.getSelected());
		BirdTimeActive b = new BirdTimeActive("");
		if(dayListener.isSelected()){
			b.set("a.m.");
		}else if(nightListener.isSelected()){
			b.set("p.m.");
		}else if(anyListener.isSelected()){
			b = null;
		}else{
			b.set("a.m., p.m.");
		}
		states.add(b); 
		return states;
	}
	
	public void resetStates(){
		nameEntered.setDefault();
		familyEntered.setDefault();
		locationChosen.setDefault();
		colorChosen.setDefault();
		sizeChosen.setDefault();
		anyListener.setSelected(true);
	}
}
