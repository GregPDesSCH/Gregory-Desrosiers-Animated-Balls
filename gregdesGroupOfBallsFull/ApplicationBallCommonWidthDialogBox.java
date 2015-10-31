package gregdesGroupOfBallsFull;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

final class ApplicationBallCommonWidthDialogBox 
{
	private JFrame windowFrame;
	private JPanel mainPanel;
	
	private JPanel topPanel;
	private JLabel commandLabel;
	private JSpinner widthSpinner;
	private SpinnerNumberModel modelOptions;
	
	private JPanel bottomPanel;
	private JRadioButton acceptButton;
	private JRadioButton declineButton;
	
	ApplicationBallCommonWidthDialogBox()
	{
		windowFrame = new JFrame();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Application.defaultBackgroundColor);
		mainPanel.setLayout(new java.awt.BorderLayout());
		
		// Top Panel construction
		topPanel = new JPanel();
		topPanel.setBackground(Application.defaultBackgroundColor);
		topPanel.setLayout(new java.awt.BorderLayout());
		
		commandLabel = new JLabel("Select a common width for all balls to have.");
		commandLabel.setBackground(Application.defaultBackgroundColor);
		commandLabel.setForeground(Application.defaultFontColor);
		commandLabel.setFont(Application.defaultFont2);
		
		widthSpinner = new JSpinner();
		widthSpinner.setBackground(Application.defaultBackgroundColor);
		widthSpinner.setForeground(Application.defaultFontColor);
		widthSpinner.setFont(Application.defaultFont2);
		
		modelOptions = new SpinnerNumberModel();
		modelOptions.setStepSize(1);
		modelOptions.setMinimum(1);
		modelOptions.setMaximum(25);
		modelOptions.setValue(Application.currentWidthDialogOptionValue);
		
		widthSpinner.setModel(modelOptions);
		
		topPanel.add(commandLabel, java.awt.BorderLayout.NORTH);
		topPanel.add(widthSpinner, java.awt.BorderLayout.CENTER);

		// Bottom Panel construction
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Application.defaultBackgroundColor);
		
		acceptButton = new JRadioButton("OK");
		acceptButton.setForeground(Application.defaultFontColor);
		acceptButton.setBackground(Application.defaultBackgroundColor);
		acceptButton.setFont(Application.defaultFont2);
		acceptButton.addActionListener(new RadioButtonListener());
		
		declineButton = new JRadioButton("Back");
		declineButton.setForeground(Application.defaultFontColor);
		declineButton.setBackground(Application.defaultBackgroundColor);
		declineButton.setFont(Application.defaultFont2);
		declineButton.addActionListener(new RadioButtonListener());
		
		bottomPanel.add(acceptButton);
		bottomPanel.add(declineButton);
		
		// Final Assembly and Initialization
		mainPanel.add(topPanel, java.awt.BorderLayout.NORTH);
		mainPanel.add(bottomPanel, java.awt.BorderLayout.CENTER);
		
		mainPanel.setBorder(BorderFactory.
				createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 8), "Common Width for All Balls", 
						javax.swing.border.TitledBorder.CENTER , javax.swing.border.TitledBorder.ABOVE_TOP, 
						Application.defaultFont, Color.WHITE));
		
		windowFrame.add(mainPanel);
		windowFrame.setUndecorated(true);
		windowFrame.pack();
		windowFrame.setLocation((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (windowFrame.getWidth() / 2), 
				(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (windowFrame.getHeight() / 2));
		windowFrame.setVisible(true);
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent g)
		{
			if (g.getSource() == acceptButton)
			{
				for(int x = 0; x < Application.canvas.currentBallCount; x++)
					Application.canvas.ballList.get(x).ballWidth = (Integer) widthSpinner.getValue();
				
				Application.currentWidthDialogOptionValue = (Integer) widthSpinner.getValue();
				Application.canvas.repaint();
			}
				
			Application.animationTimer.start();
			Application.currentAnimationStatus.setText("Animation running. Rendering Delay: " + Application.renderingDelay + " milliseconds");
			
			windowFrame.dispose();
			Application.mainFrame.setEnabled(true);
		}
	}
}