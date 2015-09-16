package org.pixelcrew.gs.manager;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		if(sender instanceof Player) {
			Player player = (Player)sender;
			if(player.isOp()){
			if(label.equalsIgnoreCase("gsgive")){
			if(args.length == 0) {
				player.sendMessage(ChatColor.GOLD + "Du hast nun die " + ChatColor.RED + "GommeSagt " + ChatColor.GOLD + "Items!");
				
				ArrayList<String> remotelore = new ArrayList<String>();
				remotelore.add(ChatColor.GRAY + "Rechtsklick um den");
				remotelore.add(ChatColor.GRAY + "Spieler in die Luft");
				remotelore.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
				
				ItemStack remote = new ItemStack(Material.REDSTONE);
				ItemMeta remotemeta = remote.getItemMeta();
				remotemeta.setDisplayName(ChatColor.RED + "Bomben Remote");
				remotemeta.setLore(remotelore);
				remote.setItemMeta(remotemeta);
				
				ArrayList<String> chestlore = new ArrayList<String>();
				chestlore.add(ChatColor.GRAY + "Spieler schlagen um");
				chestlore.add(ChatColor.GRAY + "die Jacke anzuziehen!");
				chestlore.add(ChatColor.GOLD + "Explosive Liebe <3");
				
				ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemMeta chestmeta = chest.getItemMeta();
				chestmeta.setDisplayName(ChatColor.RED + "Bomben Jacke");
				chestmeta.setLore(chestlore);
				chest.setItemMeta(chestmeta);
				
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
		    	ItemStack axe = new ItemStack(Material.IRON_AXE);
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
				ItemStack roket = new ItemStack(Material.FIREWORK);
				ItemMeta roketmeta = roket.getItemMeta();
				roketmeta.setDisplayName(ChatColor.GOLD + "Travel to the Moon");
				roketmeta.setLore(roketlore);
				roket.setItemMeta(roketmeta);
		    	
		    	player.getInventory().setItem(9, chest);
		    	player.getInventory().setItem(11, taser);
		    	player.getInventory().setItem(13, axe);
		    	player.getInventory().setItem(15, meteor);
		    	player.getInventory().setItem(17, roket);
				return true;
			}
		}
	}
		}
		return false;
	}
}
