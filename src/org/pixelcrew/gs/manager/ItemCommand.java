package org.pixelcrew.gs.manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			/* 
			 * Mache ich am Montag noch neu Manu, sorry das ich das weggemacht habe, aber das war nicht so toll!
			 * Au�erdem h�tte der Runnable f�r die Pfeile zu viele Resourcen genommen, und warum extends JavaPlugin?
			 * 
			 * ~ Benjamin :/ (also ja, du kannst es dir ja mal anschauen wenn ichs gemacht habe, aber sonst k�nnen wirs
			 * ja auch r�ckg�ngig machen ...)
			 */
		}
		return false;
	}
	
}

	
