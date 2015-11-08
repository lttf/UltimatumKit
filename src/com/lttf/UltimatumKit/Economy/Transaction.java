package com.lttf.UltimatumKit.Economy;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.entity.Player;

/**
 * Created by user on 6/11/2015.
 */
public class Transaction {

    public static void depositPlayer(Player player, Double amount) {
        String playerUUID = player.getUniqueId().toString();
        Double currentamount = Profile.playerBalance.get(playerUUID);
        Profile.playerBalance.put(playerUUID, currentamount + amount);
    }

    public static boolean withdrawPlayer(Player player, Double amount) {
        String playerUUID = player.getUniqueId().toString();
        Double currentamount = Profile.playerBalance.get(playerUUID);
        Double newamount = currentamount - amount;
        if(newamount >= 0) {
            Profile.playerBalance.put(playerUUID, newamount);
            return true;
        } else {
            Profile.playerBalance.put(playerUUID, 0.0);
            return false;
        }
    }
}
