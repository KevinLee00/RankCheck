package com.example.user01.rankcheck;

import java.util.ArrayList;

/**
 * Created by user01 on 6/21/2016.
 */
public class CurrentGameData {
    public static ArrayList<String> playersNames = new ArrayList<>();
    public static ArrayList<String> playerIds = new ArrayList<>();
    public static ArrayList<String> championIds = new ArrayList<>();
    public static ArrayList<String> summonerSpell1 = new ArrayList<>();
    public static ArrayList<String> summonerSpell2 = new ArrayList<>();
    public static ArrayList<String> playerDivision = new ArrayList<>();
    public static ArrayList<String> playerTier = new ArrayList<>();

    public static void clearAllData() {
        playersNames.clear();
        playerIds.clear();
        championIds.clear();
        summonerSpell1.clear();
        summonerSpell2.clear();
        playerDivision.clear();
        playerTier.clear();
    }
}
