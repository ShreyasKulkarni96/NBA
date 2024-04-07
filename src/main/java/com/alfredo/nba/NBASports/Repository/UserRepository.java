package com.alfredo.nba.NBASports.Repository;

import com.alfredo.nba.NBASports.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {
  Optional<User> findByEmail(String email);

  Optional<User> getByEmail(String email);

  Optional<User> getByName(String name);

  Optional<User> findByName(String name);
}
