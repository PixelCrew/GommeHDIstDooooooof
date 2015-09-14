package org.pixelcrew.gs.manager;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 0) {
				List<String> lore1 = new ArrayList<>();
				lore1.add("Das Gommond X.I ist ein misslungenes Projekt");
				lore1.add("aus den Laboren der PixelCrew. Es ist sehr stark aber");
				lore1.add("unberechenbar und wurde deßhalb sicher verwahrt!");
				ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta meta1 = item1.getItemMeta();
				meta1.setDisplayName("§cGommond §7X.I");
				meta1.setLore(lore1);
				meta1.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
				meta1.addEnchant(Enchantment.FIRE_ASPECT, 5, true);
				meta1.addEnchant(Enchantment.KNOCKBACK, 5, true);
				item1.setItemMeta(meta1);
				p.getInventory().setItem(0, item1);
				
				ArrayList<String> lore2 = new ArrayList<>();
				lore2.add(ChatColor.GRAY + "Rechtsklick um den");
				lore2.add(ChatColor.GRAY + "Spieler in die Luft");
				lore2.add(ChatColor.GRAY + "zu Jagen!" + ChatColor.RED + "#Gommemode");
				ItemStack item2 = new ItemStack(Material.REDSTONE);
				ItemMeta meta2 = item2.getItemMeta();
				meta2.setDisplayName(ChatColor.RED + "Bomben Remote");
				meta2.setLore(lore2);
				item2.setItemMeta(meta2);
				p.getInventory().setItem(6, item2);
				
				ArrayList<String> lore3 = new ArrayList<>();
				lore3.add(ChatColor.GRAY + "Spieler schlagen um");
				lore3.add(ChatColor.GRAY + "die Jacke anzuziehen!");
				lore3.add(ChatColor.GOLD + "Explosive Liebe <3");
				ItemStack item3 = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemMeta meta3 = item3.getItemMeta();
				meta3.setDisplayName(ChatColor.RED + "Bomben Jacke");
				meta3.setLore(lore3);
				item3.setItemMeta(meta3);
				p.getInventory().setItem(5, item3);
				
				ArrayList<String> lore4 = new ArrayList<>();
				lore4.add(ChatColor.GRAY + "Mit dem Kompass schlagen");
				lore4.add(ChatColor.GRAY + "um den Teleporter und die!");
				lore4.add(ChatColor.GRAY + "Einstellungen zu öffnen!");
				ItemStack item4 = new ItemStack(Material.COMMAND);
				ItemMeta meta4 = item4.getItemMeta();
				meta4.setDisplayName(ChatColor.GOLD + "EINSTELLUNGEN");
				meta4.setLore(lore4);
				item4.setItemMeta(meta4);
				p.getInventory().setItem(8, item4);
			}
		}
		return false;
	}
	
}

	
