package org.pixelcrew.gs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.pixelcrew.gs.check.CheckListener;
import org.pixelcrew.gs.manager.PositionCommand;
import org.pixelcrew.gs.punishments.BombJacketListener;
import org.pixelcrew.gs.punishments.TaserListener;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public String prefix = "�8[�6GS�8]�f ";
	public String err_prefix = "�8[�6GS�8]�c ";
	
	@Override
	public void onEnable() {
		instance = this;
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		/* COMMAND */
		this.getCommand("gspos").setExecutor(new PositionCommand());
		
		/* LISTENER */
		Bukkit.getPluginManager().registerEvents(new CheckListener(), this);
		Bukkit.getPluginManager().registerEvents(new TaserListener(), this);
		Bukkit.getPluginManager().registerEvents(new BombJacketListener(), this);
		
		System.out.println(" --=<>=---==---===<(O)>===---==---=<>=-- ");
		System.out.println("   " + JavaPlugin.getPlugin(this.getClass()).getDescription().getFullName() + " plugin loaded...");
		System.out.println(" Made by " + JavaPlugin.getPlugin(this.getClass()).getDescription().getAuthors() + " for the PixelCrew:");
		System.out.println("        http://www.pixelcrew.org");
		System.out.println(" --=<>=---==---===<(O)>===---==---=<>=--");
	}
}


