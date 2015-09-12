package org.pixelcrew.gs.check;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import api.ParticleEffect;

public class ArrowEffekts extends JavaPlugin{
 
 public void onEnable(){
  Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
   
   @Override
   public void run() {
    for(Player all: Bukkit.getOnlinePlayers()){
     World w = all.getWorld();
     for(Entity entity : w.getEntities()){
      if(entity instanceof Arrow){
       Arrow a = (Arrow) entity;
       ParticleEffect.FLAME.display(0, 0, 0, 0, 2, a.getLocation(), 250);
       if(a.isOnGround()){
        Location loc = a.getLocation();
        loc.setY(0);
        a.teleport(loc);
        

       }
      }
     }
    }
   }
  }, 0, 1);
 }

}