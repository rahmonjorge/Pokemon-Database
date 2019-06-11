package br.ufrpe.pokemondb.gui.beans;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MyTable {
	private JTable table;
	
	public MyTable(TableModel tm) {
		table = new JTable(tm);
        table.setFillsViewportHeight(true);
	}
	
	public JTable getTable() {
		return table;
	}
}
