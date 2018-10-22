package com.rest.app.model;

public class Player {
    private Integer id;
    private String name;
    private Integer teamID;

    public Player() {
    }

    public Player(Integer id, String name, Integer teamID) {
        this.id = id;
        this.name = name;
        this.teamID = teamID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }
}
