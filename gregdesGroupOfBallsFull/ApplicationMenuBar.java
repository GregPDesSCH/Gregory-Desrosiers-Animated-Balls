package gregdesGroupOfBallsFull;

import javax.swing.*;

final class ApplicationMenuBar extends JMenuBar 
{
	private static final long serialVersionUID = -8958497343273308219L;

	// Storage Component
	private java.util.ArrayList<JComponent> array = new java.util.ArrayList<JComponent>();
	
	// Menu Components
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu musicMenu;
	private JMenu settingsMenu;
	private JMenu helpMenu;
	
	// Submenu Components
	private JMenu quickSettingsMenu;
	
	// File Menu Components
	public JMenuItem stopButton;
	public JMenuItem startButton;
	private JSeparator fileMenuSeparatorBar;
	public JMenuItem quitButton;
	
	// Edit Menu Components
	public JMenuItem editABallButton;
	private JSeparator editMenuSeparatorBar1;
	public JMenuItem addABallButton;
	public JMenuItem addMultipleBallsButton; // New button to work on
	public JMenuItem removeABallButton;
	private JSeparator editMenuSeparatorBar2;
	public JMenuItem selectAColorForAllBallsButton;
	public JMenuItem selectAnOutlineColorForAllBallsButton;
	public JMenuItem selectAWidthForAllBallsButton;
	private JSeparator editMenuSeparatorBar3;
	public JMenuItem makeAllBallsHaveOutlinesButton;
	public JMenuItem makeAllBallsHaveNoOutlinesButton;
	private JSeparator editMenuSeparatorBar4;
	public JMenuItem randomizeAllBallsButton;
	public JMenuItem randomizeAllBallColorsButton;
	public JMenuItem randomizeAllBallOutlineColorsButton;
	public JMenuItem randomizeLocationOfAllBallsButton;
	public JMenuItem randomizeSpeedInXDirectionForAllBallsButton;
	public JMenuItem randomizeSpeedInYDirectionForAllBallsButton;
	public JMenuItem randomizeWidthOfAllBallsButton;
	private JSeparator editMenuSeparatorBar5;
	public JMenuItem ballColorRandomizationFlagButton;
	public JMenuItem ballOutlineColorRandomizationFlagButton;
	
	// Music Menu Components
	public JMenuItem loadMusicButton;
	private JSeparator musicMenuSeparatorBar1;
	public JMenuItem playMusicButton;
	public JMenuItem loopMusicButton;
	public JMenuItem stopMusicButton;
	private JSeparator musicMenuSeparatorBar2;
	public JMenuItem infoOnMusicButton;
	
	// Settings Menu Components
	private JSeparator settingsMenuSeparatorBar;
	public JMenuItem mainSettingsButton;
	public JMenuItem controlButton;
	
	// Quick Settings Menu Components
	public JMenuItem increaseRenderingSpeedButton;
	public JMenuItem decreaseRenderingSpeedButton;
	private JSeparator quickSettingsSeparatorBar;
	public JMenuItem increaseMaxBallCountButton;
	public JMenuItem decreaseMaxBallCountButton;
	
	// Help Menu Components
	public JMenuItem helpButton;
	public JMenuItem aboutButton;
	
	// Display Properties
	public java.awt.Font currentFont;
	public java.awt.Color currentFontColor;
	public java.awt.Color currentBackgroundColor;
	
	protected static final java.awt.Color defaultFontColor = java.awt.Color.WHITE;
	protected static final java.awt.Color defaultBackgroundColor = java.awt.Color.RED;
	
