package gregdesGroupOfBallsFull;

final class BallRandomizer 
{
	private BallRandomizer()
	{
	}
	
	static void randomizeBallRates(int y)
	{
		if (Application.canvas.ballList.get(y).randomizeCurrentDX)
		{
			Application.canvas.ballList.get(y).currentDX = Application.randomizer.nextInt(AnimatedBall.maxDX + 1);
		}
		
		if (Application.canvas.ballList.get(y).randomizeCurrentDY)
		{
			Application.canvas.ballList.get(y).currentDY = Application.randomizer.nextInt(AnimatedBall.maxDY + 1);
		}
	}
	
	static void randomizeBallColors(int y)
	{
		if (Application.canvas.ballList.get(y).randomizeBallColor)
		{
			Application.canvas.ballList.get(y).ballColor = new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
			Application.canvas.ballDraws.get(y).setColor(Application.canvas.ballList.get(y).ballColor);
		}
		
		if(Application.canvas.ballList.get(y).randomizeBallOutlineColor)
		{
			Application.canvas.ballList.get(y).ballOutlineColor = new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
			Application.canvas.ballOutlineDraws.get(y).setColor(Application.canvas.ballList.get(y).ballOutlineColor);
		}
	}
}