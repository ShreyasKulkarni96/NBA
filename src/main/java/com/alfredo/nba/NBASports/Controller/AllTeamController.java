package com.alfredo.nba.NBASports.Controller;

import com.alfredo.nba.NBASports.Models.AllTeamWrapper;
import com.alfredo.nba.NBASports.ServiceImpl.AllTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/api/v1"})
@CrossOrigin
public class AllTeamController {
    @Autowired
    AllTeamServiceImpl allTeamServiceImpl;

    public AllTeamController() {

    }

    @GetMapping({"/get-all-teams"})
    public ResponseEntity<List<List<AllTeamWrapper>>> getAllTeams() throws Exception {
        List<List<AllTeamWrapper>> allTeamsList = this.allTeamServiceImpl.getAllTeams();
        return new ResponseEntity(allTeamsList, HttpStatus.OK);
    }
}
