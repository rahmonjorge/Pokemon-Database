package br.ufrpe.pokemondb.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonBuilder {
	public static JButton create(String name, String actionCommand, String toolTipText, ActionListener actionListener) {
	
		JButton button = new JButton(name);
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(actionListener);
		
		return button;
	}
}
