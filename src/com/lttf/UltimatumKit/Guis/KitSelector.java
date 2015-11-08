package com.lttf.UltimatumKit.Guis;

import com.lttf.UltimatumKit.Profiles.Profile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by user on 6/11/2015.
 */
public class KitSelector {

    public static void openKitSelectorGUI(Player player) {
        String playerUUID = player.getUniqueId().toString();
        Inventory inv = Bukkit.createInventory(null, 54, "FFA Kit Selection");

        // KITS
        // Horsetamer Kit
        ItemStack horsetamer = new ItemStack(Material.MONSTER_EGG, 1, (short) 100);
        ItemMeta horsetamermeta = horsetamer.getItemMeta();
        horsetamermeta.setDisplayName(ChatColor.GREEN + "Horsetamer");
        List<String> horsetamerlore = new ArrayList<String>();
        horsetamerlore.add(ChatColor.GRAY + "It's a real horse I ride!");
        horsetamerlore.add("");
        horsetamerlore.add(ChatColor.DARK_GRAY + "1 Iron Helmet");
        horsetamerlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate");
        horsetamerlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        horsetamerlore.add(ChatColor.DARK_GRAY + "1 Diamond Boots (Protection II)");
        horsetamerlore.add(ChatColor.DARK_GRAY + "1 Diamond Axe");
        horsetamerlore.add("");
        horsetamerlore.add(String.format("%s%s$1000", ChatColor.GOLD, ChatColor.BOLD));
        horsetamermeta.setLore(horsetamerlore);
        horsetamer.setItemMeta(horsetamermeta);

        // Scout Kit
        ItemStack scout = new ItemStack(Material.FEATHER);
        ItemMeta scoutmeta = scout.getItemMeta();
        scoutmeta.setDisplayName(ChatColor.GREEN + "Scout");
        List<String> scoutlore = new ArrayList<String>();
        scoutlore.add(ChatColor.GRAY + "Gotta go fast!");
        scoutlore.add("");
        scoutlore.add(ChatColor.DARK_GRAY + "1 Leather Helmet");
        scoutlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate");
        scoutlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        scoutlore.add(ChatColor.DARK_GRAY + "1 Chain Boots");
        scoutlore.add(ChatColor.DARK_GRAY + "1 Wood Sword (Unbreaking I)");
        scoutlore.add(ChatColor.DARK_GRAY + "Infinite Speed II");
        scoutlore.add("");
        if(Profile.scout.get(playerUUID)) {
            scoutlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            scoutlore.add(String.format("%s%s$500", ChatColor.GOLD, ChatColor.BOLD));
        }
        scoutmeta.setLore(scoutlore);
        scout.setItemMeta(scoutmeta);

        // Astronaut Kit
        ItemStack astronaut = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta astronautmeta = astronaut.getItemMeta();
        astronautmeta.setDisplayName(ChatColor.GREEN + "Astronaut");
        List<String> astronautlore = new ArrayList<String>();
        astronautlore.add(ChatColor.GRAY + "One mini step for man!");
        astronautlore.add("");
        astronautlore.add(ChatColor.DARK_GRAY + "1 Chainmail Helmet (Blast prot. III)");
        astronautlore.add(ChatColor.DARK_GRAY + "1 Chainmail Chestplate");
        astronautlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        astronautlore.add(ChatColor.DARK_GRAY + "1 Iron Boots (Feather falling X)");
        astronautlore.add(ChatColor.DARK_GRAY + "1 Wood Sword");
        astronautlore.add("");
        if(Profile.astronaut.get(playerUUID)) {
            astronautlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            astronautlore.add(String.format("%s%s$500", ChatColor.GOLD, ChatColor.BOLD));
        }
        astronautmeta.setLore(astronautlore);
        astronaut.setItemMeta(astronautmeta);

        // Knight Kit
        ItemStack knight = new ItemStack(Material.WOOD_SWORD);
        ItemMeta knightmeta = astronaut.getItemMeta();
        knightmeta.setDisplayName(ChatColor.GREEN + "Knight");
        List<String> knightlore = new ArrayList<String>();
        knightlore.add(ChatColor.GRAY + "Keep fighting!");
        knightlore.add("");
        knightlore.add(ChatColor.DARK_GRAY + "1 Gold Helmet");
        knightlore.add(ChatColor.DARK_GRAY + "1 Gold Chestplate");
        knightlore.add(ChatColor.DARK_GRAY + "1 Gold Leggings");
        knightlore.add(ChatColor.DARK_GRAY + "1 Gold Boots (Protection II)");
        knightlore.add(ChatColor.DARK_GRAY + "1 Iron Sword");
        knightlore.add("");
        if(Profile.knight.get(playerUUID)) {
            knightlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            knightlore.add(String.format("%s%s$7500", ChatColor.GOLD, ChatColor.BOLD));
        }
        knightmeta.setLore(knightlore);
        knight.setItemMeta(knightmeta);

        // Red Dragon Kit
        ItemStack reddragon = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta reddragonmeta = reddragon.getItemMeta();
        reddragonmeta.setDisplayName(ChatColor.GREEN + "Red Dragon");
        List<String> reddragonlore = new ArrayList<String>();
        reddragonlore.add(ChatColor.GRAY + "I'm on fire!");
        reddragonlore.add("");
        reddragonlore.add(ChatColor.DARK_GRAY + "1 Diamond Helmet (Fire Prot II)");
        reddragonlore.add(ChatColor.DARK_GRAY + "1 Chain Chestplate (Fire Prot III)");
        reddragonlore.add(ChatColor.DARK_GRAY + "1 Chain Leggings (Fire Prot I)");
        reddragonlore.add(ChatColor.DARK_GRAY + "1 Iron Boots (Projectile Prot II)");
        reddragonlore.add(ChatColor.DARK_GRAY + "1 Stone Sword");
        reddragonlore.add("");
        if(Profile.reddragon.get(playerUUID)) {
            reddragonlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            reddragonlore.add(String.format("%s%s$1000", ChatColor.GOLD, ChatColor.BOLD));
        }
        reddragonmeta.setLore(reddragonlore);
        reddragon.setItemMeta(reddragonmeta);

        // Tim Kit
        ItemStack tim = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta timmeta = tim.getItemMeta();
        timmeta.setDisplayName(ChatColor.GREEN + "Tim the Enchanter");
        List<String> timlore = new ArrayList<String>();
        timlore.add(ChatColor.GRAY + "Can I enchant anything I want?");
        timlore.add("");
        timlore.add(ChatColor.DARK_GRAY + "1 Gold Helmet");
        timlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate");
        timlore.add(ChatColor.DARK_GRAY + "1 Diamond Leggings");
        timlore.add(ChatColor.DARK_GRAY + "1 Iron Boots");
        timlore.add(ChatColor.DARK_GRAY + "12 Experience Bottles");
        timlore.add(ChatColor.DARK_GRAY + "1 Stone Sword");
        timlore.add("");
        if(Profile.tim.get(playerUUID)) {
            timlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            timlore.add(String.format("%s%s$10000", ChatColor.GOLD, ChatColor.BOLD));
        }
        timmeta.setLore(timlore);
        tim.setItemMeta(timmeta);

        // Fisherman Kit
        ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishermanmeta = fisherman.getItemMeta();
        fishermanmeta.setDisplayName(ChatColor.GREEN + "Fisherman");
        List<String> fishermanlore = new ArrayList<String>();
        fishermanlore.add(ChatColor.GRAY + "Fishing is Kool!");
        fishermanlore.add("");
        fishermanlore.add(ChatColor.DARK_GRAY + "1 Chain Helmet (Unbreaking III)");
        fishermanlore.add(ChatColor.DARK_GRAY + "1 Chain Chestplate (Prot I)");
        fishermanlore.add(ChatColor.DARK_GRAY + "1 Chain Leggings (Unbreaking I)");
        fishermanlore.add(ChatColor.DARK_GRAY + "1 Chain Boots (Prot I)");
        fishermanlore.add(ChatColor.DARK_GRAY + "1 Fishing Rod (Sharpness IV)");
        fishermanlore.add("");
        if(Profile.fisherman.get(playerUUID)) {
            fishermanlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            fishermanlore.add(String.format("%s%s$12500", ChatColor.GOLD, ChatColor.BOLD));
        }
        fishermanmeta.setLore(fishermanlore);
        fisherman.setItemMeta(fishermanmeta);

        // Armorer Kit
        ItemStack armorer = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta armorermeta = armorer.getItemMeta();
        armorermeta.setDisplayName(ChatColor.GREEN + "Armorer");
        List<String> armorerlore = new ArrayList<String>();
        armorerlore.add(ChatColor.GRAY + "I take no damage!");
        armorerlore.add("");
        armorerlore.add(ChatColor.DARK_GRAY + "1 Leathetr Helmet (Projectile Prot V, Prot II, Unbreaking X)");
        armorerlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate (Prot IV, Unbreaking X");
        armorerlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings (Fire Prot X, Prot IV, Unbreaking X");
        armorerlore.add(ChatColor.DARK_GRAY + "1 Stone Sword");
        armorerlore.add("");
        armorerlore.add(String.format("%s%s$10000", ChatColor.GOLD, ChatColor.BOLD));
        armorermeta.setLore(armorerlore);
        armorer.setItemMeta(armorermeta);

        // Speleologsit Kit
        ItemStack speleologist = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta speleologistmeta = speleologist.getItemMeta();
        speleologistmeta.setDisplayName(ChatColor.GREEN + "Speleologist");
        List<String> speleologistlore = new ArrayList<String>();
        speleologistlore.add(ChatColor.GRAY + "Someone who likes to mine!");
        speleologistlore.add("");
        speleologistlore.add(ChatColor.DARK_GRAY + "1 Diamond Helmet (Prot I)");
        speleologistlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate (Prot I)");
        speleologistlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings (Prot I)");
        speleologistlore.add(ChatColor.DARK_GRAY + "1 Iron Boots (Projectile Prot I)");
        speleologistlore.add(ChatColor.DARK_GRAY + "1 Diamond Pickaxe (Sharp II)");
        speleologistlore.add("");
        if(Profile.speleologist.get(playerUUID)) {
            speleologistlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            speleologistlore.add(String.format("%s%s$5000", ChatColor.GOLD, ChatColor.BOLD));
        }
        speleologistmeta.setLore(speleologistlore);
        speleologist.setItemMeta(speleologistmeta);

        // Shadowknight Kiit
        ItemStack shadow = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta shadowmeta = shadow.getItemMeta();
        shadowmeta.setDisplayName(ChatColor.GREEN + "ShadowKnight");
        List<String> shadowlore = new ArrayList<String>();
        shadowlore.add(ChatColor.GRAY + "I am the BATMAN!");
        shadowlore.add("");
        shadowlore.add(ChatColor.DARK_GRAY + "1 Wither Skull (Prot V)");
        shadowlore.add(ChatColor.DARK_GRAY + "1 Leather Chestplate (Prot I)");
        shadowlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings (Prot I)");
        shadowlore.add(ChatColor.DARK_GRAY + "1 Leather Boots (Prot I)");
        shadowlore.add(ChatColor.DARK_GRAY + "1 Stone Sword (Unbreaking I)");
        shadowlore.add("");
        shadowlore.add(String.format("%s%s$7500", ChatColor.GOLD, ChatColor.BOLD));
        shadowmeta.setLore(shadowlore);
        shadow.setItemMeta(shadowmeta);

        // Hunter Kit
        ItemStack hunter = new ItemStack(Material.BOW, 1);
        ItemMeta huntermeta = hunter.getItemMeta();
        huntermeta.setDisplayName(ChatColor.GREEN + "Hunter");
        List<String> hunterlore = new ArrayList<String>();
        hunterlore.add(ChatColor.GRAY + "You can call me Robin Hood");
        hunterlore.add("");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Gold Helmet");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Chain Chestplate");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Iron Boots");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Stone Sword (Unbreaking I)");
        hunterlore.add(ChatColor.DARK_GRAY + "1 Bow (Power I)");
        hunterlore.add("");
        if(Profile.hunter.get(playerUUID)) {
            hunterlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            hunterlore.add(String.format("%s%s$7500", ChatColor.GOLD, ChatColor.BOLD));
        }
        huntermeta.setLore(hunterlore);
        hunter.setItemMeta(huntermeta);

        // Paladin Kit
        ItemStack paladin = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta paladinmeta = paladin.getItemMeta();
        paladinmeta.setDisplayName(ChatColor.GREEN + "Paladin");
        List<String> paladinlore = new ArrayList<String>();
        paladinlore.add(ChatColor.GRAY + "I am for the people!");
        paladinlore.add("");
        paladinlore.add(ChatColor.DARK_GRAY + "1 Iron Helmet (Unbreaking I)");
        paladinlore.add(ChatColor.DARK_GRAY + "1 Iron Chestplate (Prot I)");
        paladinlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        paladinlore.add(ChatColor.DARK_GRAY + "1 Leather Boots");
        paladinlore.add(ChatColor.DARK_GRAY + "1 Stone Sword (Unbreaking I)");
        paladinlore.add(ChatColor.DARK_GRAY + "Absorption on kill");
        paladinlore.add("");
        if(Profile.paladin.get(playerUUID)) {
            paladinlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            paladinlore.add(String.format("%s%s$15000", ChatColor.GOLD, ChatColor.BOLD));
        }
        paladinmeta.setLore(paladinlore);
        paladin.setItemMeta(paladinmeta);

        // Creepertamer Kit
        ItemStack creepertamer = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta creepertamermeta = creepertamer.getItemMeta();
        creepertamermeta.setDisplayName(ChatColor.GREEN + "Creepertamer");
        List<String> creepertamerlore = new ArrayList<String>();
        creepertamerlore.add(ChatColor.GRAY + "Creepers raised me as their own");
        creepertamerlore.add("");
        creepertamerlore.add(ChatColor.DARK_GRAY + "1 Leather Helmet (Unbreaking I)");
        creepertamerlore.add(ChatColor.DARK_GRAY + "1 Diamond Chestplate (Blast Prot X)");
        creepertamerlore.add(ChatColor.DARK_GRAY + "1 Leather Leggings");
        creepertamerlore.add(ChatColor.DARK_GRAY + "1 Gold Boots");
        creepertamerlore.add(ChatColor.DARK_GRAY + "1 Stone Sword (Unbreaking I)");
        creepertamerlore.add(ChatColor.DARK_GRAY + "Creeper Explosion on kill");
        creepertamerlore.add("");
        if(Profile.creepertamer.get(playerUUID)) {
            creepertamerlore.add(String.format("%s%sUNLOCKED", ChatColor.GREEN, ChatColor.BOLD));
        } else {
            creepertamerlore.add(String.format("%s%s$15000", ChatColor.GOLD, ChatColor.BOLD));
        }
        creepertamermeta.setLore(creepertamerlore);
        creepertamer.setItemMeta(creepertamermeta);

        // Filler
        ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.BLACK.getData());
        ItemMeta fillermeta = filler.getItemMeta();
        fillermeta.setDisplayName(String.format("%s%sUltimatumPVP", ChatColor.GOLD, ChatColor.BOLD));
        List<String> fillerlore = new ArrayList<String>();
        fillerlore.add("");
        fillerlore.add(String.format("%sSelect/Purchase a Kit", ChatColor.GRAY));
        fillerlore.add("");
        fillermeta.setLore(fillerlore);
        filler.setItemMeta(fillermeta);

