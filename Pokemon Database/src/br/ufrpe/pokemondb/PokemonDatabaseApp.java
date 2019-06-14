package br.ufrpe.pokemondb;

import javax.swing.SwingUtilities;

import br.ufrpe.pokemondb.gui.MainFrame;

public class PokemonDatabaseApp{

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame.getInstance().createAndShowGUI();
			}
		});
	
	}
}
