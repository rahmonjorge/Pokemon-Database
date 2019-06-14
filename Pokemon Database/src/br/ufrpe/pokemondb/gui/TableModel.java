package br.ufrpe.pokemondb.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;

public class TableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 4487241321693602560L;
	
	private String[] columnNames = {"#","Nome","Tipo1","Tipo2","Lendário"};
	private Object[][] tableData = new Object[100][5];
	
	public TableModel(ArrayList<Pokemon> pokemons) {
		setAllValues(pokemons);
	}
	
	public int getColumnCount() {
        return columnNames.length;
    }

	public int getRowCount() {
		return tableData.length;
	}
	
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        return tableData[row][col];
    }

	public Class getColumnClass(int col) {
		if(getValueAt(0,col) == null) {
			return Pokemon.class;
		}
		return getValueAt(0, col).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        tableData[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public void setAllValues(ArrayList<Pokemon> pokemons) {
    	for(int i = 0; i < pokemons.size(); i++) {
			tableData[i][0] = pokemons.get(i).getNumber();
			tableData[i][1] = pokemons.get(i).getName(); System.out.println("[TableModel]Pokemon "+pokemons.get(i).getName()+" added to the tablemodel data array.");
			tableData[i][2] = pokemons.get(i).getType1();
			tableData[i][3] = pokemons.get(i).getType2();
			tableData[i][4] = pokemons.get(i).getLegendary();
		}
    }

}
