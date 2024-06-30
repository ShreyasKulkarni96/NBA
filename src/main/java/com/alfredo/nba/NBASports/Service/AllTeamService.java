package com.alfredo.nba.NBASports.Service;

import com.alfredo.nba.NBASports.Models.AllTeamWrapper;

import java.util.List;

public interface AllTeamService {
    List<List<AllTeamWrapper>> getAllTeams() throws Exception;
}
