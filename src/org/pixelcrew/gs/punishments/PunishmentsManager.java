package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.pixelcrew.gs.Main;

public class PunishmentsManager implements Listener, CommandExecutor {
	
	public static Inventory inv = Bukkit.createInventory(null, 27, ChatColor.RED + "Bestrafungsauswahl");
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		if(sender instanceof Player) {
			if(args.length == 0) {
				Player player = (Player)sender;
				
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
				taserlore.add(ChatColor.GOLD + "#ElektroGomme");
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
				
				inv.setItem(0, chest);
				inv.setItem(2, taser);
				inv.setItem(4, axe);
				inv.setItem(6, meteor);
				inv.setItem(8, roket);
				
				player.openInventory(inv);
				return true;
			}
		}
		return false;
	}
	
	
	@EventHandler
	public void onClick(final InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase(ChatColor.RED + "Bestrafungsauswahl")) {
			try{
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
				taserlore.add(ChatColor.GOLD + "#ElektroGomme");
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
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Bomben Jacke") || 
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Elektro Gomme") || 
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Halsabschneider") || 
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Meteor Spawner") || 
						e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Travel to the Moon")) {
					
					e.setCancelled(true);
					player.getInventory().setItem(7, air);
					player.getInventory().setItem(8, air);
				}
				
				Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){
					World world = (World)e.getWhoClicked().getWorld();
					public void run() {
						if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Bomben Jacke")){
							player.getInventory().setItem(7, chest);
							player.getInventory().setItem(8, remote);
							world.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
							e.getView().close();
						}
						else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Elektro Gomme")){
							player.getInventory().setItem(8, taser);
							world.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
							e.getView().close();
						}
						else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Halsabschneider")){
							player.getInventory().setItem(8, axe);
							world.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
							e.getView().close();
						}
						else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Meteor Spawner")){
							player.getInventory().setItem(8, meteor);
							world.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
							e.getView().close();
						}
						else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Travel to the Moon")){
							player.getInventory().setItem(8, roket);
							world.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
							e.getView().close();
						}
					}
				}, 1L);
			}catch(NullPointerException ex){}
		}
	}
	
	@EventHandler
	public static void onOpen(PlayerInteractEvent e) {
		World w = (World)e.getPlayer().getWorld();
		
		ArrayList<String> plore = new ArrayList<String>();
		plore.add(ChatColor.GRAY + "Rechtsklick um das");
		plore.add(ChatColor.GRAY + "Strafenmenue zu");
		plore.add(ChatColor.GRAY + "öffnen!");
		ItemStack punish = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta pmeta = punish.getItemMeta();
		pmeta.setDisplayName(ChatColor.RED + "Strafen");
		pmeta.setLore(plore);
		punish.setItemMeta(pmeta);
		
		Player player = (Player)e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(player.getInventory().getItemInHand().equals(punish)) {
				e.setCancelled(true);
				w.playSound(player.getLocation(), Sound.FIREWORK_BLAST, 10, 1);
				
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
				taserlore.add(ChatColor.GOLD + "#ElektroGomme");
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
				
				inv.setItem(0, chest);
				inv.setItem(2, taser);
				inv.setItem(4, axe);
				inv.setItem(6, meteor);
				inv.setItem(8, roket);
				
				player.openInventory(inv);
			}
		}
	}
}
