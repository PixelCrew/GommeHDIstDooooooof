package org.pixelcrew.gs.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.pixelcrew.gs.Main;

public class PositionCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				PositionListener.playerpos.clear();
				
				int position = 0;
				for(Player player : Bukkit.getOnlinePlayers()) {
					if(!player.getName().equals(p.getName()) && !player.getName().equals("GommeHD")) {
						try{
							position++;
							player.teleport(new Location(p.getWorld(), Main.instance.getConfig().getDouble("position." + position + ".x"), 
									Main.instance.getConfig().getDouble("position." + position + ".y"), 
									Main.instance.getConfig().getDouble("position." + position + ".z")));
						}catch(NullPointerException ex) {}
					}
				}
				return true;
			}
			if(args.length == 1) {
				if(args[0].equals("remove")) {
					Main.instance.getConfig().set("position", null);
					Main.instance.saveConfig();
					
					Main.instance.gsposnum = 0;
					p.sendMessage(Main.instance.prefix + "Removed all Positions from config!");
					return true;
				}
				if(args[0].equals("togglesneak")) {
					if(Main.instance.gsposplayer.contains(p)) {
						Main.instance.gsposplayer.remove(p);
						p.sendMessage(Main.instance.prefix + "Sneak Mode for saving Position diabled!");
					}else {
						Main.instance.gsposplayer.add(p);
						p.sendMessage(Main.instance.prefix + "Sneak Mode for saving Position enabled!");
					}
					return true;
				}
				if(args[0].equals("togglemove")) {
					if(!Main.instance.gsposmove) {
						Main.instance.gsposmove = true;
						PositionListener.playerpos.clear();
						p.sendMessage(Main.instance.prefix + "Player movement is now allowed!");
					}else {
						Main.instance.gsposmove = false;
						p.sendMessage(Main.instance.prefix + "Player movement is now prohibited!");
					}
					return true;
				}
				Main.instance.getConfig().set("position." + args[0] + ".x", p.getLocation().getBlockX() + 0.5);
				Main.instance.getConfig().set("position." + args[0] + ".y", p.getLocation().getY());
				Main.instance.getConfig().set("position." + args[0] + ".z", p.getLocation().getBlockZ() + 0.5);
				Main.instance.saveConfig();
				
				p.sendMessage(Main.instance.prefix + "Saved position §c'" + args[0] + "'§r at File!");
				return true;
			}
			if(args.length == 2) {
				if(args[0].equals("remove")) {
					Main.instance.getConfig().set("position." + args[1], null);
					Main.instance.saveConfig();
					
					p.sendMessage(Main.instance.prefix + "Removed position §c'" + args[1] + "'§r from File!");
					return true;
				}
			}
		}
		return false;
	}

}
