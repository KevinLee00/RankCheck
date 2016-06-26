package com.example.user01.rankcheck;

import java.util.ArrayList;

public class CurrentGameData {
    public static ArrayList<String> playersNames = new ArrayList<>();
    public static ArrayList<String> playerIds = new ArrayList<>();

    public static ArrayList<String> championIds = new ArrayList<>();
    public static ArrayList<String> championImageUrls = new ArrayList<>();

    public static ArrayList<String> summonerSpell1 = new ArrayList<>();
    public static ArrayList<String> summonerSpell1Urls = new ArrayList<>();

    public static ArrayList<String> summonerSpell2 = new ArrayList<>();
    public static ArrayList<String> summonerSpell2Urls = new ArrayList<>();

    public static ArrayList<String> playerDivision = new ArrayList<>();
    public static ArrayList<String> playerTier = new ArrayList<>();

    public static int numOfPlayers = playersNames.size();


    public static void clearAllData() {
        playersNames.clear();
        playerIds.clear();
        championIds.clear();
        championImageUrls.clear();
        summonerSpell1.clear();
        summonerSpell1Urls.clear();
        summonerSpell2.clear();
        summonerSpell2Urls.clear();
        playerDivision.clear();
        playerTier.clear();
        numOfPlayers = 0;
    }
}
