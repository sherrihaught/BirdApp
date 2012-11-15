package birdProgram;

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
	private RadioListener bothListener;
	

	public SearchPane(Dimension currScreen, Controller c){
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel NameCriteriaLabel = new JLabel("Name: ");
		NameCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JTextField NameCriteriaEntry = new JTextField();
		NameCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		NameCriteriaEntry.setColumns(10);
		nameEntered = new TextEntryListener(NameCriteriaEntry);
		NameCriteriaEntry.addKeyListener(nameEntered);
		
		JLabel FamilyCriteriaLabel = new JLabel("Family: ");
		FamilyCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FamilyCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JTextField FamilyCriteriaEntry = new JTextField();
		FamilyCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		FamilyCriteriaEntry.setColumns(10);
		familyEntered = new TextEntryListener(FamilyCriteriaEntry);
		FamilyCriteriaEntry.addKeyListener(familyEntered);
		
		JLabel RegionCriteriaLabel = new JLabel("Region: ");
		RegionCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		RegionCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox RegionDropDown = new JComboBox(c.getPossibleLocations());
		RegionDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		locationChosen = new DropDownListener(RegionDropDown);
		RegionDropDown.addMouseListener(locationChosen);
		
		JLabel ColorCriteriaLabel = new JLabel("Color: ");
		ColorCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ColorCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox ColorDropDown = new JComboBox(c.getPossibleColors());
		ColorDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		colorChosen = new DropDownListener(ColorDropDown);
		ColorDropDown.addMouseListener(colorChosen);
		
		JLabel SizeCriteriaLabel = new JLabel("Size: ");
		SizeCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SizeCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox SizeDropDown = new JComboBox(c.getPossibleSizes());
		SizeDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		sizeChosen = new DropDownListener(SizeDropDown);
		SizeDropDown.addMouseListener(sizeChosen);
		
		JLabel ActivityCriteriaLabel = new JLabel("Activity Time: ");
		ActivityCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ActivityCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JRadioButton NightRadioButton = new JRadioButton("Night Only");
		NightRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		nightListener = new RadioListener(NightRadioButton);
		NightRadioButton.addMouseListener(nightListener);
		
		JRadioButton DayRadioButton = new JRadioButton("Day Only");
		DayRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		dayListener = new RadioListener(DayRadioButton);
		DayRadioButton.addMouseListener(dayListener);
		
		JRadioButton BothRadioButton = new JRadioButton("All hours");
		BothRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		bothListener = new RadioListener(BothRadioButton);
		BothRadioButton.addMouseListener(bothListener);
		
		JRadioButton AnyRadioButton = new JRadioButton("Any hours");
		AnyRadioButton.setSelected(true);
		AnyRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		ButtonGroup ActivityRadios = new ButtonGroup();
		ActivityRadios.add(NightRadioButton);
		ActivityRadios.add(DayRadioButton);
		ActivityRadios.add(BothRadioButton);
		ActivityRadios.add(AnyRadioButton);
		
		JButton ExecuteSearchButton = new JButton("  Search  ");
		ExecuteSearchButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JButton ResetCriteriaButton = new JButton("Reset");
		ResetCriteriaButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		GroupLayout gl_searchPane = new GroupLayout(this);
		gl_searchPane.setHorizontalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_searchPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(NameCriteriaLabel, 165, 165, Short.MAX_VALUE)
						.addComponent(RegionCriteriaLabel, 165, 165, Short.MAX_VALUE)
						.addComponent(FamilyCriteriaLabel, 165, 165, Short.MAX_VALUE)
						.addComponent(ColorCriteriaLabel, 165, 165, Short.MAX_VALUE)
						.addComponent(SizeCriteriaLabel, 165, 165, Short.MAX_VALUE)
						.addComponent(ActivityCriteriaLabel, 165, 165, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.LEADING)
						.addComponent(NameCriteriaEntry, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(FamilyCriteriaEntry, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(RegionDropDown, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(ColorDropDown, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(SizeDropDown, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_searchPane.createSequentialGroup()
							.addComponent(DayRadioButton)
							.addGap(25)
							.addComponent(NightRadioButton)
							.addGap(25)
							.addComponent(BothRadioButton)
							.addGap(25)
							.addComponent(AnyRadioButton))
					.addGroup(gl_searchPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(ExecuteSearchButton)
							.addComponent(ResetCriteriaButton)))
					.addContainerGap(800, Short.MAX_VALUE))
		);
		gl_searchPane.setVerticalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addGap((int)currScreen.getHeight()/10)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(NameCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameCriteriaEntry, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(FamilyCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(FamilyCriteriaEntry, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(RegionCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(RegionDropDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ColorCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(ColorDropDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(SizeCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(SizeDropDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ActivityCriteriaLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(NightRadioButton)
						.addComponent(DayRadioButton)
						.addComponent(BothRadioButton)
						.addComponent(AnyRadioButton))
					.addGap(47)
					.addComponent(ExecuteSearchButton)
					.addGap(47)
					.addComponent(ResetCriteriaButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(gl_searchPane);
	}
	
	public List<Object> getStates(){
		List<Object> states = new ArrayList<Object>();
		states.add(new BirdName(nameEntered.getTextEntered()));
		states.add(new BirdFamily(familyEntered.getTextEntered()));
		//states.add(locationChosen.getSelected());
		//states.add(colorChosen.getSelected());
		//states.add(sizeChosen.getSelected());
		BirdTimeActive b = new BirdTimeActive();
		if(dayListener.isSelected()){
			b.addTime("a.m.");
		}else if(nightListener.isSelected()){
			b.addTime("p.m.");
		}else if(bothListener.isSelected()){
			b.addTime("a.m.");
			b.addTime("p.m.");
		}
		states.add(b); 
		return states;
	}
	
	public void resetStates(){
		
	}
}
