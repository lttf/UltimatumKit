package com.lttf.UltimatumKit.Economy;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by user on 8/11/2015.
 */
public class Money implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(strings.length < 1) {
            if(player.isOp()) {
                player.sendMessage("");
                player.sendMessage(String.format("%s[%s%sECONOMY%s] %s/money", ChatColor.DARK_GRAY, ChatColor.BLUE,
                        ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW));
                player.sendMessage(String.format("%s[%s%sECONOMY%s] %s/money send <name> <amount>", ChatColor.DARK_GRAY, ChatColor.BLUE,
                        ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW));
                player.sendMessage(String.format("%s[%s%sECONOMY%s] %s/money take <name> <amount>", ChatColor.DARK_GRAY, ChatColor.BLUE,
                        ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW));
                return false;
            }
        } else if(strings.length > 4) {
            player.sendMessage(String.format("%s[%s%sECONOMY%s] %sSyntax Error - Type /money to view help menu!", ChatColor.DARK_GRAY, ChatColor.BLUE,
                    ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW));
            return false;
        }

        if(strings[0].equals("send")) {
            if (player.isOp()) {
                if(!(strings.length == 3)) {
                    player.sendMessage(String.format("%s[%s%sECONOMY%s] %sSyntax Error - Not enough arguments given!", ChatColor.DARK_GRAY, ChatColor.BLUE,
                            ChatColor.BOLD ,ChatColor.DARK_GRAY, ChatColor.YELLOW));
                    return false;
                }

                String name = strings[1];
                String amount = strings[2];
                return true;
            }
        }
        return false;
    }
}
