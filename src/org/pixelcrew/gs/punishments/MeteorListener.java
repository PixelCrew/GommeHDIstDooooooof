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

public class MeteorListener implements Listener{
	
	static int countdown = 50;
	static int stop;
	
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent e){
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Spieler schlagen um");
		lore.add(ChatColor.GRAY + "ein Meteor über ihm");
		lore.add(ChatColor.GRAY + "zu spawnen!");
    	final ItemStack meteor = new ItemStack(Material.FIREWORK_CHARGE);
    	ItemMeta tasermeta = meteor.getItemMeta();
    	tasermeta.setDisplayName(ChatColor.RED + "Meteor Spawner");
    	tasermeta.setLore(lore);
    	meteor.setItemMeta(tasermeta);
		
    	if(e.getEntity() instanceof Player){
    	if(e.getDamager() instanceof Player){
    	
		final Player p1 = (Player)e.getEntity();
		final Player p2 = (Player)e.getDamager();
		final World world = (World)e.getEntity().getWorld();
		
		if(p2.isOp()){
		if(p2.getInventory().getItemInHand().equals(meteor)){
			
			p2.getInventory().remove(meteor);
		
		Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

			public void run() {
				p2.getInventory().setItem(0, meteor);
			}
			
		}, 100L);
		
		stop = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {

			@Override
			public void run() {
				if(countdown>0){
					countdown--;
					
					Location loc = new Location(p1.getWorld(), p1.getLocation().getX(), p1.getLocation().getY() + countdown, p1.getLocation().getZ());
					
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					world.playEffect(loc, Effect.LAVA_POP, 2);
					
					world.playEffect(loc, Effect.FLAME, null);
					
					world.playEffect(loc, Effect.LAVADRIP, null);
					
					world.playSound(loc, Sound.CREEPER_HISS, 10, 1);
					
				}else{
					if(countdown == 0){
						world.playEffect(p1.getLocation(), Effect.EXPLOSION_HUGE, null);
						world.playSound(p1.getLocation(), Sound.EXPLODE, 10, 1);
						p1.damage(100L);
						Bukkit.getScheduler().cancelTask(stop);
						countdown = 50;
					}
				}
				
			}
			
		}, 0L, 1L);
	}
	}
	}
	}
	}

}
