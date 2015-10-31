package gregdesGroupOfBallsFull;

import java.awt.Color;

final class AnimatedBall 
{
	protected int xCoordinate;
	protected int yCoordinate;
	
	protected int currentDX;
	protected int currentDY;
	protected boolean randomizeCurrentDX;
	protected boolean randomizeCurrentDY;
	
	protected int ballWidth;
	
	protected Color ballColor;
	protected Color ballOutlineColor;
	protected boolean ballHasOutline;
	protected boolean randomizeBallColor;
	protected boolean randomizeBallOutlineColor;
	
	protected boolean goingDown;
	protected boolean goingRight;
	
	protected static int minBallWidth = 1;
	protected static int maxBallWidth = 40;
	
	protected static int minDX = 0;
	protected static int maxDX = 10;
	
	protected static int minDY = 0;
	protected static int maxDY = 10;
	
	public AnimatedBall()
	{
		xCoordinate = 0;
		yCoordinate = 0;
		
		currentDX = 6;
		currentDY = 6;
		randomizeCurrentDX = false;
		randomizeCurrentDY = false;
		
		ballWidth = 13;
		
		ballColor = Color.BLACK;
		ballOutlineColor = Color.WHITE;
		ballHasOutline = false;
		randomizeBallColor = false;
		randomizeBallOutlineColor = false;
		
		goingDown = true;
		goingRight = true;
	}
	
	public AnimatedBall(int x, int y, int dx, int dy, boolean randomizeDX, boolean randomizeDY, 
			int ballWidth, Color ballColor, Color ballOutlineColor, 
			boolean ballHasOutline, boolean randomizeThisBallsColor, boolean randomizeThisBallsOutlineColor,
			boolean ballIsGoingDown, boolean ballIsGoingRight)
	{
		xCoordinate = x;
		yCoordinate = y;
		currentDX = dx;
		currentDY = dy;
		
		randomizeCurrentDX = randomizeDX;
		randomizeCurrentDY = randomizeDY;
		
		this.ballWidth = ballWidth;
		
		this.ballColor = ballColor;
		this.ballOutlineColor = ballOutlineColor;
		this.ballHasOutline = ballHasOutline;
		
		randomizeBallColor = randomizeThisBallsColor;
		randomizeBallOutlineColor = randomizeThisBallsOutlineColor;
		
		goingDown = ballIsGoingDown;
		goingRight = ballIsGoingRight;
	}
	
	protected void setX(int x)
	{
		xCoordinate = x;
	}
	
	protected void setY(int y)
	{
		yCoordinate = y;
	}
	
	protected void setDX(int dx)
	{
		currentDX = dx;
	}
	
	protected void setDY(int dy)
	{
		currentDY = dy;
	}
	
	protected void setRandomizeDX(boolean randomizeDX)
	{
		randomizeCurrentDX = randomizeDX;
	}
	
	protected void setRandomizeDY(boolean randomizeDY)
	{
		randomizeCurrentDY = randomizeDY;
	}
	
	protected void setBallWidth(int ballWidth)
	{
		this.ballWidth = ballWidth;
	}
	
	protected void setBallColor(Color ballColor)
	{
		this.ballColor = ballColor;
	}
	
	protected void setBallOutlineColor(Color ballOutlineColor)
	{
		this.ballOutlineColor = ballOutlineColor;
	}
	
	protected void setRandomizeBallColor(boolean randomizeBallColor)
	{
		this.randomizeBallColor = randomizeBallColor;
	}
	
	protected void setRandomizeBallOutlineColor(boolean randomizeBallOutlineColor)
	{
		this.randomizeBallOutlineColor = randomizeBallOutlineColor;
	}
	
	protected void makeTheBallGoUp()
	{
		goingDown = false;
	}
	
	protected void makeTheBallGoDown()
	{
		goingDown = true;
	}
	
	protected void makeTheBallGoLeft()
	{
		goingRight = false;
	}
	
	protected void makeTheBallGoRight()
	{
		goingRight = true;
	}
	
	protected boolean ballIsGoingUp()
	{
		return !goingDown;
	}
	
	protected boolean ballIsGoingDown()
	{
		return goingDown;
	}
	
	protected boolean ballIsGoingLeft()
	{
		return !goingRight;
	}
	
