package org.pixelcrew.gs.punishments;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
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
		      p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 10.0F, 20.0F);
		        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 10000);
		      {
		    	  ItemStack slm2 = new ItemStack(Material.BOW);
		    	  slm2.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		    	  slm2.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10000);
		    	  ItemMeta slm2Meta = slm2.getItemMeta();
		    	  slm2Meta.setDisplayName("§b§lGommemode-Bow");
		    	  slm2.setItemMeta(slm2Meta);
		    	  p.getInventory().setItem(1, slm2);
		        }
		    	  ItemStack slm3 = new ItemStack(Material.ARROW);
		    	  ItemMeta slm3Meta = slm3.getItemMeta();
		    	  slm3Meta.setDisplayName("§1");
		    	  slm3.setItemMeta(slm3Meta);
		    	  p.getInventory().setItem(9, slm3);
		    	  
		    	  ItemStack slm4 = new ItemStack(Material.DIAMOND_SWORD);
		    	  slm4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10000);
		    	  ItemMeta slm2Meta = slm4.getItemMeta();
		    	  slm2Meta.setDisplayName("§b§lGommemode-Schwert");
		    	  slm4.setItemMeta(slm2Meta);
		    	  p.getInventory().setItem(0, slm4);  
		    	  
	  }
	return false;
	}
	}


	
