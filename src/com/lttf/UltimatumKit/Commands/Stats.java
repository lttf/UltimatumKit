package com.lttf.UltimatumKit.Commands;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by user on 7/11/2015.
 */
public class Stats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        String playerUUID = player.getUniqueId().toString();
        Double kills = (double) Profile.playerKills.get(playerUUID);
        Double deaths = (double) Profile.playerDeaths.get(playerUUID);
        player.sendMessage("");
        player.sendMessage(String.format("%s[%s%sSTATS%s] %sUsername: %s", ChatColor.DARK_GRAY, ChatColor.GREEN, ChatColor.BOLD,
                ChatColor.DARK_GRAY, ChatColor.YELLOW, player.getName()));
        player.sendMessage(String.format("%s[%s%sSTATS%s] %sKills: %s", ChatColor.DARK_GRAY, ChatColor.GREEN, ChatColor.BOLD,
                ChatColor.DARK_GRAY, ChatColor.YELLOW, Profile.playerKills.get(playerUUID)));
        player.sendMessage(String.format("%s[%s%sSTATS%s] %sDeaths: %s", ChatColor.DARK_GRAY, ChatColor.GREEN, ChatColor.BOLD,
                ChatColor.DARK_GRAY, ChatColor.YELLOW, Profile.playerDeaths.get(playerUUID)));
        player.sendMessage(String.format("%s[%s%sSTATS%s] %sKill/Death Ratio: %s", ChatColor.DARK_GRAY, ChatColor.GREEN, ChatColor.BOLD,
                ChatColor.DARK_GRAY, ChatColor.YELLOW, kills/deaths));
        return true;
    }
}
