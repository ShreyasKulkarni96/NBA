package com.alfredo.nba.NBASports.Controller;

import com.alfredo.nba.NBASports.Models.Game;
import com.alfredo.nba.NBASports.ServiceImpl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1"})
@CrossOrigin
public class GameController {

    @Autowired
    GameServiceImpl gameServiceImpl;

    public GameController() {
    }

    @GetMapping({"/get-all-games"})
    public ResponseEntity<List<Game>> getAllGames() throws Exception {
        List<Game> gameList = this.gameServiceImpl.getAllGames();
        return new ResponseEntity(gameList, HttpStatus.OK);
    }

    @GetMapping({"/get-all-games-by-id/{id}"})
    public ResponseEntity<Game> getAllGamesById(@PathVariable Long id) throws Exception {
        Game game = this.gameServiceImpl.getAllGamesById(id);
        return game != null ? new ResponseEntity(game, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"/get-all-games-by-date/{date}"})
    public ResponseEntity<List<Game>> getAllGamesByDate(@RequestParam String date) throws Exception {
        List<Game> gameList = this.gameServiceImpl.getAllGamesByDate(date);
        return gameList != null ? new ResponseEntity(gameList, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
