package com.example.thecoffeehouse.domain.user.valueobject.rankmembership;

public enum LevelRankMembership {
    NEW,
    COPPPER,
    SILVER,
    GOLD,
    DIAMOND;

    public static int getValue(LevelRankMembership levelRankMembership) {
        int value = 0;
          switch (levelRankMembership) {
            case NEW:
                value = 1;
            case COPPPER:
                value = 2;
            case SILVER:
                value = 3;
            case GOLD:
                value = 4;
            case DIAMOND:
                value = 5;
        }
        return value;
    }


    public static LevelRankMembership getLevelRankMembership(int value) {
        LevelRankMembership levelRankMembership = null;
        switch (value) {
            case 1:
                levelRankMembership = LevelRankMembership.NEW;
            case 2:
                levelRankMembership = LevelRankMembership.COPPPER;
            case 3:
                levelRankMembership = LevelRankMembership.SILVER;
            case 4:
                levelRankMembership = LevelRankMembership.GOLD;
            case 5:
                levelRankMembership = LevelRankMembership.DIAMOND;
        }
        return levelRankMembership;
    }
}
