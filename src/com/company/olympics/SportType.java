package com.company.olympics;

public enum SportType implements Comparable<SportType> {
    BASKETBALL(6,1), VOLLEYBALL(6,2), FOOTBALL(11,3);

    int maxPlayers;
    int code;

    SportType(int maxParticipants, int code) {
        this.maxPlayers = maxParticipants;
        this.code = code;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getCode() {
        return code;
    }
}
