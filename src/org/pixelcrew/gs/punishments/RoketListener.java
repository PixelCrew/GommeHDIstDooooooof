package org.pixelcrew.gs.punishments;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class RoketListener implements Listener{
	
	public static Player Roket;
	
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			if(e.getDamager() instanceof Player){
				final Player p1 = (Player)e.getDamager();
				final Player p2 = (Player)e.getEntity();
				if(p1.isOp()){
				
				ArrayList<String> roketlore = new ArrayList<String>();
				roketlore.add(ChatColor.GRAY + "Spieler schlagen um");
				roketlore.add(ChatColor.GRAY + "ihn auf den Mond zu");
				roketlore.add(ChatColor.GRAY + "schiessen! " + ChatColor.DARK_BLUE + "#MOON");
				ItemStack roket = new ItemStack(Material.FIREWORK);
				ItemMeta roketmeta = roket.getItemMeta();
				roketmeta.setDisplayName(ChatColor.GOLD + "Travel to the Moon");
				roketmeta.setLore(roketlore);
				roket.setItemMeta(roketmeta);
				
				p1.getInventory().addItem(roket);
				
				if(p1.isOp()){
					if(p1.getInventory().getItemInHand().equals(roket)){
						
						Firework f = (Firework)p2.getWorld().spawn(p2.getLocation(), Firework.class);
						
						FireworkMeta fm = f.getFireworkMeta();
						fm.addEffect(FireworkEffect.builder().flicker(true).with(Type.BALL_LARGE).withColor(Color.BLUE).withFade(Color.RED).build());
						fm.setPower(3);
						f.setFireworkMeta(fm);
						f.setPassenger(p2);
					}
				}
			}
			}
		}
	}

}
