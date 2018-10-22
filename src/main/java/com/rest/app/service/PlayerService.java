package com.rest.app.service;

import com.rest.app.model.Player;

import java.util.List;

public interface PlayerService {

    Player createPlayer(Player player);

    List<Player> getPlayers();

    List<Player> getPlayersByTeamId(Integer teamId);

    Player getPlayerById(Integer id);

    Player setPlayerName(Integer playerId, String name);

    Player deletePlayer(Integer playerId);
}
