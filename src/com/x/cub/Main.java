package com.x.cub;

import org.bukkit.plugin.java.JavaPlugin;

import com.x.cub.event.Place;

public class Main extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Place(), this);
	}
}
