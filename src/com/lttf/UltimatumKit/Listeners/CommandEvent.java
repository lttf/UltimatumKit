package com.lttf.UltimatumKit.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

/**
 * Created by user on 6/11/2015.
 */
public class CommandEvent implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            Player player = event.getPlayer();
            String cmd = event.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.sendMessage(String.format("%s[%s%s%sERROR%s] %s%sThat's an invalid command buddy!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.RED, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.GRAY));
                event.setCancelled(true);
            }
        }
    }
}
