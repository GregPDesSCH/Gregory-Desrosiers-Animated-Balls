package gregdesGroupOfBallsFull;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;

final class ApplicationMainSettingsUtility 
{
	private JFrame utilityFrame;
	private JPanel mainPanel; // with BorderLayout
	
	private JPanel topPanel;
	
	private JPanel topPanel2; // with FlowLayout
	private JPanel maxBallCountSetPanel; // with GridLayout of 2 x 2.
	private JLabel maxBallCountLabel;
	private SpinnerNumberModel maxBallCountSpinnerModel;
	private JSpinner maxBallCountSpinner;
	
	
	
	private JPanel midPanel; // with BorderLayout

	private JPanel midPanelTopPart; // with BorderLayout
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
	
	private String[] choices = 
		{"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", 
			"Magneta", "Orange", "Pink", "Red", "White", "Yellow", "Custom"};
	
	private Color[] colorObjects = 
		{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	private JPanel statusPanelDemoPane;
	
	
	private JPanel bottomPanel;
	
	private JPanel canvasBackgroundColorPanel; // with BorderLayout
	private JLabel canvasBackgroundColorLabel;
	private JPanel canvasBackgroundColorButtonPanel; // with GridLayout (1, 5)
	private ButtonGroup canvasBackgroundColorButtonGroup;
	private JRadioButton canvasBackgroundColorBlackButton;
	private JRadioButton canvasBackgroundColorWhiteButton;
	private JRadioButton canvasBackgroundColorRedButton;
	private JRadioButton canvasBackgroundColorGreenButton;
	private JRadioButton canvasBackgroundColorBlueButton;
	
	private JPanel confirmationPanel; // with FlowLayout
	// Radio buttons for Accept and Decline.
	private JRadioButton acceptButton;
	private JRadioButton declineButton;
	
	ApplicationMainSettingsUtility()
	{
		utilityFrame = new JFrame();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.BLACK);
		
		topPanel = new JPanel();
		topPanel.setBackground(Color.BLACK);
		topPanel.setLayout(new BorderLayout());
		
		topPanel2 = new JPanel();
		topPanel2.setBackground(Color.BLACK);
		
		maxBallCountSetPanel = new JPanel();
		maxBallCountSetPanel.setLayout(new GridLayout(1, 2, 5, 0));
		maxBallCountSetPanel.setBackground(Color.BLACK);
		
		maxBallCountLabel = new JLabel();
		maxBallCountLabel.setText("Max Ball Count");
		maxBallCountLabel.setFont(Application.defaultFont2);
		maxBallCountLabel.setForeground(Color.WHITE);
		maxBallCountLabel.setBackground(Color.BLACK);
		maxBallCountSetPanel.add(maxBallCountLabel);
		
		maxBallCountSpinnerModel = new SpinnerNumberModel();
		maxBallCountSpinnerModel.setMinimum(Application.canvas.LOWEST_MAX_BALL_COUNT);
		maxBallCountSpinnerModel.setMaximum(Application.canvas.ABSOLUTE_MAX_BALL_COUNT);
		
		maxBallCountSpinner = new JSpinner();
		maxBallCountSpinner.setModel(maxBallCountSpinnerModel);
		maxBallCountSpinner.setFont(Application.defaultFont2);
		maxBallCountSpinner.setValue(Application.canvas.MAX_BALL_COUNT);
		maxBallCountSetPanel.add(maxBallCountSpinner);
		
		topPanel2.add(maxBallCountSetPanel);
		topPanel.add(topPanel2);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
		
		
		midPanel = new JPanel();
		midPanel.setBackground(Color.BLACK);
		midPanel.setLayout(new BorderLayout());
		
		
		midPanelTopPart = new JPanel();
		midPanelTopPart.setBackground(Color.BLACK);
		midPanelTopPart.setLayout(new BorderLayout());
		
		commandLabel = new JLabel("Canvas Bottom Panel Color");
		commandLabel.setBackground(Color.BLACK);
		commandLabel.setForeground(Color.WHITE);
		commandLabel.setFont(Application.defaultFont2);
		midPanelTopPart.add(commandLabel, BorderLayout.NORTH);
		
		commonColorComboBox = new JComboBox<String>(choices);
		commonColorComboBox.setBackground(Color.BLACK);
		commonColorComboBox.setForeground(Color.WHITE);
		commonColorComboBox.setFont(Application.defaultFont2);
		commonColorComboBox.addActionListener(new ComboBoxListener());
		midPanelTopPart.add(commonColorComboBox);
		
		topPanelBottomPart = new JPanel();
		topPanelBottomPart.setLayout(new GridLayout(2, 3));
		topPanelBottomPart.setBackground(Color.BLACK);
		
		colorSpinnerModel1 = new SpinnerNumberModel();
		colorSpinnerModel1.setMinimum(0);
		colorSpinnerModel1.setMaximum(255);
		
		colorSpinnerModel2 = new SpinnerNumberModel();
		colorSpinnerModel2.setMinimum(0);
		colorSpinnerModel2.setMaximum(255);
		
		colorSpinnerModel3 = new SpinnerNumberModel();
		colorSpinnerModel3.setMinimum(0);
		colorSpinnerModel3.setMaximum(255);
		
		redLabel = new JLabel("Red:");
		redLabel.setBackground(Color.BLACK);
		redLabel.setForeground(Color.RED);
		redLabel.setFont(Application.defaultFont);
		topPanelBottomPart.add(redLabel);
		
		greenLabel = new JLabel("Green:");
		greenLabel.setBackground(Color.BLACK);
		greenLabel.setForeground(Color.GREEN);
		greenLabel.setFont(Application.defaultFont);
		topPanelBottomPart.add(greenLabel);
		
		blueLabel = new JLabel("Blue:");
		blueLabel.setBackground(Color.BLACK);
		blueLabel.setForeground(Color.BLUE);
		blueLabel.setFont(Application.defaultFont);
		topPanelBottomPart.add(blueLabel);
		
		redSpinner = new JSpinner();
		redSpinner.setModel(colorSpinnerModel1);
		redSpinner.setFont(Application.defaultFont2);
		redSpinner.setValue(Application.statusPanelBackgroundRedComponent);
		redSpinner.addChangeListener(new SpinnerListener());
		topPanelBottomPart.add(redSpinner);
		
		greenSpinner = new JSpinner();
		greenSpinner.setModel(colorSpinnerModel2);
		greenSpinner.setFont(Application.defaultFont2);
		greenSpinner.setValue(Application.statusPanelBackgroundGreenComponent);
		greenSpinner.addChangeListener(new SpinnerListener());
		topPanelBottomPart.add(greenSpinner);
		
		blueSpinner = new JSpinner();
		blueSpinner.setModel(colorSpinnerModel3);
		blueSpinner.setFont(Application.defaultFont2);
		blueSpinner.setValue(Application.statusPanelBackgroundBlueComponent);
		blueSpinner.addChangeListener(new SpinnerListener());
		topPanelBottomPart.add(blueSpinner);
		
		initializeCheckboxes();
		
		midPanelTopPart.add(topPanelBottomPart, BorderLayout.SOUTH);
		
		midPanel.add(midPanelTopPart);
		
		statusPanelDemoPane = new JPanel();
		statusPanelDemoPane.setBackground(Application.bottomPanel.getBackground());
		
		midPanel.add(statusPanelDemoPane, BorderLayout.SOUTH);
		
		
		mainPanel.add(midPanel);
		
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.BLACK);
		bottomPanel.setLayout(new BorderLayout());
		
