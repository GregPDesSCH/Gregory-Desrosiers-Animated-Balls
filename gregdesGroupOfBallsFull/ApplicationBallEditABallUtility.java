package gregdesGroupOfBallsFull;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;

final class ApplicationBallEditABallUtility
{
	private JFrame utilityFrame;
	private JPanel mainPanel;
	
	// Array of componets
	private ArrayList<JComponent> listOfComponents;
	
	private JPanel topPanel;
	
	private JPanel ballSelectorPanel;
	private JPanel centerContainer;
	private JLabel ballSelectLabel;
	private SpinnerNumberModel ballSelectModel;
	private JSpinner ballSelectSpinner;
	
	private JPanel topPanelBottomPart;
	
	private JPanel ballLocationPanel; // Grid panel containing four components
	private JLabel xCoordinateLabel;
	private JLabel yCoordinateLabel;
	private SpinnerNumberModel xCoordinateModel;
	private SpinnerNumberModel yCoordinateModel;
	private JSpinner xCoordinateSpinner;
	private JSpinner yCoordinateSpinner;
	
	private JPanel ballSpeedPanel; // Grid panel containing four components
	private JLabel dxLabel;
	private JLabel dyLabel;
	private SpinnerNumberModel dxModel;
	private SpinnerNumberModel dyModel;
	private JSpinner dxSpinner;
	private JSpinner dySpinner;
	
	private JPanel ballWidthPanel; // Grid panel containing two components
	private JLabel ballWidthLabel;
	private SpinnerNumberModel ballWidthSpinnerModel;
	private JSpinner ballWidthSpinner;
	
	private JPanel middlePanel;
	
	private JPanel randomizationOptionsPanel;
	// Complete with five checkboxes in a 1 by 5 grid.
	private JCheckBox randomizeDXCheckbox;
	private JCheckBox randomizeDYCheckbox;
	private JCheckBox ballHasOutlineCheckbox;
	private JCheckBox randomizeBallColorCheckbox;
	private JCheckBox randomizeBallOutlineColorCheckbox;
	
	
	private JPanel ballColorPanel; 
	// Same scheme as the original ApplicationBallCommonColorDialog minus radio buttons.
	private JLabel commandLabel;
	private JComboBox<String> commonColorComboBox;
	private JPanel ballColorPanelBottomPart;
	private SpinnerNumberModel colorSpinnerModel1;
	private SpinnerNumberModel colorSpinnerModel2;
	private SpinnerNumberModel colorSpinnerModel3;
	
	private JLabel redLabel;
	private JSpinner redSpinner;
	private JLabel greenLabel;
	private JSpinner greenSpinner;
	private JLabel blueLabel;
	private JSpinner blueSpinner;
	
	
	private JPanel ballOutlineColorPanel;
	// Same scheme as the original ApplicationBallCommonOutlineColorDialog minus radio buttons.
	private JLabel commandLabel2;
	private JComboBox<String> commonColorComboBox2;
	private JPanel ballOutlineColorPanelBottomPart;
	private SpinnerNumberModel colorSpinnerModel4;
	private SpinnerNumberModel colorSpinnerModel5;
	private SpinnerNumberModel colorSpinnerModel6;
	
	private JLabel redLabel2;
	private JSpinner redSpinner2;
	private JLabel greenLabel2;
	private JSpinner greenSpinner2;
	private JLabel blueLabel2;
	private JSpinner blueSpinner2;
	
	
	
	private JPanel bottomPanel;
	
	private JPanel directionPanel;
	// Setting initial direction
	private ButtonGroup horizontalDirectionRadioButtonGroup;
	private JRadioButton leftRadioButton;
	private JRadioButton rightRadioButton;
	private ButtonGroup verticalDirectionRadioButtonGroup;
	private JRadioButton upRadioButton;
	private JRadioButton downRadioButton;
	
	private JPanel confirmationPanel;
	// Radio buttons for Accept and Decline.
	private JRadioButton acceptButton;
	private JRadioButton declineButton;
	
	private String[] choices = 
		{"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", 
			"Magneta", "Orange", "Pink", "Red", "White", "Yellow", "Custom"};
	
	private Color[] colorObjects = 
		{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
			Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	ApplicationBallEditABallUtility()
	{
		utilityFrame = new JFrame();
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(2,2));
		mainPanel.setBackground(Color.BLACK);
		
		listOfComponents = new ArrayList<JComponent>();
		
		/*
		 *  Top Panel Build
		 */
		
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Application.defaultBackgroundColor);
		
		
		
