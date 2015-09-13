package org.pixelcrew.gs.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.pixelcrew.gs.Main;

public class PositionListener implements Listener {
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		
		if(Main.instance.gsposplayer.contains(event.getPlayer())) {
			event.setCancelled(true);
			
			Main.instance.gsposnum++;
			Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".x", p.getLocation().getX());
			Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".y", p.getLocation().getY());
			Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".z", p.getLocation().getZ());
			Main.instance.saveConfig();
			
			p.sendMessage(Main.instance.prefix + "Saved position §c'" + Main.instance.gsposnum + "'§r at File!");
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(!Main.instance.gsposmove) {
			if(!event.getPlayer().getName().equals("GommeHD") || !event.getPlayer().isOp()) {
				if(event.getFrom().distance(event.getTo()) >= 1.5) {
					event.setCancelled(true);
				}
			}
		}
	}
}
