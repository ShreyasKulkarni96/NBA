package com.alfredo.nba.NBASports.Service;

import com.alfredo.nba.NBASports.Models.HomeTeam;

public interface HomeTeamService {
    HomeTeam getHomeTeamById(Long id) throws Exception;
}
