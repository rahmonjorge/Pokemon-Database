package br.ufrpe.pokemondb.business.beans;

public class Pokemon {
	String name;
	int number;
	ElementalType type1, type2;
	boolean legendary;
	public Pokemon(String name, int number, ElementalType type1, ElementalType type2, boolean legendary) {
		this.name = name;
		this.number = number;
		this.type1 = type1;
		this.type2 = type2;
		this.legendary = legendary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ElementalType getType1() {
		return type1;
	}
	public void setType1(ElementalType type1) {
		this.type1 = type1;
	}
	public ElementalType getType2() {
		return type2;
	}
	public void setType2(ElementalType type2) {
		this.type2 = type2;
	}
	public boolean isLegendary() {
		return legendary;
	}
	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}
}
