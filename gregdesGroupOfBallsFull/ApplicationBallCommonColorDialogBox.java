package gregdesGroupOfBallsFull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

final class ApplicationBallCommonColorDialogBox 
{
	private JFrame windowFrame;
	private JPanel mainPanel;
	
	private JPanel topPanel;
	private JLabel commandLabel;
	private JComboBox<String> commonColorComboBox;
	private JPanel topPanelBottomPart;
	private SpinnerNumberModel colorSpinnerModel1;
	private SpinnerNumberModel colorSpinnerModel2;
	private SpinnerNumberModel colorSpinnerModel3;
	
	private JLabel redLabel;
	private JSpinner redSpinner;
	private JLabel greenLabel;
	private JSpinner greenSpinner;
	private JLabel blueLabel;
	private JSpinner blueSpinner;
	
	private JPanel bottomPanel;
	private JRadioButton acceptButton;
	private JRadioButton declineButton;
	
	private String[] choices = 
		{"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", 
			"Magneta", "Orange", "Pink", "Red", "White", "Yellow", "Custom"};
	
	private Color[] colorObjects = 
		{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	/*currentColorRedValue = 255;
	currentColorGreenValue = 255;
	currentColorBlueValue = 255;*/
	
	ApplicationBallCommonColorDialogBox()
	{
		windowFrame = new JFrame();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Application.defaultBackgroundColor);
		mainPanel.setLayout(new java.awt.BorderLayout());
		
		// Top Panel construction
		topPanel = new JPanel();
		topPanel.setBackground(Application.defaultBackgroundColor);
		topPanel.setLayout(new java.awt.BorderLayout());
		
		commandLabel = new JLabel("Select a common color for all balls to have.");
		commandLabel.setBackground(Application.defaultBackgroundColor);
		commandLabel.setForeground(Application.defaultFontColor);
		commandLabel.setFont(Application.defaultFont);
		
		commonColorComboBox = new JComboBox<String>(choices);
		commonColorComboBox.setFont(Application.defaultFont2);
		commonColorComboBox.setSelectedIndex(Application.commonColorComboBoxIndex);
		commonColorComboBox.addActionListener(new ComboBoxListener());
		
		// Spinner Panel
		topPanelBottomPart = new JPanel();
		topPanelBottomPart.setLayout(new GridLayout(2, 3));
		topPanelBottomPart.setBackground(Application.defaultBackgroundColor);
		
		colorSpinnerModel1 = new SpinnerNumberModel();
		colorSpinnerModel1.setMinimum(0);
		colorSpinnerModel1.setMaximum(255);
		
		colorSpinnerModel2 = new SpinnerNumberModel();
		colorSpinnerModel2.setMinimum(0);
		colorSpinnerModel2.setMaximum(255);
		
		colorSpinnerModel3 = new SpinnerNumberModel();
		colorSpinnerModel3.setMinimum(0);
		colorSpinnerModel3.setMaximum(255);
		
		redLabel = new JLabel("<html><b>Red:</b></html>");
		redLabel.setFont(Application.defaultFont2);
		redLabel.setForeground(Color.RED);
		redLabel.setBackground(Color.BLACK);
		
		topPanelBottomPart.add(redLabel);
		
		greenLabel = new JLabel("<html><b>Green:</b></html>");
		greenLabel.setFont(Application.defaultFont2);
		greenLabel.setForeground(Color.GREEN);
		greenLabel.setBackground(Color.BLACK);
		
		topPanelBottomPart.add(greenLabel);
		
		blueLabel = new JLabel("<html><b>Blue:</b></html>");
		blueLabel.setFont(Application.defaultFont2);
		blueLabel.setForeground(Color.BLUE);
		blueLabel.setBackground(Color.BLACK);
		
		topPanelBottomPart.add(blueLabel);
		
		redSpinner = new JSpinner();		
		redSpinner.setModel(colorSpinnerModel1);
		redSpinner.setValue(Application.currentColorRedValue);
		redSpinner.setFont(Application.defaultFont2);
		redSpinner.setForeground(Application.defaultFontColor);
		redSpinner.setBackground(Application.defaultBackgroundColor);
		redSpinner.addChangeListener(new SpinnerListener());
		
		topPanelBottomPart.add(redSpinner);
		
		greenSpinner = new JSpinner();		
		greenSpinner.setModel(colorSpinnerModel2);
		greenSpinner.setValue(Application.currentColorGreenValue);
		greenSpinner.setFont(Application.defaultFont2);
		greenSpinner.setForeground(Application.defaultFontColor);
		greenSpinner.setBackground(Application.defaultBackgroundColor);
		greenSpinner.addChangeListener(new SpinnerListener());
		
		topPanelBottomPart.add(greenSpinner);
		
		blueSpinner = new JSpinner();		
		blueSpinner.setModel(colorSpinnerModel3);
		blueSpinner.setValue(Application.currentColorBlueValue);
		blueSpinner.setFont(Application.defaultFont2);
		blueSpinner.setForeground(Application.defaultFontColor);
		blueSpinner.setBackground(Application.defaultBackgroundColor);
		blueSpinner.addChangeListener(new SpinnerListener());
		
		topPanelBottomPart.add(blueSpinner);
		// End of Spinner Panel
		
		topPanel.add(commandLabel, BorderLayout.NORTH);
		topPanel.add(commonColorComboBox, BorderLayout.CENTER);
		topPanel.add(topPanelBottomPart, BorderLayout.SOUTH);

		// Bottom Panel construction
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Application.defaultBackgroundColor);
		
