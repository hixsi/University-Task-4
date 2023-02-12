package com.company.olympics;

public class Coach {
    private  String name;
    private int experience;
    private SportType sportType;

    public Coach(String name, int experience, SportType sportType) {
        this.name = name;
        this.experience = experience;
        this.sportType = sportType;
    }


    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public SportType getSportType() {
        return sportType;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", sportType=" + sportType +
                '}';
    }
}
