package gregdesGroupOfBallsFull;

import java.awt.*;
import java.awt.event.*;

import javax.sound.midi.*;
import javax.sound.sampled.*;
import javax.swing.*;

final class ApplicationMenuBarActionListener implements ActionListener {

	java.awt.Font defaultFont = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 13);
	java.awt.Color defaultBackgroundColor = java.awt.Color.BLACK;
	java.awt.Color defaultFontColor = java.awt.Color.WHITE;
	
	public void actionPerformed(ActionEvent menuButtonEvent) 
	{
		Application.canvas.repaint();
		Application.canvas.remove(Application.canvas.extraPanel);
		Application.canvas.repaint();
		
		if(menuButtonEvent.getSource() == Application.menuBar.aboutButton)
		{
			Application.dialogLabel.setText("<html>"
					+ "<i><b>Gregory Desrosiers' Animated Balls</b></i><br/><br/>"
					+ "August 12, 2013 - August 26, 2013<br/><br/>"
					+ "Programmed by Gregory Desrosiers; developed using Eclipse Java EE IDE for Web Developers - Kepler Release<br/><br/>"
					+ "Eclipse IDE © Eclipse contributors and others 2005, 2013.  All rights reserved.<br/><br/>"
					+ "JAVA [JRE7] © 2013 Oracle Corporation. All rights reserved.<br/><br/><br/>"
					+ "© 2013 Gregory Desrosiers. All rights reserved."
					+ "</html>");
			Application.dialogLabel.setForeground(defaultBackgroundColor);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "About Animated Balls", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.addABallButton)
		{
			if (Application.canvas.currentBallCount < Application.canvas.MAX_BALL_COUNT)
			{
				Application.animationTimer.stop();
				Application.currentAnimationStatus.setText("Animation stopped.");
				
				Application.mainFrame.setEnabled(false);
				
				new ApplicationBallAddABallUtility();
			}
			else if (Application.canvas.currentBallCount == Application.canvas.ABSOLUTE_MAX_BALL_COUNT)
			{
				Application.dialogLabel.setText("<html>"
						+ "You cannot add a new ball anymore.<br/>The current ball count is now at the application's maximum limit."
						+ "</html>");
				Application.dialogLabel.setForeground(Color.RED);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "About Animated Balls", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (Application.canvas.currentBallCount == Application.canvas.MAX_BALL_COUNT)
			{
				Application.dialogLabel.setText("<html>"
						+ "You cannot add a new ball.<br/>The current ball count is now at the max limit.<br/><br/>"
						+ "You can modify the limit by going to Quick Settings, then click on \"Increase Max Ball Count\"<br/>"
						+ "or \"Decrease Max Ball Count.\"<br/><br/>The maximum is 1000, while the minimum is 25."
						+ "</html>");
				Application.dialogLabel.setForeground(Color.RED);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "About Animated Balls", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if (menuButtonEvent.getSource().toString().contains(Application.menuBar.ballColorRandomizationFlagButton.getText()))
		{
			for(int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				if (Application.menuBar.ballColorRandomizationFlagButton.getText().contains("Enable"))
					Application.canvas.ballList.get(x).randomizeBallColor = true;
				else if (Application.menuBar.ballColorRandomizationFlagButton.getText().contains("Disable"))
					Application.canvas.ballList.get(x).randomizeBallColor = false;
			}
			
			if (Application.menuBar.ballColorRandomizationFlagButton.getText().contains("Enable"))
				Application.menuBar.ballColorRandomizationFlagButton.setText("Disable ball color randomization");
			else if (Application.menuBar.ballColorRandomizationFlagButton.getText().contains("Disable"))
				Application.menuBar.ballColorRandomizationFlagButton.setText("Enable ball color randomization");
		}
		else if (menuButtonEvent.getSource().toString().contains(Application.menuBar.ballOutlineColorRandomizationFlagButton.getText()))
		{
			for(int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				if (Application.menuBar.ballOutlineColorRandomizationFlagButton.getText().contains("Enable"))
					Application.canvas.ballList.get(x).randomizeBallOutlineColor = true;
				else if (Application.menuBar.ballOutlineColorRandomizationFlagButton.getText().contains("Disable"))
					Application.canvas.ballList.get(x).randomizeBallOutlineColor = false;
			}
			
			if (Application.menuBar.ballOutlineColorRandomizationFlagButton.getText().contains("Enable"))
				Application.menuBar.ballOutlineColorRandomizationFlagButton.setText("Disable ball color outline randomization");
			else if (Application.menuBar.ballOutlineColorRandomizationFlagButton.getText().contains("Disable"))
				Application.menuBar.ballOutlineColorRandomizationFlagButton.setText("Enable ball outline color randomization");
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.controlButton.getText()))
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			
			new ApplicationControlUtility();
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.decreaseMaxBallCountButton)
		{
			if (Application.canvas.MAX_BALL_COUNT > Application.canvas.LOWEST_MAX_BALL_COUNT)
			{
				if (Application.canvas.MAX_BALL_COUNT < 50)
					Application.canvas.MAX_BALL_COUNT = 25;
				else
					Application.canvas.MAX_BALL_COUNT -= 25;
				
				if (Application.canvas.ballList.size() > Application.canvas.MAX_BALL_COUNT)
				{
					Application.canvas.currentBallCount = Application.canvas.MAX_BALL_COUNT;
					
					Application.dialogLabel.setText("The program is removing all the necessary balls to get down to the set max ball count.");
					
					JOptionPane.showMessageDialog(null, Application.dialogLabel, "Removing Balls", JOptionPane.WARNING_MESSAGE);
					
					for (int x = 0; x < (Application.canvas.ballList.size() - Application.canvas.MAX_BALL_COUNT); x++)
					{
						Application.canvas.ballList.removeFirst();
						Application.canvas.ballDraws.removeFirst();
						Application.canvas.ballOutlineDraws.removeFirst();
					}
					
					Application.numberOfBallsLabel.setText("Number of balls: " + Application.canvas.currentBallCount);
				}
				Application.currentMaxBallCount.setText("Current Max Ball Count: " + Application.canvas.MAX_BALL_COUNT);
			}
			else
			{
				Application.dialogLabel.setText("<html>You cannot decrease the maximum number of balls anymore.<br/>"
						+ "The absolute count minimum is 25.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Minimal Limit Reached", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.decreaseRenderingSpeedButton)
		{
			if (!Application.animationTimer.isRunning())
			{
				Application.dialogLabel.setText("<html>The canvas animation has is not running currently.<br/>"
						+ "It must be running before the rendering speed can be changed.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Animation Not Running", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (Application.renderingDelay < Application.maximalRenderingDelay)
			{
				Application.renderingDelay += 5;
				Application.animationTimer.setDelay(Application.renderingDelay);
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			}
			else
			{
				Application.dialogLabel.setText("<html>The rendering speed is currently at the lowest point.<br/>"
						+ "Delay between frames must be exactly, or less than, 0.05 seconds.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Slowest Rendering Speed Attained", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.editABallButton.getText()))
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			new ApplicationBallEditABallUtility();
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.helpButton)
		{
			if (Application.animationTimer.isRunning())
			{
				Application.animationTimer.stop();
				Application.currentAnimationStatus.setText("Animation stopped.");
			}
			
			if (Application.numberOfHelpWindowsOpened == 0)
			{
				Application.numberOfHelpWindowsOpened++;
				new Help();
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.increaseMaxBallCountButton)
		{
			if (Application.canvas.MAX_BALL_COUNT < Application.canvas.ABSOLUTE_MAX_BALL_COUNT)
			{
				if (Application.canvas.MAX_BALL_COUNT > 975)
					Application.canvas.MAX_BALL_COUNT = 1000;
				else
					Application.canvas.MAX_BALL_COUNT += 25;
				
				Application.currentMaxBallCount.setText("Current Max Ball Count: " + Application.canvas.MAX_BALL_COUNT);
			}
			else
			{
				Application.dialogLabel.setText("<html>You cannot increase the maximum number of balls anymore.<br/>"
						+ "The absolute count limit is 1000.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Limit Maxed Out", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.increaseRenderingSpeedButton)
		{
			if (!Application.animationTimer.isRunning())
			{
				Application.dialogLabel.setText("<html>The canvas animation has is not running currently.<br/>"
						+ "It must be running before the rendering speed can be changed.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Animation Not Running", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (Application.renderingDelay > Application.minimalRenderingDelay)
			{
				Application.renderingDelay -= 5;
				Application.animationTimer.setDelay(Application.renderingDelay);
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			}
			else
			{
				Application.dialogLabel.setText("<html>The rendering speed is currently at the highest point.<br/>"
						+ "Delay between frames must be more than or equal to 0.01 seconds.</html>");
				Application.dialogLabel.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Fastest Rendering Speed Attained", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains("Info on Music"))
		{
			Application.dialogLabel.setText("<html>"
					+ "This program only accepts music files that are in one of the following formats:<br/><br/>"
					+ "MIDI<br/>WAV<br/>AU<br/>AIFF<br/><br/>"
					+ "There are external programs you can download and use to convert the audio, in any<br/>"
					+ "of their supported formats, to one of the formats mentioned above. One example is<br/>"
					+ "the free audio mixer and conversion software Audacity, where you can convert <br/>"
					+ "your audio file, assuming it is supportive for the program, into either MP3, WAV,<br/>"
					+ "AU, or AIFF formats.<br/><br/>"
					+ "There is no built-in converter in this program that will be able to change the<br/>"
					+ "format the music file is in to one of what this application requires.<br/><br/>"
					+ "<b>WARNING: Download and use conversion software at your own risk, as this <br/>"
					+ "will require an Internet connection, but more importantly, using a program <br/>"
					+ "that does not fulfill your desires and therefore you have spent money you<br/>" 
					+ "refund.</b>"
					+ "<html>");
			Application.dialogLabel.setForeground(java.awt.Color.BLACK);
			
			JOptionPane.showMessageDialog(null, Application.dialogLabel, "Info on Music", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(menuButtonEvent.getSource().toString().contains("Load Music"))
			// The expression above is different than menuButtonEvent.getSource() == loadMusicButton,
			// because getSource returns info that is not the same as the button itself.
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setFileFilter(new MusicFileDialogFilter());
			fileChooser.setApproveButtonToolTipText("Click here to load the file!");
			fileChooser.setMultiSelectionEnabled(false);
			
			fileChooser.setDialogTitle("Music File Load");
		
			int dialogStatus = fileChooser.showDialog(null, "Load");
			
			if (dialogStatus == JFileChooser.APPROVE_OPTION)
			{
				Application.musicFile = fileChooser.getSelectedFile();
				
				if (Application.musicObject != null)
				{
					if (Application.musicObject instanceof Clip)
					{
						if (Application.javaSoundPlayer.isRunning())
							Application.javaSoundPlayer.stop();
					}
					// MIDI File
					else if (Application.musicObject instanceof Sequencer)
					{
						if (Application.midiObjectPlayer.isRunning())
							Application.midiObjectPlayer.stop();
					}
				}
				
				if (Application.musicFile.getName().endsWith(".midi"))
				{
					try 
					{
						Application.midiObjectPlayer = MidiSystem.getSequencer();
						Application.midiObjectPlayer.setSequence(MidiSystem.getSequence(Application.musicFile));

						Application.musicObject = Application.midiObjectPlayer;
						Application.loadedMusicFileTextField.setText(Application.musicFile.getName());
						
						Application.dialogLabel.setText("Loading complete.");
						Application.dialogLabel.setForeground(java.awt.Color.BLUE);
						
						JOptionPane.showMessageDialog(null, Application.dialogLabel);
					} 
					catch (MidiUnavailableException e) 
					{
						Application.dialogLabel.setText("Unable to load the MIDI file. Check to see if another program is using the file.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					} 
					catch (InvalidMidiDataException e) 
					{
						Application.dialogLabel.setText("Some MIDI data is not being accepted. Check for any undefined data.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					} 
					catch (java.io.IOException e) 
					{
						Application.dialogLabel.setText("There was a problem encountered with loading the MIDI file."
								+ "\nPlease select another file.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				else if (Application.musicFile.getName().endsWith(".wav") || Application.musicFile.getName().endsWith(".aiff")
					|| Application.musicFile.getName().endsWith(".au"))
				{
					try
					{
						javax.sound.sampled.AudioInputStream inputStream = AudioSystem.getAudioInputStream
								(Application.musicFile.toURI().toURL());
						
						Application.javaSoundPlayer = AudioSystem.getClip();
						Application.javaSoundPlayer.open(inputStream);
						
						Application.musicObject = Application.javaSoundPlayer;
						Application.loadedMusicFileTextField.setText(Application.musicFile.getName());
						
						Application.dialogLabel.setText("Loading complete.");
						Application.dialogLabel.setForeground(java.awt.Color.BLUE);
						
						JOptionPane.showMessageDialog(null, Application.dialogLabel);
					}
					catch (java.io.IOException fileExceptionError)
					{
						Application.dialogLabel.setText("There was a problem encountered with loading the file."
								+ " Please select another file.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (javax.sound.sampled.LineUnavailableException lineUnavailableException)
					{
						Application.dialogLabel.setText("No music feed is available for this file. Please select another file.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (javax.sound.sampled.UnsupportedAudioFileException audioFileException)
					{
						Application.dialogLabel.setText("The file has data not valid for its format and type. Please select another file.");
						Application.dialogLabel.setForeground(java.awt.Color.RED);
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music Load Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else
			{
				Application.dialogLabel.setText("No music file has been loaded to the program.");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Loaded", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains("Loop"))
		{
			if (Application.musicObject == null)
			{
				Application.dialogLabel.setText("<html>You have not loaded a music file yet.<br/>"
						+ "Therefore, the program cannot play the audio continuously.</html>");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Loaded", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				// WAV, AU, or AIFF File
				if (Application.musicObject instanceof Clip)
				{
					Application.javaSoundPlayer.setFramePosition(0);
					Application.javaSoundPlayer.loop(Clip.LOOP_CONTINUOUSLY);
				}
				// MIDI File
				else if (Application.musicObject instanceof Sequencer)
				{
					Application.midiObjectPlayer.setTickPosition(0);
					Application.midiObjectPlayer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
					Application.midiObjectPlayer.start();
				}
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.mainSettingsButton)
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			
			new ApplicationMainSettingsUtility();
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.makeAllBallsHaveNoOutlinesButton)
		{
			boolean allBallsHaveNoOutlines = true;
			
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				if (Application.canvas.ballList.get(x).ballHasOutline)
				{
					allBallsHaveNoOutlines = false;
					x = Application.canvas.ballList.size();
				}
			}
			
			if (allBallsHaveNoOutlines)
			{
				Application.dialogLabel.setText("All balls are currently set to not have outlines.");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Balls with No Outlines", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				for (int y = 0; y < Application.canvas.ballList.size(); y++)
					Application.canvas.ballList.get(y).ballHasOutline = false;
				
				Application.canvas.repaint();
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.makeAllBallsHaveOutlinesButton)
		{
			boolean allBallsHaveOutlines = true;
			
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				if (!Application.canvas.ballList.get(x).ballHasOutline)
				{
					allBallsHaveOutlines = false;
					x = Application.canvas.ballList.size();
				}
			}
			
			if (allBallsHaveOutlines)
			{
				Application.dialogLabel.setText("All balls are currently set to have outlines.");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Balls with No Outlines", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				for (int y = 0; y < Application.canvas.ballList.size(); y++)
					Application.canvas.ballList.get(y).ballHasOutline = true;
				
				Application.canvas.repaint();
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.playMusicButton.getText()))
		{
			if (Application.musicObject == null)
			{
				Application.dialogLabel.setText("<html>You have not loaded a music file yet.<br/>"
						+ "Therefore, the program cannot play the audio.</html>");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Loaded", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				// WAV, AU, or AIFF File
				if (Application.musicObject instanceof Clip)
				{
					Application.javaSoundPlayer.setFramePosition(0);
					Application.javaSoundPlayer.start();
				}
				// MIDI File
				else if (Application.musicObject instanceof Sequencer)
				{
					Application.midiObjectPlayer.setTickPosition(0);
					Application.midiObjectPlayer.setLoopCount(0);
					Application.midiObjectPlayer.start();
				}
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.quitButton)
		{
			javax.swing.JLabel labelObject = new javax.swing.JLabel("Are you sure you want to quit?");
			labelObject.setFont(defaultFont);
			
			if (JOptionPane.showConfirmDialog(null, labelObject, "Quitting the Program", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.randomizeAllBallColorsButton.getText()))
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				Application.canvas.ballList.get(x).ballColor = 
						new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				
				Application.canvas.ballDraws.get(x).setColor(Application.canvas.ballList.get(x).ballColor);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.randomizeAllBallOutlineColorsButton.getText()))
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				Application.canvas.ballList.get(x).ballOutlineColor = 
						new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				
				Application.canvas.ballOutlineDraws.get(x).setColor(Application.canvas.ballList.get(x).ballOutlineColor);
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.randomizeAllBallsButton)
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				Application.canvas.ballList.get(x).ballColor = 
						new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				
				Application.canvas.ballDraws.get(x).setColor(Application.canvas.ballList.get(x).ballColor);
				
				Application.canvas.ballList.get(x).ballOutlineColor = 
						new java.awt.Color(Application.randomizer.nextInt(256), Application.randomizer.nextInt(256), Application.randomizer.nextInt(256));
				
				Application.canvas.ballOutlineDraws.get(x).setColor(Application.canvas.ballList.get(x).ballOutlineColor);
				
				Application.canvas.ballList.get(x).xCoordinate = 
						Application.randomizer.nextInt((Application.canvas.getPreferredSize().width - Application.canvas.ballList.get(x).ballWidth) + 1);
				Application.canvas.ballList.get(x).yCoordinate = 
						Application.randomizer.nextInt((Application.canvas.getPreferredSize().height - Application.canvas.ballList.get(x).ballWidth) + 1);
				
				Application.canvas.ballList.get(x).currentDX = Application.randomizer.nextInt(AnimatedBall.maxDX) + 1;
				Application.canvas.ballList.get(x).currentDY = Application.randomizer.nextInt(AnimatedBall.maxDY) + 1;
				
				Application.canvas.ballList.get(x).ballWidth = (Application.randomizer.nextInt(AnimatedBall.maxBallWidth) + 1);
				
				Application.canvas.ballList.get(x).goingDown = Application.randomizer.nextBoolean();
				Application.canvas.ballList.get(x).goingRight = Application.randomizer.nextBoolean();
				
				Application.canvas.ballList.get(x).randomizeCurrentDX = Application.randomizer.nextBoolean();
				Application.canvas.ballList.get(x).randomizeCurrentDY = Application.randomizer.nextBoolean();
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.randomizeLocationOfAllBallsButton)
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				Application.canvas.ballList.get(x).xCoordinate = 
						Application.randomizer.nextInt((Application.canvas.getPreferredSize().width - Application.canvas.ballList.get(x).ballWidth) + 1);
				Application.canvas.ballList.get(x).yCoordinate = 
						Application.randomizer.nextInt((Application.canvas.getPreferredSize().height - Application.canvas.ballList.get(x).ballWidth) + 1);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.randomizeSpeedInXDirectionForAllBallsButton.getText()))
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
				Application.canvas.ballList.get(x).currentDX = Application.randomizer.nextInt(AnimatedBall.maxDX) + 1;
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.randomizeSpeedInYDirectionForAllBallsButton.getText()))
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
				Application.canvas.ballList.get(x).currentDY = Application.randomizer.nextInt(AnimatedBall.maxDY) + 1;
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.randomizeWidthOfAllBallsButton)
		{
			for (int x = 0; x < Application.canvas.ballList.size(); x++)
			{
				Application.canvas.ballList.get(x).ballWidth = (Application.randomizer.nextInt(AnimatedBall.maxBallWidth) + 1);
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.removeABallButton.getText()))
		{
			if (Application.canvas.currentBallCount == 1)
			{
				Application.dialogLabel.setText("<html>You have one ball; there has to be at least one ball rolling in the canvas.<br/>"
						+ "<b>The program is not removing the only ball from the canvas.</b></html>");
				Application.dialogLabel.setForeground(java.awt.Color.RED);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Ball Removal Refused", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				Application.canvas.ballList.removeFirst();
				Application.canvas.ballDraws.removeFirst();
				Application.canvas.ballOutlineDraws.removeFirst();
				
				Application.canvas.currentBallCount--;
				
				Application.numberOfBallsLabel.setText("Number of balls: " + Application.canvas.currentBallCount);
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.selectAColorForAllBallsButton)
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			
			new ApplicationBallCommonColorDialogBox();
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.selectAnOutlineColorForAllBallsButton.getText()))
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			
			new ApplicationBallCommonOutlineColorDialogBox();
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.selectAWidthForAllBallsButton)
		{
			Application.animationTimer.stop();
			Application.currentAnimationStatus.setText("Animation stopped.");
			
			Application.mainFrame.setEnabled(false);
			
			new ApplicationBallCommonWidthDialogBox();
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.startButton)
		{
			if (Application.animationTimer.isRunning())
			{
				Application.dialogLabel.setText("The canvas animation is running already.");
				Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Animation Running", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				Application.animationTimer.start();
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			}
		}
		else if(menuButtonEvent.getSource() == Application.menuBar.stopButton)
		{
			if (!Application.animationTimer.isRunning())
			{
				Application.dialogLabel.setText("The canvas animation has stopped already.");
				Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Animation Not Running", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				Application.animationTimer.stop();
				Application.currentAnimationStatus.setText("Animation stopped.");
			}
		}
		else if(menuButtonEvent.getSource().toString().contains(Application.menuBar.stopMusicButton.getText()))
		{
			if (Application.musicObject == null)
			{
				Application.dialogLabel.setText("You have not loaded a music file yet.");
				
				if (Application.dialogLabel.getForeground() == java.awt.Color.RED)
					Application.dialogLabel.setForeground(java.awt.Color.BLACK);
				
				JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Loaded", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				// WAV, AU, or AIFF File
				if (Application.musicObject instanceof Clip)
				{
					if (Application.javaSoundPlayer.isRunning())
						Application.javaSoundPlayer.stop();
					else
					{
						Application.dialogLabel.setText("The music file is not running.");
						Application.dialogLabel.setForeground(Color.BLACK);
						
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Running", JOptionPane.ERROR_MESSAGE);
					}
				}
				// MIDI File
				else if (Application.musicObject instanceof Sequencer)
				{
					if (Application.midiObjectPlayer.isRunning())
						Application.midiObjectPlayer.stop();
					else
					{
						Application.dialogLabel.setText("The music file is not running.");
						Application.dialogLabel.setForeground(Color.BLACK);
						
						JOptionPane.showMessageDialog(null, Application.dialogLabel, "Music File Not Running", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
		Application.canvas.add(Application.canvas.extraPanel, BorderLayout.NORTH);
	}

	// Class for Music File dialog filter
	private class MusicFileDialogFilter extends javax.swing.filechooser.FileFilter
	{
		public boolean accept(java.io.File f)
		{
			return f.isDirectory() || f.getName().toLowerCase().endsWith(".wav")
					|| f.getName().toLowerCase().endsWith(".aiff")
					|| f.getName().toLowerCase().endsWith(".au")
					|| f.getName().toLowerCase().endsWith(".midi");
		}
		
		public String getDescription()
		{
			return "Music Files (WAV, AIFF, AU, MIDI)";
		}
	}
}