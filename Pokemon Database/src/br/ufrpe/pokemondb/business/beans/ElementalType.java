package br.ufrpe.pokemondb.business.beans;

public enum ElementalType {
	BUG,
	DARK,
	DRAGON,
	ELECTRIC,
	FAIRY,
	FIGHTNING,
	FIRE,
	FLYING,
	GHOST,
	GRASS,
	GROUND,
	ICE,
	NORMAL,
	POISON,
	PSYCHIC,
	ROCK,
	STEEL,
	WATER;
	
	public static String[] toArray() {
		ElementalType[] types = values();
	    String[] names = new String[types.length];
	    for(int i = 0; i < types.length; i++) {
	        names[i] = types[i].name();
	    }
	    return names;
	}
}
