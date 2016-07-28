package com.example.user01.rankcheck;

/**
 * Created by user01 on 6/27/2016.
 */
public class Mastery {
    String rank;
    String masteryId;

    public Mastery(String rank, String masteryId) {
        this.rank = rank;
        this.masteryId = masteryId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(String masteryId) {
        this.masteryId = masteryId;
    }
}
