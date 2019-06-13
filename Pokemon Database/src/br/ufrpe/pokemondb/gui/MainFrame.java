package br.ufrpe.pokemondb.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;

public class MainFrame implements ActionListener, ListSelectionListener{
	//Frame
	private JFrame mainWindow = new JFrame("Pokémon Database");
	
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
		//Table Framework
		table.setFillsViewportHeight(true);
			
		//Tool Bar
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
			//Tool Bar Buttons
			JButton button = null;
			button = ButtonBuilder.createButton("Add","ADD","New Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Remove","REMOVE","Delete Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Update","UPDATE","Edit Pokemon", this);
			toolBar.add(button);
			
		//Main Framework
		mainWindow.add(tableContainer, BorderLayout.CENTER);
		mainWindow.add(toolBar, BorderLayout.PAGE_START);
		mainWindow.setPreferredSize(new Dimension(640,480));
		mainWindow.pack();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "ADD":
			new NewPokemonFrame().createAndShowGUI();
			break;
		case "UPDATE":
			//TODO Open update window to update a selected row on the table
			break;
		case "REMOVE":
			if(table.getSelectedRowCount() > 0) {
				//TODO Display dialog 'are you sure to delete selected row(s)?'
			}
			else {
				//TODO Display dialog 'select at least one row'
			}
			break;
		default:
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		
	}
}