		acceptButton = new JRadioButton("OK");
		acceptButton.setForeground(Application.defaultFontColor);
		acceptButton.setBackground(Application.defaultBackgroundColor);
		acceptButton.setFont(Application.defaultFont2);
		acceptButton.addActionListener(new RadioButtonListener());
		
		declineButton = new JRadioButton("Back");
		declineButton.setForeground(Application.defaultFontColor);
		declineButton.setBackground(Application.defaultBackgroundColor);
		declineButton.setFont(Application.defaultFont2);
		declineButton.addActionListener(new RadioButtonListener());
		
		bottomPanel.add(acceptButton);
		bottomPanel.add(declineButton);
		
		// Final Assembly and Initialization
		mainPanel.add(topPanel, java.awt.BorderLayout.NORTH);
		mainPanel.add(bottomPanel, java.awt.BorderLayout.CENTER);
		
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Common Color for All Balls", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
		windowFrame.add(mainPanel);
		windowFrame.setUndecorated(true);
		windowFrame.pack();
		windowFrame.setResizable(false);
		windowFrame.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (windowFrame.getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (windowFrame.getHeight() / 2));
		windowFrame.setVisible(true);
	}
	
	private class ComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int x = 0; x < colorObjects.length; x++)
			{
				if (((String)commonColorComboBox.getSelectedItem()).equals(choices[x]))
				{
					redSpinner.setValue((Integer)colorObjects[x].getRed());
					greenSpinner.setValue((Integer)colorObjects[x].getGreen());
					blueSpinner.setValue((Integer)colorObjects[x].getBlue());
					
					x = colorObjects.length - 1;
				}
			}
		}
	}
	
	private class SpinnerListener implements javax.swing.event.ChangeListener
	{
		public void stateChanged(ChangeEvent arg0) 
		{
			boolean matchFound = false;
			int x = 0;
			
			for(; x < colorObjects.length; x++)
			{
				if (colorObjects[x].getRed() == (Integer)redSpinner.getValue() &&
						colorObjects[x].getGreen() == (Integer)greenSpinner.getValue() &&
						colorObjects[x].getBlue() == (Integer)blueSpinner.getValue())
				{
					commonColorComboBox.setSelectedIndex(x);
					matchFound = true;
					
					x = colorObjects.length - 1;
				}
			}
			
			if (x == choices.length - 1 && !matchFound)
				commonColorComboBox.setSelectedIndex(x);
				
		}
		
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent g)
		{
			if (g.getSource() == acceptButton)
			{
				for(int x = 0; x < Application.canvas.currentBallCount; x++)
				{
					Application.canvas.ballList.get(x).ballColor = new Color((Integer)redSpinner.getValue(),
							(Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue());
					
					Application.canvas.ballDraws.get(x).setColor(new Color((Integer)redSpinner.getValue(),
							(Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue()));
				}
				
				Application.canvas.repaint();
				
				Application.currentColorRedValue = (Integer)redSpinner.getValue();
				Application.currentColorGreenValue = (Integer)greenSpinner.getValue();
				Application.currentColorBlueValue = (Integer)blueSpinner.getValue();
				
				Application.commonColorComboBoxIndex = commonColorComboBox.getSelectedIndex();
			}
			
			Application.animationTimer.start();
			Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			
			windowFrame.dispose();
			Application.mainFrame.setEnabled(true);
		}
	}
}