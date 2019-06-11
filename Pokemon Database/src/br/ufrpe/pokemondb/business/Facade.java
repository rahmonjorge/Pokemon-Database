package br.ufrpe.pokemondb.business;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;

/*
 * Fachada: Dentro do pacote business, controla os controladores.
 * */
public class Facade {
	private static Facade instance;
	
	private PokemonController pokemonController;
	
	private Facade() {
		pokemonController = PokemonController.getInstance();
	}
	
	public static Facade getInstance() {
		if(instance == null) {
			instance = new Facade();
		}
		return instance;
	}
	
	public Pokemon createPokemon(String name, int number, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException {
		return pokemonController.createPokemon(name, number, type1, type2, legendary);
	}
}
