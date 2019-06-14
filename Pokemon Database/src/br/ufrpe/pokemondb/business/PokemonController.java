package br.ufrpe.pokemondb.business;

import java.util.List;

import br.ufrpe.pokemondb.business.beans.ElementalType;
import br.ufrpe.pokemondb.business.beans.Pokemon;
import br.ufrpe.pokemondb.data.Repository;
import br.ufrpe.pokemondb.exceptions.MaxRepositoryCapacityException;
import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
/*
 * PokemonController: Contém o repositório de pokemons e as regras de negócio.
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
	
	public Pokemon insert(int number, String name, ElementalType type1, ElementalType type2, boolean legendary) 
			throws ObjectAlreadyExistsException, NullPointerException, MaxRepositoryCapacityException {
		if(pokemonRepository.list().size() > 99) {
			throw new MaxRepositoryCapacityException();
		}
		if(name.length() < 1)
			throw new IllegalArgumentException("Invalid Pokémon Number.");
		if(number < 1)
			throw new IllegalArgumentException("Invalid Pokémon Number.");
		Pokemon p = new Pokemon(number, name, type2, type2, legendary);
		pokemonRepository.add(p);
		return p;
	}
	
	public List<Pokemon> list() {
		return pokemonRepository.list();
	}
}
