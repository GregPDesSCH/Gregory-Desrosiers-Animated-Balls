package gregdesGroupOfBallsFull;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;

final class Application
{
	static JFrame mainFrame;
	static JPanel mainPanel;
	
	static AnimatedBoard canvas;
	static Timer animationTimer;
	static Random randomizer;
	static ApplicationMenuBar menuBar;
	
	public static JPanel bottomPanel;
	public static JPanel bottomPanelTopPart;
	public static JLabel numberOfBallsLabel;
	public static JLabel loadedMusicFileLabel;
	public static JTextField loadedMusicFileTextField;
	public static JLabel currentMaxBallCount;
	public static JLabel currentAnimationStatus;
	
	// Rendering Delay Per Frame
	protected static int renderingDelay = 25;
	protected static final int minimalRenderingDelay = 10;
	protected static final int maximalRenderingDelay = 50;
	
	// Dialog Object
	public static JLabel dialogLabel;
	
	// Font Settings
	protected static final java.awt.Font defaultFont = new java.awt.Font("Consolas", java.awt.Font.BOLD, 13);
	protected static java.awt.Font currentFont;
	
	// Font and Color Properties
	static java.awt.Font defaultFont2 = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 13);
	static java.awt.Color defaultBackgroundColor = java.awt.Color.BLACK;
	static java.awt.Color defaultFontColor = java.awt.Color.WHITE;
		
	// Add A Ball Utlity Properties
	static int currentBallWidth = 15;
	static int colorComboBoxIndex = 0;
	static int outlineColorComboBoxIndex = 0;
	
	// Common Width Dialog Property
	static int currentWidthDialogOptionValue = 13;
	
	// Common Color Dialog Properties
	static int commonColorComboBoxIndex = 0;
	static int currentColorRedValue = 0;
	static int currentColorGreenValue = 0;
	static int currentColorBlueValue = 0;
	
	// Common Outline Color Dialog Properties
	static int commonOutlineColorComboBoxIndex = 0;
	static int currentOutlineColorRedValue = 0;
	static int currentOutlineColorGreenValue = 0;
	static int currentOutlineColorBlueValue = 0;
	
	// Edit A Ball Utility
	static int currentBallToEditIndex = 1;
	
	// Control Utility Properties
	static boolean keyboardControlEnabled = true;
	static boolean mouseControlEnabled = true;
	static boolean mouseWheelControlEnabled = true;
	
	// Main Settings Properties
	static int statusPanelBackgroundRedComponent = Color.CYAN.getRed();
	static int statusPanelBackgroundGreenComponent = Color.CYAN.getGreen();
	static int statusPanelBackgroundBlueComponent = Color.CYAN.getBlue();
	
	/*
	 *  Music Objects
	 */
	// Source file
	protected static java.io.File musicFile;
	
	// MIDI Objects
	protected static javax.sound.midi.Sequencer midiObjectPlayer;
	
	// WAV, AIFF & AU Objects
	protected static javax.sound.sampled.Clip javaSoundPlayer;
	
	// Main Music object
	protected static Object musicObject;
	
	// Help Window Count
	protected static byte numberOfHelpWindowsOpened = 0;
	
	public Application()
	{		
		mainFrame = new JFrame();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(java.awt.Color.WHITE);
		mainPanel.setLayout(new java.awt.BorderLayout(0,0));
		
		// Canvas construction
		canvas = new AnimatedBoard();
		canvas.setBackground(java.awt.Color.WHITE);
		canvas.setPreferredSize(new java.awt.Dimension(640, 480));
		
		mainFrame.addMouseWheelListener(new BallCountMouseWheelListener());
		
		randomizer = new Random();
		
		canvas.ballList = new java.util.LinkedList<AnimatedBall>();
		canvas.ballDraws = new java.util.LinkedList<java.awt.Graphics>();
		canvas.ballOutlineDraws = new java.util.LinkedList<java.awt.Graphics>();
		
		for(int i = 0; i < canvas.currentBallCount; i++)
		{
			canvas.ballList.add(new AnimatedBall());
			
			canvas.ballList.get(i).xCoordinate = randomizer.nextInt((canvas.getPreferredSize().width - canvas.ballList.get(i).ballWidth) + 1);
			canvas.ballList.get(i).yCoordinate = randomizer.nextInt((canvas.getPreferredSize().height - canvas.ballList.get(i).ballWidth) + 1);
			
			canvas.ballList.get(i).ballWidth = randomizer.nextInt(AnimatedBall.maxBallWidth) + 1;

			canvas.ballList.get(i).currentDX = randomizer.nextInt(AnimatedBall.maxDX + 1);
			canvas.ballList.get(i).currentDY = randomizer.nextInt(AnimatedBall.maxDY + 1);
			
			canvas.ballList.get(i).ballColor = new java.awt.Color(randomizer.nextInt(256), randomizer.nextInt(256), randomizer.nextInt(256));
			canvas.ballList.get(i).ballHasOutline = randomizer.nextBoolean();
			
			canvas.ballList.get(i).randomizeBallColor = randomizer.nextBoolean();
			canvas.ballList.get(i).randomizeCurrentDX = randomizer.nextBoolean();
			canvas.ballList.get(i).randomizeCurrentDY = randomizer.nextBoolean();
			canvas.ballList.get(i).goingDown = randomizer.nextBoolean();
			canvas.ballList.get(i).goingRight = randomizer.nextBoolean();
			
			if(canvas.ballList.get(i).ballHasOutline)
			{
				canvas.ballList.get(i).randomizeBallOutlineColor = randomizer.nextBoolean();
				canvas.ballList.get(i).ballOutlineColor = new java.awt.Color(randomizer.nextInt(256), randomizer.nextInt(256), randomizer.nextInt(256));
			}
		}
		
		animationTimer = new Timer(renderingDelay, new AnimationTimerListener());
		
		// Bottom Panel Construction
		currentFont = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 12);
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(java.awt.Color.CYAN);
		bottomPanel.setLayout(new java.awt.BorderLayout());
		
		bottomPanelTopPart = new JPanel();
		bottomPanelTopPart.setBackground(java.awt.Color.CYAN);
		bottomPanelTopPart.setLayout(new java.awt.FlowLayout());
		
		numberOfBallsLabel = new JLabel("Number of balls: " + canvas.currentBallCount);
		numberOfBallsLabel.setFont(currentFont);
		numberOfBallsLabel.setForeground(Color.BLACK);
		
		loadedMusicFileLabel = new JLabel("   Loaded Music File:");
		loadedMusicFileLabel.setFont(currentFont);
		loadedMusicFileLabel.setForeground(Color.BLACK);
		
		loadedMusicFileTextField = new JTextField(45);
		loadedMusicFileTextField.setEditable(false);
		loadedMusicFileTextField.setText("No music file loaded.");
		loadedMusicFileTextField.setFont(currentFont);
		loadedMusicFileTextField.setBackground(java.awt.Color.WHITE);
		
		bottomPanelTopPart.add(numberOfBallsLabel);
		bottomPanelTopPart.add(loadedMusicFileLabel);
		bottomPanelTopPart.add(loadedMusicFileTextField);
		
		currentMaxBallCount = new JLabel("Current Max Ball Count: " + Application.canvas.MAX_BALL_COUNT);
		currentMaxBallCount.setHorizontalAlignment(SwingConstants.CENTER);
		currentMaxBallCount.setFont(currentFont);
		currentMaxBallCount.setBackground(java.awt.Color.WHITE);
		currentMaxBallCount.setForeground(Color.BLACK);
		
		currentAnimationStatus = new JLabel("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
		currentAnimationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		currentAnimationStatus.setFont(currentFont);
		currentAnimationStatus.setBackground(java.awt.Color.WHITE);
		currentAnimationStatus.setForeground(Color.BLACK);
		
		bottomPanel.add(bottomPanelTopPart, java.awt.BorderLayout.NORTH);
		bottomPanel.add(currentMaxBallCount);
		bottomPanel.add(currentAnimationStatus, java.awt.BorderLayout.SOUTH);
		// Frame Assembly
		menuBar = new ApplicationMenuBar();
		menuBar.setBorder(null);
		
		mainFrame.setJMenuBar(menuBar);
		mainPanel.add(canvas);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainFrame.add(mainPanel);
		
		// Final Initialization
		
		dialogLabel = new JLabel();
		dialogLabel.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 13));
		
		mainFrame.setFocusable(true);
		mainFrame.addKeyListener(new BallCountKeyboardListener());
		mainFrame.setBackground(java.awt.Color.WHITE);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Gregory Desrosiers' Animated Balls");
		mainFrame.setResizable(false);
		mainFrame.pack();
		mainFrame.setSize(mainFrame.getWidth(), mainFrame.getHeight() + bottomPanel.getHeight() - 5);
		mainFrame.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (mainFrame.getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (mainFrame.getHeight() / 2));
		
		animationTimer.start();
	}
	
}