package com.jpa.service.impl;

import com.jpa.entities.Club;
import com.jpa.repository.ClubRepository;
import com.jpa.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements IClubService {
    @Autowired
    private ClubRepository clubRepository;
    @Override
    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public void save(Club club) {
        clubRepository.save(club);
    }

    @Override
    public void deleteById (Long id) {
        clubRepository.deleteById(id);
    }

}
