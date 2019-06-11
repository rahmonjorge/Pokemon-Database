package br.ufrpe.pokemondb.business;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.data.Repository;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;

public class PokemonController {
	private static PokemonController instance;
	
	private Repository<Pokemon> pokemonRepository;
	
	private PokemonController() {
		pokemonRepository = new Repository<>();
	}
	
	public static PokemonController getInstance() {
		if(instance == null) {
			instance = new PokemonController();
		}
		return instance;
	}
	
	public Pokemon createPokemon(String name, int number, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException, NullPointerException {
		if(name.length() < 1)
			throw new IllegalArgumentException("Invalid Pokémon Number.");
		if(number < 1)
			throw new IllegalArgumentException("Invalid Pokémon Number.");
		Pokemon p = new Pokemon(number, name, type2, type2, legendary);
		pokemonRepository.add(p);
		return p;
	}
}
