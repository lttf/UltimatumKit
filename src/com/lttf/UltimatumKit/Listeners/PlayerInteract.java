package com.lttf.UltimatumKit.Listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import com.lttf.UltimatumKit.Guis.KitSelector;
import com.lttf.UltimatumKit.Main;
import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerInteract implements Listener {

    private Main PLUGIN;
    public PlayerInteract(Main plugin) {
        this.PLUGIN = plugin;
    }

    @EventHandler
    public void onItemClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();

        switch(player.getItemInHand().getType()) {
            case DIAMOND_SWORD:
                ItemStack i = player.getItemInHand();
                ItemMeta im = i.getItemMeta();
                try {
                    if(im.getDisplayName().equals(String.format("%s%sFFA Kit Selector %s%s(Right Click)",
                            ChatColor.YELLOW, ChatColor.BOLD, ChatColor.RESET, ChatColor.GRAY))) {

                        if(!Profile.playerPVPMode.get(playerUUID) && !Profile.playerSpectateMode.get(playerUUID)) {
                            KitSelector.openKitSelectorGUI(player);
                        } else {
                            player.sendMessage(String.format("%s[%s%s%sERROR%s] %s%sPlease turn off spectator mode to choose a kit!",
                                    ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.RED, ChatColor.BOLD,
                                    ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.GRAY));
                        }

                    }
                } catch (NullPointerException exception) {
                    exception.printStackTrace();
                }
                break;
            case GLASS:
                ItemStack j = player.getItemInHand();
                ItemMeta jm = j.getItemMeta();
                try{
                    if (jm.getDisplayName().equalsIgnoreCase(String.format("%s%sSpectator Mode %s%s(Right Click)", ChatColor.YELLOW, ChatColor.BOLD,
                            ChatColor.RESET, ChatColor.GRAY))) {
                        player.sendMessage(String.format("%s[%s%s%sERROR%s] %s%sSpectate Mode current disabled", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.RED, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.RED));
                        //TODO - FIX SPECTATE MODE
                        /*spectateMode(player, playerUUID);*/
                    }
                } catch (NullPointerException exception) {
                    exception.printStackTrace();
                }
                break;
        }
    }

    public Map<String, Long> cooldown = new HashMap<String, Long>();

    private boolean spectateMode(Player player, String playerUUID) {

        Integer cooldownTime = 10;
        if(cooldown.containsKey(player.getName())) {
            long secondsLeft = ((cooldown.get(player.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
            if(secondsLeft > 0) {
                player.sendMessage(String.format("%s[%s%s%sERROR%s] %s%sYou can't do that for another %s seconds!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.RED, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.GRAY, secondsLeft));
                return true;
            }
        }

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team Ghosts = board.registerNewTeam("Ghost");
        Ghosts.setCanSeeFriendlyInvisibles(true);
        Ghosts.setAllowFriendlyFire(false);

        cooldown.put(player.getName(), System.currentTimeMillis());
        if(!Profile.playerSpectateMode.get(playerUUID)) {
            Profile.playerSpectateMode.put(playerUUID, true);
            Ghosts.addPlayer(player);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
            spectateMessage(player, playerUUID);
        } else {
            Profile.playerSpectateMode.put(playerUUID, false);
            Ghosts.removePlayer(player);
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            spectateMessage(player, playerUUID);
        }
        return true;
    }

    public void spectateMessage(final Player player, final String playerUUID) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if(!Profile.playerSpectateMode.get(playerUUID)) {
                    this.cancel();
                }
                BountifulAPI.sendActionBar(player.getPlayer(), String.format("%s%sSpectator Mode - %s%sEnabled", ChatColor.YELLOW, ChatColor.BOLD,
                        ChatColor.GREEN, ChatColor.BOLD));
            }
        }.runTaskTimer(this.PLUGIN, 0, 20);
    }
}
