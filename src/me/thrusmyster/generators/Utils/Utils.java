package me.thrusmyster.generators.Utils;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.thrusmyster.generators.Generators;

public class Utils {
	
	public static void firework(Location loc, FireworkEffect... effects) {
		final Firework fw = (Firework)loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta data = fw.getFireworkMeta();
		data.addEffects(effects);
		data.setPower(0);
		fw.setFireworkMeta(data);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				fw.detonate();
			}
		}.runTaskLater(Generators.getInstance(), 2L);
	}

}
