package com.lttf.UltimatumKit.Listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.lttf.UltimatumKit.Economy.Transaction;
import com.lttf.UltimatumKit.Main;
import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerDeath implements Listener {

    private Main PLUGIN;
    public PlayerDeath(Main plugin) {
        this.PLUGIN = plugin;
    }
    public static Map<String, Integer> playerKillCount = new HashMap<String, Integer>();
    public static Map<String, Integer> playerDeathCount = new HashMap<String, Integer>();

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {

        // TODO - FIX /kill bug

        if(event.getEntity().getKiller() != null) {

            Player killer = event.getEntity().getKiller();
            Player victim = event.getEntity().getPlayer();

            String killerUUID = killer.getUniqueId().toString();

            // KILLER KILL MULTIPLIER
            if(playerKillCount.get(killerUUID) == null) {
                playerKillCount.put(killerUUID, 1);
            } else {
                playerKillCount.put(killerUUID, playerKillCount.get(killerUUID) + 1);
            }

            Integer killCount = playerKillCount.get(killerUUID);

            Profile.playerKills.put(killerUUID, Profile.playerKills.get(killerUUID) + 1);
            playerDeathCount.put(killerUUID, 0);
            BountifulAPI.sendActionBar(killer, String.format("%s%sKill Streak - %s%s%s",
                    ChatColor.YELLOW, ChatColor.BOLD, ChatColor.GREEN, ChatColor.BOLD, killCount));

            Double health = killer.getHealth();
            if (health < 10.0) {
                killer.setHealth(health + 10.0);
            } else if (health < 15.0) {
                killer.setHealth(health + 5.0);
            } else {
                killer.setHealth(health);
            }


            if (killCount <= 1) {
                Transaction.depositPlayer(killer, 2.00);
                killer.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received %s$2 %sfor the blood of %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.GREEN,
                        ChatColor.YELLOW, ChatColor.GREEN, victim.getName(), ChatColor.RESET, ChatColor.YELLOW));
            } else if (killCount < 5) {
                Transaction.depositPlayer(killer, 5.00);
                killer.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received %s$4 %sfor the blood of %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.GREEN,
                        ChatColor.YELLOW, ChatColor.GREEN, victim.getName(), ChatColor.RESET, ChatColor.YELLOW));
                if (killCount == 3) {
                    Bukkit.getServer().broadcastMessage(String.format("%s[%s%s%sFFA%s] %s%s%s is on a blazing 3 kill streak!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.AQUA, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName()));
                }
            } else if (killCount < 10) {
                Transaction.depositPlayer(killer, 10.00);
                killer.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received %s$10 %sfor the blood of %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.GREEN,
                        ChatColor.YELLOW, ChatColor.GREEN, victim.getName(), ChatColor.RESET, ChatColor.YELLOW));
                if (killCount == 5) {
                    Bukkit.getServer().broadcastMessage(String.format("%s[%s%s%sFFA%s] %s%s%s is on a hot 5 kill streak!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.AQUA, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName()));
                }
            } else if (killCount < 20) {
                Transaction.depositPlayer(killer, 20.00);
                killer.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received %s$20 %sfor the blood of %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.GREEN,
                        ChatColor.YELLOW, ChatColor.GREEN, victim.getName(), ChatColor.RESET, ChatColor.YELLOW));
                if (killCount == 10) {
                    Bukkit.getServer().broadcastMessage(String.format("%s[%s%s%sFFA%s] %s%s%s is on an awesome 10 kill streak!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.AQUA, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName()));
                    killer.getWorld().strikeLightningEffect(killer.getLocation());
                }
                if (killCount == 15) {
                    Bukkit.getServer().broadcastMessage(String.format("%s[%s%s%sFFA%s] %s%s%s is on an incredible 15 kill streak!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.AQUA, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName()));
                }
            } else if (killCount > 20) {
                Transaction.depositPlayer(killer, 50.00);
                killer.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've received %s$50 %sfor the blood of %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                        ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.GREEN,
                        ChatColor.YELLOW, ChatColor.GREEN, victim.getName(), ChatColor.RESET, ChatColor.YELLOW));
                if (killCount == 20) {
                    Bukkit.getServer().broadcastMessage(String.format("%s[%s%s%sFFA%s] %s%s%s is on a record breaking 20 kill streak!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.AQUA, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName()));
                    killer.getWorld().strikeLightningEffect(killer.getLocation());
                }
            }

            // VICTIM DEATH MULTIPLIER

            String victimUUID = victim.getUniqueId().toString();
            playerKillCount.put(victimUUID, 0);
            Profile.playerDeaths.put(victimUUID, Profile.playerDeaths.get(victimUUID) + 1);
            victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%s%s had %s%s \u2764 %sleft!", ChatColor.DARK_GRAY, ChatColor.RESET,
                    ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, killer.getName(),
                    ChatColor.RED, Math.round(health / 2), ChatColor.YELLOW));

            if (playerDeathCount == null) {
                playerDeathCount.put(victimUUID, 1);
            } else {
                playerDeathCount.put(victimUUID, playerDeathCount.get(victimUUID) + 1);
            }

            Integer deathCount = playerDeathCount.get(victimUUID);

            if (deathCount <= 2) {
                if (Transaction.withdrawPlayer(victim, 5.00)) {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$5 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                } else {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$0 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                }
            } else if (deathCount < 5) {
                if (Transaction.withdrawPlayer(victim, 10.00)) {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$10 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                } else {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$0 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                }
            } else if (deathCount > 5) {
                if (Transaction.withdrawPlayer(victim, 20.00)) {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$20 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                } else {
                    victim.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've lost %s$0 %sfor dying to %s%s%s%s!", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW, ChatColor.RED, killer.getName(), ChatColor.RESET, ChatColor.YELLOW));
                }
            }
        }

    }

    // HOLOGRAM CREATION/DELETION
    public void deathHologram(Player victim, Player killer) {
        String text = String.format("%s%s got %s%s#rekt%s%s by %s", ChatColor.YELLOW, victim.getName(),
                ChatColor.AQUA, ChatColor.BOLD, ChatColor.RESET, ChatColor.YELLOW, killer.getName());
        Location deathlocation = new Location(victim.getWorld(), victim.getLocation().getX(),
                victim.getLocation().getY() + 1.5, victim.getLocation().getZ());
        final Hologram hologram = HologramsAPI.createHologram(this.PLUGIN, deathlocation);
        hologram.appendTextLine(text);
        new BukkitRunnable() {
            @Override
            public void run() {
                hologram.delete();
            }
        }.runTaskLater(this.PLUGIN, (20 * 30));
    }

    // HANDLES DROPPED ITEMS + QUICK RESPAWN
    @EventHandler
    public void clearItems(final PlayerDeathEvent event) {
        if(event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getPlayer();
            String playerUUID = player.getUniqueId().toString();
            event.getDrops().clear();

            //PLAY SOUND
            event.getEntity().getKiller().playSound(event.getEntity().getKiller().getLocation(), Sound.NOTE_PLING, 1, 1);

            // CREATE DEATH HOLOGRAM FOR PLAYER
            deathHologram(event.getEntity(), event.getEntity().getKiller());
            Profile.playerKit.put(playerUUID, "null");

            // Quick Respawn
            try {
                Bukkit.getScheduler().runTaskLater(this.PLUGIN, new Runnable() {
                    public void run() {
                        event.getEntity().spigot().respawn();
                    }
                }, 1);
            } catch (NoClassDefFoundError error) {
                error.printStackTrace();
            }
        } else {
            event.getDrops().clear();
        }
    }
}
