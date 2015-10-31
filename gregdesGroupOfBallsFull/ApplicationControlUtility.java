package gregdesGroupOfBallsFull;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

final class ApplicationControlUtility 
{
	private JFrame utilityFrame;
	private JPanel mainPanel;
	
	private JLabel commandLabel;
	
	private JPanel controlSchemePanel;
	private JCheckBox keyboardControlCheckBox;
	private JCheckBox mouseControlCheckBox;
	private JCheckBox mouseWheelControlCheckBox;
	
	private JPanel confirmationPanel;
	// Radio buttons for Accept and Decline.
	private JRadioButton acceptButton;
	private JRadioButton declineButton;
	
	ApplicationControlUtility()
	{
		utilityFrame = new JFrame();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Application.defaultBackgroundColor);
		
		commandLabel = new JLabel("<html>These controls add and remove balls faster than using the<br/>"
				+ "\"Add A Ball\" or \"Remove A Ball\" utilities.<br/>"
				+ "Select which control scheme you want to perform this.</html>");
		commandLabel.setFont(Application.currentFont);
		commandLabel.setForeground(Application.defaultFontColor);
		commandLabel.setBackground(Application.defaultBackgroundColor);
		mainPanel.add(commandLabel, BorderLayout.NORTH);
		
		
		
		controlSchemePanel = new JPanel();
		controlSchemePanel.setLayout(new GridLayout(3, 1));
		controlSchemePanel.setBackground(Application.defaultBackgroundColor);
		
		keyboardControlCheckBox = new JCheckBox("Keyboard Control", Application.keyboardControlEnabled);
		keyboardControlCheckBox.setFont(Application.currentFont);
		keyboardControlCheckBox.setForeground(Application.defaultFontColor);
		keyboardControlCheckBox.setBackground(Application.defaultBackgroundColor);
		keyboardControlCheckBox.setToolTipText("<html>Toggle, whether or not, the program to accept keyboard control.<br/><br/>"
				+ "Pressing the Up or Right Arrow Key adds an unknown ball to the canvas.<br/>"
				+ "Pressing the Left or Down Arrow Key removes a ball from the canvas."
				+ "</html>");
		controlSchemePanel.add(keyboardControlCheckBox);
		
		mouseControlCheckBox =  new JCheckBox("Mouse Button Control", Application.mouseControlEnabled);
		mouseControlCheckBox.setFont(Application.currentFont);
		mouseControlCheckBox.setForeground(Application.defaultFontColor);
		mouseControlCheckBox.setBackground(Application.defaultBackgroundColor);
		mouseControlCheckBox.setToolTipText("<html>Toggle, whether or not, the program to accept keyboard control.<br/><br/>"
				+ "Clicking on the left mouse button adds an unknown ball to the canvas.<br/>"
				+ "Clicking on the right mouse button removes a ball from the canvas."
				+ "</html>");
		controlSchemePanel.add(mouseControlCheckBox);
		
		mouseWheelControlCheckBox =  new JCheckBox("Mouse Wheel Control", Application.mouseWheelControlEnabled);
		mouseWheelControlCheckBox.setFont(Application.currentFont);
		mouseWheelControlCheckBox.setForeground(Application.defaultFontColor);
		mouseWheelControlCheckBox.setBackground(Application.defaultBackgroundColor);
		mouseWheelControlCheckBox.setToolTipText("<html>Toggle, whether or not, the program to accept keyboard control.<br/><br/>"
				+ "Scrolling the mouse wheel up adds unknown balls to the canvas.<br/>"
				+ "Scrolling the mouse wheel down removes balls from the canvas."
				+ "</html>");
		controlSchemePanel.add(mouseWheelControlCheckBox);
		
		mainPanel.add(controlSchemePanel);
		
		
		
		confirmationPanel = new JPanel();
		confirmationPanel.setBackground(Application.defaultBackgroundColor);
		// Radio buttons for Accept and Decline.
		acceptButton = new JRadioButton("Accept");
		acceptButton.setBackground(Application.defaultBackgroundColor);
		acceptButton.setForeground(Application.defaultFontColor);
		acceptButton.setFont(Application.currentFont);
		acceptButton.setToolTipText("Click it to add the button with the above settings!");
		acceptButton.addActionListener(new RadioButtonListener());
		confirmationPanel.add(acceptButton);
		
		declineButton = new JRadioButton("Cancel");
		declineButton.setBackground(Application.defaultBackgroundColor);
		declineButton.setForeground(Application.defaultFontColor);
		declineButton.setFont(Application.currentFont);
		declineButton.setToolTipText("Go back to the main application and don't add a new ball.");
		declineButton.addActionListener(new RadioButtonListener());
		confirmationPanel.add(declineButton);
		
		mainPanel.add(confirmationPanel, BorderLayout.SOUTH);
		
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Control Functions", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
		utilityFrame.add(mainPanel);
		utilityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		utilityFrame.setUndecorated(true);
		utilityFrame.pack();
		utilityFrame.setResizable(false);
		utilityFrame.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (utilityFrame.getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (utilityFrame.getHeight() / 2));
		utilityFrame.setVisible(true);
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent g)
		{
			if (g.getSource().toString().contains(acceptButton.getText()))
			{
				Application.keyboardControlEnabled = keyboardControlCheckBox.isSelected();
				Application.mouseControlEnabled = mouseControlCheckBox.isSelected();
				Application.mouseWheelControlEnabled = mouseWheelControlCheckBox.isSelected();
				
				if (keyboardControlCheckBox.isSelected())
				{
					if (Application.mainFrame.getKeyListeners().length == 1)
						Application.mainFrame.removeKeyListener(Application.mainFrame.getKeyListeners()[0]);
						
					Application.mainFrame.addKeyListener(new BallCountKeyboardListener());
				}
				else
					if (Application.mainFrame.getKeyListeners().length == 1)
						Application.mainFrame.removeKeyListener(Application.mainFrame.getKeyListeners()[0]);
				
				if (mouseControlCheckBox.isSelected())
				{
					if (Application.canvas.getMouseListeners().length == 1)
						Application.canvas.removeMouseListener(Application.canvas.getMouseListeners()[0]);
					
					Application.canvas.addMouseListener(new BallCountMouseListener());
				}
				else
					if (Application.canvas.getMouseListeners().length == 1)
						Application.canvas.removeMouseListener(Application.canvas.getMouseListeners()[0]);
				
				if (mouseWheelControlCheckBox.isSelected())
				{
					if (Application.mainFrame.getMouseWheelListeners().length == 1)
						Application.mainFrame.removeMouseWheelListener(Application.mainFrame.getMouseWheelListeners()[0]);
					
					Application.mainFrame.addMouseWheelListener(new BallCountMouseWheelListener());
				}
				else
					if (Application.mainFrame.getMouseWheelListeners().length == 1)
						Application.mainFrame.removeMouseWheelListener(Application.mainFrame.getMouseWheelListeners()[0]);
					
				Application.animationTimer.start();
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
					
				utilityFrame.dispose();
				Application.mainFrame.setEnabled(true);
			}
			else if (g.getSource().toString().contains(declineButton.getText()))
			{
				Application.animationTimer.start();
				Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
				
				utilityFrame.dispose();
				Application.mainFrame.setEnabled(true);
			}
		}
	}
}