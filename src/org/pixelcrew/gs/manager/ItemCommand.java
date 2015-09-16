package org.pixelcrew.gs.manager;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		Player player = (Player)sender;
		if(label.equalsIgnoreCase("gommegive")){
			
			ArrayList<String> plore = new ArrayList<String>();
			plore.add(ChatColor.GRAY + "Rechtsklick um das");
			plore.add(ChatColor.GRAY + "Strafenmenue zu");
			plore.add(ChatColor.GRAY + "öffnen!");
			ItemStack punish = new ItemStack(Material.EYE_OF_ENDER);
			ItemMeta pmeta = punish.getItemMeta();
			pmeta.setDisplayName(ChatColor.RED + "Strafen");
			pmeta.setLore(plore);
			punish.setItemMeta(pmeta);
			
			ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName(ChatColor.DARK_RED + "Gommemode");
			item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			item.setItemMeta(itemmeta);
			
			ItemStack bow = new ItemStack(Material.BOW);
			ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName(ChatColor.DARK_BLUE + "Gommebow");
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
			bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			bow.setItemMeta(bowmeta);
			
			ItemStack arrow = new ItemStack(Material.ARROW);
			
			player.getInventory().setItem(0, item);
			player.getInventory().setItem(1, bow);
			player.getInventory().setItem(27, arrow);
			player.getInventory().setItem(4, punish);
		}
		
		return false;
	}

}
