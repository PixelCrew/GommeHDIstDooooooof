package org.pixelcrew.gs.punishments;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.pixelcrew.gs.Main;

public class RoketListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			if(e.getDamager() instanceof Player){
				Player p1 = (Player)e.getDamager();
				final Player p2 = (Player)e.getEntity();
				World world = (World)e.getEntity().getWorld();
				
				ArrayList<String> roketlore = new ArrayList<String>();
				roketlore.add(ChatColor.GRAY + "Spieler schlagen um");
				roketlore.add(ChatColor.GRAY + "ihn auf den Mond zu");
				roketlore.add(ChatColor.GRAY + "schiessen! " + ChatColor.DARK_BLUE + "#MOON");
				ItemStack roket = new ItemStack(Material.FIREWORK);
				ItemMeta roketmeta = roket.getItemMeta();
				roketmeta.setDisplayName(ChatColor.GOLD + "Travel to the Moon");
				roketmeta.setLore(roketlore);
				roket.setItemMeta(roketmeta);
				
				p1.getInventory().addItem(roket);
				
				if(p1.isOp()){
					if(p1.getInventory().getItemInHand().equals(roket)){
						p1.sendMessage("Test");
						world.spawnCreature(p2.getLocation(), EntityType.FIREWORK);
						Entity entity = (Entity)EntityType.FIREWORK;
	        				entity.setPassenger(p2);
					}
				}
			}
		}
	}

}
