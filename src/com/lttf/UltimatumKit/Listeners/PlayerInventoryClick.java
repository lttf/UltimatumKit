package com.lttf.UltimatumKit.Listeners;

import com.lttf.UltimatumKit.Economy.Transaction;
import com.lttf.UltimatumKit.Guis.PromptPlayer;
import com.lttf.UltimatumKit.Kits.*;
import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by user on 6/11/2015.
 */
public class PlayerInventoryClick implements Listener {

    private static String kit = "null";

    @EventHandler
    public void MenuProtection(InventoryClickEvent event) {
        Entity player = event.getWhoClicked();
        String playerUUID = player.getUniqueId().toString();
        try {
            if (!Profile.playerPVPMode.get(playerUUID)) {
                switch (event.getAction()) {
                    case HOTBAR_MOVE_AND_READD:
                        event.setCancelled(true);
                        event.setResult(Event.Result.DENY);
                        break;
                    case HOTBAR_SWAP:
                        event.setCancelled(true);
                        event.setResult(Event.Result.DENY);
                        break;
                    case SWAP_WITH_CURSOR:
                        event.setCancelled(true);
                        event.setResult(Event.Result.DENY);
                        break;
                    default:
                        event.setCancelled(true);
                        event.setResult(Event.Result.DENY);
                        break;
                }
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    @EventHandler
    public void KitSelectorMenu(InventoryClickEvent event) {
        Entity player = event.getWhoClicked();
        String playerUUID = player.getUniqueId().toString();
        Inventory inv = event.getInventory();

        if(inv.getTitle().equals("FFA Kit Selection")) {
            ItemStack im = event.getCurrentItem();
            switch(im.getType()) {
                case FEATHER:
                    event.setCancelled(true);
                    kit = "Scout";
                    kitCheck((Player) player, playerUUID);
                    break;
                case CHAINMAIL_BOOTS:
                    event.setCancelled(true);
                    kit = "Astronaut";
                    kitCheck((Player) player, playerUUID);
                    break;
                case FLINT_AND_STEEL:
                    event.setCancelled(true);
                    kit = "Red Dragon";
                    kitCheck((Player) player, playerUUID);
                    break;
                case DIAMOND_PICKAXE:
                    event.setCancelled(true);
                    kit = "Speleologist";
                    kitCheck((Player) player, playerUUID);
                    break;
                case WOOD_SWORD:
                    event.setCancelled(true);
                    kit = "Knight";
                    kitCheck((Player) player, playerUUID);
                    break;
                case BOW:
                    event.setCancelled(true);
                    kit = "Hunter";
                    kitCheck((Player) player, playerUUID);
                    break;
                case DIAMOND_LEGGINGS:
                    event.setCancelled(true);
                    kit = "Tim";
                    kitCheck((Player) player, playerUUID);
                    break;
                case FISHING_ROD:
                    event.setCancelled(true);
                    kit = "Fisherman";
                    kitCheck((Player) player, playerUUID);
                    break;
                case IRON_CHESTPLATE:
                    event.setCancelled(true);
                    kit = "Paladin";
                    kitCheck((Player) player, playerUUID);
                    break;
                case DIAMOND_CHESTPLATE:
                    event.setCancelled(true);
                    kit = "Creepertamer";
                    kitCheck((Player) player, playerUUID);
            }
        }

    }

    public static void kitCheck(Player player, String playerUUID) {
        player.closeInventory();

        if(kit.equals("Scout")) {
            if(Profile.scout.get(playerUUID)) {
                Scout.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Hunter")) {
            if(Profile.hunter.get(playerUUID)) {
                Hunter.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Knight")) {
            if(Profile.knight.get(playerUUID)) {
                Knight.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Astronaut")) {
            if(Profile.astronaut.get(playerUUID)) {
                Astronaut.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Red Dragon")) {
            if(Profile.reddragon.get(playerUUID)) {
                RedDragon.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Speleologist")) {
            if(Profile.speleologist.get(playerUUID)) {
                Speleologist.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Tim")) {
            if(Profile.tim.get(playerUUID)) {
                Tim.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if(kit.equals("Fisherman")) {
            if(Profile.fisherman.get(playerUUID)) {
                Fisherman.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if (kit.equals("Paladin")) {
            if(Profile.paladin.get(playerUUID)) {
                Paladin.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        } else if (kit.equals("Creepertamer")) {
            if(Profile.creepertamer.get(playerUUID)) {
                Creepertamer.giveItems(player);
                player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                        kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                Profile.playerKit.put(playerUUID, kit);
                Profile.playerPVPMode.put(playerUUID, true);
            } else {
                PromptPlayer.promptInventory(player);
            }
        }
    }

    @EventHandler
    public void PromptPlayerMenu(InventoryClickEvent event) {
        Entity player = event.getWhoClicked();
        String playerUUID = player.getUniqueId().toString();
        Inventory inv = event.getInventory();
        Double amount = 0.0;

        try {
            if (kit.equals("Scout")) {
                amount = 500.00;
            } else if (kit.equals("Hunter")) {
                amount = 7500.00;
            } else if (kit.equals("Knight")) {
                amount = 7500.00;
            } else if (kit.equals("Astronaut")) {
                amount = 500.00;
            } else if (kit.equals("Red Dragon")) {
                amount = 1000.00;
            } else if (kit.equals("Speleologist")) {
                amount = 5000.00;
            } else if (kit.equals("Tim")) {
                amount = 10000.00;
            } else if (kit.equals("Fisherman")) {
                amount = 12500.00;
            } else if (kit.equals("Paladin")) {
                amount = 15000.00;
            } else if (kit.equals("Creepertamer")) {
                amount = 15000.00;
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }

        if(inv.getTitle().equals("Are you sure?")) {
            ItemStack im = event.getCurrentItem();
            if(im.getType() == Material.WOOL) {
                if(Transaction.withdrawPlayer((Player) player, amount)) {
                    if(kit.equals("Scout")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$500%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Scout.giveItems((Player) player);
                        Profile.scout.put(playerUUID, true);
                    } else if(kit.equals("Hunter")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$7500%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Hunter.giveItems((Player) player);
                        Profile.hunter.put(playerUUID, true);
                    } else if(kit.equals("Knight")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$5000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Knight.giveItems((Player) player);
                        Profile.knight.put(playerUUID, true);
                    } else if(kit.equals("Astronaut")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$500%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Astronaut.giveItems((Player) player);
                        Profile.astronaut.put(playerUUID, true);
                    } else if(kit.equals("Red Dragon")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$1000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        RedDragon.giveItems((Player) player);
                        Profile.reddragon.put(playerUUID, true);
                    } else if(kit.equals("Speleologist")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$5000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Speleologist.giveItems((Player) player);
                        Profile.speleologist.put(playerUUID, true);
                    } else if(kit.equals("Tim")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$10000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Tim.giveItems((Player) player);
                        Profile.tim.put(playerUUID, true);
                    } else if(kit.equals("Fisherman")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$12500%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Fisherman.giveItems((Player) player);
                        Profile.fisherman.put(playerUUID, true);
                    } else if (kit.equals("Paladin")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$15000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Paladin.giveItems((Player) player);
                        Profile.paladin.put(playerUUID, true);
                    } else if (kit.equals("Creepertamer")) {
                        player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou've been deducted %s$15000%s.", ChatColor.DARK_GRAY, ChatColor.RESET,
                                ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                                ChatColor.YELLOW));
                        Creepertamer.giveItems((Player) player);
                        Profile.playerKit.put(playerUUID, kit);
                        Profile.creepertamer.put(playerUUID, true);
                    }

                    ((Player) player).playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                    player.sendMessage(ChatColor.YELLOW + "You have received your " + ChatColor.GREEN + ChatColor.BOLD +
                            kit + ChatColor.RESET + ChatColor.YELLOW + " kit!");
                    Profile.playerPVPMode.put(playerUUID, true);
                } else {

                    player.sendMessage(String.format("%s[%s%s%sUltimatumPVP%s] %s%sYou have %sinsufficient %sfunds.", ChatColor.DARK_GRAY, ChatColor.RESET,
                            ChatColor.GOLD, ChatColor.BOLD, ChatColor.DARK_GRAY, ChatColor.RESET, ChatColor.YELLOW, ChatColor.RED,
                            ChatColor.YELLOW));
                }

                event.setCancelled(true);
                ((Player) player).closeInventory();

            } else if (im.getType() == Material.BARRIER) {
                event.setCancelled(true);
                ((Player) player).closeInventory();
            }
        }
    }
}
