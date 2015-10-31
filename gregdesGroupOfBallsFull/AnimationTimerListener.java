package gregdesGroupOfBallsFull;

import java.awt.event.ActionListener;

final class AnimationTimerListener implements ActionListener 
{
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		for(int y = 0; y < Application.canvas.ballList.size(); y++)
		{
			if (Application.canvas.ballList.get(y).xCoordinate + Application.canvas.ballList.get(y).currentDX > (Application.canvas.getPreferredSize().width - Application.canvas.ballList.get(y).ballWidth))
			{
				Application.canvas.ballList.get(y).makeTheBallGoLeft();
				BallRandomizer.randomizeBallRates(y);
				BallRandomizer.randomizeBallColors(y);
			}
			else if ((Application.canvas.ballList.get(y).xCoordinate - Application.canvas.ballList.get(y).currentDX) < 0)
			{
				Application.canvas.ballList.get(y).makeTheBallGoRight();
				BallRandomizer.randomizeBallRates(y);
				BallRandomizer.randomizeBallColors(y);
			}
				
			if (Application.canvas.ballList.get(y).yCoordinate + Application.canvas.ballList.get(y).currentDY > (Application.canvas.getPreferredSize().height - Application.canvas.ballList.get(y).ballWidth))
			{
				Application.canvas.ballList.get(y).makeTheBallGoUp();
				BallRandomizer.randomizeBallRates(y);
				BallRandomizer.randomizeBallColors(y);
			}
			else if ((Application.canvas.ballList.get(y).yCoordinate - Application.canvas.ballList.get(y).currentDY) < 0)
			{
				Application.canvas.ballList.get(y).makeTheBallGoDown();
				BallRandomizer.randomizeBallRates(y);
				BallRandomizer.randomizeBallColors(y);
			}
			
			if (Application.canvas.ballList.get(y).ballIsGoingUp())
				Application.canvas.ballList.get(y).yCoordinate -= Application.canvas.ballList.get(y).currentDY;
			else if (Application.canvas.ballList.get(y).ballIsGoingDown())
				Application.canvas.ballList.get(y).yCoordinate += Application.canvas.ballList.get(y).currentDY;
			
			if (Application.canvas.ballList.get(y).ballIsGoingLeft())
				Application.canvas.ballList.get(y).xCoordinate -= Application.canvas.ballList.get(y).currentDX;
			else if (Application.canvas.ballList.get(y).ballIsGoingRight())
				Application.canvas.ballList.get(y).xCoordinate += Application.canvas.ballList.get(y).currentDX;
		}
		
		Application.canvas.repaint();
	}
}