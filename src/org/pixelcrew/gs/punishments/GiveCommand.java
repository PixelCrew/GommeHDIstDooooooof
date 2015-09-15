package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		Player player = (Player)sender;
		if(label.equalsIgnoreCase("gommegive")){
			player.sendMessage(ChatColor.GOLD + "Du hast nun die " + ChatColor.RED + "GommeSagt " + ChatColor.GOLD + "Items!");
			
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
			
			ArrayList<String> taserlore = new ArrayList<String>();
			taserlore.add(ChatColor.GRAY + "Spieler schlagen");
			taserlore.add(ChatColor.GRAY + "um ihn zu elektrisieren");
			taserlore.add(ChatColor.GOLD + "#ElektroGomne");
	    	ItemStack taser = new ItemStack(Material.IRON_HOE);
	    	ItemMeta tasermeta = taser.getItemMeta();
	    	tasermeta.setDisplayName(ChatColor.YELLOW + "Elektro Gomme");
	    	tasermeta.setLore(taserlore);
	    	taser.setItemMeta(tasermeta);
	    	
	    	ArrayList<String> axelore = new ArrayList<String>();
	    	axelore.add(ChatColor.GRAY + "Spieler schlagen");
			axelore.add(ChatColor.GRAY + "um ihn einen Kopf");
			axelore.add(ChatColor.GRAY + "kürzer zu machen!");
	    	ItemStack Axe = new ItemStack(Material.IRON_AXE);
	    	ItemMeta axemeta = Axe.getItemMeta();
	    	axemeta.setDisplayName(ChatColor.RED + "Halsabschneider");
	    	axemeta.setLore(axelore);
	    	Axe.setItemMeta(axemeta);
	    	
	    	ArrayList<String> meteorlore = new ArrayList<String>();
			meteorlore.add(ChatColor.GRAY + "Spieler schlagen um");
			meteorlore.add(ChatColor.GRAY + "ein Meteor über ihm");
			meteorlore.add(ChatColor.GRAY + "zu spawnen!");
	    	final ItemStack meteor = new ItemStack(Material.FIREWORK_CHARGE);
	    	ItemMeta meteormeta = meteor.getItemMeta();
	    	meteormeta.setDisplayName(ChatColor.RED + "Meteor Spawner");
	    	meteormeta.setLore(meteorlore);
	    	meteor.setItemMeta(meteormeta);
	    	
	    	player.getInventory().setItem(0, chest);
	    	player.getInventory().setItem(1, remote);
	    	player.getInventory().setItem(3, taser);
	    	player.getInventory().setItem(5, Axe);
	    	player.getInventory().setItem(7, meteor);
		}
		
		return false;
	}

}
