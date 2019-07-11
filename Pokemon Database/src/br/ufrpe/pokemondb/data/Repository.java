package br.ufrpe.pokemondb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.ufrpe.pokemondb.exceptions.ObjectAlreadyExistsException;
import br.ufrpe.pokemondb.exceptions.ObjectDoesNotExistsException;

public class Repository<T> implements IRepository<T>{

	protected List<T> objectList;
	
	public Repository() {
		objectList = new ArrayList<>();
	}
	
	public void add(T newObject) throws ObjectAlreadyExistsException {
		ListIterator<T> iterator = objectList.listIterator();
		while(iterator.hasNext()) {
			if(newObject.equals(iterator.next())) {
				throw new ObjectAlreadyExistsException();
			}
		}
		objectList.add(newObject);
		System.out.println(objectList.toString());
	}

	public void update(T newObject) throws ObjectDoesNotExistsException {
		if(objectList.contains(newObject))
			objectList.set(objectList.indexOf(newObject), newObject);
		else
			throw new ObjectDoesNotExistsException();
	}

	public void remove(T object) throws ObjectDoesNotExistsException {
		if(objectList.contains(object))
			objectList.remove(objectList.indexOf(object));
		else
			throw new ObjectDoesNotExistsException();
		
	}
	
	public List<T> list() {
		return objectList;
	}

	public Object recover(T recoverMethod) throws ObjectDoesNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

}
