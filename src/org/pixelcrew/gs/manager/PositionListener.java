package org.pixelcrew.gs.manager;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;
import org.pixelcrew.gs.Main;

public class PositionListener implements Listener {
	
	public static HashMap<Player, Vector> playerpos = new HashMap<>();
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		Player p = event.getPlayer();
		
		if(Main.instance.gsposplayer.contains(event.getPlayer())) {
			
			if(p.isSneaking()) {
				Main.instance.gsposnum++;
				Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".x", p.getLocation().getBlockX() + 0.5);
				Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".y", p.getLocation().getY());
				Main.instance.getConfig().set("position." + Main.instance.gsposnum + ".z", p.getLocation().getBlockZ() + 0.5);
				Main.instance.saveConfig();
				
				p.sendMessage(Main.instance.prefix + "Saved position §c'" + Main.instance.gsposnum + "'§r at File!");
			}
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(Main.instance.gsposmove == false) {
			if(!event.getPlayer().getName().equals("GommeHD") && !event.getPlayer().isOp()) {
				if(playerpos.get(event.getPlayer()) == null) {
					playerpos.put(event.getPlayer(), event.getPlayer().getLocation().toVector());
					return;
				}
				Location l = event.getPlayer().getLocation();
				Vector v = (Vector)playerpos.get(event.getPlayer());
				
				if((l.getBlockX() != v.getBlockX()) || (l.getBlockZ() != v.getBlockZ())) {
					l.setX(v.getBlockX() + 0.5D);
					l.setZ(v.getBlockZ() + 0.5D);
					l.setYaw(event.getPlayer().getLocation().getYaw());
					l.setPitch(event.getPlayer().getLocation().getPitch());
					event.getPlayer().teleport(l);
				}
			}
		}
	}
}
