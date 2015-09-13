package org.pixelcrew.gs;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println(" --=<>=---==---===<(O)>===---==---=<>=-- ");
        System.out.println("   " + JavaPlugin.getPlugin(this.getClass()).getDescription().getFullName() + " plugin loaded...");
        System.out.println(" Made by " + JavaPlugin.getPlugin(this.getClass()).getDescription().getAuthors() + " for the PixelCrew:");
        System.out.println("        http://www.pixelcrew.org");
        System.out.println(" --=<>=---==---===<(O)>===---==---=<>=--");
	}
}


