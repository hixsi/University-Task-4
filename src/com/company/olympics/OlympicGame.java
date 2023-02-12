package com.company.olympics;

import java.util.*;

public class OlympicGame {
    private Date date;
    private String place;
    EnumMap<SportType,Integer> sportTypeMaxNumberParticipants;
    Map<SportTeam,Map<Sportsman, Role>> teamsParticipantsRoles;

    public OlympicGame(Date date, String place) {
        this.date = date;
        this.place = place;
        this.sportTypeMaxNumberParticipants = new EnumMap<>(SportType.class);
        this.teamsParticipantsRoles = new HashMap<>();
    }


    public void addTeam(SportTeam team){
        if(!teamsParticipantsRoles.keySet().contains(team))
            teamsParticipantsRoles.keySet().add(team);
    }




    public void addParticipant(SportTeam team, Sportsman sportsman){
        if(sportsman.getSportType().equals(team.getSportType()) && !team.getSportsmanSumMap().keySet().contains(sportsman) && !this.teamsParticipantsRoles.get(team).keySet().contains(sportsman))
            if(Collections.frequency(teamsParticipantsRoles.get(team).keySet(),true) < this.sportTypeMaxNumberParticipants.get(team.getSportType()))
                if(Collections.frequency(teamsParticipantsRoles.get(team).values(),true ) < team.getSportType().getMaxPlayers())
        {
            this.teamsParticipantsRoles.get(team).put(sportsman,Role.PLAYER);

        }
               else{

                    this.teamsParticipantsRoles.get(team).put(sportsman,Role.SUBSTITUTE);

                }
    }


    public void removeTeam(SportTeam sportTeam){

        this.teamsParticipantsRoles.remove(sportTeam);
    }


    public void removeTeamParticipant(Sportsman sportsman, SportTeam team){

        if(this.teamsParticipantsRoles.get(team).containsKey(sportsman)){
            if(this.teamsParticipantsRoles.get(team).get(sportsman).equals(SportType.valueOf("PLAYER"))){

                List <Sportsman> sportsmanList = new ArrayList<Sportsman>();

                Set <Map.Entry<Sportsman,Role>> sportsmanRoleEntry = this.teamsParticipantsRoles.get(team).entrySet();

                for(Map.Entry<Sportsman,Role> me: sportsmanRoleEntry){
                    if(me.getValue().equals(Role.SUBSTITUTE))
                        sportsmanList.add(me.getKey());
                }

                Collections.sort(sportsmanList);

                this.teamsParticipantsRoles.get(team).forEach((sportsman1,role)-> {
                    if(sportsman1.equals(sportsmanList.get(0)))
                        role = Role.PLAYER;
                });

          }

            this.teamsParticipantsRoles.get(team).remove(sportsman);

        }
    }

    public void showAllTeamsAndParticipants(){
        this.teamsParticipantsRoles.forEach((team,participants)-> System.out.println(team.getName() + participants.keySet()));

    }

    public void showMostExperiencedCoach(){
        System.out.println(Collections.max(this.teamsParticipantsRoles.keySet(),SportTeam.ComparatorByCoachExp).getCoach());

    }

    public void sortByTypeAndBudget(){
        List<SportTeam> sportTeamList = new ArrayList<>(this.teamsParticipantsRoles.keySet());

        Collections.sort(sportTeamList,SportTeam.ComparatorBySportType.thenComparing(SportTeam.ComparatorByBudget));
        System.out.println(sportTeamList);
    }








}
