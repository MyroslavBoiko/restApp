package com.rest.app.service;

import com.rest.app.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    List<Player> players = new ArrayList<>();

    public PlayerServiceImpl() {
        players.add(new Player(1,"Torin",1));
        players.add(new Player(2,"Vorel",2));
        players.add(new Player(3,"Bopes",1));
        players.add(new Player(4,"Molar",2));
    }

    @Override
    public Player createPlayer(Player player) {
        return players.add(player) ? player : null;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public List<Player> getPlayersByTeamId(Integer teamId) {
        List<Player> result = new ArrayList<>();
        for (Player p : players) {
            if(p.getTeamID().equals(teamId)){
                result.add(p);
            }
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public Player getPlayerById(Integer id) {
        for (Player p : players) {
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public Player setPlayerName(Integer playerId, String name) {
        for (Player p : players) {
            if(p.getId().equals(playerId)){
                p.setName(name);
                return p;
            }
        }
        return null;
    }

    @Override
    public Player deletePlayer(Integer playerId) {
        Player team = null;
        for(Player t : players){
            if(t.getId().equals(playerId)){
                team = t;
            }
        }
        return players.remove(team) ? team: null;
    }
}
