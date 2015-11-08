package com.lttf.UltimatumKit.Profiles;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 6/11/2015.
 */
public class Profile {
    // Player Information
    public static Map<String, Integer> playerExperience = new HashMap<String, Integer>();
    public static Map<String, String> playerRank = new HashMap<String, String>();

    // Player PVP Statistics
    public static Map<String, Integer> playerKills = new HashMap<String, Integer>();
    public static Map<String, Integer> playerDeaths = new HashMap<String, Integer>();

    // Player Kit Information
    public static Map<String, Boolean> scout = new HashMap<String, Boolean>();
    public static Map<String, Boolean> hunter = new HashMap<String, Boolean>();
    public static Map<String, Boolean> knight = new HashMap<String, Boolean>();
    public static Map<String, Boolean> reddragon = new HashMap<String, Boolean>();
    public static Map<String, Boolean> horsetamer = new HashMap<String, Boolean>();
    public static Map<String, Boolean> speleologist = new HashMap<String, Boolean>();
    public static Map<String, Boolean> astronaut = new HashMap<String, Boolean>();
    public static Map<String, Boolean> tim = new HashMap<String, Boolean>();
    public static Map<String, Boolean> fisherman = new HashMap<String, Boolean>();
    public static Map<String, Boolean> paladin = new HashMap<String, Boolean>();
    public static Map<String, Boolean> creepertamer = new HashMap<String, Boolean>();

    // Player Currency
    public static Map<String, Double> playerBalance = new HashMap<String, Double>();

    // PVP Mode
    public static Map<String, Boolean> playerPVPMode = new HashMap<String, Boolean>();
    public static Map<String, String> playerKit = new HashMap<String, String>();
    public static Map<String, Boolean> playerSpectateMode = new HashMap<String, Boolean>();
}
