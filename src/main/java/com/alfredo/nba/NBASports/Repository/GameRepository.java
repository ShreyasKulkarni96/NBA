package com.alfredo.nba.NBASports.Repository;

import com.alfredo.nba.NBASports.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
