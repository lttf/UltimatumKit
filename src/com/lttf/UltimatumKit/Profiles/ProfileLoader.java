package com.lttf.UltimatumKit.Profiles;

import com.lttf.UltimatumKit.Economy.Transaction;
import com.lttf.UltimatumKit.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 6/11/2015.
 */
public class ProfileLoader implements Listener {

    private Main PLUGIN;
    public ProfileLoader(Main plugin) {
        this.PLUGIN = plugin;
    }

    @EventHandler
    public void profileLoad(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        File playerData = new File("./plugins/UltimatumKits/" + playerUUID + ".yml");

        // Checking whether player already has YML File
        if(playerData.exists()) {
            System.out.println("[UltimatumKits] File Exists for " + player.getName());
            FileConfiguration data = YamlConfiguration.loadConfiguration(playerData);

            // Assigning information to Profile Data

            // PVP Statistics
            Profile.playerKills.put(playerUUID, (Integer) data.get("player.Kills"));
            Profile.playerDeaths.put(playerUUID, (Integer) data.get("player.Deaths"));
            Profile.playerExperience.put(playerUUID, (Integer) data.get("player.Experience"));
            Profile.playerRank.put(playerUUID, (String) data.get("player.Rank"));

            // Kits
            Profile.knight.put(playerUUID, (Boolean) data.get("kits.Knight"));
            Profile.scout.put(playerUUID, (Boolean) data.get("kits.Scout"));
            Profile.hunter.put(playerUUID, (Boolean) data.get("kits.Hunter"));
            Profile.horsetamer.put(playerUUID, (Boolean) data.get("kits.Horsetamer"));
            Profile.reddragon.put(playerUUID, (Boolean) data.get("kits.Reddragon"));
            Profile.astronaut.put(playerUUID, (Boolean) data.get("kits.Astronaut"));
            Profile.paladin.put(playerUUID, (Boolean) data.get("kits.Paladin"));
            Profile.speleologist.put(playerUUID, (Boolean) data.get("kits.Speleologist"));
            Profile.fisherman.put(playerUUID, (Boolean) data.get("kits.Fisherman"));
            Profile.tim.put(playerUUID, (Boolean) data.get("kits.Tim"));
            Profile.creepertamer.put(playerUUID, (Boolean) data.get("kits.Creepertamer"));

            // Currency
            Profile.playerBalance.put(playerUUID, (Double) data.get("currency.Balance"));
        } else {
            if(createPlayerData(player, playerData, true)) {
                System.out.println(String.format("[UltimatumKits] Data File created for %s", player.getName()));
            } else {
                System.out.println(String.format("[UltimatumKits] Data File creation failed for %s", player.getName()));
            }
        }
    }

    public static boolean createPlayerData(Player player, File playerData, boolean b) {
        try {
            playerData.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

        FileConfiguration data = YamlConfiguration.loadConfiguration(playerData);
        data.set("player.Name", player.getName());
        data.set("player.Experience", 0);
        data.set("player.Rank", "Beginner");
        data.set("player.Kills", 0);
        data.set("player.Deaths", 0);
        data.set("kits.Knight", false);
        data.set("kits.Hunter", false);
        data.set("kits.Scout", false);
        data.set("kits.Horsetamer", false);
        data.set("kits.Reddragon", false);
        data.set("kits.Astronaut", false);
        data.set("kits.Paladin", false);
        data.set("kits.Speleologist", false);
        data.set("kits.Fisherman", false);
        data.set("kits.Tim", false);
        data.set("kits.Creepertamer", false);
        data.set("currency.Balance", 0.0);

        try {
            data.save(playerData);
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }

        // Assign default data values to player.
        newPlayerValues(player);
        return true;
    }

    public static void newPlayerValues(Player player) {
        String playerUUID = player.getUniqueId().toString();

        // PVP Statistics
        Profile.playerKills.put(playerUUID, 0);
        Profile.playerDeaths.put(playerUUID, 0);
        Profile.playerExperience.put(playerUUID, 0);
        Profile.playerRank.put(playerUUID, "Beginner");

        // Kits
        Profile.knight.put(playerUUID, false);
        Profile.scout.put(playerUUID, false);
        Profile.hunter.put(playerUUID, false);
        Profile.horsetamer.put(playerUUID, false);
        Profile.reddragon.put(playerUUID, false);
        Profile.astronaut.put(playerUUID, false);
        Profile.paladin.put(playerUUID, false);
        Profile.speleologist.put(playerUUID, false);
        Profile.fisherman.put(playerUUID, false);
        Profile.tim.put(playerUUID, false);
        Profile.creepertamer.put(playerUUID, false);

        // Currency
        Profile.playerBalance.put(playerUUID, 0.0);
        Transaction.depositPlayer(player, 500.00);

        // Send "Welcome" message.
        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received $500 as this is your first login!", ChatColor.DARK_GRAY, ChatColor.RESET,
                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW));
    }
}
