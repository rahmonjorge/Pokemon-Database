package br.ufrpe.pokemondb.data;

import java.util.List;

import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public interface IRepository<GenericType> {
	void add(GenericType obj) throws ObjectAlreadyExistsException;
	void update(GenericType obj) throws ObjectDoesNotExistsException;
	void remove(GenericType obj) throws ObjectDoesNotExistsException;
	List<GenericType> list();
}