		ballSelectorPanel = new JPanel();
		ballSelectorPanel.setBackground(Application.defaultBackgroundColor);
		ballSelectorPanel.setLayout(new FlowLayout());
		
		centerContainer = new JPanel();
		centerContainer.setBackground(Application.defaultBackgroundColor);
		centerContainer.setLayout(new GridLayout(1, 2));
		centerContainer.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));
		
		ballSelectLabel = new JLabel("Select Ball:");
		centerContainer.add(ballSelectLabel);
		listOfComponents.add(ballSelectLabel);
		
		ballSelectModel = new SpinnerNumberModel();
		ballSelectModel.setMinimum(Application.canvas.MIN_BALL_COUNT);
		ballSelectModel.setMaximum(Application.canvas.currentBallCount);
		
		ballSelectSpinner = new JSpinner();
		ballSelectSpinner.setModel(ballSelectModel);
		
		if (Application.currentBallToEditIndex <= Application.canvas.currentBallCount)
			ballSelectSpinner.setValue((Integer)Application.currentBallToEditIndex);
		else
			ballSelectSpinner.setValue((Integer)(Application.canvas.currentBallCount / 2));
		
		ballSelectSpinner.addChangeListener(new BallSelectSpinnerListener());
		centerContainer.add(ballSelectSpinner);
		listOfComponents.add(ballSelectSpinner);
		
		ballSelectorPanel.add(centerContainer);
		topPanel.add(ballSelectorPanel, BorderLayout.NORTH);
		
		topPanelBottomPart = new JPanel();
		topPanelBottomPart.setLayout(new BorderLayout());
		topPanelBottomPart.setBackground(Application.defaultBackgroundColor);
		
		
		ballLocationPanel = new JPanel(); // Grid panel containing four components
		ballLocationPanel.setLayout(new GridLayout(2, 2));
		ballLocationPanel.setBackground(Application.defaultBackgroundColor);
		
		xCoordinateLabel = new JLabel("X Coor.:");
		ballLocationPanel.add(xCoordinateLabel);
		listOfComponents.add(xCoordinateLabel);
		
		yCoordinateLabel = new JLabel("Y Coor.:");
		ballLocationPanel.add(yCoordinateLabel);
		listOfComponents.add(yCoordinateLabel);
		
		xCoordinateModel = new SpinnerNumberModel();
		xCoordinateModel.setMinimum(0);
		xCoordinateModel.setMaximum(640 - Application.currentBallWidth);
		
		yCoordinateModel = new SpinnerNumberModel();
		yCoordinateModel.setMinimum(0);
		yCoordinateModel.setMaximum(480 - Application.currentBallWidth);
		
		xCoordinateSpinner = new JSpinner();
		xCoordinateSpinner.setModel(xCoordinateModel);
		xCoordinateSpinner.setToolTipText("<html>Click on the spinner arrows to set the horizontal position<br/>"
				+ "of the ball to be launched from relative to the canvas.</html>");
		xCoordinateSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).xCoordinate);
		ballLocationPanel.add(xCoordinateSpinner);
		listOfComponents.add(xCoordinateSpinner);
		
		yCoordinateSpinner = new JSpinner();
		yCoordinateSpinner.setModel(yCoordinateModel);
		yCoordinateSpinner.setToolTipText("<html>Click on the spinner arrows to set the vertical position<br/>"
				+ "of the ball to be launched from relative to the canvas.</html>");
		yCoordinateSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).yCoordinate);
		ballLocationPanel.add(yCoordinateSpinner);
		listOfComponents.add(yCoordinateSpinner);
		
		topPanelBottomPart.add(ballLocationPanel, BorderLayout.NORTH);
		
		ballSpeedPanel = new JPanel(); // Grid panel containing four components
		ballSpeedPanel.setLayout(new GridLayout(2, 2));
		ballSpeedPanel.setBackground(Application.defaultBackgroundColor);
		
		dxLabel = new JLabel("X Speed:");
		ballSpeedPanel.add(dxLabel);
		listOfComponents.add(dxLabel);
		
		dyLabel = new JLabel("Y Speed:");
		ballSpeedPanel.add(dyLabel);
		listOfComponents.add(dyLabel);
		
		dxModel = new SpinnerNumberModel();
		dxModel.setMinimum(AnimatedBall.minDX);
		dxModel.setMaximum(AnimatedBall.maxDX);
		
		dyModel = new SpinnerNumberModel();
		dyModel.setMinimum(AnimatedBall.minDY);
		dyModel.setMaximum(AnimatedBall.maxDY);
		
		dxSpinner = new JSpinner();
		dxSpinner.setModel(dxModel);
		dxSpinner.setToolTipText("Select the horizontal speed of the ball using the spinner arrows.");
		dxSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDX);
		ballSpeedPanel.add(dxSpinner);
		listOfComponents.add(dxSpinner);
		
		dySpinner = new JSpinner();
		dySpinner.setModel(dyModel);
		dySpinner.setToolTipText("Select the vertical speed of the ball using the spinner arrows.");
		dySpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDY);
		ballSpeedPanel.add(dySpinner);
		listOfComponents.add(dySpinner);
		
		topPanelBottomPart.add(ballSpeedPanel);
		
		ballWidthPanel = new JPanel(); // Grid panel containing two components
		ballWidthPanel.setLayout(new GridLayout(1, 2));
		ballWidthPanel.setBackground(Application.defaultBackgroundColor);
		
		ballWidthLabel = new JLabel("Ball width: ");
		ballWidthPanel.add(ballWidthLabel);
		listOfComponents.add(ballWidthLabel);
		
		ballWidthSpinnerModel = new SpinnerNumberModel();
		ballWidthSpinnerModel.setMinimum(AnimatedBall.minBallWidth);
		ballWidthSpinnerModel.setMaximum(AnimatedBall.maxBallWidth);
		
		ballWidthSpinner = new JSpinner();
		ballWidthSpinner.setModel(ballWidthSpinnerModel);
		ballWidthSpinner.setToolTipText("Set the width of the new ball using this spinner.");
		ballWidthSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballWidth);
		ballWidthSpinner.addChangeListener(new BallWidthSpinnerListener());
		ballWidthPanel.add(ballWidthSpinner);
		listOfComponents.add(ballWidthSpinner);
		
		topPanelBottomPart.add(ballWidthPanel, BorderLayout.SOUTH);
		
		topPanel.add(topPanelBottomPart);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		
		/*
		 *  Middle Panel Build
		 */
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		middlePanel.setBackground(Application.defaultBackgroundColor);
		
		randomizationOptionsPanel = new JPanel();
		// Complete with five checkboxes in a 1 by 5 grid.
		randomizationOptionsPanel.setLayout(new GridLayout(1, 5));
		
		randomizeDXCheckbox = new JCheckBox("Randomize DX");
		randomizeDXCheckbox.setToolTipText("<html>Click here to make the program change the horizontal speed of the ball<br/>"
				+ "every time it hits a wall.</html>");
		randomizeDXCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDX);
		randomizationOptionsPanel.add(randomizeDXCheckbox);
		listOfComponents.add(randomizeDXCheckbox);
		
		randomizeDYCheckbox = new JCheckBox("Randomize DY");
		randomizeDYCheckbox.setToolTipText("<html>Click here to make the program change the vertical speed of the ball<br/>"
				+ "every time it hits a wall.</html>");
		randomizeDYCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDY);
		randomizationOptionsPanel.add(randomizeDYCheckbox);
		listOfComponents.add(randomizeDYCheckbox);
		
		ballHasOutlineCheckbox = new JCheckBox("Ball has outline", true);
		ballHasOutlineCheckbox.setToolTipText("Checking this box will make the ball display an outline on its canvas.");
		ballHasOutlineCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballHasOutline);
		ballHasOutlineCheckbox.addItemListener(new CheckBoxListener());
		randomizationOptionsPanel.add(ballHasOutlineCheckbox);
		listOfComponents.add(ballHasOutlineCheckbox);
		
		randomizeBallColorCheckbox = new JCheckBox("<html>Randomize Ball<br/>Color</html>");
		randomizeBallColorCheckbox.setToolTipText("<html>Click here to make the program change the ball's color<br/>"
				+ "every time it hits a wall.</html>");
		randomizeBallColorCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallColor);
		randomizationOptionsPanel.add(randomizeBallColorCheckbox);
		listOfComponents.add(randomizeBallColorCheckbox);
		
		randomizeBallOutlineColorCheckbox = new JCheckBox("<html>Randomize Ball<br/>Outline Color</html>");
		randomizeBallOutlineColorCheckbox.setToolTipText("<html>Click here to make the program change the ball's outline color<br/>"
				+ "every time it hits a wall.</html>");
		randomizeBallOutlineColorCheckbox.
			setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallOutlineColor);
		randomizationOptionsPanel.add(randomizeBallOutlineColorCheckbox);
		listOfComponents.add(randomizeBallOutlineColorCheckbox);
		
		middlePanel.add(randomizationOptionsPanel, BorderLayout.NORTH);
		
		
		
		ballColorPanel = new JPanel();
		ballColorPanel.setLayout(new BorderLayout());
		ballColorPanel.setBackground(Application.defaultBackgroundColor);
		// Same scheme as the original ApplicationBallCommonColorDialog minus radio buttons.
		
		commandLabel = new JLabel("Select a color for the ball either using this combo box or the spinners below.");
		ballColorPanel.add(commandLabel, BorderLayout.NORTH);
		listOfComponents.add(commandLabel);
		
		commonColorComboBox = new JComboBox<String>(choices);
		commonColorComboBox.addActionListener(new ComboBoxListener());
		ballColorPanel.add(commonColorComboBox);
		listOfComponents.add(commonColorComboBox);
		
		ballColorPanelBottomPart = new JPanel();
		ballColorPanelBottomPart.setLayout(new GridLayout(2,3));
		ballColorPanelBottomPart.setBackground(Application.defaultBackgroundColor);
		colorSpinnerModel1 = new SpinnerNumberModel();
		colorSpinnerModel2 = new SpinnerNumberModel();
		colorSpinnerModel3 = new SpinnerNumberModel();
		
		colorSpinnerModel1.setMinimum(0);
		colorSpinnerModel1.setMaximum(255);
		
		colorSpinnerModel2.setMinimum(0);
		colorSpinnerModel2.setMaximum(255);
		
		colorSpinnerModel3.setMinimum(0);
		colorSpinnerModel3.setMaximum(255);
		
		redLabel = new JLabel("Red:");
		redLabel.setFont(Application.defaultFont);
		redLabel.setBackground(Application.defaultBackgroundColor);
		redLabel.setForeground(Color.RED);
		ballColorPanelBottomPart.add(redLabel);
		
		redSpinner = new JSpinner();
		redSpinner.setModel(colorSpinnerModel1);
		redSpinner.setToolTipText("Set the red component of the ball's color with this spinner.");
		redSpinner.addChangeListener(new SpinnerListener());
		listOfComponents.add(redSpinner);
		
		greenLabel = new JLabel("Green:");
		greenLabel.setFont(Application.defaultFont);
		greenLabel.setBackground(Application.defaultBackgroundColor);
		greenLabel.setForeground(Color.GREEN);
		ballColorPanelBottomPart.add(greenLabel);
		
		greenSpinner = new JSpinner();
		greenSpinner.setModel(colorSpinnerModel2);
		greenSpinner.setToolTipText("Set the green component of the ball's color with this spinner.");
		greenSpinner.addChangeListener(new SpinnerListener());
		listOfComponents.add(greenSpinner);
		
		blueLabel = new JLabel("Blue:");
		blueLabel.setFont(Application.defaultFont);
		blueLabel.setBackground(Application.defaultBackgroundColor);
		blueLabel.setForeground(Color.BLUE);
		ballColorPanelBottomPart.add(blueLabel);
		
		blueSpinner = new JSpinner();
		blueSpinner.setModel(colorSpinnerModel3);
		blueSpinner.setToolTipText("Set the blue component of the ball's color with this spinner.");
		blueSpinner.addChangeListener(new SpinnerListener());
		listOfComponents.add(blueSpinner);
		
		ballColorPanelBottomPart.add(redSpinner);
		ballColorPanelBottomPart.add(greenSpinner);
		ballColorPanelBottomPart.add(blueSpinner);
		
		ballColorPanel.add(ballColorPanelBottomPart, BorderLayout.SOUTH);
		
		middlePanel.add(ballColorPanel);
		
		
		
		ballOutlineColorPanel = new JPanel();
		ballOutlineColorPanel.setLayout(new BorderLayout());
		ballOutlineColorPanel.setBackground(Application.defaultBackgroundColor);
		// Same scheme as the original ApplicationBallCommonOutlineColorDialog minus radio buttons.
		commandLabel2 = new JLabel("Select an outline color for the ball either using this combo box or the spinners below.");
		ballOutlineColorPanel.add(commandLabel2, BorderLayout.NORTH);
		listOfComponents.add(commandLabel2);
		
		commonColorComboBox2 = new JComboBox<String>(choices);
		commonColorComboBox2.addActionListener(new ComboBoxListener2());
		ballOutlineColorPanel.add(commonColorComboBox2);
		listOfComponents.add(commonColorComboBox2);
		
		ballOutlineColorPanelBottomPart = new JPanel();
		ballOutlineColorPanelBottomPart.setLayout(new GridLayout(2,3));
		ballOutlineColorPanelBottomPart.setBackground(Application.defaultBackgroundColor);
		colorSpinnerModel4 = new SpinnerNumberModel();
		colorSpinnerModel5 = new SpinnerNumberModel();
		colorSpinnerModel6 = new SpinnerNumberModel();
		
		redLabel2 = new JLabel("Red:");
		redLabel2.setFont(Application.defaultFont);
		redLabel2.setBackground(Application.defaultBackgroundColor);
		redLabel2.setForeground(Color.RED);
		ballOutlineColorPanelBottomPart.add(redLabel2);
		
		redSpinner2 = new JSpinner();
		redSpinner2.setModel(colorSpinnerModel4);
		redSpinner2.setToolTipText("Set the red component of the ball's outline color with this spinner.");
		redSpinner2.addChangeListener(new SpinnerListener2());
		listOfComponents.add(redSpinner2);
		
		greenLabel2 = new JLabel("Green:");
		greenLabel2.setFont(Application.defaultFont);
		greenLabel2.setBackground(Application.defaultBackgroundColor);
		greenLabel2.setForeground(Color.GREEN);
		ballOutlineColorPanelBottomPart.add(greenLabel2);
		
		greenSpinner2 = new JSpinner();
		greenSpinner2.setModel(colorSpinnerModel5);
		greenSpinner2.setToolTipText("Set the green component of the ball's outline color with this spinner.");
		greenSpinner2.addChangeListener(new SpinnerListener2());
		listOfComponents.add(greenSpinner2);
		
		blueLabel2 = new JLabel("Blue:");
		blueLabel2.setFont(Application.defaultFont);
		blueLabel2.setBackground(Application.defaultBackgroundColor);
		blueLabel2.setForeground(Color.BLUE);
		ballOutlineColorPanelBottomPart.add(blueLabel2);
		
		blueSpinner2 = new JSpinner();
		blueSpinner2.setModel(colorSpinnerModel6);
		blueSpinner2.setToolTipText("Set the blue component of the ball's outline color with this spinner.");
		blueSpinner2.addChangeListener(new SpinnerListener2());
		listOfComponents.add(blueSpinner2);
		
		ballOutlineColorPanelBottomPart.add(redSpinner2);
		ballOutlineColorPanelBottomPart.add(greenSpinner2);
		ballOutlineColorPanelBottomPart.add(blueSpinner2);
		
		ballOutlineColorPanel.add(ballOutlineColorPanelBottomPart, BorderLayout.SOUTH);
		
		redSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getRed());
		greenSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getGreen());
		blueSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getBlue());
		
		middlePanel.add(ballOutlineColorPanel, BorderLayout.SOUTH);
		
		initializeCheckboxes();
		
		mainPanel.add(middlePanel);
		
		/*
		 * Bottom Panel Build
		 */
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBackground(Application.defaultBackgroundColor);
		
		directionPanel = new JPanel();
		directionPanel.setBackground(Application.defaultBackgroundColor);
		// Setting initial direction
		horizontalDirectionRadioButtonGroup = new ButtonGroup();
		leftRadioButton = new JRadioButton("Left");
		leftRadioButton.setToolTipText("Make the ball go left initially.");
		horizontalDirectionRadioButtonGroup.add(leftRadioButton);
		directionPanel.add(leftRadioButton);
		listOfComponents.add(leftRadioButton);
		
		rightRadioButton = new JRadioButton("Right");
		rightRadioButton.setToolTipText("Make the ball go right initially.");
		horizontalDirectionRadioButtonGroup.add(rightRadioButton);
		directionPanel.add(rightRadioButton);
		listOfComponents.add(rightRadioButton);
		
		verticalDirectionRadioButtonGroup = new ButtonGroup();
		upRadioButton = new JRadioButton("Up");
		upRadioButton.setToolTipText("Make the ball go up initially.");
		verticalDirectionRadioButtonGroup.add(upRadioButton);
		directionPanel.add(upRadioButton);
		listOfComponents.add(upRadioButton);
		
		downRadioButton = new JRadioButton("Down");
		downRadioButton.setToolTipText("Make the ball go down initially.");
		verticalDirectionRadioButtonGroup.add(downRadioButton);
		directionPanel.add(downRadioButton);
		listOfComponents.add(downRadioButton);
		
		initializeDirectionalRadioButtons();
		
		bottomPanel.add(directionPanel, BorderLayout.NORTH);
		
		
		confirmationPanel = new JPanel();
		confirmationPanel.setBackground(Application.defaultBackgroundColor);
		// Radio buttons for Accept and Decline.
		acceptButton = new JRadioButton("Make changes");
		acceptButton.setToolTipText("Click it to change the properties of the selected ball.");
		acceptButton.addActionListener(new RadioButtonListener());
		confirmationPanel.add(acceptButton);
		listOfComponents.add(acceptButton);
		
		declineButton = new JRadioButton("Cancel");
		declineButton.setToolTipText("Go back to the main application and don't let the changes take effect.");
		declineButton.addActionListener(new RadioButtonListener());
		confirmationPanel.add(declineButton);
		listOfComponents.add(declineButton);
		bottomPanel.add(confirmationPanel);
		
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		/*
		 *  Component Initialization
		 */
		
		if (Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballHasOutline)
		{
			ballOutlineColorPanel.setEnabled(true);
			ballOutlineColorPanel.setToolTipText(null);
			
			commonColorComboBox2.setEnabled(true);
			commonColorComboBox2.setToolTipText(null);
			redSpinner2.setEnabled(true);
			redSpinner2.setToolTipText("Set the red component of the ball's outline color with this spinner.");
			greenSpinner2.setEnabled(true);
			greenSpinner2.setToolTipText("Set the green component of the ball's outline color with this spinner.");
			blueSpinner2.setEnabled(true);
			blueSpinner2.setToolTipText("Set the blue component of the ball's outline color with this spinner.");
		}
		else
		{
			ballOutlineColorPanel.setEnabled(false);
			ballOutlineColorPanel.setToolTipText("Ball outline components are disabled because you have asked not to include an outline.");
			
			commonColorComboBox2.setEnabled(false);
			commonColorComboBox2.setToolTipText(ballOutlineColorPanel.getToolTipText());
			redSpinner2.setEnabled(false);
			redSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
			greenSpinner2.setEnabled(false);
			greenSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
			blueSpinner2.setEnabled(false);
			blueSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
		}
		
		for(int z = 0; z < listOfComponents.size(); z++)
		{
			if (listOfComponents.get(z) instanceof JRadioButton || listOfComponents.get(z) instanceof JLabel ||
					listOfComponents.get(z) instanceof JSpinner || listOfComponents.get(z) instanceof JCheckBox ||
					listOfComponents.get(z) instanceof JComboBox)
			{
				listOfComponents.get(z).setFont(Application.currentFont);
				listOfComponents.get(z).setForeground(Application.defaultFontColor);
				listOfComponents.get(z).setBackground(Application.defaultBackgroundColor);
				listOfComponents.get(z).setBorder(null);
			}
		}
		
		/*
		 *  Frame Assembly
		 */
		
		utilityFrame.add(mainPanel);
		
		/*
		 *  Frame Initialization
		 */
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Editing A Ball", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
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
			if (colorObjects[x].getRed() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed() &&
					colorObjects[x].getGreen() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen() &&
					colorObjects[x].getBlue() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue())
			{
				commonColorComboBox.setSelectedIndex(x);
				ballColorMatchFound = true;
				
				x = colorObjects.length - 1;
			}
		}
		
		if (x == choices.length - 1 && !ballColorMatchFound)
			commonColorComboBox.setSelectedIndex(x);
		
		redSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed());
		greenSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen());
		blueSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue());
		
		boolean ballOutlineColorMatchFound = false;
		int y = 0;
		
		for(; y < colorObjects.length; y++)
		{
			if (colorObjects[y].getRed() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed() &&
					colorObjects[y].getGreen() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen() &&
					colorObjects[y].getBlue() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue())
			{
				commonColorComboBox.setSelectedIndex(y);
				ballOutlineColorMatchFound = true;
				
				y = colorObjects.length - 1;
			}
		}
		
		if (y == choices.length - 1 && !ballOutlineColorMatchFound)
			commonColorComboBox.setSelectedIndex(y);
		
	}
	
	void initializeDirectionalRadioButtons()
	{
		if (!Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingRight)
		{
			leftRadioButton.setSelected(true);
			rightRadioButton.setSelected(false);
		}
		else
		{
			leftRadioButton.setSelected(false);
			rightRadioButton.setSelected(true);
		}
		
		if (!Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingDown)
		{
			upRadioButton.setSelected(true);
			downRadioButton.setSelected(false);
		}
		else
		{
			upRadioButton.setSelected(false);
			downRadioButton.setSelected(true);
		}
		
	}
	
	private class BallSelectSpinnerListener implements ChangeListener
	{	
		public void stateChanged(ChangeEvent eventObject) 
		{
			xCoordinateSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).xCoordinate);
			yCoordinateSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).yCoordinate);
			
			dxSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDX);
			dySpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDY);
			
			ballWidthSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballWidth);
			
			randomizeDXCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDX);
			randomizeDYCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDY);
			ballHasOutlineCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballHasOutline);
			
			if (ballHasOutlineCheckbox.isSelected())
			{
				ballOutlineColorPanel.setEnabled(true);
				ballOutlineColorPanel.setToolTipText(null);
				
				commonColorComboBox2.setEnabled(true);
				commonColorComboBox2.setToolTipText(null);
				redSpinner2.setEnabled(true);
				redSpinner2.setToolTipText("Set the red component of the ball's outline color with this spinner.");
				greenSpinner2.setEnabled(true);
				greenSpinner2.setToolTipText("Set the green component of the ball's outline color with this spinner.");
				blueSpinner2.setEnabled(true);
				blueSpinner2.setToolTipText("Set the blue component of the ball's outline color with this spinner.");
			}
			else
			{
				ballOutlineColorPanel.setEnabled(false);
				ballOutlineColorPanel.setToolTipText("Ball outline components are disabled because you have asked not to include an outline.");
				
				commonColorComboBox2.setEnabled(false);
				commonColorComboBox2.setToolTipText(ballOutlineColorPanel.getToolTipText());
				redSpinner2.setEnabled(false);
				redSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
				greenSpinner2.setEnabled(false);
				greenSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
				blueSpinner2.setEnabled(false);
				blueSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
			}
			
			randomizeBallColorCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallColor);
			randomizeBallOutlineColorCheckbox.setSelected(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallOutlineColor);
		
			boolean ballColorMatchFound = false;
			int x = 0;
			
			for(; x < colorObjects.length; x++)
			{
				if (colorObjects[x].getRed() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed() &&
						colorObjects[x].getGreen() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen() &&
						colorObjects[x].getBlue() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue())
				{
					commonColorComboBox.setSelectedIndex(x);
					ballColorMatchFound = true;
					
					x = colorObjects.length - 1;
				}
			}
			
			if (x == choices.length - 1 && !ballColorMatchFound)
				commonColorComboBox.setSelectedIndex(x);
			
			redSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed());
			greenSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen());
			blueSpinner.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue());
			
			boolean ballOutlineColorMatchFound = false;
			int y = 0;
			
			for(; y < colorObjects.length; y++)
			{
				if (colorObjects[y].getRed() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getRed() &&
						colorObjects[y].getGreen() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getGreen() &&
						colorObjects[y].getBlue() == Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor.getBlue())
				{
					commonColorComboBox.setSelectedIndex(y);
					ballOutlineColorMatchFound = true;
					
					y = colorObjects.length - 1;
				}
			}
			
			if (y == choices.length - 1 && !ballOutlineColorMatchFound)
				commonColorComboBox.setSelectedIndex(y);
			
			redSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getRed());
			greenSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getGreen());
			blueSpinner2.setValue(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor.getBlue());
			
			if (!Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingRight)
			{
				leftRadioButton.setSelected(true);
				rightRadioButton.setSelected(false);
			}
			else
			{
				leftRadioButton.setSelected(false);
				rightRadioButton.setSelected(true);
			}
			
			if (!Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingDown)
			{
				upRadioButton.setSelected(true);
				downRadioButton.setSelected(false);
			}
			else
			{
				upRadioButton.setSelected(false);
				downRadioButton.setSelected(true);
			}
		}
		
	}
	
	private class CheckBoxListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent eventObject) 
		{
			if (eventObject.getSource().toString().contains(ballHasOutlineCheckbox.getText()))
			{
				if (ballHasOutlineCheckbox.isSelected())
				{
					ballOutlineColorPanel.setEnabled(true);
					ballOutlineColorPanel.setToolTipText(null);
					
					commonColorComboBox2.setEnabled(true);
					commonColorComboBox2.setToolTipText(null);
					redSpinner2.setEnabled(true);
					redSpinner2.setToolTipText("Set the red component of the ball's outline color with this spinner.");
					greenSpinner2.setEnabled(true);
					greenSpinner2.setToolTipText("Set the green component of the ball's outline color with this spinner.");
					blueSpinner2.setEnabled(true);
					blueSpinner2.setToolTipText("Set the blue component of the ball's outline color with this spinner.");
				}
				else
				{
					ballOutlineColorPanel.setEnabled(false);
					ballOutlineColorPanel.setToolTipText("Ball outline components are disabled because you have asked not to include an outline.");
					
					commonColorComboBox2.setEnabled(false);
					commonColorComboBox2.setToolTipText(ballOutlineColorPanel.getToolTipText());
					redSpinner2.setEnabled(false);
					redSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
					greenSpinner2.setEnabled(false);
					greenSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
					blueSpinner2.setEnabled(false);
					blueSpinner2.setToolTipText(ballOutlineColorPanel.getToolTipText());
				}
			}
		}
	}
	
	// Listener for the ball color combo box.
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
	
	// Listener for the ball width spinner
	private class BallWidthSpinnerListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent arg0) 
		{
			xCoordinateModel.setMaximum(640 - (Integer)ballWidthSpinner.getValue());
			yCoordinateModel.setMaximum(480 - (Integer)ballWidthSpinner.getValue());
			
			if ((Integer)xCoordinateSpinner.getValue() > 640 - (Integer)ballWidthSpinner.getValue())
				xCoordinateSpinner.setValue((Integer)640 - (Integer)ballWidthSpinner.getValue());
			
			if ((Integer)yCoordinateSpinner.getValue() > 480 - (Integer)ballWidthSpinner.getValue())
				yCoordinateSpinner.setValue((Integer)480 - (Integer)ballWidthSpinner.getValue());
		}
	}
	
	// Listener for the ball color spinners below the combo box.
	private class SpinnerListener implements ChangeListener
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
	
	// Listener for the ball outline color combo box.
	private class ComboBoxListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			for (int x = 0; x < colorObjects.length; x++)
			{
				if (((String)commonColorComboBox2.getSelectedItem()).equals(choices[x]))
				{
					redSpinner2.setValue((Integer)colorObjects[x].getRed());
					greenSpinner2.setValue((Integer)colorObjects[x].getGreen());
					blueSpinner2.setValue((Integer)colorObjects[x].getBlue());
					
					x = colorObjects.length - 1;
				}
			}
		}
	}
	
	// Listener for the ball outline color spinners below the combo box.
	private class SpinnerListener2 implements ChangeListener
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
	
	// Listener for the radio buttons at the bottom of the utility.
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent g)
		{
			if (g.getSource().toString().contains(acceptButton.getText()))
			{
				Application.currentBallToEditIndex = (Integer)ballSelectSpinner.getValue() - 1;
				
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballWidth = (Integer)ballWidthSpinner.getValue();
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).xCoordinate = (Integer)xCoordinateSpinner.getValue();
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).yCoordinate = (Integer)yCoordinateSpinner.getValue();
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDX = (Integer)dxSpinner.getValue();
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).currentDY = (Integer)dySpinner.getValue();
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor 
					= new java.awt.Color((Integer)redSpinner.getValue(), (Integer)greenSpinner.getValue(), (Integer)blueSpinner.getValue());
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballHasOutline
					= ballHasOutlineCheckbox.isSelected();
						
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor 
					= new java.awt.Color((Integer)redSpinner2.getValue(), (Integer)greenSpinner2.getValue(), (Integer)blueSpinner2.getValue());
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDX = randomizeDXCheckbox.isSelected();
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeCurrentDY = randomizeDYCheckbox.isSelected();
					
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallColor = randomizeBallColorCheckbox.isSelected();
				Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).randomizeBallOutlineColor = randomizeBallOutlineColorCheckbox.isSelected();
					
				if (leftRadioButton.isSelected())
					Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingRight = false;
				else if (rightRadioButton.isSelected())
					Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingRight = true;
					
				if (upRadioButton.isSelected())
					Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingDown = false;
				else if (downRadioButton.isSelected())
					Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).goingDown = true;
						
				Application.canvas.ballDraws.get((Integer)ballSelectSpinner.getValue() - 1).setColor(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballColor);
						
				Application.canvas.ballOutlineDraws.get((Integer)ballSelectSpinner.getValue() - 1).setColor(Application.canvas.ballList.get((Integer)ballSelectSpinner.getValue() - 1).ballOutlineColor);
			}
			
			Application.animationTimer.start();
			Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			
			utilityFrame.dispose();
			Application.mainFrame.setEnabled(true);
		}
	}
}