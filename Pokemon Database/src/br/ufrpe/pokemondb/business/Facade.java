package br.ufrpe.pokemondb.business;

import java.util.List;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.exceptions.MaxRepositoryCapacityException;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

/*
 * Fachada: Controla os controladores.
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
	
	public void insert(int number, String name, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException, NullPointerException, MaxRepositoryCapacityException {
		pokemonController.insert(number, name, type1, type2, legendary);
	}
	
	public void remove(Pokemon p) throws ObjectDoesNotExistsException {
		pokemonController.remove(p);
	}
	
	public Pokemon browse(int number) throws ObjectDoesNotExistsException {
		return pokemonController.browse(number);
	}
	
	public List<Pokemon> list() {
		return pokemonController.list();
	}
}
