package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Main;
import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerSpawn implements Listener {

    private Main PLUGIN;
    public PlayerSpawn(Main plugin) {
        this.PLUGIN = plugin;
    }

    @EventHandler
    public void onPlayerSpawn(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();
        Profile.playerPVPMode.put(playerUUID, false);
        Profile.playerSpectateMode.put(playerUUID, false);
        PlayerMovement.playerFallDamage.put(playerUUID, false);
        PlayerDeath.playerKillCount.put(playerUUID, 0);
        PlayerDeath.playerDeathCount.put(playerUUID, 0);

        for(int i=0;i<20;i++) {
            player.sendMessage("");
        }

        // Server-wide Join Message
        event.setJoinMessage((String.format("%s[%s%sSERVER%s%s]%s %s has entered this realm!",
                ChatColor.DARK_GRAY, ChatColor.BLUE, ChatColor.BOLD, ChatColor.RESET, ChatColor.DARK_GRAY,
                ChatColor.YELLOW, event.getPlayer().getName())));

        // Inventory
        playerInventory(player);

        // Health & Effects
        playerHealthandEffects(player);

        // Teleportation
        playerSpawnTeleport(player);

        healthbar(player);

    }

    // Inventory Management
    public static void playerInventory(Player player) {

        // Clear whole inventory.
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        // Set Items
        // Kit Selector Menu (Item)
        ItemStack kitmenu = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta kitmenumeta = kitmenu.getItemMeta();
        kitmenumeta.setDisplayName(String.format("%s%sFFA Kit Selector %s%s(Right Click)", ChatColor.YELLOW, ChatColor.BOLD,
                ChatColor.RESET, ChatColor.GRAY));
        kitmenu.setItemMeta(kitmenumeta);
        player.getPlayer().getInventory().setItem(3, kitmenu);

        // Spectator Mode (Item)
        ItemStack spectate = new ItemStack(Material.GLASS);
        ItemMeta spectatemeta = spectate.getItemMeta();
        spectatemeta.setDisplayName(String.format("%s%sSpectator Mode %s%s(Right Click)", ChatColor.YELLOW, ChatColor.BOLD,
                ChatColor.RESET, ChatColor.GRAY));
        spectate.setItemMeta(spectatemeta);
        player.getPlayer().getInventory().setItem(5, spectate);


        // TODO - Options Menu
    }

    public static void playerHealthandEffects(Player player) {
        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        player.removePotionEffect(PotionEffectType.ABSORPTION);
        player.setHealth(20);
        player.setExp(0);
    }

    public static void playerSpawnTeleport(Player player) {
        // TODO - Get real coordinates.
        Location location = new Location(Bukkit.getWorld("world"), -472.50, 33 , -131.5, 0 , 0);
        player.teleport(location);
    }

    public static void healthbar(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("showhealth", "health");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(String.format("%s\u2764", ChatColor.RED));

        for(Player online : Bukkit.getOnlinePlayers()){
            online.setScoreboard(board);
            online.setHealth(online.getHealth());
        }
    }
}
