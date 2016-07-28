package com.example.user01.rankcheck;


public class Rune {
    private String runeId;
    private String count;

    Rune(String runeId, String count) {
        this.runeId = runeId;
        this.count = count;
    }

    public String getRuneId() {
        return runeId;
    }

    public void setRuneId(String runeId) {
        this.runeId = runeId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


}