		canvasBackgroundColorPanel = new JPanel();
		canvasBackgroundColorPanel.setBackground(Color.BLACK);
		canvasBackgroundColorPanel.setLayout(new BorderLayout());
		
		canvasBackgroundColorLabel = new JLabel("Canvas Background Color:");
		canvasBackgroundColorLabel.setFont(Application.defaultFont2);
		canvasBackgroundColorLabel.setForeground(Color.WHITE);
		canvasBackgroundColorLabel.setBackground(Color.BLACK);
		canvasBackgroundColorPanel.add(canvasBackgroundColorLabel, BorderLayout.NORTH);
		
		canvasBackgroundColorButtonPanel = new JPanel();
		canvasBackgroundColorButtonPanel.setLayout(new GridLayout(1, 5));
		canvasBackgroundColorButtonPanel.setBackground(Color.BLACK);
		
		
		canvasBackgroundColorButtonGroup = new ButtonGroup();
		
		canvasBackgroundColorBlackButton = new JRadioButton("Black");
		canvasBackgroundColorBlackButton.setForeground(Color.WHITE);
		canvasBackgroundColorBlackButton.setBackground(Color.BLACK);
		canvasBackgroundColorBlackButton.setFont(Application.defaultFont2);
		canvasBackgroundColorButtonGroup.add(canvasBackgroundColorBlackButton);
		canvasBackgroundColorButtonPanel.add(canvasBackgroundColorBlackButton);
		
