package com.rest.app.controller;

import com.rest.app.model.Player;
import com.rest.app.model.Team;
import com.rest.app.service.PlayerService;
import com.rest.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
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
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Integer id) {
        Team team = teamService.getTeamById(id);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> createTeam(@RequestParam(value = "id") Integer id,
                                           @RequestParam(value = "name") String name) {
        Team team = teamService.createTeam(new Team(id,name));

        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> setTeamName(@RequestParam(value = "id") Integer id,
                                            @RequestParam(value = "name") String name) {
        Team team = teamService.setTeamName(id,name);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Team> deleteTeam(@PathVariable(value = "id") Integer id) {
        Team team = teamService.deleteTeam(id);
        if(team == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/players", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable(value = "id") Integer id) {
        List<Player> players = playerService.getPlayersByTeamId(id);
        if(players== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamId}/players", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> createPlayer(@PathVariable(value = "teamId") Integer teamId,
                                               @RequestParam(value = "id") Integer id,
                                               @RequestParam(value = "name") String name) {
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
    public ResponseEntity<Player> getPlayersById(@PathVariable(value = "id") Integer id) {
        Player player = playerService.getPlayerById(id);
        if(player== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> setPlayerName(@RequestParam(value = "id") Integer id,
                                                @RequestParam(value = "name") String name) {
        Player player = playerService.setPlayerName(id, name);
        if(player== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> deletePlayer(@PathVariable(value = "id") Integer id) {
        Player player = playerService.deletePlayer(id);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

}
