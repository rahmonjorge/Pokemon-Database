package br.ufrpe.pokemondb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.ufrpe.pokemondb.business.Facade;
import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.exceptions.MaxRepositoryCapacityException;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public class NewPokemonFrame implements ActionListener, ItemListener{
	
	private JFrame addPokemonWindow = new JFrame("Novo Pokemon");
	private JPanel mainPanel = new JPanel();
	private boolean isEditWindow = false;
	
	private static JTextField numberField;
	private static JTextField nameField;
	private static JComboBox<Object> type1ComboBox;
	private static JComboBox<Object> type2ComboBox;
	private static JCheckBox legendaryCheckBox;
	private static boolean isBoxChecked = false;
	
	private static Pokemon editingPokemon;
	
	public NewPokemonFrame() {
		//Default constructor
	}
	
	public NewPokemonFrame(Object listObject) {
		isEditWindow = true;
		try {
			editingPokemon = (Pokemon) listObject;
			editingPokemon.getName();
		} catch(NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
		}
		addPokemonWindow.setTitle("Editar Pokemon");
	}
	
	public void createAndShowGUI() {
		//Main Framework
		addPokemonWindow.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Novo Pokemon"));
		if(isEditWindow)
			mainPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Editar Pokemon"));
		
		//Main Panel Contents
		JLabel label = new JLabel("Número");
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(label);
		numberField = new JTextField(30);
		numberField.setMaximumSize(new Dimension(400,0));
		numberField.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(numberField);
		
		label = new JLabel("Nome");
		mainPanel.add(label);
		nameField = new JTextField(30);
		nameField.setMaximumSize(new Dimension(400,0));
		nameField.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(nameField);
		
		label = new JLabel("Tipo 1");
		mainPanel.add(label);
		type1ComboBox = new JComboBox<Object>(ElementalType.toArray());
		type1ComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(type1ComboBox);
		
		label = new JLabel("Tipo 2");
		mainPanel.add(label);
		type2ComboBox = new JComboBox<Object>(ElementalType.toArray());
		type2ComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		mainPanel.add(type2ComboBox);
		
		legendaryCheckBox = new JCheckBox("Lendário?");
		legendaryCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		legendaryCheckBox.addItemListener(this);
		mainPanel.add(legendaryCheckBox);
		
		JButton defaultButton = ButtonBuilder.createButton("Adicionar", "ADD", null, this);
		addPokemonWindow.getContentPane().add(defaultButton, BorderLayout.PAGE_END);
		addPokemonWindow.getRootPane().setDefaultButton(defaultButton);
		
		//Edit window
		if(isEditWindow) {
			numberField.setText(Integer.toString(editingPokemon.getNumber()));
			nameField.setText(editingPokemon.getName());
			type1ComboBox.setSelectedItem(editingPokemon.getType1().name());
			type2ComboBox.setSelectedItem(editingPokemon.getType2().name());
			if(editingPokemon.getLegendary())
				legendaryCheckBox.setSelected(true);
			
			defaultButton.setName("Editar");
		}
		
		//Main Framework
		addPokemonWindow.pack();
		addPokemonWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addPokemonWindow.setLocationRelativeTo(null);
		addPokemonWindow.setResizable(false);
		addPokemonWindow.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ADD")) {
			try {
				int pkmnNumber = Integer.parseInt(numberField.getText());
				String pkmnName = nameField.getText();
				ElementalType pkmnType1 = ElementalType.valueOf((String)type1ComboBox.getSelectedItem());
				ElementalType pkmnType2 = ElementalType.valueOf((String)type2ComboBox.getSelectedItem());
				boolean pkmnLegendary = isBoxChecked;
				Facade.getInstance().insert(pkmnNumber, pkmnName, pkmnType1, pkmnType2, pkmnLegendary);
				if(isEditWindow)
					Facade.getInstance().remove(editingPokemon);
				MainFrame.getInstance().updateTable();
				addPokemonWindow.setVisible(false);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "NullPointerException. Source: " + e1.getMessage());
				e1.printStackTrace();
			} catch (ObjectAlreadyExistsException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Este pokémon já foi criado."); //TODO not firing
				e1.printStackTrace();
			} catch (MaxRepositoryCapacityException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Foi atingida a capacidade máxima do repositório de pokémons.");
				e1.printStackTrace();
			} catch (ObjectDoesNotExistsException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "O pokémon selecionado não existe.\nIsso não deveria ser possível.");
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Insira um número válido.");
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Insira um nome válido.");
				e1.printStackTrace();
			}
		}
	}

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        if (source == legendaryCheckBox) {
        	if(e.getStateChange() == ItemEvent.SELECTED) {
                isBoxChecked = true;
            }
        	else if(e.getStateChange() == ItemEvent.DESELECTED) {
        		isBoxChecked = false;
        	}
        }
    }
}
