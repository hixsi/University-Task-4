package com.company.olympics;

public class Sportsman implements Comparable<Sportsman> {
    private String name;
    private SportType sportType;

    public Sportsman(String name, SportType sportType) {
        this.name = name;
        this.sportType = sportType;
    }

    public String getName() {
        return name;
    }

    public SportType getSportType() {
        return sportType;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "name='" + name + '\'' +
                ", sportType=" + sportType +
                '}';
    }


    @Override
    public int compareTo(Sportsman o) {
        return this.name.compareTo(o.name);
    }
}
