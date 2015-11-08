package com.lttf.UltimatumKit;

import com.lttf.UltimatumKit.Commands.Stats;
import com.lttf.UltimatumKit.Economy.Balance;
import com.lttf.UltimatumKit.Economy.Balance;
import com.lttf.UltimatumKit.Kits.Creepertamer;
import com.lttf.UltimatumKit.Kits.Scout;
import com.lttf.UltimatumKit.Listeners.*;
import com.lttf.UltimatumKit.Profiles.ProfileLoader;
import com.lttf.UltimatumKit.Profiles.ProfileSaver;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by user on 6/11/2015.
 */
public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        this.getServer().getPluginManager().registerEvents(this, this);
        logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");

        // Register Commands & Events
        registerEvents();
        registerCommands();

        // File Creation
        try {
            File userFolder = new File("./plugins/UltimatumKits/");
            if(!userFolder.exists()) {
                System.out.println("[UltimatumKits] Creating UltimatumKits folder.");
                userFolder.mkdir();
            }
        } catch(SecurityException exception) {
            System.out.println("[UltimatumKits] Unable to create folder 'Ultimatum Kits'");
            exception.printStackTrace();
        }
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new CommandEvent(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDamage(), this);
        pm.registerEvents(new PlayerInventoryClick(), this);
        pm.registerEvents(new PlayerMovement(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerSpawn(this), this);
        pm.registerEvents(new PlayerInteract(this), this);
        pm.registerEvents(new ProfileLoader(this), this);
        pm.registerEvents(new ProfileSaver(), this);
        pm.registerEvents(new PlayerItemDrop(), this);
        pm.registerEvents(new FoodLevelChange(), this);
        pm.registerEvents(new PlayerRespawn(), this);
        pm.registerEvents(new PlayerDeath(this), this);
        pm.registerEvents(new Creepertamer()    , this);
    }

    public void registerCommands() {
        getCommand("balance").setExecutor(new Balance());
        getCommand("stats").setExecutor(new Stats());
    }

    @Override
    public void onDisable() {

        for(Player online : Bukkit.getOnlinePlayers()){
            ProfileSaver.playerSaveData(online, online.getUniqueId().toString());
            online.kickPlayer(String.format("%s[%sSERVER%s] %sShutdown/Reload", ChatColor.DARK_GRAY, ChatColor.GOLD, ChatColor.DARK_GRAY, ChatColor.RED));
        }

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();
        logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
    }

}
