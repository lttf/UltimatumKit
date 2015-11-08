package com.lttf.UltimatumKit.Kits;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by user on 6/11/2015.
 */
public class Scout {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // SWORD

        ItemStack sword = new ItemStack(Material.WOOD_SWORD);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.setDisplayName(String.format("%sScout Sword", ChatColor.GREEN));
        sword.setItemMeta(swordmeta);
        player.getPlayer().getInventory().setItem(0, sword);

        // HELMET

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.setDisplayName(String.format("%sScout Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.setDisplayName(String.format("%sScout Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // LEGGINGS

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.setDisplayName(String.format("%sScout Leggings", ChatColor.GREEN));
        leggings.setItemMeta(leggingsmeta);
        player.getEquipment().setLeggings(leggings);

        // BOOTS

        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.setDisplayName(String.format("%sScout Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sScout Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);

        // EFFECTS
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1 ));

    }

}
