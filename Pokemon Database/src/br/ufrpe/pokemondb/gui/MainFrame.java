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
import javax.swing.ListSelectionModel;

import br.ufrpe.pokemondb.business.Facade;
import br.ufrpe.pokemondb.business.PokemonController;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public class MainFrame extends AbstractFrame implements ActionListener{
	
	private static MainFrame instance;
	
	private JFrame mainWindow;
	private TableModel dataModel;
	private JTable table;
	private JScrollPane tableContainer;
	
	private MainFrame() {
		mainWindow = new JFrame("Pokémon Database");
		dataModel = new TableModel(PokemonController.getInstance().list());
		table = new JTable(dataModel);
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
			
		//Tool Bar
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
			//Tool Bar Buttons
			JButton button = null;
			button = ButtonBuilder.createButton("Novo","NEW","New Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Remover","REMOVE","Delete Pokemon", this);
			toolBar.add(button);
			button = ButtonBuilder.createButton("Editar","EDIT","Edit Pokemon", this);
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
		case "NEW":
			new NewPokemonFrame().createAndShowGUI();
			break;
		case "EDIT":
			if(table.getSelectedRowCount() == 1) {
				try {
					Pokemon selectedPokemon = Facade.getInstance().browse((int) table.getModel().getValueAt(table.getSelectedRow(), 0));
					new NewPokemonFrame(selectedPokemon).createAndShowGUI();
				} catch (ObjectDoesNotExistsException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "A linha selecionada está vazia.");
					e1.printStackTrace();
				}
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
				int optionSelected = JOptionPane.showConfirmDialog(
                        mainWindow, "Tem certeza que deseja remover o objeto selecionado(s)?",
                        "Confirmar Remoção",
                        JOptionPane.YES_NO_OPTION);
                 if (optionSelected == JOptionPane.YES_OPTION) {
                	try {
                		Pokemon selectedPokemon = Facade.getInstance().browse((int) table.getModel().getValueAt(table.getSelectedRow(), 0));
						Facade.getInstance().remove(selectedPokemon);
						updateTable();
					} catch (ObjectDoesNotExistsException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Houve uma tentativa de remover um objeto que não existe no repositório.\nIsso devia ser impossível.");
						e1.printStackTrace();
					}
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
		TableModel newData = new TableModel(new ArrayList<Pokemon>(Facade.getInstance().list()));
		table.setModel(newData);
		table.updateUI();
	}
	
}
