package me.thrusmyster.generators.Configs;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	private JavaPlugin plugin;
	private File pluginpath;
	private File file;
	private String name;
	private FileConfiguration config;
	private boolean injar;

	public Configuration(JavaPlugin p, File pluginpath, String name, boolean inJar) {
		this.plugin = p;
		this.pluginpath = pluginpath;
		this.name = (name + ".yml");
		this.file = new File(pluginpath, this.name);
		this.injar = inJar;

	}

	public void reload() {
		if (!this.pluginpath.exists()) {
			this.pluginpath.mkdirs();
		}
		try {
			if (this.injar) {
				if (!this.file.exists()) {
					Files.copy(this.plugin.getResource(this.name), this.file.toPath(), new CopyOption[0]);
				}
			}
			else if (!this.file.exists()) {
				this.file.createNewFile();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		this.config = YamlConfiguration.loadConfiguration(this.file);
	}

	public void save() {
		try {
			this.config.save(this.file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileConfiguration getConfig() {
		return this.config;
	}

	public File getFile() {
		return this.file;
	}
}
