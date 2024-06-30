package com.alfredo.nba.NBASports.Repository;

import com.alfredo.nba.NBASports.Models.AllTeamWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllTeamRepository extends JpaRepository<AllTeamWrapper, Long> {
}
