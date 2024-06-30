package com.alfredo.nba.NBASports.Controller;

import com.alfredo.nba.NBASports.Models.HomeTeam;
import com.alfredo.nba.NBASports.ServiceImpl.HomeTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1"})
@CrossOrigin
public class HomeTeamController {

    @Autowired
    HomeTeamServiceImpl homeTeamService;

    public HomeTeamController () {
    }

    @GetMapping({"/get-team-by-id/{id}"})
    public ResponseEntity<HomeTeam> getHomeTeamById(@PathVariable Long id) throws Exception {
        HomeTeam homeTeam = this.homeTeamService.getHomeTeamById(id);
        return new ResponseEntity(homeTeam, HttpStatus.OK);
    }
}
