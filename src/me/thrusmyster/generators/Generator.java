package me.thrusmyster.generators;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Generator {

	private int id;
	private String name;
	private Location block;
	private Location sign;
	private Player owner;
	private GeneratorType type;
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Location getLocation() {
		return this.block;
	}
	
	public Location getSignLocation() {
		return this.sign;
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	public GeneratorType getType() {
		return this.type;
	}
	
	public boolean hasSign() {
		return this.sign != null;
	}
	
	public boolean hasOwner() {
		return this.owner != null;
	}
	
	public String toString() {
		return "Generator";
	}
	
}
