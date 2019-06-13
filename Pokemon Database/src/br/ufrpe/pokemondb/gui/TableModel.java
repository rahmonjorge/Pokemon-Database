package br.ufrpe.pokemondb.gui;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.ufrpe.pokemondb.business.PokemonController;
import br.ufrpe.pokemondb.business.beans.Pokemon;

public class TableModel extends AbstractTableModel implements TableModelListener{
	
	private static final long serialVersionUID = 4487241321693602560L;
	
	private ArrayList<Pokemon> pokemons = new ArrayList<>();
	
	private String[] columnNames = {"#","Nome","Tipo1","Tipo2","Lendário"};
	private Object[][] tableData = new Object[100][5];
	
	public TableModel() {
		//Copies pokemons from repository
		for(int i = 0; i < PokemonController.getInstance().getRepository().list().size(); i++) {
			pokemons.add(PokemonController.getInstance().getRepository().list().get(i));
		}
		//Add their data to the tableData variable
		for(int i = 0; i < pokemons.size(); i++) {
			tableData[i][0] = pokemons.get(i).getNumber();
			tableData[i][1] = pokemons.get(i).getName(); System.out.println("[TableModel]Pokemon "+pokemons.get(i).getName()+" added to the tablemodel data array.");
			tableData[i][2] = pokemons.get(i).getType1();
			tableData[i][3] = pokemons.get(i).getType2();
			tableData[i][4] = pokemons.get(i).getLegendary();
		}
	}
	
	public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return pokemons.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row) {
    	return pokemons.get(row);
    }
    
    public Object getValueAt(int row, int col) {
        return tableData[row][col];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        tableData[row][col] = value;
        fireTableCellUpdated(row, col);
    }

	public void tableChanged(TableModelEvent e) {
		
	}

}
