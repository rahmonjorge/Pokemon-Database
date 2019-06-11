package br.ufrpe.pokemondb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import br.ufrpe.pokemondb.gui.MainFrame;

public class PokemonDatabaseApp implements ActionListener{

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().createAndShowGUI();
			}
		});
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