		canvasBackgroundColorWhiteButton = new JRadioButton("White");
		canvasBackgroundColorWhiteButton.setForeground(Color.WHITE);
		canvasBackgroundColorWhiteButton.setBackground(Color.BLACK);
		canvasBackgroundColorWhiteButton.setFont(Application.defaultFont2);
		canvasBackgroundColorButtonGroup.add(canvasBackgroundColorWhiteButton);
		canvasBackgroundColorButtonPanel.add(canvasBackgroundColorWhiteButton);
		
		canvasBackgroundColorRedButton = new JRadioButton("Red");
		canvasBackgroundColorRedButton.setForeground(Color.WHITE);
		canvasBackgroundColorRedButton.setBackground(Color.BLACK);
		canvasBackgroundColorRedButton.setFont(Application.defaultFont2);
		canvasBackgroundColorButtonGroup.add(canvasBackgroundColorRedButton);
		canvasBackgroundColorButtonPanel.add(canvasBackgroundColorRedButton);
		
		canvasBackgroundColorGreenButton = new JRadioButton("Green");
		canvasBackgroundColorGreenButton.setForeground(Color.WHITE);
		canvasBackgroundColorGreenButton.setBackground(Color.BLACK);
		canvasBackgroundColorGreenButton.setFont(Application.defaultFont2);
		canvasBackgroundColorButtonGroup.add(canvasBackgroundColorGreenButton);
		canvasBackgroundColorButtonPanel.add(canvasBackgroundColorGreenButton);
		
		canvasBackgroundColorBlueButton = new JRadioButton("Blue");
		canvasBackgroundColorBlueButton.setForeground(Color.WHITE);
		canvasBackgroundColorBlueButton.setBackground(Color.BLACK);
		canvasBackgroundColorBlueButton.setFont(Application.defaultFont2);
		canvasBackgroundColorButtonGroup.add(canvasBackgroundColorBlueButton);
		canvasBackgroundColorButtonPanel.add(canvasBackgroundColorBlueButton);
		
		if (Application.canvas.getBackground() == Color.BLACK)
			canvasBackgroundColorBlackButton.setSelected(true);
		else if (Application.canvas.getBackground() == Color.WHITE)
			canvasBackgroundColorWhiteButton.setSelected(true);
		else if (Application.canvas.getBackground() == Color.RED)
			canvasBackgroundColorRedButton.setSelected(true);
		else if (Application.canvas.getBackground() == Color.GREEN)
			canvasBackgroundColorGreenButton.setSelected(true);
		else if (Application.canvas.getBackground() == Color.BLUE)
			canvasBackgroundColorBlueButton.setSelected(true);
		
		
		canvasBackgroundColorPanel.add(canvasBackgroundColorButtonPanel);
		
		bottomPanel.add(canvasBackgroundColorPanel);
		
		
		confirmationPanel = new JPanel();
		confirmationPanel.setBackground(Color.BLACK);
		
		acceptButton = new JRadioButton("Accept Settings");
		acceptButton.setBackground(Color.BLACK);
		acceptButton.setForeground(Color.WHITE);
		acceptButton.setFont(Application.defaultFont2);
		acceptButton.addActionListener(new RadioButtonListener());
		
		declineButton = new JRadioButton("Back");
		declineButton.setBackground(Color.BLACK);
		declineButton.setForeground(Color.WHITE);
		declineButton.setFont(Application.defaultFont2);
		declineButton.addActionListener(new RadioButtonListener());
		
		confirmationPanel.add(acceptButton);
		confirmationPanel.add(declineButton);
		
