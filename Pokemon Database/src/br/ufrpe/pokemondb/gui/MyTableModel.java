package br.ufrpe.pokemondb.gui.beans;

import javax.swing.table.AbstractTableModel;

public class PDBTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 8626419598504056302L;

	private String[] columnNames = {"#","Name","Type1","Type2","Legendary"};
	private Object[][] data;
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.length;
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void setObjectAt(Object object, int row, int col) {
        data[row][col] = object;
        fireTableCellUpdated(row, col);
    }

}
