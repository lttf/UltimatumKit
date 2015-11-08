package com.lttf.UltimatumKit.Economy;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by user on 6/11/2015.
 */
public class Balance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        player.sendMessage(String.format("%s[%s%sECONOMY%s] %sCurrent Balance : %s", ChatColor.DARK_GRAY, ChatColor.BLUE,
                 ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW, Profile.playerBalance.get(player.getUniqueId().toString())));
        return false;
    }
}
