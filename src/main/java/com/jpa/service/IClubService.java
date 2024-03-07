package com.jpa.service;

import com.jpa.entities.Club;

import java.util.List;
import java.util.Optional;

public interface IClubService {

    List<Club> findAll();
    Optional<Club> findById(Long id);
    void save(Club club);
    void deleteById(Long id);

}
