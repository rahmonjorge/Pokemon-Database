package br.ufrpe.pokemondb.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufrpe.pokemondb.gui.builders.RootBuilder;

@SuppressWarnings("serial")
public class RootFrame extends JPanel{
	public RootFrame() {
		JTable table = RootBuilder.newTable();
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		setVisible(true);
	}
}
