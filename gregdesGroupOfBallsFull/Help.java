package gregdesGroupOfBallsFull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;
import javax.swing.*;

final class Help extends JFrame
{	
	private static final long serialVersionUID = 1874053674600164729L;

	private JPanel mainPanel;
	
	private JTabbedPane tabPane;
	
	// First Tab
	private JPanel panel;
	private JTextArea textArea;
	protected JScrollPane scrollPane;
	
	/** Second Tab */
	private JPanel panel2;
	private JTabbedPane secondaryTabPane;
	
	private JPanel panel2_1;
	private JTextArea textArea2_1;
	protected JScrollPane scrollPane2_1;
	
	private JPanel panel2_2;
	private JTextArea textArea2_2;
	protected JScrollPane scrollPane2_2;
	
	private JPanel panel2_3;
	private JTextArea textArea2_3;
	protected JScrollPane scrollPane2_3;
	
	private JPanel panel2_4;
	private JTextArea textArea2_4;
	protected JScrollPane scrollPane2_4;
	
	private JPanel panel2_5;
	private JTextArea textArea2_5;
	protected JScrollPane scrollPane2_5;
	
	private JPanel panel2_6;
	private JTextArea textArea2_6;
	protected JScrollPane scrollPane2_6;
	
	private JPanel panel2_7;
	private JTextArea textArea2_7;
	protected JScrollPane scrollPane2_7;
	
	private JPanel panel2_8;
	private JTextArea textArea2_8;
	protected JScrollPane scrollPane2_8;
	
	private JPanel panel2_9;
	private JTextArea textArea2_9;
	protected JScrollPane scrollPane2_9;
	
	// Third Tab
	private JPanel panel3;
	private JTextArea textArea3;
	protected JScrollPane scrollPane3;
	
	// Fourth Tab
	private JPanel panel4;
	private JTextArea textArea4;
	protected JScrollPane scrollPane4;
	
	// Bottom Panel
	private JPanel confirmationPanel;
	private JRadioButton closeButton;
	
	// Component Array
	private java.util.ArrayList<JComponent> componentList = new java.util.ArrayList<JComponent>();
	
	// Application Properties
	private Border noBorder = null;
	public static final byte numberOfRows = 20;
	public static final byte numberOfColumns = 50;
	
