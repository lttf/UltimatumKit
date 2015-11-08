package com.lttf.UltimatumKit.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by user on 7/11/2015.
 */
public class Fisherman {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // HELMET

        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        helmetmeta.setDisplayName(String.format("%sFisherman Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestplatemeta.setDisplayName(String.format("%sFisherman Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // LEGGINGS

        ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        leggingsmeta.setDisplayName(String.format("%sFisherman Leggings", ChatColor.GREEN));
        leggings.setItemMeta(leggingsmeta);
        player.getEquipment().setLeggings(leggings);

        // BOOTS

        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        bootsmeta.setDisplayName(String.format("%sFisherman Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 10, true);
        fishingrodmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        fishingrodmeta.setDisplayName(String.format("%sFisher Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(0, fishingrod);

    }

}
