package org.pixelcrew.gs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.pixelcrew.gs.check.CheckListener;
import org.pixelcrew.gs.manager.PositionCommand;
import org.pixelcrew.gs.manager.PositionListener;
import org.pixelcrew.gs.punishments.BombJacketListener;
import org.pixelcrew.gs.punishments.GuillotioneListener;
import org.pixelcrew.gs.punishments.ItemsListener;
import org.pixelcrew.gs.punishments.TaserListener;


public class Main extends JavaPlugin {
	
	public static Main instance;
	
	public String prefix = "�8[�6GS�8]�f ";
	public String err_prefix = "�8[�6GS�8]�c ";
	
	public List<Player> gsposplayer = new ArrayList<>();
	public int gsposnum = 0;
	public boolean gsposmove = true;
	
	@Override
	public void onEnable() {
		instance = this;
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		/* COMMAND */
		this.getCommand("gspos").setExecutor(new PositionCommand());
		this.getCommand("gommesagt").setExecutor(new ItemsListener());
		
		/* LISTENER */
		Bukkit.getPluginManager().registerEvents(new CheckListener(), this);
		Bukkit.getPluginManager().registerEvents(new TaserListener(), this);
		Bukkit.getPluginManager().registerEvents(new BombJacketListener(), this);
		Bukkit.getPluginManager().registerEvents(new PositionListener(), this);
		Bukkit.getPluginManager().registerEvents(new GuillotioneListener(), this);
		
		System.out.println(" --=<>=---==---===<(O)>===---==---=<>=-- ");
		System.out.println("   " + JavaPlugin.getPlugin(this.getClass()).getDescription().getFullName() + " plugin loaded...");
		System.out.println("   Made by the PixelCrew Developer's:");
		System.out.println("        http://www.pixelcrew.org");
		System.out.println(" --=<>=---==---===<(O)>===---==---=<>=--");
	}
}

