package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.pixelcrew.gs.Main;

public class punishmentsListener implements Listener{
	
	@EventHandler
	public void onClick(final InventoryClickEvent e){
		
		ArrayList<String> remotelore = new ArrayList<String>();
		remotelore.add(ChatColor.GRAY + "Rechtsklick um den");
		remotelore.add(ChatColor.GRAY + "Spieler in die Luft");
		remotelore.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
		
		final ItemStack remote = new ItemStack(Material.REDSTONE);
		ItemMeta remotemeta = remote.getItemMeta();
		remotemeta.setDisplayName(ChatColor.RED + "Bomben Remote");
		remotemeta.setLore(remotelore);
		remote.setItemMeta(remotemeta);
		
		ArrayList<String> chestlore = new ArrayList<String>();
		chestlore.add(ChatColor.GRAY + "Spieler schlagen um");
		chestlore.add(ChatColor.GRAY + "die Jacke anzuziehen!");
		chestlore.add(ChatColor.GOLD + "Explosive Liebe <3");
		
		final ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemMeta chestmeta = chest.getItemMeta();
		chestmeta.setDisplayName(ChatColor.RED + "Bomben Jacke");
		chestmeta.setLore(chestlore);
		chest.setItemMeta(chestmeta);
		
		ArrayList<String> taserlore = new ArrayList<String>();
		taserlore.add(ChatColor.GRAY + "Spieler schlagen");
		taserlore.add(ChatColor.GRAY + "um ihn zu elektrisieren");
		taserlore.add(ChatColor.GOLD + "#ElektroGomne");
    	final ItemStack taser = new ItemStack(Material.IRON_HOE);
    	ItemMeta tasermeta = taser.getItemMeta();
    	tasermeta.setDisplayName(ChatColor.YELLOW + "Elektro Gomme");
    	tasermeta.setLore(taserlore);
    	taser.setItemMeta(tasermeta);
    	
    	ArrayList<String> axelore = new ArrayList<String>();
    	axelore.add(ChatColor.GRAY + "Spieler schlagen");
		axelore.add(ChatColor.GRAY + "um ihn einen Kopf");
		axelore.add(ChatColor.GRAY + "kürzer zu machen!");
    	final ItemStack axe = new ItemStack(Material.IRON_AXE);
    	ItemMeta axemeta = axe.getItemMeta();
    	axemeta.setDisplayName(ChatColor.RED + "Halsabschneider");
    	axemeta.setLore(axelore);
    	axe.setItemMeta(axemeta);
    	
    	ArrayList<String> meteorlore = new ArrayList<String>();
		meteorlore.add(ChatColor.GRAY + "Spieler schlagen um");
		meteorlore.add(ChatColor.GRAY + "ein Meteor über ihm");
		meteorlore.add(ChatColor.GRAY + "zu spawnen!");
    	final ItemStack meteor = new ItemStack(Material.FIREWORK_CHARGE);
    	ItemMeta meteormeta = meteor.getItemMeta();
    	meteormeta.setDisplayName(ChatColor.RED + "Meteor Spawner");
    	meteormeta.setLore(meteorlore);
    	meteor.setItemMeta(meteormeta);
    	
    	ArrayList<String> roketlore = new ArrayList<String>();
		roketlore.add(ChatColor.GRAY + "Spieler schlagen um");
		roketlore.add(ChatColor.GRAY + "ihn auf den Mond zu");
		roketlore.add(ChatColor.GRAY + "schiessen! " + ChatColor.DARK_BLUE + "#MOON");
		final ItemStack roket = new ItemStack(Material.FIREWORK);
		ItemMeta roketmeta = roket.getItemMeta();
		roketmeta.setDisplayName(ChatColor.GOLD + "Travel to the Moon");
		roketmeta.setLore(roketlore);
		roket.setItemMeta(roketmeta);
		
		ItemStack air = new ItemStack(Material.AIR);
		
		final Player player = (Player)e.getWhoClicked();
		
		if(e.getSlot() == 9 || e.getSlot() == 11 || e.getSlot() == 13 || e.getSlot() == 15 || e.getSlot() == 17){
			e.setCancelled(true);
				player.getInventory().setItem(7, air);
				player.getInventory().setItem(8, air);
		}
		
		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

			public void run() {
				if(e.getSlot() == 9){
					player.getInventory().setItem(7, chest);
					player.getInventory().setItem(8, remote);
				}
				else if(e.getSlot() == 11){
					player.getInventory().setItem(8, taser);
				}
				else if(e.getSlot() == 13){
					player.getInventory().setItem(8, axe);
				}
				else if(e.getSlot() == 15){
					player.getInventory().setItem(8, meteor);
				}
				else if(e.getSlot() == 17){
					player.getInventory().setItem(8, roket);
				}
			}
			
		}, 1L);
		
	}

}
