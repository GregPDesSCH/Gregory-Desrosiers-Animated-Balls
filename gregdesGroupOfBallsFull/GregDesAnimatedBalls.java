/*
 * 		Gregory Desrosiers' Animated Balls
 * 
 * 	Developed by Gregory Desrosiers
 * 	© 2013 Gregory Desrosiers. All rights reserved.	
 * 
 * 	Developed using Eclipse Keplar and Oracle's JAVA SE 7.
 * 
 * 	© Eclipse contributors and others 2005, 2013.  All rights reserved.
 *  © 2013 Oracle Corporation. All rights reserved.
 * 
 * 	THIS APPLICATION IS SUITABLE FOR ALL AGES. REPRODUCTION, REVERSE
 * 	ENGINEERING, REDISTRIBUTION, PIRACY, PLAIGARISM OR COPYRIGHT
 * 	INFRINGEMENT IS STRICTLY PROHIBITED.
 * 
 * 	Source Code v1.0
 * 	
 * 	GregDesAnimatedBalls.java 
 * 	(Main Application Initialization and Error Handler)
 * 
 * 	Builds the full application, runs it, and handles any serious exceptions
 * 	or errors that can be caused by the program itself.
 * 
 *  ~ TECHNICAL DETAILS ~
 * 	# of Imported Package Calls: 23
 *  # of Class Files: 19 (including this one)
 *  # of Interface Files: 0
 *  # of Packages: 1 (only for this program)
 *  
 *  # of Lines Total: 5803 lines of code
 *  42 This file
 *  322 // AnimatedBall
 *  74 // AnimatedBoard
 *  50 // AnimationTimerListener
 *  219 // Application
 *  764 // ApplicationBallAddABallUtility
 *  256 // ApplicationBallCommonColorDialog
 *  252 // ApplicationBallCommonOutlineColorDialog
 *  112 // ApplicationBallCommonWidthDialog
 *  998 // ApplicationBallEditABallUtility
 *  176 // ApplicationControlUtility
 *  483 // ApplicationMainSettingsUtility
 *  388 // ApplicationMenuBar
 *  720 // ApplicationMenuBarActionListener
 *  77 // BallCountKeyboardListener
 *  92 // BallCountMouseListener
 *  75 // BallCountMouseWheelListener
 *  36 // BallRandomizer
 *  667 // Help
 */

package gregdesGroupOfBallsFull;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class GregDesAnimatedBalls 
{
	public static void main(String[] args)
	{
		JLabel errorMessage = null;
		
		try
		{
			new Application();
			Application.mainFrame.setVisible(true);
		}
		catch(Exception e)
		{
			Application.mainFrame.dispose();
			
			errorMessage = new JLabel("<html>The program has encountered an exception it cannot handle and therefore must be closed."
					+ "<br/><br/>Please run the program again.</html>");
			errorMessage.setFont(new Font("Consolas", Font.PLAIN, 13));
			errorMessage.setForeground(Color.RED);
			
			javax.swing.JOptionPane.showMessageDialog(null, errorMessage, "Fatal Exception Detected", javax.swing.JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		catch(Error fatalError)
		{
			Application.mainFrame.dispose();
			
			errorMessage = new JLabel("<html>The program has generated a fatal error and is now forced to be closed."
					+ "<br/><br/>Please run the program again.</html>");
			errorMessage.setFont(new Font("Consolas", Font.PLAIN, 13));
			errorMessage.setForeground(Color.RED);
			
			javax.swing.JOptionPane.showMessageDialog(null, errorMessage, "Fatal Error Detected", javax.swing.JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}
