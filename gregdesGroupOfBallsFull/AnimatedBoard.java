package gregdesGroupOfBallsFull;

import javax.swing.JPanel;

final class AnimatedBoard extends JPanel
{
	private static final long serialVersionUID = 4936281005463011493L;
	
	java.awt.Graphics mainGraphicsManager;
	
	public JPanel extraPanel;
	// Ball Count Properties
	int currentBallCount = 10;
	int MAX_BALL_COUNT = 250;
	final int MIN_BALL_COUNT = 1;
	final int LOWEST_MAX_BALL_COUNT = 25;
	final int ABSOLUTE_MAX_BALL_COUNT = 1000;

	// Ball List
	java.util.LinkedList<AnimatedBall> ballList;
	
	// Graphics Manipulators
	java.util.LinkedList<java.awt.Graphics> ballDraws;
	java.util.LinkedList<java.awt.Graphics> ballOutlineDraws;
	
	// Initialization Flag
	boolean ballDrawsArrayInitialized = false;
	
	AnimatedBoard()
	{
		addMouseListener(new BallCountMouseListener());
		setLayout(new java.awt.BorderLayout());
		
		extraPanel = new JPanel();
		extraPanel.setPreferredSize(new java.awt.Dimension(640, 21));
		extraPanel.setBackground(java.awt.Color.BLUE);
		add(extraPanel, java.awt.BorderLayout.NORTH);
	}

	protected void paintComponent(java.awt.Graphics g)
	{
		super.paintComponent(g);
		
		if (!ballDrawsArrayInitialized)
		{
			mainGraphicsManager = g.create();
			
			for(int x = 0; x < currentBallCount; x++)
			{
				ballDraws.add(mainGraphicsManager.create());
				ballDraws.get(x).setColor(ballList.get(x).ballColor);
			
				ballOutlineDraws.add(mainGraphicsManager.create());
				ballOutlineDraws.get(x).setColor(ballList.get(x).ballOutlineColor);
			
			}
		
			ballDrawsArrayInitialized = true;
		}
		else
		{
			mainGraphicsManager.drawRect(0, 0, 639, 480);
		
			for (int x = 0; x < currentBallCount; x++)
			{
				ballDraws.get(x).fillOval(ballList.get(x).xCoordinate, ballList.get(x).yCoordinate, ballList.get(x).ballWidth, ballList.get(x).ballWidth);
			
				if (ballList.get(x).ballHasOutline)
					ballOutlineDraws.get(x).drawOval(ballList.get(x).xCoordinate, ballList.get(x).yCoordinate, ballList.get(x).ballWidth, ballList.get(x).ballWidth);
			}
		}
		
	}
}