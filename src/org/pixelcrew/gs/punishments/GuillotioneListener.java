package org.pixelcrew.gs.punishments;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.pixelcrew.gs.Main;

public class GuillotioneListener implements Listener{
	
	static List<Player> tracket = new ArrayList<Player>();
	
	@EventHandler
	public static void onHit(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			if(e.getEntity() instanceof Player){
				Player p1 = (Player)e.getDamager();
				final Player p2 = (Player)e.getEntity();
				
				ArrayList<String> lore = new ArrayList<String>();
				lore.add(ChatColor.GRAY + "Spieler schlagen");
				lore.add(ChatColor.GRAY + "um ihn einen Kopf");
				lore.add(ChatColor.GRAY + "kürzer zu machen!");
		    	ItemStack Axe = new ItemStack(Material.IRON_AXE);
		    	ItemMeta tasermeta = Axe.getItemMeta();
		    	tasermeta.setDisplayName(ChatColor.RED + "Halsabschneider");
		    	tasermeta.setLore(lore);
		    	Axe.setItemMeta(tasermeta);
		    	
		    	p1.getInventory().setItem(8, Axe);
		    	
		    	if(p1.getInventory().getItemInHand().equals(Axe)){
		    		if(p2.isSneaking()){
		    			World w = p2.getWorld();
		    			tracket.add(p2);
		    			w.playSound(p2.getLocation(), Sound.ENDERDRAGON_HIT, 10, 1);
		    			w.playSound(p2.getLocation(), Sound.GHAST_SCREAM2, 10, 1);
		    			e.setCancelled(true);
		    			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		    			ItemStack hose = new ItemStack(Material.LEATHER_LEGGINGS);
		    			ItemStack schuhe = new ItemStack(Material.LEATHER_BOOTS);
		    			p2.getInventory().setChestplate(chest);
		    			p2.getInventory().setLeggings(hose);
		    			p2.getInventory().setBoots(schuhe);
		    			p2.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 10, false));
		    			p2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 10, false));
		    			p2.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 10, false));
		    			
		    			Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

							@SuppressWarnings("deprecation")
							public void run() {
								String owner = p2.getName();
				    			p2.getLocation().getBlock().setType(Material.SKULL);
				    			p2.getLocation().getBlock().setData((byte) 3);
				    			Skull s = (Skull)p2.getLocation().getBlock().getState();
				    			s.setRotation(BlockFace.WEST);
				    			s.setOwner(owner);
				    			s.update(true);
							}
	    					
	    				}, 10L);
		    			
		    			
		    			Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable(){

							public void run() {
								p2.damage(100L);
							}
	    					
	    				}, 60L);
		    		}
		    	}
			}
		}
	}
	
	
	
	@EventHandler
	public static void onDeath(PlayerDeathEvent e){
		Player player = (Player)e.getEntity();
		int count = 0;
		while (count < tracket.size()){
			final Player target = (Player)tracket.get(count);
			if(player.getName() == target.getName()){
				tracket.remove(count);
			}
		}
	}

}
