package gregdesGroupOfBallsFull;

import java.awt.event.KeyEvent;

final class BallCountKeyboardListener implements java.awt.event.KeyListener
{
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if (Application.canvas.currentBallCount < Application.canvas.MAX_BALL_COUNT)
			{
				Application.canvas.ballList.add(new AnimatedBall());
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).ballWidth = Application.randomizer.nextInt(AnimatedBall.maxBallWidth) + 1;
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).xCoordinate = Application.randomizer.nextInt(Application.canvas.getPreferredSize().width 
						- Application.canvas.ballList.get(Application.canvas.currentBallCount).ballWidth + 1);
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).yCoordinate = Application.randomizer.nextInt(Application.canvas.getPreferredSize().height 
						- Application.canvas.ballList.get(Application.canvas.currentBallCount).ballWidth + 1);
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).currentDX = Application.randomizer.nextInt(AnimatedBall.maxDX + 1);
				Application.canvas.ballList.get(Application.canvas.currentBallCount).currentDY = Application.randomizer.nextInt(AnimatedBall.maxDY + 1);
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).ballColor = new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				Application.canvas.ballList.get(Application.canvas.currentBallCount).ballHasOutline = Application.randomizer.nextBoolean();
					
				Application.canvas.ballList.get(Application.canvas.currentBallCount).randomizeBallColor = Application.randomizer.nextBoolean();
				Application.canvas.ballList.get(Application.canvas.currentBallCount).randomizeCurrentDX = Application.randomizer.nextBoolean();
				Application.canvas.ballList.get(Application.canvas.currentBallCount).randomizeCurrentDY = Application.randomizer.nextBoolean();
				
				Application.canvas.ballList.get(Application.canvas.currentBallCount).goingDown = Application.randomizer.nextBoolean();
				Application.canvas.ballList.get(Application.canvas.currentBallCount).goingRight = Application.randomizer.nextBoolean();
					
				if(Application.canvas.ballList.get(Application.canvas.currentBallCount).ballHasOutline)
				{
					Application.canvas.ballList.get(Application.canvas.currentBallCount).randomizeBallOutlineColor = Application.randomizer.nextBoolean();
					Application.canvas.ballList.get(Application.canvas.currentBallCount).ballOutlineColor = new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				}
					
				Application.canvas.ballDraws.add(Application.canvas.mainGraphicsManager.create());
				Application.canvas.ballDraws.get(Application.canvas.currentBallCount).setColor(Application.canvas.ballList.get(Application.canvas.currentBallCount).ballColor);
					
				Application.canvas.ballOutlineDraws.add(Application.canvas.mainGraphicsManager.create());
				Application.canvas.ballOutlineDraws.get(Application.canvas.currentBallCount).setColor(Application.canvas.ballList.get(Application.canvas.currentBallCount).ballOutlineColor);
					
				Application.canvas.currentBallCount++;
			}
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if (Application.canvas.currentBallCount > Application.canvas.MIN_BALL_COUNT)
			{
				Application.canvas.ballList.removeFirst();
				Application.canvas.ballDraws.removeFirst();
				Application.canvas.ballOutlineDraws.removeFirst();
					
				Application.canvas.currentBallCount--;
			}
		}
		
		Application.numberOfBallsLabel.setText("Number of balls: " + Application.canvas.currentBallCount);
		Application.canvas.repaint();
	}

	public void keyReleased(KeyEvent e) 
	{	
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{	
	}
		
}