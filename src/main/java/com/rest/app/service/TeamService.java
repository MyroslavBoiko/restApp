package com.rest.app.service;

import com.rest.app.model.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team);

    List<Team> getTeams();

    Team getTeamById(Integer id);

    Team setTeamName(Integer teamId, String name);

    Team deleteTeam(Integer teamId);
}
