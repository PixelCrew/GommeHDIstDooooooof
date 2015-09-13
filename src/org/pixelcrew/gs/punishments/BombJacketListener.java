package org.pixelcrew.gs.punishments;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BombJacketListener implements Listener {
	
	static List<Player> tracket = new ArrayList<Player>();
	
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
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
		
		if(p1.getInventory().getItemInHand().equals(chest)){
			if(p1.isOp()){
				tracket.add(p2);
				e.setCancelled(true);
				p2.getInventory().setChestplate(chest);
			}
		}
		}
		return;
	}
	
	@EventHandler
	public static void onRemote(PlayerInteractEvent e){
		Player player = e.getPlayer();
		World world = (World)e.getPlayer().getWorld();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "Rechtsklick um den");
			lore.add(ChatColor.GRAY + "Spieler in die Luft");
			lore.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
			
			ItemStack remote = new ItemStack(Material.REDSTONE);
			ItemMeta meta1 = remote.getItemMeta();
			meta1.setDisplayName(ChatColor.RED + "Bomben Remote");
			meta1.setLore(lore);
			remote.setItemMeta(meta1);
			
			ArrayList<String> lore1 = new ArrayList<String>();
			lore1.add(ChatColor.GRAY + "Spieler schlagen um");
			lore1.add(ChatColor.GRAY + "die Jacke anzuziehen!");
			lore1.add(ChatColor.GOLD + "Explosive Liebe <3");
			
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemMeta meta11 = chest.getItemMeta();
			meta11.setDisplayName(ChatColor.RED + "Bomben Jacke");
			meta11.setLore(lore1);
			chest.setItemMeta(meta11);
			
			if(player.getInventory().getItemInHand().equals(remote)){
				if(player.isOp()){
					e.setCancelled(true);
					int count = 0;
					while (count < tracket.size()){
						final Player target = (Player)tracket.get(count);
						world.playEffect(target.getLocation(), Effect.EXPLOSION_HUGE, null);
						world.playSound(target.getLocation(), Sound.EXPLODE, 10, 1);
						target.getInventory().remove(chest);
						target.damage(21F);
						tracket.remove(count);
						count++;
					}
				
				}
			}
		}
	}

}
