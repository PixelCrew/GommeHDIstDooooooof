package org.pixelcrew.gs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {

		System.out.println("Hallo World!");
		Bukkit.getConsoleSender().sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "GommeHD" + ChatColor.WHITE + "]" + ChatColor.GREEN + " Das Plugin wurde aktiviert!");

		System.out.println("Hallo Manuey!");
	}
}


