package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerQuit implements Listener {

    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        Profile.playerPVPMode.put(playerUUID, false);
        Profile.playerSpectateMode.put(playerUUID, false);

        event.setQuitMessage((String.format("%s[%s%sSERVER%s%s]%s %s has left this realm!",
                ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.BOLD, ChatColor.RESET, ChatColor.DARK_GRAY,
                ChatColor.YELLOW, event.getPlayer().getName())));
    }
}
