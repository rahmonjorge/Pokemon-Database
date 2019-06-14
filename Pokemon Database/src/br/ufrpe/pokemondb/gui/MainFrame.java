package br.ufrpe.pokemondb.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import br.ufrpe.pokemondb.business.PokemonController;
import br.ufrpe.pokemondb.business.beans.Pokemon;

public class MainFrame implements ActionListener, TableModelListener{
	
	private static MainFrame instance;
	
	private JFrame mainWindow;
	private TableModel tableModel;
	private JTable table;
	private JScrollPane tableContainer;
	
	private MainFrame() {
		mainWindow = new JFrame("Pokémon Database");
		tableModel = new TableModel((ArrayList<Pokemon>) PokemonController.getInstance().list());
		table = new JTable(tableModel);
		 tableContainer = new JScrollPane(table);
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public void createAndShowGUI() {
		
		//Table Framework
		table.getModel().addTableModelListener(this);
		table.setFillsViewportHeight(true);
			
		//Tool Bar
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
			//Tool Bar Buttons
			JButton button = null;
			button = ButtonBuilder.createButton("Novo","ADD","New Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Remover","REMOVE","Delete Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Editar","UPDATE","Edit Pokemon", this);
			toolBar.add(button);
			
		//Main Framework
		mainWindow.add(tableContainer, BorderLayout.CENTER);
		mainWindow.add(toolBar, BorderLayout.PAGE_START);
		mainWindow.setPreferredSize(new Dimension(640,480));
		mainWindow.pack();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
		
		//Special Framework
		if(table.getRowCount() == 0) {
			toolBar.getComponent(1).setEnabled(false);
			toolBar.getComponent(2).setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "ADD":
			new NewPokemonFrame().createAndShowGUI();
			break;
		case "UPDATE":
			if(table.getSelectedRowCount() == 1) {
				Object selectedObject = table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn());
				new NewPokemonFrame(selectedObject).createAndShowGUI();
			}
			else if(table.getSelectedRowCount() == 0){
				JOptionPane.showMessageDialog(new JFrame(), "Escolha um objeto da tabela.");
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Escolha somente um objeto da tabela.");
			}
			break;
		case "REMOVE":
			if(table.getSelectedRowCount() > 0) {
				int n = JOptionPane.showConfirmDialog(
                        mainWindow, "Tem certeza que deseja remover o(s) objeto(s) selecionado(s)?",
                        "Confirmar Remoção",
                        JOptionPane.YES_NO_OPTION);
                 if (n == JOptionPane.YES_OPTION) {
                	 //TODO Remove selection
                 } else {
                	 //Close window
                 }
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(), "Escolha ao menos um objeto da tabela.");
			}
			break;
		default:
		}
	}

	public void updateTable() {
		ArrayList<Pokemon> updatedList = new ArrayList<>();
		updatedList.addAll(PokemonController.getInstance().list());
		tableModel.setAllValues(updatedList);
		table.updateUI();
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
