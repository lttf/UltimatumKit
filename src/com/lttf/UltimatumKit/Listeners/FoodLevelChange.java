package com.lttf.UltimatumKit.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by user on 7/11/2015.
 */
public class FoodLevelChange implements Listener {

    @EventHandler
    public void foodLevelChange(FoodLevelChangeEvent event) {
        Entity player = event.getEntity();
        if(player instanceof Player) {
            ((Player) player).setFoodLevel(20);
            event.setCancelled(true);
        }

    }
}
