package org.pixelcrew.gs.punishments;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.pixelcrew.gs.Main;

public class TaserListener implements Listener {
	
	public static int stop;
    
    @EventHandler
    public static void onHit(final EntityDamageByEntityEvent e){
    	if(e.getEntity() instanceof Player){
	    	if(e.getDamager() instanceof Player){
		    	final Player player = (Player)e.getDamager();
		    	final Player p = (Player)e.getEntity();
		    	ItemStack item = new ItemStack(Material.IRON_HOE);
				final World w = player.getWorld();
		    	if(player.getInventory().getItemInHand().equals(item)) {
		    		
		    		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
		
						public void run() {
							p.damage(21L);
						}
						
					}, 60L);
		    		
		    		stop = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
		    			
		    			public void run() {
		    				if(!p.isDead()){
			    				Location loc = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getX(),e.getEntity().getLocation().getY() + 1 , e.getEntity().getLocation().getZ());
			    				e.getEntity().teleport(loc);
			    				w.playSound(player.getLocation(), Sound.VILLAGER_NO, 10, 1);
			    				
			    				Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){
			
									public void run() {
										Location loc1 = new Location(e.getEntity().getWorld(), e.getEntity().getLocation().getX(),e.getEntity().getLocation().getY() - 1 , e.getEntity().getLocation().getZ());
										e.getEntity().teleport(loc1);
										w.playSound(player.getLocation(), Sound.VILLAGER_NO, 10, 1);
									}
			    					
			    				}, 1L);
		    				}else{
		    					Bukkit.getScheduler().cancelTask(stop);
		    				}
		    			}
		    		}, 0L, 2L);
		    	}
		    }
	    }
    }
}
