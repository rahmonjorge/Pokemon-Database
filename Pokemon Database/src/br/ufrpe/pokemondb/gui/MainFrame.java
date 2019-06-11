package br.ufrpe.pokemondb.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;

public class MainFrame implements ActionListener{
	
	//Beans
	static Pokemon pikachu = new Pokemon(25, "Pikachu",ElementalType.ELECTRIC, ElementalType.ELECTRIC, false);
	static Pokemon raichu = new Pokemon(26, "Raichu",ElementalType.ELECTRIC, ElementalType.ELECTRIC, false);
	static Pokemon articuno = new Pokemon(144, "Articuno",ElementalType.ICE, ElementalType.FLYING, false);
		
	//Table
	static String[] colNames = {"#","Name","Type1","Type2","Legendary"};
	static Object[][] data = {
			{pikachu.getNumber(), pikachu.getName(), pikachu.getType1(), pikachu.getType2(), pikachu.getLegendary()},
			{raichu .getNumber(), raichu .getName(), raichu .getType1(), raichu .getType2(), raichu .getLegendary()},
			{articuno.getNumber(), articuno.getName(), articuno.getType1(), articuno.getType2(), articuno.getLegendary()},
	};
	static JTable table = new JTable(data, colNames);
	static JScrollPane tableContainer = new JScrollPane(table);
	
	//Buttons
	static final String ADD = "add";
	static final String REMOVE = "remove";
	static final String UPDATE = "update";
		
	public void createAndShowGUI() {
		//Pre-Framework
		JFrame mainWindow = new JFrame("Pokémon Database");
			
		//Framework
			//Table Framework
			table.setFillsViewportHeight(true);
			
			//Tool Bar
			JToolBar toolBar = new JToolBar();
			toolBar.setFloatable(false);
			toolBar.setRollover(true);
				//Tool Bar Buttons
				JButton button = null;
				button = ButtonBuilder.createButton("AddPokemon","ADD","New Pokemon","New", this);
				toolBar.add(button);
				button = ButtonBuilder.createButton("RemovePokemon","REMOVE","Delete Pokemon","Delete", this);
				toolBar.add(button);
				button = ButtonBuilder.createButton("UpdatePokemon","UPDATE","Edit Pokemon","Edit", this);
				toolBar.add(button);
			
		//Post-Framework
		mainWindow.add(tableContainer, BorderLayout.CENTER);
		mainWindow.add(toolBar, BorderLayout.PAGE_START);
		
		mainWindow.setPreferredSize(new Dimension(640,480));
		mainWindow.pack();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "ADD":
			JFrame addPokemonWindow = new JFrame("Add Pokemon");
			addPokemonWindow.setPreferredSize(new Dimension(320,240));
			addPokemonWindow.pack();
			addPokemonWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			addPokemonWindow.setVisible(true);
			break;
		case "UPDATE":
			break;
		case "REMOVE":
			break;
		default:
		}
	}
}
