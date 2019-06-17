package br.ufrpe.pokemondb.data;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public class Repository<T> implements IRepository<T>{

	protected List<T> objects;
	
	public Repository() {
		objects = new ArrayList<>();
	}
	
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
		return objects;
	}

	public Object recover(T recoverMethod) throws ObjectDoesNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

}
