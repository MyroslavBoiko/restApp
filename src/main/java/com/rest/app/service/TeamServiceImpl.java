package com.rest.app.service;

import com.rest.app.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    List<Team> teams = new ArrayList<>();

    @Autowired
    PlayerService playerService;

    public TeamServiceImpl() {
        teams.add(new Team(1, "Lobas"));
        teams.add(new Team(2, "Turvak"));
    }

    @Override
    public Team createTeam(Team team) {
        return teams.add(team) ? team : null;
    }

    @Override
    public List<Team> getTeams() {
        for (Team t : teams) {
            t.setPlayerList(playerService.getPlayersByTeamId(t.getId()));
        }
        return teams;
    }

    @Override
    public Team getTeamById(Integer id) {
        for (Team t : teams) {
            if(t.getId().equals(id)){
                t.setPlayerList(playerService.getPlayersByTeamId(t.getId()));
                return t;
            }
        }
        return null;
    }

    @Override
    public Team setTeamName(Integer teamId, String name) {
        for (Team t : teams) {
            if(t.getId().equals(teamId)){
                t.setName(name);
                t.setPlayerList(playerService.getPlayersByTeamId(t.getId()));
                return t;
            }
        }
        return null;
    }

    @Override
    public Team deleteTeam(Integer teamId) {
        Team team = null;
        for(Team t : teams){
            if(t.getId().equals(teamId)){
                t.setPlayerList(playerService.getPlayersByTeamId(t.getId()));
                team = t;
            }
        }
        return teams.remove(team) ? team: null;
    }
}
