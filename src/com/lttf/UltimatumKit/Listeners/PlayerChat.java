package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if (e.getPlayer().isOp()){
            e.setFormat(String.format("%s[%s] %s[%s%sADMIN%s]%s %s%s: %s%s", ChatColor.GRAY, Profile.playerKills.get(e.getPlayer().getUniqueId().toString()),ChatColor.DARK_GRAY, ChatColor.RED, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET,
                    ChatColor.RED ,e.getPlayer().getDisplayName(), ChatColor.RESET, e.getMessage()));
        } else {
            e.setFormat(String.format("%s[%s] %s[%s%sTESTER%s]%s %s%s: %s%s",ChatColor.GRAY, Profile.playerKills.get(e.getPlayer().getUniqueId().toString()), ChatColor.DARK_GRAY, ChatColor.GRAY, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET,
                    ChatColor.GRAY, e.getPlayer().getDisplayName(), ChatColor.GRAY, e.getMessage()));
        }
    }
}
