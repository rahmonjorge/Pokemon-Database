package br.ufrpe.pokemondb.gui;

import java.awt.Dimension;

import javax.swing.JTextField;

public class FieldBuilder {
	public static JTextField create(int lenght, Dimension maximumSize, float alignmentX) {
		
		JTextField field = new JTextField(lenght);
		field.setMaximumSize(maximumSize);
		field.setAlignmentX(alignmentX);
		
		return field;
	}
}