        // FFA Data
        ItemStack pvpdata = new ItemStack(Material.BOOK, 1);
        ItemMeta pvpdatameta = pvpdata.getItemMeta();
        pvpdatameta.setDisplayName(String.format("%s%sInformation:", ChatColor.RED, ChatColor.BOLD));
        List<String> pvpdatalore = new ArrayList<String>();
        pvpdatalore.add("");
        pvpdatalore.add(String.format("%s1 Kill Streak - %s2 Coins", ChatColor.GRAY, ChatColor.GOLD));
        pvpdatalore.add(String.format("%s2 Kill Streak - %s4 Coins", ChatColor.GRAY, ChatColor.GOLD));
        pvpdatalore.add(String.format("%s5 Kill Streak - %s10 Coins", ChatColor.GRAY, ChatColor.GOLD));
        pvpdatalore.add(String.format("%s10 Kill Streak - %s20 Coins", ChatColor.GRAY, ChatColor.GOLD));
        pvpdatalore.add(String.format("%s20 Kill Streak - %s50 Coins", ChatColor.GRAY, ChatColor.GOLD));
        pvpdatalore.add("");
        pvpdatameta.setLore(pvpdatalore);
        pvpdata.setItemMeta(pvpdatameta);

        // INVENTORY PLACEMENT
        // KITS
        inv.setItem(20, scout);
        inv.setItem(21, astronaut);
        inv.setItem(22, reddragon);
        inv.setItem(23, speleologist);
        inv.setItem(24, knight);
        inv.setItem(29, hunter);
        inv.setItem(30, tim);
        inv.setItem(31, fisherman);
        inv.setItem(32, paladin);
        inv.setItem(33, creepertamer);

        //BORDER
        inv.setItem(0, filler);
        inv.setItem(1, filler);
        inv.setItem(2, filler);
        inv.setItem(3, filler);
        inv.setItem(4, filler);
        inv.setItem(5, filler);
        inv.setItem(6, filler);
        inv.setItem(7, filler);
        inv.setItem(8, filler);
        inv.setItem(9, filler);
        inv.setItem(17, filler);
        inv.setItem(18, filler);
        inv.setItem(26, filler);
        inv.setItem(27, filler);
        inv.setItem(35, filler);
        inv.setItem(36, filler);
        inv.setItem(44, filler);
        inv.setItem(45, filler);
        inv.setItem(46, filler);
        inv.setItem(47, filler);
        inv.setItem(48, filler);
        inv.setItem(50, filler);
        inv.setItem(51, filler);
        inv.setItem(52, filler);
        inv.setItem(53, filler);

        // FFA INFORMATION
        inv.setItem(49, pvpdata);

        player.openInventory(inv);
    }

}
