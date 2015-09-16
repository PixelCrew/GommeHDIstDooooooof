package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.pixelcrew.gs.Main;

public class TaserListener implements Listener {
	
	public static int stop;
    
    @EventHandler
    public static void onHit(final EntityDamageByEntityEvent e){
    	
    	ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Spieler schlagen");
		lore.add(ChatColor.GRAY + "um ihn zu elektrisieren");
		lore.add(ChatColor.GOLD + "#ElektroGomme");
    	ItemStack taser = new ItemStack(Material.IRON_HOE);
    	ItemMeta tasermeta = taser.getItemMeta();
    	tasermeta.setDisplayName(ChatColor.YELLOW + "Elektro Gomme");
    	tasermeta.setLore(lore);
    	taser.setItemMeta(tasermeta);
    	
    	if(e.getEntity() instanceof Player){
    	if(e.getDamager() instanceof Player){
    	final Player player = (Player)e.getDamager();
    	final Player p = (Player)e.getEntity();
		final World w = player.getWorld();
		
		if(player.isOp()){
    	if(player.getInventory().getItemInHand().equals(taser)){
    		
    		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

				public void run() {
					p.damage(100L);
				}
				
			}, 60L);
    		
    		stop = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
    			
    			public void run() {
    				if(!p.isDead()){
    				Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ());
    				p.teleport(loc);
    				w.playSound(player.getLocation(), Sound.CREEPER_HISS, 10, 1);
    				w.playEffect(loc, Effect.FLAME, 2);
    				
    				Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

						public void run() {
							Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ());
							p.teleport(loc);
							w.playSound(player.getLocation(), Sound.CREEPER_HISS, 10, 1);
							w.playEffect(loc, Effect.FLAME, 2);
						}
    					
    				}, 2L);
    				
    				
    				}else{
    					Bukkit.getScheduler().cancelTask(stop);
    				}
    			}
    		}, 0L, 4L);
    	}
    }
    }
    }
    }

}
