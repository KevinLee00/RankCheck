package com.example.user01.rankcheck;

/**
 * Created by user01 on 6/25/2016.
 */
public class Player {
    private String name;
    private String id;
    private String championId;
    private String championImageUrl;
    private String summonerSpell1;
    private String summonerSpell1Url;
    private String summonerSpell2;
    private String summonerSpell2Url;
    private String playerDivision;
    private String playerTier;

    Player() {
        this.name = "";
        this.id = "";
        this.championId = "";
        this.championImageUrl = "";
        this.summonerSpell1 = "";
        this.summonerSpell1Url = null;
        this.summonerSpell2 = null;
        this.summonerSpell2Url = null;
        this.playerDivision = null;
        this.playerTier = null;

    }
    public String getPlayerTier() {
        return playerTier;
    }

    public void setPlayerTier(String playerTier) {
        this.playerTier = playerTier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public String getChampionImageUrl() {
        return championImageUrl;
    }

    public void setChampionImageUrl(String championImageUrl) {
        this.championImageUrl = championImageUrl;
    }

    public String getSummonerSpell1() {
        return summonerSpell1;
    }

    public void setSummonerSpell1(String summonerSpell1) {
        this.summonerSpell1 = summonerSpell1;
    }

    public String getSummonerSpell1Url() {
        return summonerSpell1Url;
    }

    public void setSummonerSpell1Url(String summonerSpell1Url) {
        this.summonerSpell1Url = summonerSpell1Url;
    }

    public String getSummonerSpell2() {
        return summonerSpell2;
    }

    public void setSummonerSpell2(String summonerSpell2) {
        this.summonerSpell2 = summonerSpell2;
    }

    public String getSummonerSpell2Url() {
        return summonerSpell2Url;
    }

    public void setSummonerSpell2Url(String summonerSpell2Url) {
        this.summonerSpell2Url = summonerSpell2Url;
    }

    public String getPlayerDivision() {
        return playerDivision;
    }

    public void setPlayerDivision(String playerDivision) {
        this.playerDivision = playerDivision;
    }
}
