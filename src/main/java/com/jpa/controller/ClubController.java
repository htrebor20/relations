package com.jpa.controller;

import com.jpa.entities.Club;
import com.jpa.entities.Player;
import com.jpa.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/club")
public class ClubController {
    @Autowired
    private IClubService clubService;
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Club> clubOptional = clubService.findById(id);
        if(clubOptional.isPresent()){
            return ResponseEntity.ok(clubOptional);
        }
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<?>findAll() {
        List<Club> clubList = clubService.findAll();
        return ResponseEntity.ok(clubList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>saveCLub(@RequestBody Club club) throws URISyntaxException {
        if(club.getName().isBlank()) {
            return ResponseEntity.notFound().build();
        }
        clubService.save(club);
        return ResponseEntity.created(new URI("api/club/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateClub(@PathVariable Long id, @RequestBody Club club) {
        Optional<Club> clubOptional = clubService.findById(id);
        if(clubOptional.isPresent()) {
            Club club1 = clubOptional.get();
            club1.setName(club.getName());
            clubService.save(club1);
            return ResponseEntity.ok("Registro atualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id) {
  if(id !=null) {
      clubService.deleteById(id);
        return ResponseEntity.ok("Reguistro elininado");
  }
        return ResponseEntity.badRequest().build();
    }
}