	Help()
	{
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setLayout(new BorderLayout());
		
		
		tabPane = new JTabbedPane();
		tabPane.setBackground(Color.WHITE);
		tabPane.setFont(Application.defaultFont);
		 
		panel = new JPanel();
		textArea = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane = new JScrollPane(textArea);
		componentList.add(panel);
		componentList.add(textArea);
		componentList.add(scrollPane);
		
		panel2 = new JPanel();
		secondaryTabPane = new JTabbedPane();
		secondaryTabPane.setBackground(Color.WHITE);
		secondaryTabPane.setFont(Application.defaultFont);
		componentList.add(panel2);
	
		panel2_1 = new JPanel();
		textArea2_1 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_1  = new JScrollPane(textArea2_1);
		componentList.add(panel2_1);
		componentList.add(textArea2_1);
		componentList.add(scrollPane2_1);
	
		panel2_2 = new JPanel();
		textArea2_2 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_2 = new JScrollPane(textArea2_2);
		componentList.add(panel2_2);
		componentList.add(textArea2_2);
		componentList.add(scrollPane2_2);
	
		panel2_3 = new JPanel();
		textArea2_3 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_3 = new JScrollPane(textArea2_3);
		componentList.add(panel2_3);
		componentList.add(textArea2_3);
		componentList.add(scrollPane2_3);
	
		panel2_4 = new JPanel();
		textArea2_4 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_4 = new JScrollPane(textArea2_4);
		componentList.add(panel2_4);
		componentList.add(textArea2_4);
		componentList.add(scrollPane2_4);
		
		panel2_5 = new JPanel();
		textArea2_5 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_5 = new JScrollPane(textArea2_5);
		componentList.add(panel2_5);
		componentList.add(textArea2_5);
		componentList.add(scrollPane2_5);
		
		panel2_6 = new JPanel();
		textArea2_6 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_6 = new JScrollPane(textArea2_6);
		componentList.add(panel2_6);
		componentList.add(textArea2_6);
		componentList.add(scrollPane2_6);
		
		panel2_7 = new JPanel();
		textArea2_7 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_7  = new JScrollPane(textArea2_7);
		componentList.add(panel2_7);
		componentList.add(textArea2_7);
		componentList.add(scrollPane2_7);
		
		panel2_8 = new JPanel();
		textArea2_8 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_8 = new JScrollPane(textArea2_8);
		componentList.add(panel2_8);
		componentList.add(textArea2_8);
		componentList.add(scrollPane2_8);
		
		panel2_9 = new JPanel();
		textArea2_9 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane2_9 = new JScrollPane(textArea2_9);
		componentList.add(panel2_9);
		componentList.add(textArea2_9);
		componentList.add(scrollPane2_9);
		
		panel3 = new JPanel();
		textArea3 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane3 = new JScrollPane(textArea3);
		componentList.add(panel3);
		componentList.add(textArea3);
		componentList.add(scrollPane3);
		
		panel4 = new JPanel();
		textArea4 = new JTextArea(numberOfRows, numberOfColumns);
		scrollPane4 = new JScrollPane(textArea4);
		componentList.add(panel4);
		componentList.add(textArea4);
		componentList.add(scrollPane4);
		
		for (int x = 0; x < componentList.size(); x++)
		{
			componentList.get(x).setBorder(noBorder);
			
			if (componentList.get(x) instanceof JPanel)
			{
				((JPanel)componentList.get(x)).setLayout(new BorderLayout());
				((JPanel)componentList.get(x)).setBackground(Color.WHITE);
			}
			
			else if (componentList.get(x) instanceof JTextArea)
			{
				((JTextArea)componentList.get(x)).setBackground(Color.BLACK);
				((JTextArea)componentList.get(x)).setForeground(Color.WHITE);
				((JTextArea)componentList.get(x)).setFont(Application.defaultFont);
				((JTextArea)componentList.get(x)).setLineWrap(true);
				((JTextArea)componentList.get(x)).setWrapStyleWord(true);
				((JTextArea)componentList.get(x)).setEditable(false);
			}
			
			else if (componentList.get(x) instanceof JScrollPane)
			{
				((JScrollPane)componentList.get(x)).setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				((JScrollPane)componentList.get(x)).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			}
		}
		
		buildText();
		
		for (int z = 0; z < componentList.size(); z++)
			if (componentList.get(z) instanceof JTextArea)
				((JTextArea)componentList.get(z)).setCaretPosition(0);
		
		// Tab Panels Assembly
		panel.add(scrollPane);
		panel2_1.add(scrollPane2_1);
		panel2_2.add(scrollPane2_2);
		panel2_3.add(scrollPane2_3);
		panel2_4.add(scrollPane2_4);
		panel2_5.add(scrollPane2_5);
		panel2_6.add(scrollPane2_6);
		panel2_7.add(scrollPane2_7);
		panel2_8.add(scrollPane2_8);
		panel2_9.add(scrollPane2_9);
		panel3.add(scrollPane3);
		panel4.add(scrollPane4);
		
		// Panel2 Tab Pane Construction
		
		secondaryTabPane.addTab("Ball Outlines", panel2_7);
		secondaryTabPane.addTab("Randomization Options", panel2_8);
		secondaryTabPane.addTab("Music", panel2_9);
		secondaryTabPane.addTab("Color/Outline Color for all Balls", panel2_6);
		secondaryTabPane.addTab("How to Add A Ball with Options", panel2_5);
		secondaryTabPane.addTab("How to Edit A Ball", panel2_4);
		secondaryTabPane.addTab("How to Control Max Ball Count", panel2_3);
		secondaryTabPane.addTab("How to Control Animation", panel2_2);
		secondaryTabPane.addTab("How to Start & Stop Animation", panel2_1);
		
		secondaryTabPane.setSelectedIndex(secondaryTabPane.getTabCount() - 1);
		
		panel2.add(secondaryTabPane);
		
		// Tab Pane Construction
		tabPane.addTab("Main Settings and Controls", panel3);
		tabPane.addTab("FAQ", panel4);
		tabPane.addTab("Basic Instructions", panel);
		tabPane.addTab("How to Instructions", panel2);
		
		tabPane.setSelectedIndex(tabPane.getTabCount() - 2);
		
		mainPanel.add(tabPane);
		
		confirmationPanel = new JPanel();
		confirmationPanel.setBackground(Color.BLACK);
		
		closeButton = new JRadioButton("Close");
		closeButton.setFont(Application.defaultFont);
		closeButton.setBackground(Color.BLACK);
		closeButton.setForeground(Color.WHITE);
		
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent g)
			{
				Application.animationTimer.start();
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
				Application.numberOfHelpWindowsOpened = 0;
				
				dispose();
			}
		});
		
		confirmationPanel.add(closeButton);
		mainPanel.add(confirmationPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Help Board", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
		setResizable(false);
		setUndecorated(true);
		pack();
		setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (getHeight() / 2));
		setVisible(true);
	}
	
	public void buildText()
	{
		// Basic Instructions
		textArea.setText("When you start the program, you will see 10 revolving simple balls on the white canvas.\n\n"
				+ "Control the animation using the Start and Stop buttons in the File Menu, as"
				+ " well as the Increase & Decrease Rendering Speed buttons from the Quick Settings"
				+ " submenu in the Options Menu."
				+ "\n\nTo add a ball to the canvas, press either the Left or Up Arrow Key. You can "
				+ "also click on the Left Mouse Button. Remove the ball with the Right Arrow Key, "
				+ "Down Arrow Key, or the Right Mouse Button. If you have a mouse wheel or a "
				+ "trackball, you can adjust the number of balls in the canvas within a shorter "
				+ "amount of time by just rapidly scrolling up or down.\n\n"
				+ "You can also remove the ball anytime by going into the Edit Menu and click on "
				+ "\"Remove a ball.\"\n\n"
				+ "Anytime you want to quit the program, click on the Quit button in the File"
				+ " Menu, then click \"Yes\" on the dialog box. Alternatively you can click the "
				+ "Close Button on top of the window where you can stop running the program "
				+ "without opening the dialog box.");
		
		// How to Start & Stop Animation
		textArea2_1.setText("On the File Menu above the single separator bar, you have two buttons you can click;"
				+ " the Start Button and the Stop Button.\n\n\n\n"
				+ "Clicking on the Start Button will cause all the balls in the canvas to start moving. From there,"
				+ "the Animation Status Label you see at the bottom of the canvas will display to something like:\n\n"
				+ "\"Animation running. Rendering Delay: 30 milliseconds\"\n\n"
				+ "The rendering delay is how long for the canvas to display each frame before causing it to create"
				+ "a new one. This is the technique for computer-based animation: the program causes certain"
				+ "properties in all of the graphical objects you see to be changed with new data and therefore"
				+ "a transition between points occur.\n\n\n"
				+ "If you click on the button when the animation is already running, you will see a pop-up dialog.\n\n\n"
				+ "The Stop Button will halt, or pause, the rendering animation this program is creating. You will"
				+ "see the Animation Status Label change to \"Animation stopped\", denoting that the program is "
				+ "not handling the change in properties of all the visible graphics currently.\n\n"
				+ "You get a popup if you click on the same button where the animation has already stopped.\n\n\n"
				+ "For more details on controlling animation, click on the \"How to Control Animation\" Tab.\n");
		
		// How to Control Animation
		textArea2_2.setText("There is a way to control the rendering delay between frames, which allows you to"
				+ "obtain different frame rates for the application.\n\n"
				+ "On the Settings Menu, you will see a separate menu in a white background called \"Quick Settings\","
				+ " and in it are four different buttons. The first two top adjust the rendering speed for the canvas"
				+ " frames.\n\n"
				+ "When you start the program, the rendering delay is 25 milliseconds. That means if we were to neglect "
				+ "the time delay for all the balls to have their position and any other properties changed, the "
				+ "canvas would run at a constant 40 frames per second.\n\n"
				+ "Clicking on the Increase Rendering Speed button will make the rendering delay shorter and therefore"
				+ " the animation faster. Clicking on the Decrease Rendering Speed button will do the exact opposite.\n\n\n"
				+ "Keep in mind that there are limits set to the rendering delay. The minimum delay is 10 milliseconds,"
				+ " while the maximum is 50 milliseconds. Also, notice on how you may notice that the balls may move "
				+ "longer or shorter for each second; that's because regardless of the rendering delay, when the ball "
				+ "is freely moving towards one wall, it has the same change in its position for each frame. This "
				+ "means that you actually do not see more or less frames the animation creates for the same distance "
				+ "covered to each ball.\n\n\n"
				+ "The program does not use any mathematics to calculate the ball's position for each frame, regardless "
				+ "of frame rate, where at the end of any given period of time (more of a common time period"
				+ " based on the frame rate), the ball remains in the same position.");
		
		// How to Control Max Ball Count
		textArea2_3.setText("On the same menu to where you can control the animation (Quick Settings), you have"
				+ "two buttons below a separator bar. They control the maximum number of balls you can have.\n\n"
				+ "This is a quick way to change the maximum number of balls.\n\n"
				+ "Click on \"Increase Max Ball Count\" and the maximum ball count will increase by 25. Click on "
				+ "\"Decrease Max Ball Count\" and the maximum ball count will decrease by 25. You can set the "
				+ "ball limit to between 25 and 1000.\n\n"
				+ "For convenience, if the max ball count is less than 50 and you click on \"Decrease Max Ball "
				+ "Count,\" the program automatically makes the max ball count 25. If the ball count is "
				+ "more than 975 and you click on \"Increase Max Ball Count,\" the max ball count will then "
				+ "be 1000.\n\n"
				+ "If you want to adjust the max ball count without increasing it or decreasing it by 25, where "
				+ "you decide which value you want, go to the Main Settings Utility and follow the instructions "
				+ "from the Main Settings Tab from this window.");
		
		// How to Edit A Ball
		textArea2_4.setText("Are you going to stick with the same kind of balls in all the time you're spending "
				+ "on this college student project? Probably not! You can actually modify the properties for "
				+ "each existing ball on the canvas.\n\n"
				+ "The program has a utility in the Edit Menu where you can change the properties of one existing "
				+ "ball at your convenience. Technically, you can't modify more than one ball, but this is a "
				+ "demonstration of creating a utility from scratch.\n\n"
				+ "Click on \"Edit A Ball.\" This opens a utility to where you can select a ball (they are "
				+ "indexed from 1 to the current ball count in the canvas) and then modify it.\n\n"
				+ "You can select the position of the ball relative to the canvas, the speed in both "
				+ "horizontal and vertical directions, and of course the ball width. Keep in mind that the "
				+ "ball width accepts values from 1 to 40 pixels, and that also affects the ball's position "
				+ "if it's on the bottom or right side of the canvas. Basically, when you change the ball's "
				+ "position, you are actually changing the location of the ball's top left corner.\n\n"
				+ "If you place the ball's corner at a location where either X or Y is at its max value and "
				+ "you make the ball wider, the X or Y will decrease to accommodate the space needed for the "
				+ "ball with its width to fit, without having to overlap a boundary.\n\n"
				+ "The speeds of the balls, in both horizontal and vertical directions,  are measured in "
				+ "pixels per rendered frame. You can set the speed value between 1 and 10. What this means "
				+ "is, if you set the horizontal speed to 10 and vertical to five, at roughly 50 frames per "
				+ "second, the ball would travel 500 pixels in the horizontal direction and 250 in the "
				+ "vertical direction. As you will see, the speeds cannot be negative values.\n\n"
				+ "Below the Ball Width spinner are five checkboxes. Four of them are for randomization, while "
				+ "one is for whether or not for that particular ball to have its outline displayed. In"
				+ " sequence, the buttons are: \"Randomize DX,\" \"Randomize DY,\" \"Ball Has Outline,\" "
				+ "\"Randomize Ball Color,\" and \"Randomize Ball Outline Color.\"\n\n"
				+ "The first two checkboxes toggles whether or not to change the corresponding speeds "
				+ "when a ball hits one of the walls of the Animation Canvas. The third checkbox toggles "
				+ "the outline to be displayed. The fourth and fifth toggles whether or not to cause the ball's "
				+ "corresponding colors to randomize as soon as it hits a wall.\n\n"
				+ "Take note that if you uncheck the \"Ball Has Outline\" checkbox, the components to "
				+ "choose the ball's outline color will be disabled.\n\n"
				+ "Finally, there are four radio buttons that they speecify a direction. You can change the "
				+ "direction of them. Even though one for the horizontal and one for the vertical must be "
				+ "selected, you can still have a ball that goes directly up and down, or left and right.\n\n"
				+ "If you set the ball's speed, in both horizontal and vertical directions, to zero, the "
				+ "ball will not move at all in the Animation Canvas.\n\n"
				+ "Once you are done with your changes, you have two options: click on the \"Make changes\" "
				+ "radio button to have the changed values take effect, or \"Cancel\" to go back to the "
				+ "Animation Canvas with no changes made.\n\n"
				+ "Enjoy experimenting with different values for your balls!");
		
		// How to Add A Ball with Options
		textArea2_5.setText("You can add a ball with set options rather than randomly like what you would "
				+ "do with your keyboard, mouse, or mouse wheel (any control scheme you've set from the "
				+ "program).\n\n"
				+ "Below the first separator bar in the Edit Menu is a button called \"Add a ball.\" Click"
				+ "on it, and it opens up the Add A Ball Utility.\n\n"
				+ "What you can do with the utility is initialize the ball with a given X and Y position, "
				+ "its speed in both the horizontal and vertical directions, its width, whether to randomize "
				+ "its horizontal speed, its vertical speed, its color, its outline color (if it has to have "
				+ "an outline), and whether or not to have an outline.\n\n"
				+ "In addition, you got two separate compartments; one is to set the ball's color;"
				+ " the other, its outline color.\n\n"
				+ "Finally, you have four radio buttons for direction.\n\n"
				+ "Set the ball's position, speed in both directions, its width, and check or uncheck "
				+ "the five checkboxes as you see. Use the tool tip text to help you out as "
				+ "necessary. Then select the corresponding colors.\n\n"
				+ "Once you get to the directions, be aware that there are two exclusive sets of "
				+ "buttons. You must press one in each set to make the utility add a ball in the "
				+ "canvas with the selected settings.\n\n"
				+ "So, select whether or not to make the ball go left or right, then up or down.\n\n"
				+ "Once you are done, click on either the \"Add Ball\" radio button to add the "
				+ "ball with the corresponding settings, or the \"Cancel\" radio button to go "
				+ "back to the Animation Canvas right away.");
		
		// How to Set A Common Color/Outline Color / Width for All Balls
		textArea2_6.setText("Below the second separator bar on the Edit Menu, there are three "
				+ "buttons where each one opens its own utility.\n\n"
				+ "The first one is a utility that allows you to set a color for all balls to have."
				+ "Use either the combo box or the spinners to set the colors you want. Click on "
				+ "OK to make the change, or Back to go back to the Animation Canvas.\n\n"
				+ "The second one is for setting a common outline color for all balls, with the "
				+ "same functionality as the first. Choose your color, then click OK to make the "
				+ "change.\n\n"
				+ "The last one is to set a common width for all balls. Use the spinner to set "
				+ "the width of all balls between 1 and 40, then click OK to make the change "
				+ "or Back to go back to the Animation Canvas.");
		
		// Ball Outlines
		textArea2_7.setText("You don't have to completely stick with having some balls displaying their "
				+ "outlines. There are two things you can do to toggle whether or not to display them for "
				+ "all the balls.\n\n"
				+ "On the Edit Menu, below the third separator bar, there are two buttons. One is to have "
				+ "all the balls to display their outlines; the other, the exact opposite.\n\n"
				+ "To have all the balls display their outlines, click on \"Make all balls have outlines.\""
				+ "This will cause their outlines to be conveniently displayed with the specified outline "
				+ "color each ball has.\n\n"
				+ "If you click on it again where all the balls have their outlines displayed, you will "
				+ "get a popup message.\n\n"
				+ "Click on \"Make all balls have no outlines\" to make the outlines not be displayed "
				+ "at all on the Animation Canvas. Clicking it again, with the balls' outlines not "
				+ "displayed, pops up a dialog message as well.\n\n"
				+ "Be aware that you can still change the number of balls in the canvas afterwards, "
				+ "to where whenever you add, remove, or replace the balls, clicking either buttons "
				+ "again should not display a popup message at all.");
		
		// Randomization Options
		textArea2_8.setText("The application lets you execute code that enables balls to be ranomized in many different "
				+ "ways. Here's what you can do to randomize the existing balls.\n\n"
				+ "On the Edit Menu, below the 4th separator bar, you have seven straightforward buttons that you can "
				+ "click on one of them and then it will execute accordingly; randomize colors, positions, speeds, even "
				+ "most of the properties of the balls.\n\n"
				+ "In addition, you have two more buttons to click on at the bottom of the menu.\n\n"
				+ "\"Randomize all balls\"\n"
				+ "This randomizes all the visible components of each and every existing ball in the canvas; the colors, "
				+ "plus their outlines (making sure those set to not display them will not so afterwards), positions, and "
				+ "their linear movements between frames. This also tells the balls whether or not to cause their motions "
				+ "to randomize every time they hit one side of the canvas.\n\n"
				+ "\"Randomize colors of all balls\"\n"
				+ "Causes all the balls to randomly change their overall colors (does not affect their outlines).\n\n"
				+ "\"Randomize outline colors of all balls\"\n"
				+ "Regardless if you cannot see the outlines for each and every single ball, they are designed to hold "
				+ "a color specifically for their outlines. This button will randomly change the possible outline colors. "
				+ "This also affects balls where you can see their outlines currently on the canvas.\n\n"
				+ "\"Randomize location of all balls\"\n"
				+ "Instantly causes the balls to be displayed at a different position than where they were the moment "
				+ "this is pressed.\n\n"
				+ "\"Randomize speed in X direction for all balls\"\n"
				+ "Changes their movement in the horizontal direction for each rendered canvas frame. Does not affect their "
				+ "direction.\n\n"
				+ "\"Randomize speed in Y direction for all balls\"\n"
				+ "Changes their movement in the vertical direction for each rendered canvas frame. Does not affect their "
				+ "direction.\n\n"
				+ "\"Disable / Enable ball color randomization\"\n"
				+ "A toggle button whether to have all balls change their color within each wall collision or not.\n\n"
				+ "\"Disable / Enable ball outline color randomization\"\n"
				+ "A toggle button whether to have all the balls with their outlines visible change their color within "
				+ "each wall collision or not. This also affects balls where their outlines are not currently displayed.\n\n\n"
				+ "That's all the randomization options you can do on the program without using the Edit A Ball Utility.");
		
		// Music
		textArea2_9.setText("Do you know that you can play audio files in this program? Well, there is a strong limit to "
				+ "this, but here's what you can do to load your favourite audio and listen as you watch the balls fly like "
				+ "crazy!\n\n"
				+ "Before you begin loading your audio file, you need to make sure that the file is formatted in one of the "
				+ "four types: MIDI, AU, AIFF, or WAV.\n\n"
				+ "You need to load your file before you can start playing, so in the Music Menu, click on \"Load Music.\""
				+ "This opens up an open file dialog. Search for the file in the directory that you have saved it into, then "
				+ "click on the \"Load\" button. The files that are compatible for loading have an icon where it is a sheet "
				+ "of paper with its top right corner folded into a triangle.\n\n"
				+ "Wait for a few moments as the program loads the file (the time to wait depends on the file size and how "
				+ "fast your computer is currently), then you will see a dialog box with a blue label that says \"Loading "
				+ "complete.\" This means that the program has loaded the file and is now ready to play. You will see "
				+ "that the file name is displayed in the text field on the Status Panel below the Animation Canvas.\n\n"
				+ "Now that you have the audio loaded, you can now either play the file or loop it where it plays up to "
				+ "the point where you click on the Stop Button.\n\n"
				+ "Click on the \"Play\" button to start listening to the loaded file. If you have speakers, adjust the "
				+ "volume so that way you can hear the audio coming from them.\n\n"
				+ "If you click on the \"Play\" button as the audio is being played, you will restart it from the beginning."
				+ " Unfortunately, this program does not have an external audio player where you can set the current lapse "
				+ "to a certain place in the audio's timeframe to listen to that sequence, without having to wait all over."
				+ " The only way to improvise it is to actually play the song on a media player that's installed in your "
				+ "computer.\n\n"
				+ "The \"Loop\" button will cause the loaded file to play repeatedly, with no interruption up to the point "
				+ "where you click on the Stop Button, exit the program, or shut down the computer to where this was"
				+ "running.\n\n"
				+ "The \"Stop\" button lets you stop playing the current audio. This is convenient if you feel tired on "
				+ "listening to the same audio, or if you decide to keep the program silent.\n\n"
				+ "The \"Info on Music\" button is simply a dialog box on what format the audio file needs to be.");
		
		// Main Settings and Controls
		textArea3.setText("Main Settings\n\n"
				+ "On the Settings Menu, there is a button called \"Main Settings\". Click on it to open"
				+ " the Main Settings Utility.\n\n"
				+ "What you can do here is select an exact value for the maximum number of balls allowed "
				+ "on the canvas using the spinner next to the \"Max Ball Count\" label. Remember, you cannot "
				+ "set the \"Max Ball Count\" below 25 or over 1000. This is to ensure that the program will "
				+ "be forced to shut down on most computers because all balls require some memory. Using too "
				+ "much of it will cause the program to create an error saying that it needs memory for other "
				+ "things, but there isn't enough.\n\n"
				+ "Below is a label on top of a combo box. This is where you can select your colors other than the"
				+ " three colored labels, the three spinners, and a color sample, all below. "
				+ "This is for the Status Panel below the canvas. The combo box lets you "
				+ "select a common color without having to use the spinners. Just keep in mind that anytime you want "
				+ "to use a custom color instead of common ones, click on \"Custom\" in the menu, or just change the "
				+ "values for the spinners as required.\n\n"
				+ "The values will not change when you click on \"Custom\".\n\n"
				+ "Use the spinners to select a custom color. All of them use the RGB gamut where you need "
				+ "to set the value for each component accordingly to get the color you want. Each component "
				+ "allows you to set an 8-bit value to denote how much of that component color shall blend in "
				+ "with the overall color. The minimum is 0 (no color), and the maximum is 255 (full).\n\n"
				+ "Keep in mind that 0 in all color components gives you black, while 255 in all color "
				+ "components gives you white.\n\n"
				+ "Use the sample below all three spinners to get the color of your choice.\n\n"
				+ "Below the color scheme for the Status Panel below the Animation Canvas, you have "
				+ "five different radio buttons to select the color for the background of the "
				+ "Animation Canvas. There are five colors you can select: black, white, red, green, "
				+ "and blue.\n\n"
				+ "By default, the Animation Canvas background color is white.\n\n"
				+ "When you have all the settings set, click on \"Accept Settings\" for these settings to take "
				+ "effect. Otherwise, you can click on \"Back\" to go back to the animation and not have these "
				+ "settings take effect."
				+ "\n\n\n"
				+ "Controls\n\n"
				+ "When you start the program, you have three different control methods to adjust how many "
				+ "balls are being animated on the canvas: keyboard, mouse, and mouse wheel. But you know you "
				+ "don't necessarily have to use all three.\n\n"
				+ "Because of this, there is a utility where you can select the control schemes to add or "
				+ "remove balls quickly. From the \"Settings\" menu, go to \"Controls.\""
				+ "\n\n"
				+ "When you get there, you will see the Control Functions Utility with a label, three "
				+ "checkboxes, and two radio buttons. Checking a checkbox enables the specified control, "
				+ "while unchecking it disables it.\n\n"
				+ "\"Keyboard Control\" means that you can change the number of balls on the canvas by "
				+ "using the Arrow Keys on your keyboard; Left or Up Arrow Key adds a random ball, while"
				+ " Right or Down Arrow Key removes one. Hold down either key to do the same function "
				+ "efficiently.\n\n"
				+ "\"Mouse Button Control\" means you use the Left and Right Mouse Buttons to change the "
				+ "number of balls on the canvas. The only difference is, you will not add, or remove, "
				+ "random balls efficiently by holding down either button.\n\n"
				+ "\"Mouse Wheel Control\" allows manipulation through the mouse wheel. Scrolling it up "
				+ "adds more randomized balls, while scrolling it down does the exact opposite.\n\n"
				+ "Click on the \"Accept\" button to change the overall control scheme, or click on "
				+ "Cancel to not make the necessary changes.");
		
		// FAQ
		textArea4.setText("Q: Why are there tool tip texts?\n\n"
				+ "A: If you leave your Mouse Pointer over a Menu Bar Item or a Menu Item, or in a certain"
				+ "component, you will notice a 10-point Arial text over a frameless background. This is for "
				+ "your own convenience in case the components that do have associated text don't come"
				+ "straightforward. This is also practice using those tool tip texts as they are used"
				+ "in many different GUI programs.\n\n\n\n"
				+ "Q: Why does it take not that much memory to install and use this program itself?\n\n"
				+ "A: It's the graphics. This program uses the traditional JAVA Abstract Windows Toolkit Graphics"
				+ "class to draw the balls and their outlines on the canvas.\n\n\n\n"
				+ "Q: Can you tell me about the graphics?\n\n"
				+ "A: Other than being AWT simple-colored pieces of vision, there are no external graphics plugins"
				+ "used in this program. It would require research, learning, testing, and analysis in order to"
				+ "select and implement a better graphics plugin than the one used here. Nevertheless, since this "
				+ "is still a college student-based program, intelligence has to be built up first before going "
				+ "forward with more sophisticated and harder sources of art.\n\n\n\n"
				+ "Q: What programming language was this written in?\n\n" 
				+ "A: This was written entirely in JAVA; the only thing is, there is a teeny bit of HTML coding,"
				+ " but they are for labels only because when you want to make a label spread more than one line,"
				+ "this is the technique to use it.\n\n\n\n"
				+ "Q: How come the program slows down when you have more than 500 balls on canvas?\n\n"
				+ "A: Every single ball is drawn with its specified location; for it to create animation, "
				+ "the ball's location must be changed within every frame. There is no multitasking "
				+ "used in the program to let more than one processor work on manipulating the ball's "
				+ "location. The program uses a complete loop to change the location and determine the "
				+ "collisions and randomization of them; the time lapse of the loop per frame increases "
				+ "as there are more balls.\n\n\n\n"
				+ "Q: What's the best rendering speed possible?\n\n"
				+ "A: If you keep your ball count low with a rendering delay of either 10 or 15 milliseconds, "
				+ "you will see an animation that creates an illusion; the balls are moving so fast per second"
				+ " that it feels like the entire canvas is rendering at 60 frames per second. However, "
				+ "with the rendering delay specified, if we assume that the change in all balls' properties"
				+ "causes no delay, then the frame rate alone would be either 66.7 or 100 frames per second.\n\n\n\n"
				+ "Q: Occasionally, on the Status Panel below the Animation Canvas, I would see many different"
				+ "painted balls over the labels and the only text field. Why is this happening?\n\n"
				+ "A: In terms of simplicity, the AWT Graphics tend to be vulnerable to bugs and glitches."
				+ "Regardless if the Status Panel is designed to only present labels and what music"
				+ " file is loaded, the AWT Graphics cannot limit themselves to only the canvas, since"
				+ " the Canvas and the Status Panel have one thing in common.\n\n"
				+ "In terms of complicated programming however, the Status Panel is the same type as the "
				+ "Canvas itself. They are two different data entities (known as objects) that were made "
				+ "from an original standalone source (which is a class).\n\n\n\n"
				+ "Q: How are you able to adjust the color of the labels in the Status Panel for whenever "
				+ "its background changes?\n\n"
				+ "A: Simple. The program changes the font color within a few cases to where the"
				+ " desired color has been set. It uses the original RGB components to determine whether "
				+ "to display the font in a black color, or in white. All it is is a simple decision "
				+ "structure.\n\n\n\n"
				+ "Q: Considering you (the programmer) spent more than 10 days on this project, was it "
				+ "really a learning process?\n\n"
				+ "A: Yes, it was. I haven't learned much, but I have learned about undecorated frames, "
				+ "spinners, tabbed panes, some special properties, as well as making three different things "
				+ "customizable.\n\n\n\n"
				+ "Q: Would you want to do another GUI program like this but make improvements such as "
				+ "a more fancy graphics technique?\n\n"
				+ "A: Actually, yes. I definitely want to try writing newer GUI programs where for each one, "
				+ "I experiment with a different graphical technique of drawing them. This is part of my"
				+ "build of experience to becoming a better status programmer. Eventually, I want to build a "
				+ "game of my own that I'll publish it through an independent publishing label. Hope to be a "
				+ "fun game for others to download and play!\n\n\n\n"
				+ "Q: JAVA games cannot be standalone. You have something you can sell your game for?\n\n"
				+ "A: I have a download of the Google Android SDK. Of course that would mean I have to "
				+ "learn something new, but I think putting my programming capabilities to the mobile "
				+ "world will allow me to have a better chance of marketing compared to just conventional "
				+ "computer gammes. Although the problem I find is the memory size to where I am completely "
				+ "restricted down to, if I can find convenient, low-memory but high-quality ways of "
				+ "delivering graphics and interactivity, I say I give myself a chance to develop one of "
				+ "those things people are seeking for in the entertainment biz.\n\n\n\n"
				+ "Q: What tools did you use to develop this?\n\n"
				+ "A: Old-fashioned Eclipse. I have used the Keplar Version. I didn't use NetBeans or any "
				+ "other IDE to where all I have to do is click and drag components independently, then " 
				+ "modifying some of the code to fix compiler and syntax errors, as well as making sure "
				+ "that the program will not crash at the moment of execution.\n\n\n\n"
				+ "Q: Where can I submit comments / feedback?\n\n"
				+ "A: I have a page of my own on Facebook as well as an account on Google, Instagram, and "
				+ "Twitter. You will need an Internet or mobile data connection in order to log in and "
				+ "write and submit your comment. You can also go onto my Blogger site:\n\n"
				+ "http://gregorypdesrosiersmontreal.blogspot.ca\n\n"
				+ "I recommend you write comments on this program when I have a Blogger post on JAVA programs, "
				+ "in which I do already.\n\n\n\n"
				+ "Q: Do you have anything more to present?\n\n"
				+ "A: Nope. That's about it. Hope you enjoy this program!");
	}
}