	ApplicationMenuBar()
	{
		// Main Menu Builds
		fileMenu = new JMenu("File");
		fileMenu.setToolTipText("Control the animation or quit the program here.");
		
		editMenu = new JMenu("Edit");
		editMenu.setToolTipText("<html>Click here to view and select what you want to<br/>do with the balls seen here.</html>");
		
		musicMenu = new JMenu("Music");
		musicMenu.setToolTipText("Choose and control the playback of your music right here!");
		
		settingsMenu = new JMenu("Settings");
		settingsMenu.setToolTipText("Change certain settings for your convenience.");
		
		helpMenu = new JMenu("Help");
		helpMenu.setToolTipText("Consider the Help Window or view the About Window.");
		
		quickSettingsMenu = new JMenu("Quick Settings");
		quickSettingsMenu.setToolTipText("Choose your settings quickly rather than taking the longer process.");
		
		// File Menu Build
		stopButton = new JMenuItem("Stop");
		stopButton.setToolTipText("Stops the animation.");
		
		startButton = new JMenuItem("Start");
		startButton.setToolTipText("Restarts the animation again.");
		
		fileMenuSeparatorBar = new JSeparator();
		quitButton = new JMenuItem("Quit");
		quitButton.setToolTipText("Click here to quit the program.");
		
		// Edit Menu Build
		editABallButton = new JMenuItem("Edit A Ball");
		editABallButton.setToolTipText("Set a ball's properties with your predetermined choice.");
		
		editMenuSeparatorBar1 = new JSeparator();
		
		addABallButton = new JMenuItem("Add A Ball");
		addABallButton.setToolTipText("Adds a ball to the animation canvas.");
		
		removeABallButton = new JMenuItem("Remove A Ball");
		removeABallButton.setToolTipText("Removes a ball from the animation canvas.");
		
		editMenuSeparatorBar2 = new JSeparator();
		
		selectAColorForAllBallsButton = new JMenuItem("Color for all balls...");
		selectAColorForAllBallsButton.setToolTipText("Click here to choose a color to be used for all of the animated balls.");
		
		selectAnOutlineColorForAllBallsButton = new JMenuItem("Outline color for all balls...");
		selectAnOutlineColorForAllBallsButton.setToolTipText("What color do you want for the outline of all balls? Click here to choose!");
		
		selectAWidthForAllBallsButton = new JMenuItem("Width of all balls");
		selectAWidthForAllBallsButton.setToolTipText("Select a common width for all balls.");
		
		editMenuSeparatorBar3 = new JSeparator();
		
		makeAllBallsHaveOutlinesButton = new JMenuItem("Make all balls have outlines");
		makeAllBallsHaveOutlinesButton.setToolTipText("Enables all balls to have outlines.");
		
		makeAllBallsHaveNoOutlinesButton = new JMenuItem("Make all balls have no outlines");
		makeAllBallsHaveNoOutlinesButton.setToolTipText("Disables the outline feature in all existing balls.");
		
		editMenuSeparatorBar4 = new JSeparator();
		
		randomizeAllBallsButton = new JMenuItem("Randomize all balls");
		randomizeAllBallsButton.setToolTipText("Click to automatically randomize all properties of the existing balls.");
		
		randomizeAllBallColorsButton = new JMenuItem("Randomize colors of all balls");
		randomizeAllBallColorsButton.setToolTipText("Changes colors of all balls randomly.");
		
		randomizeAllBallOutlineColorsButton = new JMenuItem("Randomize outline colors of all balls");
		randomizeAllBallOutlineColorsButton.setToolTipText("Changes the colors of all balls' outlines randomly.");
		
		randomizeLocationOfAllBallsButton = new JMenuItem("Randomize location of all balls");
		randomizeLocationOfAllBallsButton.setToolTipText("Sets the location of each existing ball randomly on the animation canvas.");
		
		randomizeSpeedInXDirectionForAllBallsButton = new JMenuItem("Randomize speed in X direction for all balls");
		randomizeSpeedInXDirectionForAllBallsButton.setToolTipText("<html>Randomly changes the rate of change for the horizontal coordinate<br/>in each existing ball.</html>");
		
		randomizeSpeedInYDirectionForAllBallsButton = new JMenuItem("Randomize speed in Y direction for all balls");
		randomizeSpeedInYDirectionForAllBallsButton.setToolTipText("<html>Randomly changes the rate of change for the vertical coordinate<br/>in each existing ball.</html>");
		
		randomizeWidthOfAllBallsButton = new JMenuItem("Randomize width of all balls");
		randomizeWidthOfAllBallsButton.setToolTipText("<html>Changes the width of each existing ball with a random number."
				+ "<br/>Some balls will be smaller, some will be larger, while only a few will be the same size.</html>");
		
		editMenuSeparatorBar5 = new JSeparator();
		
		ballColorRandomizationFlagButton = new JMenuItem("Disable ball color randomization");
		ballColorRandomizationFlagButton.setToolTipText("Toggles the randomization option of the color for each ball when it hits a wall.");
		
		ballOutlineColorRandomizationFlagButton = new JMenuItem("Disable ball outline color randomization");
		ballOutlineColorRandomizationFlagButton.setToolTipText("Toggles the option to randomize each ball's outline color when it hits a wall.");
		
		// Music Menu Build
		loadMusicButton = new JMenuItem("Load Music");
		loadMusicButton.setToolTipText("Load a music file.");
		
		musicMenuSeparatorBar1 = new JSeparator();
		
		playMusicButton = new JMenuItem("Play");
		playMusicButton.setToolTipText("Start listening to the music from the loaded file.");
		
		loopMusicButton = new JMenuItem("Loop");
		loopMusicButton.setToolTipText("Repeatedly plays the music file.");
		
		stopMusicButton = new JMenuItem("Stop");
		stopMusicButton.setToolTipText("<html>Discontinue listening to the music, if you don't want to hear it,<br/>or want to keep the application silent.</html>");
		
		musicMenuSeparatorBar2 = new JSeparator();
		
		infoOnMusicButton = new JMenuItem("Info on Music");
		infoOnMusicButton.setToolTipText("Click here to learn on integrating music files into this program.");
		
		// Settings Menu Build
		settingsMenuSeparatorBar = new JSeparator();
		mainSettingsButton = new JMenuItem("Main Settings");
		mainSettingsButton.setToolTipText("Select the major settings from here.");
		
		controlButton = new JMenuItem("Controls");
		controlButton.setToolTipText("Modify the control settings.");
		
		// Quick Settings Menu
		increaseRenderingSpeedButton = new JMenuItem("Increase Rendering Speed");
		increaseRenderingSpeedButton.setToolTipText("Reduces the time delay between canvas frames.");
		
		decreaseRenderingSpeedButton = new JMenuItem("Decrease Rendering Speed");
		decreaseRenderingSpeedButton.setToolTipText("Adds more to the delay between canvas frames.");
		
		
		quickSettingsSeparatorBar = new JSeparator();
		
		increaseMaxBallCountButton = new JMenuItem("Increase Max Ball Count");
		increaseMaxBallCountButton.setToolTipText("Allow more balls to appear in the canvas.");
		
		decreaseMaxBallCountButton = new JMenuItem("Decrease Max Ball Count");
		decreaseMaxBallCountButton.setToolTipText("Limit the number of balls down.");
		
		// Help
		helpButton = new JMenuItem("Help");
		helpButton.setToolTipText("Opens a separate window where you can view some handy text.");
		
		aboutButton = new JMenuItem("About");
		aboutButton.setToolTipText("View the program information.");
		
		/*
		 * Component Accumulation
		 */
		array.add(fileMenu);
		array.add(editMenu);
		array.add(musicMenu);
		array.add(settingsMenu);
		array.add(helpMenu);
		array.add(quickSettingsMenu);
		
		array.add(stopButton);
		array.add(startButton);
		array.add(fileMenuSeparatorBar);
		array.add(quitButton);
		
		array.add(editABallButton);
		array.add(editMenuSeparatorBar1);
		array.add(addABallButton);
		array.add(removeABallButton);
		array.add(editMenuSeparatorBar2);
		array.add(selectAColorForAllBallsButton);
		array.add(selectAnOutlineColorForAllBallsButton);
		array.add(selectAWidthForAllBallsButton);
		array.add(editMenuSeparatorBar3);
		array.add(makeAllBallsHaveOutlinesButton);
		array.add(makeAllBallsHaveNoOutlinesButton);
		array.add(editMenuSeparatorBar4);
		array.add(randomizeAllBallsButton);
		array.add(randomizeAllBallColorsButton);
		array.add(randomizeAllBallOutlineColorsButton);
		array.add(randomizeLocationOfAllBallsButton);
		array.add(randomizeSpeedInXDirectionForAllBallsButton);
		array.add(randomizeSpeedInYDirectionForAllBallsButton);
		array.add(randomizeWidthOfAllBallsButton);
		array.add(ballColorRandomizationFlagButton);
		array.add(ballOutlineColorRandomizationFlagButton);
		
		
		array.add(loadMusicButton);
		array.add(musicMenuSeparatorBar1);
		array.add(playMusicButton);
		array.add(loopMusicButton);
		array.add(stopMusicButton);
		array.add(musicMenuSeparatorBar2);
		array.add(infoOnMusicButton);
		
		array.add(settingsMenuSeparatorBar);
		array.add(mainSettingsButton);
		array.add(controlButton);
		
		array.add(increaseRenderingSpeedButton);
		array.add(decreaseRenderingSpeedButton);
		array.add(quickSettingsSeparatorBar);
		array.add(increaseMaxBallCountButton);
		array.add(decreaseMaxBallCountButton);
		
		// Quick Settings Menu
		array.add(helpButton);
		array.add(aboutButton);
		
		/*
		 * Display Property Sets
		 */
		// Current Use Initialization
		currentFont = Application.defaultFont;
		currentFontColor = defaultFontColor;
		currentBackgroundColor = defaultBackgroundColor;
		
		// Setting the Default Colors and Font, and Adding the Action Listener
		for(int x = 0; x < array.size(); x++)
		{
			array.get(x).setFont(currentFont);
			array.get(x).setForeground(currentFontColor);
			array.get(x).setBackground(currentBackgroundColor);
			
			if(array.get(x) instanceof JMenuItem)
				((JMenuItem)array.get(x)).addActionListener(new ApplicationMenuBarActionListener());
		}
		quickSettingsMenu.setForeground(java.awt.Color.BLACK);
				
		/*
		 * Menu Assembly
		 */
		
		// File Menu
		fileMenu.add(stopButton);
		fileMenu.add(startButton);
		fileMenu.add(fileMenuSeparatorBar);
		fileMenu.add(quitButton);
		
		// Edit Menu
		editMenu.add(editABallButton);
		editMenu.add(editMenuSeparatorBar1);
		editMenu.add(addABallButton);
		editMenu.add(removeABallButton);
		editMenu.add(editMenuSeparatorBar2);
		editMenu.add(selectAColorForAllBallsButton);
		editMenu.add(selectAnOutlineColorForAllBallsButton);
		editMenu.add(selectAWidthForAllBallsButton);
		editMenu.add(editMenuSeparatorBar3);
		editMenu.add(makeAllBallsHaveOutlinesButton);
		editMenu.add(makeAllBallsHaveNoOutlinesButton);
		editMenu.add(editMenuSeparatorBar4);
		editMenu.add(randomizeAllBallsButton);
		editMenu.add(randomizeAllBallColorsButton);
		editMenu.add(randomizeAllBallOutlineColorsButton);
		editMenu.add(randomizeLocationOfAllBallsButton);
		editMenu.add(randomizeSpeedInXDirectionForAllBallsButton);
		editMenu.add(randomizeSpeedInYDirectionForAllBallsButton);
		editMenu.add(randomizeWidthOfAllBallsButton);
		editMenu.add(editMenuSeparatorBar5);
		editMenu.add(ballColorRandomizationFlagButton);
		editMenu.add(ballOutlineColorRandomizationFlagButton);
		
		// Music Menu
		musicMenu.add(loadMusicButton);
		musicMenu.add(musicMenuSeparatorBar1);
		musicMenu.add(playMusicButton);
		musicMenu.add(loopMusicButton);
		musicMenu.add(stopMusicButton);
		musicMenu.add(musicMenuSeparatorBar2);
		musicMenu.add(infoOnMusicButton);
		
		loadMusicButton = new JMenuItem("Load Music");
		musicMenuSeparatorBar1 = new JSeparator();
		playMusicButton = new JMenuItem("Play");
		loopMusicButton = new JMenuItem("Loop");
		stopMusicButton = new JMenuItem("Stop");
		musicMenuSeparatorBar2 = new JSeparator();
		infoOnMusicButton = new JMenuItem("Info on Music");
		
		// Quick Settings Menu;
		quickSettingsMenu.add(increaseRenderingSpeedButton);
		quickSettingsMenu.add(decreaseRenderingSpeedButton);
		quickSettingsMenu.add(quickSettingsSeparatorBar);
		quickSettingsMenu.add(increaseMaxBallCountButton);
		quickSettingsMenu.add(decreaseMaxBallCountButton);
		
		// Settings Menu
		settingsMenu.add(quickSettingsMenu);
		settingsMenu.add(settingsMenuSeparatorBar);
		settingsMenu.add(mainSettingsButton);
		settingsMenu.add(controlButton);
		
		// Help Menu
		helpMenu.add(helpButton);
		helpMenu.add(aboutButton);
		
		// Finalization
		setBackground(java.awt.Color.BLACK);
		add(fileMenu);
		add(editMenu);
		add(musicMenu);
		add(settingsMenu);
		add(helpMenu);
	}
}