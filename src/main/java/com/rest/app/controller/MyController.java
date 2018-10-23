package com.rest.app.controller;

import com.rest.app.model.Player;
import com.rest.app.model.Team;
import com.rest.app.service.PlayerService;
import com.rest.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/teams")
public class MyController {

    @Autowired
    TeamService teamService;

    @Autowired
    PlayerService playerService;


    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamService.getTeams();
        if(teams == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teams,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {
        Team team = teamService.getTeamById(id);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/create/id={id}&name={name}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> createTeam(@PathVariable Integer id, @PathVariable String name) {
        Team team = teamService.createTeam(new Team(id,name));

        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/id={id}&name={name}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> setTeamName(@PathVariable Integer id, @PathVariable String name) {
        Team team = teamService.setTeamName(id,name);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> deleteTeam(@PathVariable Integer id) {
        Team team = teamService.deleteTeam(id);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/players", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable Integer id) {
        List<Player> players = playerService.getPlayersByTeamId(id);
        if(players== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamId}/players/create/id={id}&name={name}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> createPlayer(@PathVariable Integer teamId, @PathVariable Integer id, @PathVariable String name) {
        Player player = playerService.createPlayer(new Player(id,name, teamId));

        if(player == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        if(players== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayersById(@PathVariable Integer id) {
        Player player = playerService.getPlayerById(id);
        if(player== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/players/update/id={id}&name={name}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> setPlayerName(@PathVariable Integer id, @PathVariable String name) {
        Player player = playerService.setPlayerName(id, name);
        if(player== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/players/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> deletePlayer(@PathVariable Integer id) {
        Player player = playerService.deletePlayer(id);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

}
