package me.thrusmyster.generators;

import org.bukkit.plugin.java.JavaPlugin;

import me.thrusmyster.generators.Configs.ConfigManager;

public class Generators extends JavaPlugin{

	private ConfigManager configmanager;
	private static Generators instance;
	
	public void onEnable() {
		instance = this;
		
		startup();
		getLogger().info(getDescription().getVersion() + " has been Enabled!");
	}
	
	public void onDisable() {
		getLogger().info(getDescription().getVersion() + " has been Disabled!");
	}
	
	private void startup() {
		this.configmanager = new ConfigManager(this);
		
	}
	
	public ConfigManager getConfigManager() {
		return this.configmanager;
	}
	
	public static Generators getInstance() {
		return instance;
	}
	
}
