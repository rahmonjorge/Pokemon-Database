package br.ufrpe.pokemondb.gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.ufrpe.pokemondb.business.beans.Pokemon;

public class TableModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 4487241321693602560L;
	
	private String[] columnNames = {"#","Nome","Tipo1","Tipo2","Lendario"};
	private Object[][] tableData = new Object[23][5]; // Can be improved by only instatiating this variable based on the amount of objects received by the constructor
	
	public TableModel(List<Pokemon> pokemons) {
		for(int i = 0; i < pokemons.size(); i++) {
			tableData[i][0] = pokemons.get(i).getNumber();
			tableData[i][1] = pokemons.get(i).getName();
			tableData[i][2] = pokemons.get(i).getType1();
			tableData[i][3] = pokemons.get(i).getType2();
			tableData[i][4] = pokemons.get(i).getLegendary();
		}
	}
	
	public int getColumnCount() {
        return columnNames.length;
    }

	public int getRowCount() {
		if(tableData == null) {
			return 0;
		}
		return tableData.length;
	}
	
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        return tableData[row][col];
    }

	public Class<?> getColumnClass(int col) {
		return String.class;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        tableData[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
