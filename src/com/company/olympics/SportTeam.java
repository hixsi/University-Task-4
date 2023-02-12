package com.company.olympics;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SportTeam {
    private String name;
    private double budget;
    private Coach coach;
    private SportType sportType;
    private Map<Sportsman,Double> sportsmanSumMap;

    public SportTeam(String name, double budget, Coach coach, SportType sportType) {
        this.name = name;
        this.budget = budget;
        this.coach = coach;
        this.sportType = sportType;
        this.sportsmanSumMap = new TreeMap<>();

    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public Coach getCoach() {
        return coach;
    }

    public SportType getSportType() {
        return sportType;
    }

    public Map<Sportsman, Double> getSportsmanSumMap() {
        return sportsmanSumMap;
    }

    public void addSportsman(Sportsman sportsman,Double sum){
        if(sportsman.getSportType().equals(this.sportType) && !this.sportsmanSumMap.keySet().contains(sportsman))
            this.sportsmanSumMap.put(sportsman,sum);
    }

    public static Comparator <SportTeam> ComparatorByCoachExp = new Comparator<SportTeam>() {
        @Override
        public int compare(SportTeam o1, SportTeam o2) {
        return  Integer.compare(o1.getCoach().getExperience(),o2.getCoach().getExperience());
    }
    };

    public static Comparator <SportTeam> ComparatorBySportType = (t1,t2) -> (Integer.compare(t1.getSportType().getCode(),t2.getSportType().getCode()));

    public static Comparator <SportTeam> ComparatorByBudget = (t1,t2) -> (Double.compare(t1.budget,t2.budget));

    public String toString() {
        return "SportTeam{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", coach=" + coach +
                ", sportType=" + sportType +
                ", sportsmanSumMap=" + sportsmanSumMap +
                '}';
    }
}
