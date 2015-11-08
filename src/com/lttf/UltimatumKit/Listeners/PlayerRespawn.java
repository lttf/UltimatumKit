package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by user on 7/11/2015.
 */
public class PlayerRespawn implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();

        PlayerSpawn.playerHealthandEffects(player);
        PlayerSpawn.playerInventory(player);
        PlayerSpawn.playerSpawnTeleport(player);

        Profile.playerPVPMode.put(playerUUID, false);
    }
}
