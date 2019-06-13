package br.ufrpe.pokemondb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.ufrpe.pokemondb.business.beans.ElementalType;

public class NewPokemonFrame implements ActionListener{
	
	private JFrame addPokemonWindow = new JFrame("Add Pokemon");
	private JPanel mainPanel = new JPanel();
	
	public void createAndShowGUI() {
		//Main Framework
		addPokemonWindow.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "New Pokemon"));
		
		//Main Panel Contents
		JLabel label = new JLabel("Number");
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(label);
		
		JTextField numberField = new JTextField(30);
		numberField.setMaximumSize(new Dimension(400,0));
		numberField.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(numberField);
		
		label = new JLabel("Name");
		mainPanel.add(label);
		
		JTextField nameField = new JTextField(30);
		nameField.setMaximumSize(new Dimension(400,0));
		nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(nameField);
		
		label = new JLabel("Type 1");
		mainPanel.add(label);
		
		JComboBox<Object> type1ComboBox = new JComboBox<Object>(ElementalType.toArray());
		type1ComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(type1ComboBox);
		
		label = new JLabel("Type 2");
		mainPanel.add(label);
		
		JComboBox<Object> type2ComboBox = new JComboBox<Object>(ElementalType.toArray());
		type2ComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(type2ComboBox);
		
		JCheckBox legendaryCheckBox = new JCheckBox("Legendary?");
		legendaryCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(legendaryCheckBox);
		
		JButton defaultButton = ButtonBuilder.createButton("Add", "Add", null, this);
		addPokemonWindow.getContentPane().add(defaultButton, BorderLayout.PAGE_END);
		addPokemonWindow.getRootPane().setDefaultButton(defaultButton);
		
		//Main Framework
		addPokemonWindow.pack();
		addPokemonWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addPokemonWindow.setLocationRelativeTo(null);
		addPokemonWindow.setResizable(false);
		addPokemonWindow.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add")) {
			//TODO Adds pokemon to repository properly
		}
	}
}
