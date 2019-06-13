package br.ufrpe.pokemondb.business;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.data.Repository;
import br.ufrpe.pokemondb.exceptions.MaxRepositoryCapacityException;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
/*
 * PokemonController: Cont�m o reposit�rio de pokemons e as regras de neg�cio.
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
	
	public Pokemon createPokemon(int number, String name, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException, NullPointerException, MaxRepositoryCapacityException {
		if(pokemonRepository.list().size() > 99) {
			throw new MaxRepositoryCapacityException();
		}
		if(name.length() < 1)
			throw new IllegalArgumentException("Invalid Pok�mon Number.");
		if(number < 1)
			throw new IllegalArgumentException("Invalid Pok�mon Number.");
		Pokemon p = new Pokemon(number, name, type2, type2, legendary);
		pokemonRepository.add(p);
		System.out.println("[PokemonController.createPokemon()]Pokemon "+p.getName()+" added to the repository.");
		return p;
	}
	
	public Repository<Pokemon> getRepository() {
		return pokemonRepository;
	}
}
