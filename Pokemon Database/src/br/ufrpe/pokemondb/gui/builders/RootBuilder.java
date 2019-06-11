package br.ufrpe.pokemondb.gui.builders;

import javax.swing.JTable;

public class RootBuilder {
	private static ButtonBuilder buttonBuilder;
	private static TableBuilder tableBuilder;
	private static WindowBuilder windowBuilder;
	
	public static JTable newTable() {
		return tableBuilder.getTable();
	}
}
