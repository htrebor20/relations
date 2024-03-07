package com.jpa.service;

import com.jpa.entities.Player;

import java.util.List;
import java.util.Optional;


public interface IPlayerService {

    List<Player> findAll();
    Optional<Player> findById(Long id);
    void save(Player player);
    void deleteById(Long id);

}
