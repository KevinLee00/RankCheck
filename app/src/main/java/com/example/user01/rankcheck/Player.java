package com.example.user01.rankcheck;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class Player implements ParentObject {
    private String name;
    private String id;
    private String championImageUrl;
    private String summonerSpell1Url;
    private String summonerSpell2Url;
    private String playerDivision;
    private String playerTier;
    private ArrayList<Rune> runes;
    private ArrayList<Mastery> masteries;

    Player() {
        this.name = null;
        this.id = null;
        this.championImageUrl = null;
        this.summonerSpell1Url = null;
        this.summonerSpell2Url = null;
        this.playerDivision = null;
        this.playerTier = null;
        this.runes = null;
        this.masteries = null;
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

    public String getChampionImageUrl() {
        return championImageUrl;
    }

    public void setChampionImageUrl(String championImageUrl) {
        this.championImageUrl = championImageUrl;
    }

    public String getSummonerSpell1Url() {
        return summonerSpell1Url;
    }

    public void setSummonerSpell1Url(String summonerSpell1Url) {
        this.summonerSpell1Url = summonerSpell1Url;
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

    public ArrayList<Rune> getRunes() {
        return runes;
    }

    public void setRunes(ArrayList<Rune> runes) {
        this.runes = runes;
    }

    public ArrayList<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(ArrayList<Mastery> masteries) {
        this.masteries = masteries;
    }

    @Override
    public List<Object> getChildObjectList() {
        return null;
    }

    @Override
    public void setChildObjectList(List<Object> list) {

    }
}
