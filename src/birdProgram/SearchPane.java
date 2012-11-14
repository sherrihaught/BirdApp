package birdProgram;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SearchPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public SearchPane(Dimension currScreen){
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel NameCriteriaLabel = new JLabel("Name: ");
		NameCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NameCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JTextField NameCriteriaEntry = new JTextField();
		NameCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		NameCriteriaEntry.setColumns(10);
		
		JLabel FamilyCriteriaLabel = new JLabel("Family: ");
		FamilyCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		FamilyCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JTextField FamilyCriteriaEntry = new JTextField();
		FamilyCriteriaEntry.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		FamilyCriteriaEntry.setColumns(10);
		
		JLabel RegionCriteriaLabel = new JLabel("Region: ");
		RegionCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		RegionCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox RegionDropDown = new JComboBox(); //add BirdLocation as Type once implemented
		RegionDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		JLabel ColorCriteriaLabel = new JLabel("Color: ");
		ColorCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ColorCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox ColorDropDown = new JComboBox(); //add BirdColor as Type once implemented
		ColorDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		JLabel SizeCriteriaLabel = new JLabel("Size: ");
		SizeCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SizeCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JComboBox SizeDropDown = new JComboBox(); //add BirdSize as Type once implemented
		SizeDropDown.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		JLabel ActivityCriteriaLabel = new JLabel("Activity Time: ");
		ActivityCriteriaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ActivityCriteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		
		JCheckBox NightCheckBox = new JCheckBox("Night");
		NightCheckBox.setSelected(true);
		NightCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		JCheckBox DayCheckBox = new JCheckBox("Day");
		DayCheckBox.setSelected(true);
		DayCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/110));
		
		JButton ExecuteSearchButton = new JButton("  Search  ");
		ExecuteSearchButton.setFont(new Font("Times New Roman", Font.PLAIN, (int)currScreen.getWidth()/90));
		ExecuteSearchButton.addActionListener(new Searcher());
		
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
						.addGroup(gl_searchPane.createSequentialGroup()
							.addGap(62)
							.addComponent(DayCheckBox)
							.addGap(54)
							.addComponent(NightCheckBox))
						.addGroup(gl_searchPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(ExecuteSearchButton)
							.addComponent(SizeDropDown, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addComponent(ResetCriteriaButton)))
					.addContainerGap(1400, Short.MAX_VALUE))
		);
		gl_searchPane.setVerticalGroup(
			gl_searchPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPane.createSequentialGroup()
					.addGap(120)
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
						.addComponent(NightCheckBox)
						.addComponent(DayCheckBox))
					.addGap(47)
					.addComponent(ExecuteSearchButton)
					.addGap(47)
					.addComponent(ResetCriteriaButton)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		setLayout(gl_searchPane);
	}
	
	private class Searcher implements ActionListener{
		public Searcher(){
			
		}
		
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
