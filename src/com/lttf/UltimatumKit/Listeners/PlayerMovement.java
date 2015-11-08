package com.lttf.UltimatumKit.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerMovement implements Listener {

    public static Map<String, Boolean> playerFallDamage = new HashMap<String, Boolean>();

    @EventHandler
    public void onPlayerMovement(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if(block.getType() == Material.STAINED_CLAY) {
            if(block.getData() == DyeColor.RED.getData()) {
                player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 2000);
                Vector v = new Vector(player.getLocation().getDirection().getX() * 4, 3.5,
                        player.getLocation().getDirection().getZ() * 20);
                player.setVelocity(v);
                playerFallDamage.put(playerUUID, true);
                player.playSound(player.getLocation(), Sound.WITHER_SHOOT, 1, 1);
            } else if(block.getData() == DyeColor.LIGHT_BLUE.getData()) {
                player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 2000);
                Vector v = new Vector(player.getLocation().getDirection().getX() * 1.3, 1.2,
                        player.getLocation().getDirection().getZ() * 1.7);
                player.setVelocity(v);
                playerFallDamage.put(playerUUID, true);
                player.playSound(player.getLocation(), Sound.WITHER_SHOOT, 1, 1);
            } else if(block.getData() == DyeColor.PINK.getData()) {
                player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 2000);
                Vector v = new Vector(player.getLocation().getDirection().getX() * 4, 1.8,
                        player.getLocation().getDirection().getZ() * 4);
                player.setVelocity(v);
                playerFallDamage.put(playerUUID, true);
                player.playSound(player.getLocation(), Sound.WITHER_SHOOT, 1, 1);
            }
        }


    }
}
