package com.lttf.UltimatumKit.Profiles;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 6/11/2015.
 */
public class ProfileSaver implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        File playerData = new File("./plugins/UltimatumKits/" + playerUUID + ".yml");

        // Existence Check
        if(playerData.exists()) {
        playerSaveData(player, playerUUID);
        } else {
            if(ProfileLoader.createPlayerData(player, playerData, true)) {
                System.out.println(String.format("[UltimatumKits] Data File created for %s", player.getName()));
            } else {
                System.out.println(String.format("[UltimatumKits] Data File creation failed for %s", player.getName()));
            }
        }
    }

    public static void playerSaveData(Player player, String playerUUID) {
        File playerData = new File("./plugins/UltimatumKits/" + playerUUID + ".yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(playerData);
        data.set("player.Name", player.getName());
        data.set("player.Experience", Profile.playerExperience.get(playerUUID));
        data.set("player.Rank", Profile.playerRank.get(playerUUID));
        data.set("player.Kills", Profile.playerKills.get(playerUUID));
        data.set("player.Deaths", Profile.playerDeaths.get(playerUUID));
        data.set("kits.Knight", Profile.knight.get(playerUUID));
        data.set("kits.Hunter", Profile.hunter.get(playerUUID));
        data.set("kits.Scout", Profile.scout.get(playerUUID));
        data.set("kits.Horsetamer", Profile.horsetamer.get(playerUUID));
        data.set("kits.Reddragon", Profile.reddragon.get(playerUUID));
        data.set("kits.Astronaut", Profile.astronaut.get(playerUUID));
        data.set("kits.Paladin", Profile.paladin.get(playerUUID));
        data.set("kits.Speleologist", Profile.speleologist.get(playerUUID));
        data.set("kits.Fisherman", Profile.fisherman.get(playerUUID));
        data.set("kits.Tim", Profile.tim.get(playerUUID));
        data.set("kits.Creepertamer", Profile.creepertamer.get(playerUUID));
        data.set("currency.Balance", Profile.playerBalance.get(playerUUID));

        try {
            System.out.println(String.format("[UltimatumKits] Player data saved for %s", player.getName()));
            data.save(playerData);
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println(String.format("[UltimatumKits] Unable to save data for %s", player.getName()));
        }
    }

}
