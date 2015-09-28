package me.thrusmyster.generators.Configs;

import me.thrusmyster.generators.Generators;

public class ConfigManager {

	private Generators instance;
	private Configuration main_Config;
	private Configuration generator_Config;
	
	public ConfigManager(Generators instance) {
		this.instance = instance;
	}
	
	public void load() {
		this.main_Config = new Configuration(this.instance, this.instance.getDataFolder(), "config", true);
		this.generator_Config = new Configuration(this.instance, this.instance.getDataFolder(), "generators", false);
		
		reloadConfig();
		reloadGenerators();
	}
	
	public void reloadConfig() {
		this.main_Config.reload();
	}
	
	public void reloadGenerators() {
		this.generator_Config.reload();
	}
	
}
