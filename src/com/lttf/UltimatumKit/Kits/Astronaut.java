package com.lttf.UltimatumKit.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by user on 6/11/2015.
 */
public class Astronaut {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // SWORD

        ItemStack sword = new ItemStack(Material.WOOD_SWORD);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.setDisplayName(String.format("%sAstronaut Sword", ChatColor.GREEN));
        sword.setItemMeta(swordmeta);
        player.getPlayer().getInventory().setItem(0, sword);

        // HELMET

        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
        helmetmeta.setDisplayName(String.format("%sAstronaut Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.setDisplayName(String.format("%sAstronaut Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // LEGGINGS

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.setDisplayName(String.format("%sAstronaut Leggings", ChatColor.GREEN));
        leggings.setItemMeta(leggingsmeta);
        player.getEquipment().setLeggings(leggings);

        // BOOTS

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
        bootsmeta.setDisplayName(String.format("%sAstronaut Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sAstronaut Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);

    }

}
