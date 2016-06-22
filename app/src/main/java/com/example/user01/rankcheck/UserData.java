package com.example.user01.rankcheck;

/**
 * Created by user01 on 6/18/2016.
 */
public class UserData {

    private static String SummonerName;
    private static String SummonerId;

    public static void setSummonerId(String id) {
        UserData.SummonerId = id;
    }

    public static void setSummonerName(String name) {
        UserData.SummonerName = name;
    }

    public static String getSummonerName() {
        return UserData.SummonerName;
    }

    public static String getSummonerId() {
        return UserData.SummonerId;
    }
}
