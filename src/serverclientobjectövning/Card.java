package serverclientobjectövning;

import java.io.Serializable;

public class Card implements Serializable{
	String name;
	int cost;
	boolean foil;

	public Card(String name, int cost, boolean foil) {
		this.name = name;
		this.cost = cost;
		this.foil = foil;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public boolean isFoil() {
		return foil;
	}
}
