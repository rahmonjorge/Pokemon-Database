package br.ufrpe.pokemondb.business;

import java.util.List;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.data.Repository;
import br.ufrpe.pokemondb.exceptions.MaxRepositoryCapacityException;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;
/*
 * PokemonController: Contem o repositorio de pokemons e as regras de negocio.
 * */
public class PokemonController {
	private static PokemonController instance;
	
	private Repository<Pokemon> pokemonRepository;
	
	private PokemonController() {
		pokemonRepository = new Repository<Pokemon>();
	}
	
	public static PokemonController getInstance() {
		if(instance == null) {
			instance = new PokemonController();
		}
		return instance;
	}
	
	public void insert(int number, String name, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException, NullPointerException, MaxRepositoryCapacityException {
		if(pokemonRepository.list().size() > 99) {
			throw new MaxRepositoryCapacityException();
		}
		if(name.length() < 1)
			throw new IllegalArgumentException("Invalid Pokemon Name.");
		if(number < 1)
			throw new IllegalArgumentException("Invalid Pokemon Number.");
		Pokemon p = new Pokemon(number, name, type1, type2, legendary);
		pokemonRepository.add(p);
	}
	
	public void remove(Pokemon p) throws ObjectDoesNotExistsException {
		pokemonRepository.remove(p);
	}
	
	public Pokemon browse(int number) throws ObjectDoesNotExistsException {
		for(Pokemon listItem : pokemonRepository.list()) {
			if(listItem.getNumber() == number) {
				return listItem;
			}
		}
		throw new ObjectDoesNotExistsException();
	}
	
	public List<Pokemon> list() {
		return pokemonRepository.list();
	}
}
