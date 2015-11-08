package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerDamage implements Listener {

    @EventHandler
    public void onPlayerDam(EntityDamageEvent event) {
        Entity player = event.getEntity();
        if(player instanceof Player) {
            String playerUUID = player.getUniqueId().toString();
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL || event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE ||
                    event.getCause() == EntityDamageEvent.DamageCause.THORNS || event.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
                if(!(Profile.playerPVPMode.get(playerUUID))) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerHit(final EntityDamageByEntityEvent event) {
        Entity player = event.getEntity();
        String playerUUID = player.getUniqueId().toString();
        try {
            if(!Profile.playerPVPMode.get(playerUUID)) {
                event.setCancelled(true);
            }
        } catch (NullPointerException exception) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerFall(final EntityDamageEvent event) {
        // TODO - FIX ISSUE
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            String playerUUID = entity.getUniqueId().toString();
            try {
                if (PlayerMovement.playerFallDamage.get(playerUUID) == null) {
                    PlayerMovement.playerFallDamage.put(playerUUID, false);
                }
                    if (PlayerMovement.playerFallDamage.get(playerUUID) && Profile.playerPVPMode.get(playerUUID)) {
                        event.setCancelled(true);
                        entity.setFallDistance(0);
                        PlayerMovement.playerFallDamage.put(playerUUID, false);
                    }
            } catch (NullPointerException exception) {
                System.out.println("[UltimatumKits] [ERROR] Fall Damage Error - Ignore");
            }
        }
    }

}
