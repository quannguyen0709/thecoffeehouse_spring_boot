package com.example.thecoffeehouse.domain.user.valueobject.rankmembership;

public enum LevelRankMembership {
    NEW,
    COPPPER,
    SILVER,
    GOLD,
    DIAMOND;

    public static int getValue(String levelRankMembership) {
        String a= LevelRankMembership.NEW.name();
        if(levelRankMembership.equals(LevelRankMembership.NEW.toString())) {return 1;}
        if(levelRankMembership.equals(LevelRankMembership.COPPPER.toString())) {return 2;}
        if(levelRankMembership.equals(LevelRankMembership.SILVER.toString())) {return 3;}
        if(levelRankMembership.equals(LevelRankMembership.GOLD.toString())) {return  4;}
        if(levelRankMembership.equals(LevelRankMembership.DIAMOND.toString())) {return 5;}
        return 0;
    }


    public static LevelRankMembership getLevelRankMembership(int value) {
        LevelRankMembership levelRankMembership = null;
        switch (value) {
            case 1:
                return LevelRankMembership.NEW;
            case 2:
                return levelRankMembership = LevelRankMembership.COPPPER;
            case 3:
                return levelRankMembership = LevelRankMembership.SILVER;
            case 4:
                return levelRankMembership = LevelRankMembership.GOLD;
            case 5:
                return levelRankMembership = LevelRankMembership.DIAMOND;
        }
        return levelRankMembership;
    }
}