		bottomPanel.add(confirmationPanel, BorderLayout.SOUTH);
		
		
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Main Settings", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
		utilityFrame.add(mainPanel);
		utilityFrame.setUndecorated(true);
		utilityFrame.pack();
		utilityFrame.setResizable(false);
		utilityFrame.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (utilityFrame.getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (utilityFrame.getHeight() / 2));
		utilityFrame.setVisible(true);
	}
	
	void initializeCheckboxes()
	{
		boolean ballColorMatchFound = false;
		int x = 0;
		
		for(; x < colorObjects.length; x++)
		{
			if (colorObjects[x].getRed() == Application.bottomPanel.getBackground().getRed() &&
					colorObjects[x].getGreen() == Application.bottomPanel.getBackground().getGreen() &&
					colorObjects[x].getBlue() == Application.bottomPanel.getBackground().getBlue())
			{
				commonColorComboBox.setSelectedIndex(x);
				ballColorMatchFound = true;
				
				x = colorObjects.length - 1;
			}
		}
		
		if (x == choices.length - 1 && !ballColorMatchFound)
			commonColorComboBox.setSelectedIndex(x);
		
		redSpinner.setValue(Application.bottomPanel.getBackground().getRed());
		greenSpinner.setValue(Application.bottomPanel.getBackground().getGreen());
		blueSpinner.setValue(Application.bottomPanel.getBackground().getBlue());
		
	}
	
	// Listener for Main Application Bottom Panel Color Check Box.
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
					
					if (statusPanelDemoPane != null)
						statusPanelDemoPane.setBackground(new Color((Integer)colorObjects[x].getRed(), (Integer)colorObjects[x].getGreen(), (Integer)colorObjects[x].getBlue()));
					
					x = colorObjects.length - 1;
				}
			}
		}
	}
	
	// Listener for the ball color spinners below the combo box for the 
	// bottom of the main application panel.
	private class SpinnerListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent arg0) 
		{
			
			if (statusPanelDemoPane != null)
				statusPanelDemoPane.setBackground(
						new Color((Integer)redSpinner.getValue(), (Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue()));
			
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
	
	// Listener for the radio buttons at the bottom of the utility.
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent g)
		{
			if (g.getSource().toString().contains(acceptButton.getText()))
			{
				Application.canvas.MAX_BALL_COUNT = (Integer)maxBallCountSpinner.getValue();
				
				if (Application.canvas.ballList.size() > Application.canvas.MAX_BALL_COUNT)
				{
					Application.canvas.currentBallCount = Application.canvas.MAX_BALL_COUNT;
					
					Application.dialogLabel.setText("The program is removing all the necessary balls to get down to the set max ball count.");
					
					JOptionPane.showMessageDialog(null, Application.dialogLabel, "Removing Balls", JOptionPane.WARNING_MESSAGE);
					
					for (int x = 0; x < (Application.canvas.ballList.size() - Application.canvas.MAX_BALL_COUNT); x++)
					{
						Application.canvas.ballList.removeFirst();
						Application.canvas.ballDraws.removeFirst();
						Application.canvas.ballOutlineDraws.removeFirst();
					}
					
					Application.numberOfBallsLabel.setText("Number of balls: " + Application.canvas.currentBallCount);
				}
				Application.currentMaxBallCount.setText("Current Max Ball Count: " + Application.canvas.MAX_BALL_COUNT);
				
				Application.bottomPanel.setBackground(new Color(
						(Integer)redSpinner.getValue(), (Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue()));
				Application.bottomPanelTopPart.setBackground(new Color(
						(Integer)redSpinner.getValue(), (Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue()));
				
				if (canvasBackgroundColorBlackButton.isSelected())
				{
					Application.canvas.setBackground(Color.BLACK);
					Application.canvas.mainGraphicsManager.setColor(Color.WHITE);
				}
				else if (canvasBackgroundColorWhiteButton.isSelected())
				{
					Application.canvas.setBackground(Color.WHITE);
					Application.canvas.mainGraphicsManager.setColor(Color.BLACK);
				}
				else if (canvasBackgroundColorRedButton.isSelected())
				{
					Application.canvas.setBackground(Color.RED);
					Application.canvas.mainGraphicsManager.setColor(Color.WHITE);
				}
				else if (canvasBackgroundColorGreenButton.isSelected())
				{
					Application.canvas.setBackground(Color.GREEN);
					Application.canvas.mainGraphicsManager.setColor(Color.BLACK);
				}
				else if (canvasBackgroundColorBlueButton.isSelected())
				{
					Application.canvas.setBackground(Color.BLUE);
					Application.canvas.mainGraphicsManager.setColor(Color.WHITE);
				}
				
				if ((Application.bottomPanel.getBackground().getRed() <= 100
						&& Application.bottomPanel.getBackground().getGreen() <= 100
						&& Application.bottomPanel.getBackground().getBlue() <= 100) ||
						(Application.bottomPanel.getBackground().getRed() <= 50
						&& Application.bottomPanel.getBackground().getGreen() <= 50)
						||
						(Application.bottomPanel.getBackground().getGreen() <= 50
						&& Application.bottomPanel.getBackground().getBlue() <= 50))
				{
					Application.currentAnimationStatus.setForeground(Color.WHITE);
					Application.currentMaxBallCount.setForeground(Color.WHITE);
					Application.numberOfBallsLabel.setForeground(Color.WHITE);
					Application.loadedMusicFileLabel.setForeground(Color.WHITE);
				}
				else
				{
					Application.currentAnimationStatus.setForeground(Color.BLACK);
					Application.currentMaxBallCount.setForeground(Color.BLACK);
					Application.numberOfBallsLabel.setForeground(Color.BLACK);
					Application.loadedMusicFileLabel.setForeground(Color.BLACK);
				}
			}
			
			Application.animationTimer.start();
			Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			
			utilityFrame.dispose();
			Application.mainFrame.setEnabled(true);
		}
	}
}