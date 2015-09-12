package org.pixelcrew.gs.punishments;

import org.bukkit.Effect;
import org.bukkit.GameMode;
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
		    	  p.getInventory().setItem(2, slm3);
		        }
		      
	return false;

	}
}

	
