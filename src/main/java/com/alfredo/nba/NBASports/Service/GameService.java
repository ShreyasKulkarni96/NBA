package com.alfredo.nba.NBASports.Service;

import com.alfredo.nba.NBASports.Models.Game;

import java.util.List;

public interface GameService {
    List<Game> getAllGames() throws Exception;

    List<Game> getAllGamesByDate(String date) throws Exception;

    Game getAllGamesById(Long id) throws Exception;
}
