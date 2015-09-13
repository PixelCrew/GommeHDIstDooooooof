package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BombJacketListener implements Listener {
	
	@EventHandler
	public static void onClick(EntityDamageByEntityEvent e){
		Player p1 = (Player)e.getDamager();
		Player p2 = (Player)e.getEntity();
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Spieler schlagen um");
		lore.add(ChatColor.GRAY + "die Jacke anzuziehen!");
		lore.add(ChatColor.GOLD + "Explosive Liebe <3");
		
		ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta meta1 = chest.getItemMeta();
		meta1.setDisplayName(ChatColor.RED + "Bomben Jacke");
		meta1.setLore(lore);
		chest.setItemMeta(meta1);
		
		p1.getInventory().setItem(0, chest);
		
		if(p1.getInventory().getItemInHand().equals(chest)){
			e.setCancelled(true);
			p2.getInventory().setChestplate(chest);
			
		}
	}
	
	@EventHandler
	public static void onRemote(PlayerInteractEvent e){
		Player player = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Rechtsklick um den");
			lore.add(ChatColor.GRAY + "Spieler in die Luft");
			lore.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
			
			ItemStack remote = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemMeta meta1 = remote.getItemMeta();
			meta1.setDisplayName(ChatColor.RED + "Bomben Remote");
			meta1.setLore(lore);
			remote.setItemMeta(meta1);
			
			if(player.getInventory().getItemInHand().equals(remote)){
				
			}
		}
	}

}
