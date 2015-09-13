package org.pixelcrew.gs.punishments;

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

public class ItemsListener implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  {
		  Player p = (Player)sender;
		      if (p.hasPermission("gommesagt.gommesagt"))
		    	  p.sendMessage("§6test");
		        {
		    	  ItemStack slm2 = new ItemStack(Material.BOW);
		    	  slm2.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
		    	  ItemMeta slm2Meta = slm2.getItemMeta();
		    	  slm2Meta.setDisplayName("§5§lGommemode BOW");
		    	  slm2.setItemMeta(slm2Meta);
		    	  p.getInventory().setItem(0, slm2);
		        }
		    	  ItemStack slm3 = new ItemStack(Material.ARROW);
		    	  ItemMeta slm3Meta = slm3.getItemMeta();
		    	  slm3Meta.setDisplayName("§1aawx");
		    	  slm3.setItemMeta(slm3Meta);
		    	  p.getInventory().setItem(1, slm3);
		    	  
		    	  ArrayList<String> lore = new ArrayList<String>();
		  			lore.add(ChatColor.GRAY + "Spieler schlagen um");
		  			lore.add(ChatColor.GRAY + "die Jacke anzuziehen!");
		  			lore.add(ChatColor.GOLD + "Explosive Liebe <3");
		  			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		  			ItemMeta meta1 = chest.getItemMeta();
		  			meta1.setDisplayName(ChatColor.RED + "Bomben Jacke");
		  			meta1.setLore(lore);
		  			chest.setItemMeta(meta1);
		  			p.getInventory().setItem(2, chest);
		  			
		  			ArrayList<String> lore1 = new ArrayList<String>();
					lore1.add(ChatColor.GRAY + "Rechtsklick um den");
					lore1.add(ChatColor.GRAY + "Spieler in die Luft");
					lore1.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
					
					ItemStack remote = new ItemStack(Material.REDSTONE);
					ItemMeta meta11 = remote.getItemMeta();
					meta11.setDisplayName(ChatColor.RED + "Bomben Remote");
					meta11.setLore(lore1);
					remote.setItemMeta(meta11);
					p.getInventory().setItem(3, remote);
		        }
		      
	return false;

	}
}

	
