package br.ufrpe.pokemondb.business.beans;

public class Pokemon {
	String name;
	int number;
	ElementalType type1, type2;
	boolean legendary;
	public Pokemon(int number, String name, ElementalType type1, ElementalType type2, boolean legendary) {
		this.number = number;
		this.name = name;
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
	public boolean getLegendary() {
		return legendary;
	}
	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pokemon) {
			if(
					this.number == ((Pokemon) obj).getNumber() &&
					this.name.equals(((Pokemon) obj).getName()) &&
					this.type1.equals(((Pokemon) obj).getType1()) &&
					this.type2.equals(((Pokemon) obj).getType2()) &&
					this.legendary == ((Pokemon) obj).getLegendary()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Number: " + number + " Name: " + name;
	}
}
