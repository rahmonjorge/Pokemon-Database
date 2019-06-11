package br.ufrpe.pokemondb.gui.builders;

import javax.swing.JTable;

import br.ufrpe.pokemondb.gui.beans.PDBTableModel;

public class TableBuilder{
	
	private JTable table;
	private PDBTableModel tableModel;
	
	public JTable getTable() {
		return table;
	}

    public void newTable(Object[][] data, String[] columnNames) {
        table = new JTable(data, columnNames);
        table.setModel(tableModel);
    }
	
}
