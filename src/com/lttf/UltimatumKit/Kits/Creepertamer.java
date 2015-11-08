package com.lttf.UltimatumKit.Kits;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by user on 7/11/2015.
 */
public class Creepertamer implements Listener {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // SWORD

        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        swordmeta.setDisplayName(String.format("%sCreepertamer Sword", ChatColor.GREEN));
        sword.setItemMeta(swordmeta);
        player.getPlayer().getInventory().setItem(0, sword);

        // HELMET

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        helmetmeta.setDisplayName(String.format("%sCreepertamer Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);
        chestplatemeta.setDisplayName(String.format("%sCreepertamer Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // LEGGINGS

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.setDisplayName(String.format("%sCreepertamer Leggings", ChatColor.GREEN));
        leggings.setItemMeta(leggingsmeta);
        player.getEquipment().setLeggings(leggings);

        // BOOTS

        ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.setDisplayName(String.format("%sCreepertamer Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sCreepertamer Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);

    }


    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if(event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            String playerUUID = player.getUniqueId().toString();
            ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
            ItemMeta fishingrodmeta = fishingrod.getItemMeta();
            fishingrodmeta.setDisplayName(String.format("%sCreepertamer Fishing Rod", ChatColor.GREEN));
            fishingrod.setItemMeta(fishingrodmeta);
            if(Profile.playerKit.get(playerUUID).equals("Creepertamer")){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3, 10));
                    Bukkit.getWorld("world").createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 3.0F, false, false);
            }
        }
    }
}
