package br.ufrpe.pokemondb.data;

import java.util.List;

import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public class Repository<T> implements IRepository<T>{

	protected List<T> objects;
	
	public void add(T newObject) throws ObjectAlreadyExistsException {
		if(!objects.contains(newObject))
			objects.add(newObject);
		else
			throw new ObjectAlreadyExistsException();
	}

	public void update(T newObject) throws ObjectDoesNotExistsException {
		if(objects.contains(newObject))
			objects.set(objects.indexOf(newObject), newObject);
		else
			throw new ObjectDoesNotExistsException();
	}

	public void remove(T object) throws ObjectDoesNotExistsException {
		if(objects.contains(object))
			objects.remove(objects.indexOf(object));
		else
			throw new ObjectDoesNotExistsException();
		
	}

	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