	protected boolean ballIsGoingRight()
	{
		return goingRight;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof AnimatedBall)
			return ((AnimatedBall)o).xCoordinate == this.xCoordinate &&
					((AnimatedBall)o).yCoordinate == this.yCoordinate &&
					((AnimatedBall)o).ballWidth == this.ballWidth &&
					((AnimatedBall)o).ballColor.equals(this.ballColor);
		else
			return false;
	}
	
	public boolean equalsWithOutline(Object o)
	{
		if (o instanceof AnimatedBall)
			return ((AnimatedBall)o).xCoordinate == this.xCoordinate &&
					((AnimatedBall)o).yCoordinate == this.yCoordinate &&
					((AnimatedBall)o).ballWidth == this.ballWidth &&
					((AnimatedBall)o).ballColor.equals(this.ballColor) &&
					((AnimatedBall)o).ballOutlineColor.equals(this.ballOutlineColor);
		else
			return false;
	}
	
	
	
	public String toString()
	{
		String stringToReturn = "Current X Position: " + this.xCoordinate + "\nCurrent Y Position: " + this.yCoordinate + 
				"\nCurrent Ball Width: " + this.ballWidth + " pixels\nCurrent Ball Color: ";
		
		// Which color is which?
		if (this.ballColor.equals(Color.BLACK))
			stringToReturn += "Black";
		else if (this.ballColor.equals(Color.BLUE))
			stringToReturn += "Blue";
		else if (this.ballColor.equals(Color.CYAN))
			stringToReturn += "Cyan";
		else if (this.ballColor.equals(Color.DARK_GRAY))
			stringToReturn += "Dark Gray";
		else if (this.ballColor.equals(Color.GRAY))
			stringToReturn += "Gray";
		else if (this.ballColor.equals(Color.GREEN))
			stringToReturn += "Green";
		else if (this.ballColor.equals(Color.LIGHT_GRAY))
			stringToReturn += "Light Gray";
		else if (this.ballColor.equals(Color.MAGENTA))
			stringToReturn += "Magneta";
		else if (this.ballColor.equals(Color.ORANGE))
			stringToReturn += "Orange";
		else if (this.ballColor.equals(Color.PINK))
			stringToReturn += "Pink";
		else if (this.ballColor.equals(Color.RED))
			stringToReturn += "Red";
		else if (this.ballColor.equals(Color.WHITE))
			stringToReturn += "White";
		else if (this.ballColor.equals(Color.YELLOW))
			stringToReturn += "Yellow";
		else
			stringToReturn += "( R: " + this.ballColor.getRed() + " G: " + this.ballColor.getGreen() + " B: " 
		+ this.ballColor.getBlue() + " )";
		
		// Executes only if this ball has an outline.
		if (this.ballHasOutline)
		{
			stringToReturn += "\nCurrent Ball Outline Color: ";
			
			if (this.ballOutlineColor.equals(Color.BLACK))
				stringToReturn += "Black";
			else if (this.ballOutlineColor.equals(Color.BLUE))
				stringToReturn += "Blue";
			else if (this.ballOutlineColor.equals(Color.CYAN))
				stringToReturn += "Cyan";
			else if (this.ballOutlineColor.equals(Color.DARK_GRAY))
				stringToReturn += "Dark Gray";
			else if (this.ballOutlineColor.equals(Color.GRAY))
				stringToReturn += "Gray";
			else if (this.ballOutlineColor.equals(Color.GREEN))
				stringToReturn += "Green";
			else if (this.ballOutlineColor.equals(Color.LIGHT_GRAY))
				stringToReturn += "Light Gray";
			else if (this.ballOutlineColor.equals(Color.MAGENTA))
				stringToReturn += "Magneta";
			else if (this.ballOutlineColor.equals(Color.ORANGE))
				stringToReturn += "Orange";
			else if (this.ballOutlineColor.equals(Color.PINK))
				stringToReturn += "Pink";
			else if (this.ballOutlineColor.equals(Color.RED))
				stringToReturn += "Red";
			else if (this.ballOutlineColor.equals(Color.WHITE))
				stringToReturn += "White";
			else if (this.ballOutlineColor.equals(Color.YELLOW))
				stringToReturn += "Yellow";
			else
				stringToReturn += "( R: " + this.ballColor.getRed() + " G: " + this.ballColor.getGreen() + " B: " 
			+ this.ballColor.getBlue() + " )";
		}
		
		stringToReturn += "\n\nWhich way is the ball going? ";
		
		if (this.goingDown)
			stringToReturn += "Down";
		else
			stringToReturn += "Up";
			
		stringToReturn += " and ";
		
		if (this.goingRight)
			stringToReturn += "right";
		else
			stringToReturn += "left";
		
		stringToReturn += "\n\nWill the ball color randomize? ";
		
		if(this.randomizeBallColor)
			stringToReturn += "Yes";
		else
			stringToReturn += "No";

		if (this.ballHasOutline)
		{
			stringToReturn+= "\nWill the ball outline color randomize? ";
			
			if (randomizeBallOutlineColor)
				stringToReturn += "Yes";
			else
				stringToReturn += "No";
		}
		
		stringToReturn += "\n\n\nCurrent Difference in X Direction for Each Frame: " + this.currentDX +
				"\nCurrent Difference in Y Direction for Each Frame: " + this.currentDY +
				"\nWill the rates randomize? ";
		
		if (randomizeCurrentDX && randomizeCurrentDY)
			stringToReturn += "Yes";
		else if (randomizeCurrentDX)
			stringToReturn += "Only the rate in the X direction";
		else if (randomizeCurrentDY)
			stringToReturn += "Only the rate in the Y direction";
		else
			stringToReturn += "No";
		
		return stringToReturn;
		
	}
}