package br.ufrpe.pokemondb.gui;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonBuilder {
	public static JButton createButton(String imageName, String actionCommand, String toolTipText, String altText, ActionListener actionListener) {
		//TODO Access button image from file system
		String imgLocation = imageName;
	
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.setIcon(new ImageIcon());
		
		button.addActionListener(actionListener);
		
		return button;
	}
}
